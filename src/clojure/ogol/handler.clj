(ns ogol.handler
  (:use compojure.core)
  (:use ring.middleware.clj-params)
  (:require [ring.util.response :as resp]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [himera.server.cljs :as cljs]
            [himera.server.service :as himera]))

(defroutes app-routes
  (GET "/" [] (resp/file-response "index.html" {:root "resources/public"}))

  ; Himera service
  (POST "/compile" [expr]
  	(himera/generate-js-response (cljs/compilation expr :simple false)))
  ; not sure if this is needed?
  (POST "/ast" [expr]
    (himera/generate-ast-response (cljs/analyze expr :simple true)))


  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> app-routes
      wrap-clj-params))

;; (def app
;;   (handler/site app-routes))
