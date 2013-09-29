(ns ogol.canvas
  (:use [jayq.core :only [$]])
  (:require-macros [jayq.macros :as jayq]))

(defn ^:export createCanvas []
  (jayq/ready
    (doto ($ :#canvas-window)
      (.resizable (clj->js {:alsoResize "#canvas1"
                            :autoHide true }))
      (.draggable))))
