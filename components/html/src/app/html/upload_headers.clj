(ns app.html.upload-headers)

(defn page []
  [:div
   {:class "bg-white"}
   [:div
    {:class "relative isolate px-6 pt-14 lg:px-8"} 
    [:div
     {:class "mx-auto max-w-2xl py-32 sm:py-48 lg:py-56"}
     [:div
      {:class "text-center"}
      [:h1
       {:class
        "text-balance text-4xl font-bold tracking-tight text-gray-900 sm:text-6xl"}
       "Kopfdaten importieren"]
      [:div
       {:class "mt-10 flex items-center justify-center gap-x-6"}
       [:form
        {:hx-encoding "multipart/form-data"
         :hx-post "/upload-headers"}
        [:input {:type "file", :name "file"}]
        [:button.inline-block.shrink-0.rounded-md.border.border-blue-600.bg-blue-600.px-12.py-3.text-sm.font-medium.text-white.transition.hover:bg-transparent.hover:text-blue-600.focus:outline-none.focus:ring.active:text-blue-500.dark:hover:bg-blue-700.dark:hover:text-white "Upload"]]]]]
    [:div
     {:class
      "absolute inset-x-0 top-[calc(100%-13rem)] -z-10 transform-gpu overflow-hidden blur-3xl sm:top-[calc(100%-30rem)]",
      :aria-hidden "true"}
     [:div
      {:class
       "relative left-[calc(50%+3rem)] aspect-[1155/678] w-[36.125rem] -translate-x-1/2 bg-gradient-to-tr from-[#ff80b5] to-[#9089fc] opacity-30 sm:left-[calc(50%+36rem)] sm:w-[72.1875rem]",
       :style
       "clip-path: polygon(74.1% 44.1%, 100% 61.6%, 97.5% 26.9%, 85.5% 0.1%, 80.7% 2%, 72.5% 32.5%, 60.2% 62.4%, 52.4% 68.1%, 47.5% 58.3%, 45.2% 34.5%, 27.5% 76.7%, 0.1% 64.9%, 17.9% 100%, 27.6% 76.8%, 76.1% 97.7%, 74.1% 44.1%)"}]]]])