(ns sudoku.generator
  (:require [sudoku.collection :as collection]))

(def num-blanks 30)

(defn print-sudoku [sudoku]
  "Prints a sudoku to the console with indices e.g: A B C for columns and 1 2 3 rows"
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

(defn replace-with-random-zero [grid index size-of-sudoku]
  "Replaces some values in each row of the Sudoku grid with random zeros."
  (if (= index size-of-sudoku)
    (println size-of-sudoku)
    ((println index) (replace-with-random-zero grid (inc index) size-of-sudoku))))


(defn create-sudoku [x]
  "Generates and prints a valid shuffled 9x9 sudoku."
  (-> (collection/get-random-collection x)
      (replace-with-random-zero 0 (Integer/parseInt x))
      print-sudoku))