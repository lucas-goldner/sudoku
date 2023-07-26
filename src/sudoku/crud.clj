(ns sudoku.crud
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.string :as str]
            [sudoku.dbj :as db]))

(defn vec->pg-array [v]
  (str "{" (str/join "," (map #(str "{" (str/join "," %) "}") v)) "}"))

(defn create-entry [data]
  (jdbc/insert! db/database :sudoku {:data (vec->pg-array (:data data))}))

;; (defn retrieve-all []
;;   (map (fn [row] (update row :data pg-array->vec))
;;        (jdbc/query db/database ["select * from sudokus"])))
