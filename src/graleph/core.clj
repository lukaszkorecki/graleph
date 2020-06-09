(ns graleph.core
  (:gen-class)
  (:require
    [aleph.udp :as udp]
    [byte-streams :as bs]
    [clojure.string :as str]
    [clojure.tools.logging :as log]
    [manifold.stream :as s]
    [utility-belt.lifecycle :as lifecycle]))

;; Adopted from aleph.udp examples
(defn parse-statsd-packet
  [{:keys [message]}]
  (let [message (bs/to-string message)
        [metric value] (str/split message #":")]
    [metric value]))


(defn start
  [server-port data-store]
  (let [server-socket @(udp/socket {:port server-port :bind "0.0.0.0"})]
    (->> server-socket
         (s/map parse-statsd-packet)
         (s/consume (fn [[metric value]]
                      (log/infof "m %s v %s" metric value)
                      (swap! data-store conj [metric value]))))
    server-socket))


(defn stop
  [sock]
  (s/close! sock))


(defn start-and-monitor
  []
  (let [store (atom [])
        watcher (future
                  (while true
                    (log/info @store)
                    (Thread/sleep 5000)))
        flusher (future (while true
                          (Thread/sleep (* 30 1000))
                          (reset! store [])))
        sock (start 8025 store)]
    {:sock sock
     :flusher flusher
     :watcher watcher}))


(defn -main
  [& args]
  (log/info "starting")
  (let [{:keys [watcher flusher sock]} (start-and-monitor)]
    (lifecycle/register-shutdown-hook :stop (fn []
                                              (log/warn "stopping")
                                              (stop sock)
                                              (future-cancel flusher)
                                              (future-cancel watcher)))
    (lifecycle/install-shutdown-hooks!)))
