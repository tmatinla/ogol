(ns ogol.canvas
  (:use [ogol.utils :only [map->js]]
        [jayq.core :only [$]])
  (:require-macros [jayq.macros :as jayq]))

(defn ^:export createCanvas []
  (jayq/ready
    (doto ($ :#canvas-window)
      (.resizable (map->js {:alsoResize "#canvas1"
                            :autoHide true }))
      (.draggable))))
