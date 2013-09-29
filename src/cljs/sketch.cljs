(ns ogol.sketch
  (:use [jayq.core :only [$]])
  (:require [libre.sketch :as sk])
  (:require-macros [jayq.macros :as jayq]))

(defn ^:export createSketch []
  (jayq/ready
    (doto ($ :#sketch-window)
      (.resizable (clj->js {:alsoResize "#sketch1"
                            :autoHide true }))
      (.draggable))
    (doto ($ :#run-sketch)
      (.button (clj->js {:icons {:primary "ui-icon-play"}})))
    (doto ($ :#stop-sketch)
      (.button (clj->js {:icons {:primary "ui-icon-stop"}})))))

(defn- get-textarea-value [textarea]
  (.-value (.get ($ textarea) 0)))

(defn ^:export runSketch []
  (sk/run-sketch :#canvas1 (get-textarea-value :#sketch1)))