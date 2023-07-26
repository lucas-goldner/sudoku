(ns sudoku.core
  (:require [sudoku.generator :as generator])
  (:require [sudoku.input :as input])
  (:require [sudoku.game :as game])
  (:require [sudoku.crud :as crud]))

(defn -main
  "Generates sudoku of size x"
  []
  (case (input/explain-inputs)
    "read" (do (println "Will list all past sudokus")
               (crud/retrieve-all))
    "sudoku" ((println "Enter the size of your sudoku. Available sizes: 4, 8 or 9")
              (let [sudoku (generator/create-sudoku (input/ask-for-sudoku-size))]
                (println "Initial sudoku:")
                (input/print-sudoku sudoku)
                (println "Please complete the sudoku by entering your number at the 0s")
                (loop [sudoku sudoku]
                  (let [[updated-sudoku status] (game/process-sudoku sudoku)]
                    (if (= status :finished)
                      (game/finish-sudoku updated-sudoku)
                      (do
                        (println "Updated sudoku:")
                        (input/print-sudoku updated-sudoku)
                        (recur updated-sudoku)))))))))
