(ns example-rest-api.management
  (:import [java.lang Runtime])
  (:require [clojure.data.xml :as xml]))

(defn get-status []
  (xml/emit-str
   (xml/sexp-as-element
    [:status
     [:jvm
      [:memory {:free (str (. (Runtime/getRuntime) freeMemory))
                :total "?"}]]])))
