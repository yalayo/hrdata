(ns app.csv-importer.core
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]))

(defn process-file [input-stream]
  (with-open [reader (io/reader input-stream)]
    (csv/read-csv reader)))