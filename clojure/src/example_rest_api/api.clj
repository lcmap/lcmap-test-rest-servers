(ns example-rest-api.api
  (:require [clojure.data.json :as json]
            [clojure.string :as string]
            [clojure.tools.logging :as log]
            [ring.util.response :as response]
            [example-rest-api.config :as config]
            [example-rest-api.const :as const]
            [example-rest-api.util :as util]))


(defn hello-world []
  "Hello World!!!")

(defn echo [content]
  {:headers {"Content-Type" "application/json"}
   :body (.toString content)})

(defn options
  ([]
    (options #{:options nil}))
  ([allowed]
    (options allowed nil))
  ([allowed body]
    (->
      (response/response body)
      (response/header
        "Allow"
        (string/join
          ", "
          (map
            (comp string/upper-case name)
            allowed))))))

(defn method-not-allowed
  [allowed]
    (->
      (options allowed)
      (response/status const/method-not-allowed)))

(defn no-content
  [body]
  (if (or (nil? body) (empty? body))
    (->
      (response/response nil)
      (response/status const/no-content))
    (response/response body)))

(defn not-implemented
  []
  (->
    (response/response nil)
    (response/status const/not-implemented)))
