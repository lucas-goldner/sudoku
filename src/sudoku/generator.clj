(ns sudoku.generator)

(defn create-sudoku-rows
  "Creates a vector of x rows, each containing numbers from 1 to x"
  [x]
  (map (fn [_] (vec (range 1 (inc x)))) (range x)))


(defn print-sudoku
  "Prints a sudoku to the console with indices e.g: A B C for columns and 1 2 3 rows"
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

(defn create-sudoku
  "Creates a sudoku of size x by gradually expanding the sudoku vector"
  [x]
  (let [sudoku (vec (create-sudoku-rows (Integer/parseInt x)))]
    (print-sudoku sudoku)))




