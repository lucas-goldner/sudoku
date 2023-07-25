(ns sudoku.input)

(defn explain-inputs "Ask for user inputs" []
  (println "Following inputs are available:")
  (println "To start a new sudoku: sudoku")
  (println "To see past entries enter: read")
  (println "To exit the program enter: exit")
  (read-line))

(defn ask-for-sudoku-size "Asks for sudoku size"
  []
  (println "To starting a new sudoku: sudoku")
  (read-line))