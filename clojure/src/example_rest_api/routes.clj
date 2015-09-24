(ns example-rest-api.routes
  (:require [compojure.core :refer [GET OPTIONS POST PUT context defroutes]]
            [compojure.route :as route]
            [example-rest-api.api :as api]
            [example-rest-api.const :as const]))


(defroutes v1-routes
  (OPTIONS "/" []
    (api/options [:options] {:version const/api-version}))
  (GET "/" []
    (api/no-content)))

(defroutes v2-routes)

(defroutes api-routes
  (GET "/hello" [] (api/hello-world))
  (PUT "/echo" {content :json-params} (api/echo content))
  (GET "/echo" {content :json-params} (api/echo content))
  (POST "/echo" [:as req] (api/echo req))
  (context "/v1" [] v1-routes)
  (context "/v2" [] v2-routes)
  (route/not-found const/four-oh-four-message))
