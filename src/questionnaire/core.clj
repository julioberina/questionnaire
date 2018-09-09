(ns questionnaire.core
  (:require [bidi.ring :as br]
            [bidi.bidi :as bd]
            [org.httpkit.server :refer :all]
            [ring.util.response :refer :all]
            [clojure.java.io :as io])
  (:gen-class))

(defn serve-index-html []
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (slurp (io/resource "public/index.html"))})

(defn handler [req]
  (let [routes ["/" {"" :index
                     "about" :about}]]
    (case (:handler (bd/match-route routes (:uri req)))
      :index (serve-index-html)
      :about (serve-index-html))))

(defn -main [& args]
  (let [server (run-server handler {:port 3000})]
    (println "Server started at port 3000")))
