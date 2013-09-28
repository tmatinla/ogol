(defproject ogol "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]]
  :plugins [[lein-ring "0.8.5"]
            [lein-cljsbuild "0.3.3"]]
  :source-paths ["src/clojure"]
  :cljsbuild {:builds [{:source-paths ["src/cljs"]
                        :compiler {:output-to "resources/public/development.js"
                                   :optimizations :whitespace
                                   :pretty-print true}}]}
  :ring {:handler ogol.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.5"]]}})
