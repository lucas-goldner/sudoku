(ns sudoku.collection)

(def sudoku-9-1
  [[1 2 3 4 5 6 7 8 9]
   [2 3 4 5 6 7 8 9 1]
   [3 4 5 6 7 8 9 1 2]
   [4 5 6 7 8 9 1 2 3]
   [5 6 7 8 9 1 2 3 4]
   [6 7 8 9 1 2 3 4 5]
   [7 8 9 1 2 3 4 5 6]
   [8 9 1 2 3 4 5 6 7]
   [9 1 2 3 4 5 6 7 8]])

(def sudoku-9-2
  [[9 8 7 6 5 4 3 2 1]
   [6 5 4 3 2 1 9 8 7]
   [3 2 1 9 8 7 6 5 4]
   [2 1 9 8 7 6 5 4 3]
   [8 7 6 5 4 3 2 1 9]
   [5 4 3 2 1 9 8 7 6]
   [7 6 5 4 3 2 1 9 8]
   [4 3 2 1 9 8 7 6 5]
   [1 9 8 7 6 5 4 3 2]])

(def sudoku-9-3
  [[8 9 1 7 5 3 6 4 2]
   [4 3 2 1 9 6 8 7 5]
   [7 5 6 8 4 2 9 3 1]
   [3 7 5 2 1 9 4 6 8]
   [2 1 4 6 8 7 3 5 9]
   [9 6 8 3 7 5 1 2 4]
   [5 2 9 4 3 1 7 8 6]
   [6 8 7 5 2 4 3 1 9]
   [1 4 3 9 6 8 2 5 7]])

(def sudoku-8-1
  [[1 2 3 4 5 6 7 8]
   [3 4 5 6 7 8 1 2]
   [5 6 7 8 1 2 3 4]
   [7 8 1 2 3 4 5 6]
   [2 1 4 3 6 5 8 7]
   [4 3 6 5 8 7 2 1]
   [6 5 8 7 2 1 4 3]
   [8 7 2 1 4 3 6 5]])

(def sudoku-8-2
  [[6 5 4 3 2 1 8 7]
   [8 7 2 1 4 3 6 5]
   [2 1 8 7 6 5 4 3]
   [7 6 5 4 3 2 1 8]
   [4 3 1 2 8 7 5 6]
   [1 8 3 5 7 6 2 4]
   [5 2 7 6 1 8 3 4]
   [3 4 6 8 5 2 7 1]])

(def sudoku-8-3
  [[5 6 7 8 1 2 3 4]
   [1 2 3 4 5 6 7 8]
   [8 7 6 5 4 3 2 1]
   [4 5 2 1 8 7 6 3]
   [3 1 5 6 7 8 4 2]
   [7 8 4 2 3 1 5 6]
   [6 3 1 7 2 4 8 5]
   [2 4 8 3 6 5 1 7]])

(def sudoku-4-1
  [[1 2 3 4]
   [3 4 1 2]
   [2 1 4 3]
   [4 3 2 1]])

(def sudoku-4-2
  [[1 2 4 3]
   [3 4 2 1]
   [2 1 3 4]
   [4 3 1 2]])

(def sudoku-4-3
  [[1 2 3 4]
   [4 3 2 1]
   [3 1 4 2]
   [2 4 1 3]])

(defn get-random-collection
  "Returns a random collection from the given options."
  [x]
  (let [random-sudoku (case (Integer/parseInt x)
                        4 (rand-nth [sudoku-4-1
                                     sudoku-4-2
                                     sudoku-4-3])
                        8 (rand-nth [sudoku-8-1
                                     sudoku-8-2
                                     sudoku-8-3])
                        9 (rand-nth [sudoku-9-1
                                     sudoku-9-2
                                     sudoku-9-3])
                        (throw (IllegalArgumentException. "Invalid size input")))]
    random-sudoku))
