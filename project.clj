(defproject sudoku "0.1.0-SNAPSHOT"
  :main sudoku.core
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 ;; Mmore math functions
                 [org.clojure/math.numeric-tower "0.0.5"]
                 ;; More transducers and reducing functions
                 [net.cgrand/xforms "0.19.5"]]
  :repl-options {:init-ns sudoku.core})
