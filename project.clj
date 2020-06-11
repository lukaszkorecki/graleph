(def netty-verion
  "4.1.50.Final")

(defproject graleph "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :managed-dependencies [[io.netty/netty-codec-http ~netty-verion]
                         [io.netty/netty-codec ~netty-verion]
                         [io.netty/netty-handler-proxy ~netty-verion]
                         [io.netty/netty-codec-socks ~netty-verion]
                         [io.netty/netty-handler ~netty-verion]
                         [io.netty/netty-resolver-dns ~netty-verion]
                         [io.netty/netty-codec-dns ~netty-verion]
                         [io.netty/netty-resolver ~netty-verion]
                         [io.netty/netty-transport-native-epoll ~netty-verion]
                         [io.netty/netty-common ~netty-verion]
                         [io.netty/netty-transport-native-unix-common ~netty-verion]
                         [io.netty/netty-transport ~netty-verion]
                         [io.netty/netty-buffer ~netty-verion]]

  :dependencies [[org.clojure/clojure "1.10.2-alpha1"]
                 [aleph "0.4.7-alpha5"]
                 [org.clojure/tools.logging "1.1.0"]
                 [ch.qos.logback/logback-classic "1.2.3"]
                 [nomnom/utility-belt "1.2.3" :exclusions [nrepl]]
                 #_ [borkdude/graal.locking "0.0.2"]]
  :main ^:skip-aot graleph.core
  :target-path "target/%s"
  :uberjar-name "graleph-standalone.jar"
  :profiles {:uberjar {:jvm-opts ["-Dclojure.compiler.direct-linking=true"]
                       :aot :all}})
