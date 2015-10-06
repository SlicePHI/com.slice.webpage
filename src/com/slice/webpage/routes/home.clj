(ns com.slice.webpage.routes.home
  (:require [com.slice.webpage.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :refer [ok]]
            [clojure.java.io :as io]))

(defn home-page []
  (layout/render
   "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn about-page []
  (layout/render "about.html"))

(defn partners-page []
  (layout/render
   "partners.html" {:partners (-> "docs/partners.md" io/resource slurp)}))


(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page))
  (GET "/partners" [] (partners-page)))

