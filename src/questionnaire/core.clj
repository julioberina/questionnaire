(ns questionnaire.core
  (:require [bidi.ring :as br]
            [bidi.bidi :as bd]
            [org.httpkit.server :refer :all]
            [ring.util.response :refer :all])
  (:gen-class))

(defn display-response [body]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body body})

(defn handler [req]
  (let [routes ["/" {"" :index
                     "about" :about}]]
    (case (:handler (bd/match-route routes (:uri req)))
      :index (display-response "<h1>Index</h1>")
      :about (display-response "<p>About</p>"))))

(defn -main [& args]
  (let [server (run-server handler {:port 8000})]
    (println "Server started at port 8000")))
