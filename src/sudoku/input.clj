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

(defn wait-for-sudoku-input
  "Asks for sudoku input"
  []
  (println "Enter the location you want to enter a value e.g: A1, C4 and then enter the desired number")
  (let [location (read-line)
        value (Integer. (read-line))]
    [location value]))

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