(ns hedn.core
  (:require
   [fern :as f]
   [fern.easy :as fern]
   [hiccup.core :as hiccup]))

(defn render-template
  [template params]
  (-> (assoc template 'params params)
      (f/evaluate 'content)
      eval
      hiccup/html))
