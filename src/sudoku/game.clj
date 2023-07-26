(ns sudoku.game
  (:require [sudoku.input :as input]))

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

(defn convert-letter-to-number
  "Converts a letter to the corresponding number, e.g., A -> 1, B -> 2, etc."
  [letter]
  (let [char-value (- (int (first letter)) 64)]
    (if (and (>= char-value 1) (<= char-value 9))
      char-value
      (throw (IllegalArgumentException. "Invalid letter input")))))

(defn enter-input-to-sudoku
  "Enters a new value into the sudoku"
  [sudoku location input]
  (let [x (convert-letter-to-number (subs location 0 1))
        y (Integer/parseInt (subs location 1 2))]
    (assoc-in sudoku [x y] input)))


(defn process-sudoku [sudoku]
  (let [[location value] (input/wait-for-sudoku-input)]
    (if (= location "finish")
      (do
        (println "Done")
        sudoku)
      (do
        (println "You entered:" location value)
        (let [updated-sudoku (enter-input-to-sudoku sudoku location value)]
          (print-sudoku updated-sudoku)
          (recur updated-sudoku))))))