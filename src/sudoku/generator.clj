(ns sudoku.generator
  (:require [clojure.core.matrix :as m]))

(defn base-sudoku []
  "Returns a valid solved 9x9 sudoku puzzle."
  [[7 3 5 6 1 3 8 9 2]
   [8 4 2 9 7 3 5 6 1]
   [9 6 1 2 8 5 3 7 4]
   [2 8 6 3 4 9 1 5 7]
   [4 1 3 8 5 7 9 2 6]
   [5 7 9 1 2 6 4 3 8]
   [1 5 7 4 9 2 6 8 3]
   [6 9 4 7 3 8 2 1 5]
   [3 2 8 5 6 1 7 4 9]])


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

(defn get-3x3-blocks [sudoku]
  "Returns blocks of 3x3 from the given sudoku."
  (let [blocks (partition 3 (map (partial partition 3) sudoku))]
    (apply concat (map #(mapv vec %) blocks))))

(defn shuffle-row-blocks [sudoku]
  "Shuffles the row-blocks of the sudoku while maintaining its validity."
  (let [blocks (partition 3 (map (partial partition 3) sudoku))
        shuffled-blocks (->> blocks
                             (shuffle)
                             (get-3x3-blocks))]
    shuffled-blocks))

(defn transform-sudoku [sudoku]
  (let [blocks (partition 3 sudoku)]
    (->> (reverse blocks)
         (mapv #(apply concat %))
         (mapv #(->> % (partition 3) (mapv (apply concat %)))))))

(defn create-sudoku [x]
  "Generates and prints a valid shuffled 9x9 sudoku."
  (-> (base-sudoku)
      shuffle-row-blocks
      transform-sudoku
      print-sudoku))