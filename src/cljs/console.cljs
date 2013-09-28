(ns ogol.console
  (:require [himera.client.repl :as himera]))

(defn- map->js [m]
  (let [out (js-obj)]
    (doseq [[k v] m]
      (aset out (name k) v))
    out))

(defn ^:export go []
  (.ready (js/jQuery js/document)
          (fn []
            (set! js/controller
                  (doto (js/jQuery "#console1")
                    (.console (map->js {:welcomeMessage "Ogol console"
                                        :promptLabel "Ogol> "
                                        :commandValidate himera/on-validate
                                        :commandHandle himera/on-handle
                                        :autofocus true
                                        :animateScroll true
                                        :promptHistory true})))))))
