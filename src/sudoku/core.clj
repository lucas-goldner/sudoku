(ns sudoku.core
  (:require [sudoku.crud :as crud]))

(defn start []
  (try
    (crud/create-entry {:detail "new entry"})
    (println (crud/retrieve-all))
    (catch Exception e
      (println "An error occurred:" (.getMessage e)))))

(defn -main
  "Manages a database."
  [& args]
  (start))