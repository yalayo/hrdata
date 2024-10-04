(ns app.csv-importer.interface
  (:require [app.csv-importer.core :as core]))

(defn process-file [input-stream]
  (core/process-file input-stream))