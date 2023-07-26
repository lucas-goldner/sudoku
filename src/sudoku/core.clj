(ns sudoku.core
  (:require [sudoku.generator :as generator])
  (:require [sudoku.input :as input])
  (:require [sudoku.game :as game]))

(defn -main
  "Generates sudoku of size x"
  []
  (case (input/explain-inputs)
    "read" (println "Implement read old entries")
    "sudoku" ((println "Enter the size of your sudoku. E.g. 8 or 9")
              (let [sudoku (generator/create-sudoku (input/ask-for-sudoku-size))]
                (println "You can always enter 'finish' to finish the sudoku")
                (loop [sudoku sudoku]
                  (let [updated-sudoku (game/process-sudoku sudoku)]
                    (recur updated-sudoku)))))))
