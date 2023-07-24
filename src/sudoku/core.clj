(ns sudoku.core
  (:require [sudoku.generator :as generator]))

(defn -main
  "Generates sudoku of size x"
  [x]
  (generator/create-sudoku x))