(ns sudoku.generator
  (:require [sudoku.collection :as collection]))

(defn randomize-row-with-zeros [vector]
  (mapv #(if (< (rand) 0.6) 0 %) vector))

(defn replace-rows-with-zeros "Replaces some values in each row of the Sudoku grid with random zeros."
  [grid index size-of-sudoku]
  (if (= index size-of-sudoku)
    grid
    (let [row (nth grid index)]
      (replace-rows-with-zeros (assoc grid index (randomize-row-with-zeros row)) (inc index) size-of-sudoku))))


(defn create-sudoku "Generates a randomized sudoku."
  [x]
  (let [sudoku-with-zeros (-> (collection/get-random-collection x)
                              (replace-rows-with-zeros 0 (Integer/parseInt x)))]
    sudoku-with-zeros))