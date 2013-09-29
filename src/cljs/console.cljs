(ns ogol.console
  (:use [jayq.core :only [$]])
  (:require-macros [jayq.macros :as jayq])
  (:require [himera.client.repl :as himera]))

(defn ^:export createConsole []
  (jayq/ready
    (doto ($ :#console-window)
      (.resizable (clj->js {:alsoResize "#console1, div.jquery-console-inner"
                            :autoHide true }))
      (.draggable))
    (doto ($ :#console1)        
      (.console (clj->js {:promptLabel "Ogol> "
                          :commandValidate himera/on-validate
                          :commandHandle himera/on-handle
                          :autofocus true
                          :animateScroll true
                          :promptHistory true})))))
