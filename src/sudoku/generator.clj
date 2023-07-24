(ns sudoku.generator)

(defn create-sudoku-row
  "Creates a sudoku row of index x and adds it to the sudoku vector of vectors"
  [sudoku x]
  (println (format "This number was passed: %s" x))
  (conj sudoku (vec (range 1 (inc x)))))


(defn print-sudoku "Prints a sudoku to the console"
  [sudoku]
  (doseq [row sudoku]
    (doseq [cell row]
      (print cell " "))
    (println)))

(defn create-sudoku
  "Creates a sudoku of size x by gradually expanding the sudoku vector"
  [x]
  (let [initial-sudoku (vec [])]
    (doseq [i (range 1 (inc (Integer/parseInt x)))]
      (create-sudoku-row initial-sudoku i)
      (when (= i 3)
        (print-sudoku initial-sudoku)))))




