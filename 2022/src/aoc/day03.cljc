(ns aoc.day03
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [clojure.set :as set]
            [clojure.core.match :refer [match]]))

(def input (->> (slurp (io/resource "aoc/day03.txt"))
               (str/split-lines)))

(def test-input
  (str/split-lines
    "vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg
wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
CrZsJsPPZsGzwwsLwLmpwMDw
"))
;; when using function on here should be 157 for part-1

(defn test
  [_]
  input)

(def alphabet
  "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")

(defn part-1-helper
  "Takes a line and splits it by half, finding the characters in both and converting to priority"
  [line]
  (let [a (set (subs line 0 (/ (count line) 2)))
        b (set (subs line (/ (count line) 2)))]
    (->> (set/intersection a b)
         (map #(+ 1 (str/index-of alphabet %))))))

(defn part-1
  [_]
  (->> input
       (map #(part-1-helper %))
       (flatten)
       (apply +)))

(defn part-2-helper
  "Gets three lines of input and finds the common item, returns priority"
  [three-lines]
  (let [three-lines (map set three-lines)]
    (->> (reduce set/intersection three-lines)
         (map #(+ 1 (str/index-of alphabet %))))))

(defn part-2
  "Takes the same input and paritions each group into its own list then uses helper to find common item"
  [_]
  (->> input
       (partition 3)
       (map part-2-helper)
       (flatten)
       (apply +)))
