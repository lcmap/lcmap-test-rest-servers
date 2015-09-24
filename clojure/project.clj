(defproject example-rest-api "0.1.0-SNAPSHOT"
  :description "An Example REST API Server for Clojure"
  :url "http://localhost/example-api"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/data.json "0.2.3"]
                 [org.clojure/tools.cli "0.2.4"]
                 [org.clojure/tools.logging "0.2.6"]
                 [clj-http "0.7.7"]
                 [compojure "1.1.5"]
                 [http-kit "2.1.11"]
                 [ring/ring-core "1.2.0"]
                 [ring/ring-devel "1.2.0"]
                 [ring/ring-json "0.2.0"]]
  :plugins [[lein-ring "0.8.5"]
            [lein-exec "0.3.1"]]
  :ring {:handler example-rest-api.handler/app}
  :main example-rest-api.main
  :profiles
  {:testing
    {:dependencies [[ring-mock "0.1.5"]
                    [clj-http-fake "0.4.1"]
                    [midje "1.5.1"]]}})
