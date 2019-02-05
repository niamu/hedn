(ns hedn.core-test
  (:require
   [hedn.core :as hedn]
   [fern.easy :as fern]
   [clojure.test :as t]))

(def result
  (str "<div id=\"posts\">"
       "<div id=\"page-header\">"
       "<h1>archives</h1>"
       "</div>"
       "<div>"
       "<h4>2019</h4>"
       "<ul>"
       "<li>2019-02-04 - <a href=\"/post/2019-02-04-example\">example</a></li>"
       "</ul>"
       "</div>"
       "</div>"))

(def params
  {:groups [{:group "2019"
             :posts [{:date "2019-02-04"
                      :uri "/post/2019-02-04-example"
                      :title "example"}]}]
   :subtitle "archives"})

(def template
  (fern/file->environment "resources/example.edn"))

(t/deftest example
  (t/testing "example.edn -> hiccup"
    (t/is (= (hedn/render-template template params)
             result))))
