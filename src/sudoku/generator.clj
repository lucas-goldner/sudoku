(ns sudoku.generator)

(defn create-sudoku-rows
  "Creates a vector of x rows, each containing numbers from 1 to x"
  [x]
  (map (fn [_] (vec (range 1 (inc x)))) (range x)))

(defn transform-sudoku-values-to-strings
  "Transforms a vector of vectors of integers into a vector of vectors of strings."
  [data]
  (mapv #(mapv str %) data))

(defn transform-sudoku-values-to-strings
  "Transforms a vector of vectors of integers into a vector of vectors of strings."
  [data]
  (mapv #(mapv str %) data))


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
  (-> x
      Integer/parseInt
      create-sudoku-rows
      transform-sudoku-values-to-strings
      print-sudoku))