(ns ogol.repl
  (:require [clojure.browser.repl :as repl])
  (:use [jayq.core :only [$]])
  (:require-macros [jayq.macros :as jayq]))

(defn launch-repl [url]
  (repl/connect (or url "http://localhost:9000/repl")))

(defn- get-value [elem]
  (.-value (.get ($ elem) 0)))

(defn ^:export createRepl []
  (jayq/ready
    (doto ($ :#external-repl-window)
      (.draggable))
    (doto ($ :#connect-repl)
      (-> (.button (clj->js {:icons {:primary "ui-icon-play"}}))
      	  (.click (fn [event] (launch-repl (get-value :#repl-url))))))))
