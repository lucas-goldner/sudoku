(ns sudoku.crud
  (:require [sudoku.dbj :as db]
            [clojure.java.jdbc :as jdbc]))

(defn create-entry [data]
  (jdbc/insert! db/database :sudoku data))

(defn retrieve-all []
  (jdbc/query db/database ["select * from sudoku"]))

(defn update-entry [id data]
  (jdbc/update! db/database :sudoku data ["id=?" id]))

(defn delete-entry [id]
  (jdbc/delete! db/database :sudoku ["id=?" id]))

