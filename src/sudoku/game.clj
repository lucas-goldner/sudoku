(ns sudoku.game
  (:require [sudoku.input :as input]
            [sudoku.collection :as collection]
            [sudoku.game :as game]))

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
  (let [x (dec (convert-letter-to-number (subs location 0 1)))
        y (dec (Integer/parseInt (subs location 1 2)))]
    (assoc sudoku y (assoc (nth sudoku y) x input))))

(defn has-zero?
  "Checks if any value in the vector of vectors is zero."
  [matrix]
  (some #(some zero? %) matrix))

(defn process-sudoku [sudoku]
  (let [[location value] (input/wait-for-sudoku-input)]
    (let [updated-sudoku (enter-input-to-sudoku sudoku location value)]
      (if (not (has-zero? updated-sudoku))
        (do
          (print-sudoku updated-sudoku)
          :finished)
        (do
          (println "You entered:" location value)
          (print-sudoku updated-sudoku)
          (recur updated-sudoku))))))

(defn compare-rows "Compare each rows to make sure they are equal"
  [sudoku result-sudoku index max-size]
  (if (= index max-size)
    true
    (if (= (nth sudoku index) (nth result-sudoku index))
      (compare-rows sudoku result-sudoku (inc index) max-size)
      false)))

(defn compare-sudokus "Compare each sudokus to make sure they are equal"
  [sudoku result-sudokus sudoku-index]
  (println "Run compare sudokus")
  (println (compare-rows sudoku (nth result-sudokus sudoku-index) 0 (count sudoku)))
  (if (= sudoku-index (count result-sudokus))
    false
    (if (compare-rows sudoku (nth result-sudokus sudoku-index) 0 (count sudoku))
      true
      (compare-sudokus sudoku result-sudokus (inc sudoku-index)))))

(defn finish-sudoku [sudoku]
  (println "Finished sudoku")
  (println "Checking results...")
  (if (compare-sudokus sudoku (collection/get-collections-for-size (count (nth sudoku 0))) 0)
    (println "Correct congratulations")
    (println "You failed"))
  sudoku)