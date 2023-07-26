(ns sudoku.dbj
  (:require [clojure.java.jdbc :as jdbc]))

(def database {:dbtype "postgresql" :dbname "postgres" :user "postgres" :password "mysecretpassword"})

(defn connect []
  (jdbc/get-connection database))
