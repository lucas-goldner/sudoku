(ns sudoku.core
  (:require [sudoku.generator :as generator])
  (:require [sudoku.input :as input]))

(defn -main
  "Generates sudoku of size x"
  []
  (case (input/explain-inputs)
    "read" (println "Implement read old entries")
    "sudoku" (generator/create-sudoku (input/ask-for-sudoku-size))))