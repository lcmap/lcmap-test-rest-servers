(defproject example-rest-api "0.1.0-SNAPSHOT"
  :description "An Example REST API Server for Clojure"
  :url "http://localhost/example-api"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/tools.logging "0.3.1"]
                 [compojure "1.4.0"]
                 [http-kit "2.1.17"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [ring/ring-core "1.4.0"]
                 [ring/ring-devel "1.4.0"]]
  :plugins [[lein-ring "0.9.7"]]
  :main example-rest-api.main)
