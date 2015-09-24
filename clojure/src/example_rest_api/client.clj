(ns example-rest-api.client
  (:require [clojure.data.json :as json]
            [clojure.tools.logging :as log]
            [clj-http.client :as http])
  (:import [java.net ConnectException]
           [java.io EOFException]))


(defn error-catcher [func]
  (try (func)
    (catch ConnectException error
      (log/error (.getMessage error)))
    (catch EOFException error
      (log/error (.getMessage error)))
    (catch Exception error
      (let [data ((.getData error) :object)
            status (data :status)
            body (data :body)
            parens-code (str "(" status "):")]
        (cond
          (<= 400 status 499)
            (log/error
              "Client Error" parens-code body)
          (<= 500 status 599)
            (log/error
              "Server Error" parens-code body
              "... (see log file for server for more information)")
          :else (throw error))))))

(defn get-body [data]
  (data :body))

(defn get-hello [base-url]
  (error-catcher
    #(get-body
      (http/get (str base-url "/hello")))))

(defn get-echo [base-url content]
  (error-catcher
    #(http/get
      (str base-url "/echo")
      {:headers {"Content-Type" "application/json"}
       :body content})))

(defn put-echo [base-url content]
  (error-catcher
    #(http/put
      (str base-url "/echo")
      {:headers {"Content-Type" "application/json"}
       :body content})))

(defn post-echo [base-url content]
  (error-catcher
    #(http/post
      (str base-url "/echo")
      {:headers {"Content-Type" "application/json"}
       :body content})))
