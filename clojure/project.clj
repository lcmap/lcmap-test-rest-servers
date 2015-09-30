(defproject example-rest-api "0.1.0-SNAPSHOT"
  :description "An Example REST API Server for Clojure"
  :url "http://localhost/example-api"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/data.json "0.2.6"]
                 [org.clojure/tools.cli "0.3.3"]
                 [org.clojure/tools.logging "0.3.1"]
                 [clj-http "0.7.7"]
                 [compojure "1.4.0"]
                 [http-kit "2.1.17"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [ring/ring-core "1.4.0"]
                 [ring/ring-devel "1.4.0"]
                 [ring/ring-json "0.2.0"]]
  :plugins [[lein-ring "0.9.7"]
            [lein-exec "0.3.5"]]
  :ring {:handler example-rest-api.handler/app}
  :main example-rest-api.main)
