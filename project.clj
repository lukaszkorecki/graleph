(defproject graleph "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [aleph "0.4.6"]
                 [org.clojure/tools.logging "1.1.0"]
                 [nomnom/utility-belt "1.2.3" :exclusions [nrepl]]]
  :main ^:skip-aot graleph.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
