(ns aoc.day04
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [clojure.set :as set]))

(def input (->> (slurp (io/resource "aoc/day04.txt"))
               (str/split-lines)))

(def test-input
  (str/split-lines
    "2-4,6-8
2-3,4-5
5-7,7-9
2-8,3-7
6-6,4-6
2-6,4-8
"))
;; when using function on here should be 157 for part-1

(defn test
  [_]
  test-input)

(defn into-range
  "Turns the sections into range"
  [r]
  (let [a (first (str/split r #"-"))
        b (second (str/split r #"-"))]
    (->> (range (Integer/parseInt a) (+ 1 (Integer/parseInt b)))
         (set))))

(defn part-1-helper
  "Splits line and tests if either part is a subset of the other"
  [line]
  (let [a (into-range (first (str/split line #",")))
        b (into-range (second (str/split line #",")))]
    (if (or (set/subset? a b) (set/subset? b a))
      1
      0)))

(defn part-1
  "Uses helper on each line then adds count"
  [_]
  (->> input
       (map #(part-1-helper %))
       (reduce +)))

(defn part-2-helper
  "Splits line and tests if there is any intersection"
  [line]
  (let [a (into-range (first (str/split line #",")))
        b (into-range (second (str/split line #",")))]
    (if (empty? (set/intersection a b))
      0
      1)))

(defn part-2
  "Uses helper on each line then adds count"
  [_]
  (->> input
       (map #(part-2-helper %))
       (reduce +)))
