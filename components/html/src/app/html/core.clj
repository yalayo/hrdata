(ns app.html.core
	(:require [hiccup2.core :as h]
            [io.pedestal.http.body-params :as body-params]
            [ring.util.response :as response]
            [app.html.index :as index]
            [app.html.dashboard :as dashboard]
            [app.html.upload-headers :as upload-headers]))

;; Prepare the hicup to return it as html
(defn template [html-body]
  [:html
   [:head
    [:title "Title"]
    [:link {:href "tailwind.min.css" :rel "stylesheet"}]
    [:script {:src "htmx.min.js"}]]
   [:body (h/raw html-body)]])

(defn ok [body]
  {:status 200
   :headers {"Content-Type" "text/html" "Content-Security-Policy" "img-src 'self'"}
   :body (-> body
             (h/html)
             (str))})

(defn respond [content]
  (ok (template (str (h/html (content))))))

(defn respond-with-params [content value]
  (ok (template (str (h/html (content value))))))

(defn index-page-handler [context]
  (respond index/index-page))

(defn dashboard-handler [context]
  (let [session (-> context :session)]
    (if (empty? session)
      (response/redirect "/sign-in")
      (respond-with-params dashboard/content {:email (:email session) :created-at (:created-at session)}))))

(def upload-headers-handler
  {:name ::get
   :enter (fn [context]
            (assoc context :response (respond upload-headers/page)))})

(def routes
  #{["/" :get index-page-handler :route-name ::index-page]
    ["/dashboard"
     :get [(body-params/body-params) dashboard-handler]
     :route-name ::dashboard]
    ["/upload-headers"
     :get [(body-params/body-params) upload-headers-handler]
     :route-name ::upload-headers]})