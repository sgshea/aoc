(ns aoc.day01
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def input (->> (slurp (io/resource "aoc/day01.txt"))
               (str/split-lines)
               (map parse-long)))

; Run with (n)bb -x aoc.day01/part-1
 
(defn create-sorted-list
  "Creates a sorted list to find the most calories"
  [input]
  (->> (partition-by nil? input)
       (map #(reduce + %))
       (remove nil?)
       (sort >)))

(defn part-1
  "Simply gets the max"
  [_]
  (first (create-sorted-list input)))

(defn part-2
  "Gets the first three numbers and add together"
  [_]
  (reduce + (take 3 (create-sorted-list input))))

