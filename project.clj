(defproject graleph "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]

                 [aleph "0.4.7-alpha5"
                  :exclusions [io.netty/netty-codec-http
                               io.netty/netty-codec
                               io.netty/netty-handler-proxy
                               io.netty/netty-handler
                               io.netty/netty-resolver-dns
                               io.netty/netty-resolver
                               io.netty/netty-transport-native-epoll
                               io.netty/netty-transport]]

                 [io.netty/netty-codec-http "4.1.39.Final"]
                 [io.netty/netty-codec "4.1.39.Final"]
                 [io.netty/netty-handler-proxy "4.1.39.Final"]
                 [io.netty/netty-handler "4.1.39.Final"]
                 [io.netty/netty-resolver-dns "4.1.39.Final"]
                 [io.netty/netty-resolver "4.1.39.Final"]
                 [io.netty/netty-transport-native-epoll "4.1.39.Final"]
                 [io.netty/netty-transport "4.1.39.Final"]

                 [org.clojure/tools.logging "1.1.0"]

                 [nomnom/utility-belt "1.2.3" :exclusions [nrepl]]]
  :main ^:skip-aot graleph.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
