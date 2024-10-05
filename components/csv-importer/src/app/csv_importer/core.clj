(ns app.csv-importer.core
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]))

(defn vectors-to-maps [data]
  (let [keys (mapv keyword (first data))
        values (rest data)]
    (mapv #(zipmap keys %) values)))

(defn process-file [input-stream]
  (with-open [reader (io/reader input-stream)]
    (vectors-to-maps (csv/read-csv reader))))