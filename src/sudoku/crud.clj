(ns sudoku.crud
  (:require [clojure.edn :as edn]
            [clojure.java.jdbc :as jdbc]
            [clojure.string :as str]
            [sudoku.dbj :as db]
            [sudoku.input :as input]))

(defn vec->str [v]
  (str "{" (str/join "," (map #(str "{" (str/join "," %) "}") v)) "}"))

(defn str->vec [s]
  (-> s
      (str/replace "{" "[")
      (str/replace "}" "]")
      (edn/read-string)))

(defn create-entry [data]
  (jdbc/insert! db/database :sudoku {:data (vec->str (:data data))}))

(defn retrieve-all []
  (let [rows (jdbc/query db/database ["SELECT * from sudoku"])]
    (doseq [row rows]
      (input/print-sudoku (str->vec (get row :data))))))