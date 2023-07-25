(ns sudoku.generator
  (:require [sudoku.collection :as collection]))

(defn print-sudoku "Prints a sudoku to the console with indices e.g: A B C for columns and 1 2 3 rows"
  [sudoku]
  (let [num-cols (count (first sudoku))]
    (print "   ")
    (doseq [col-label (range 1 (inc num-cols))]
      (print (char (+ 64 col-label)) " "))
    (println)
    (doseq [[row-label row] (map vector (range 1 (inc (count sudoku))) sudoku)]
      (print row-label " ")
      (doseq [cell row]
        (print cell " "))
      (println))))

(defn randomize-row-with-zeros [vector]
  (mapv #(if (< (rand) 0.6) 0 %) vector))

(defn replace-rows-with-zeros "Replaces some values in each row of the Sudoku grid with random zeros."
  [grid index size-of-sudoku]
  (if (= index size-of-sudoku)
    grid
    (let [row (nth grid index)]
      (replace-rows-with-zeros (assoc grid index (randomize-row-with-zeros row)) (inc index) size-of-sudoku))))


(defn create-sudoku "Generates and prints a valid shuffled 9x9 sudoku."
  [x]
  (-> (collection/get-random-collection x)
      (replace-rows-with-zeros 0 (Integer/parseInt x))
      print-sudoku))