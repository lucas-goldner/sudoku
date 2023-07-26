(ns sudoku.core
  (:require [sudoku.generator :as generator])
  (:require [sudoku.input :as input])
  (:require [sudoku.game :as game]))

(defn -main
  "Generates sudoku of size x"
  []
  (case (input/explain-inputs)
    "read" (println "Implement read old entries")
    "sudoku" ((println "Enter the size of your sudoku. Available sizes: 4, 8 or 9")
              (let [sudoku (generator/create-sudoku (input/ask-for-sudoku-size))]
                (println "Initial sudoku:")
                (game/print-sudoku sudoku)
                (println "Please complete the sudoku by entering your number at the 0s")
                (loop [sudoku sudoku]
                  (let [[updated-sudoku status] (game/process-sudoku sudoku)]
                    (if (= status :finished)
                      (game/finish-sudoku updated-sudoku)
                      (do
                        (println "Updated sudoku:")
                        (game/print-sudoku updated-sudoku)
                        (recur updated-sudoku)))))))))
