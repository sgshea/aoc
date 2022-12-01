(ns day01
  (:require #? (:clj [clojure.java.io :as io]
                     :cljs [nbb.core :refer [slurp await]])
            [clojure.string :as str]
            #? (:cljs [promesa.core :as p])))

;; Different file functions for when running with babashka vs nbb (java vs javascript libraries)
#?(:clj
   (def input (->> (slurp (io/resource "day01.txt"))
                   (str/split-lines)
                   (map parse-long)))
   :cljs
   (def input (await (p/->> (slurp "resources/day01.txt")
                            (str/split-lines)
                            (map parse-long)))))


