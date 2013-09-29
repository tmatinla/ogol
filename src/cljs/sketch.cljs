(ns ogol.sketch
  (:use [jayq.core :only [$]])
  (:require [libre.sketch :as sk]
            [himera.client.repl :as himera])
  (:require-macros [jayq.macros :as jayq]))

(defn- get-textarea-value [textarea]
  (.-value (.get ($ textarea) 0)))

(defn run-sketch [canvas sketch]
    (let [input (.trim js/jQuery sketch)
          compiled (himera/go-compile input)]
      (if-let [err (and compiled (:error compiled))]
        (js/alert "Compilation error: " err)
        (try
          (sk/run-sketch canvas (js/eval (:js compiled)))
          (catch js/Error e
            (js/alert "Compilation error: " e))))))

  ; (js/alert (himera/go-compile sketch)))
  ;(sk/run-sketch canvas (himera/go-compile sketch)))

(defn ^:export createSketch []
  (jayq/ready
    (doto ($ :#sketch-window)
      (.resizable (clj->js {:alsoResize "#sketch1"
                            :autoHide true }))
      (.draggable))
    (doto ($ :#run-sketch)
      (-> (.button (clj->js {:icons {:primary "ui-icon-play"}}))
      	  (.click (fn [e] (run-sketch :#canvas1 (get-textarea-value :#sketch1))))))
    (doto ($ :#stop-sketch)
      (.button (clj->js {:icons {:primary "ui-icon-stop"}})))))

