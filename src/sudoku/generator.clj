(ns sudoku.generator)

(defn create-sudoku-rows
  "Creates a vector of x rows, each containing numbers from 1 to x"
  [x]
  (map (fn [_] (vec (range 1 (inc x)))) (range x)))


(defn print-sudoku "Prints a sudoku to the console"
  [sudoku]
  (doseq [row sudoku]
    (doseq [cell row]
      (print cell " "))
    (println)))

(defn create-sudoku
  "Creates a sudoku of size x by gradually expanding the sudoku vector"
  [x]
  (let [sudoku (vec (create-sudoku-rows (Integer/parseInt x)))]
    (print-sudoku sudoku)))




