(ns aoc.day02
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [clojure.core.match :refer [match]]))

(def input (->> (slurp (io/resource "aoc/day02.txt"))
               (str/split-lines)))

(defn test
  [_]
  input)

(defn test-line
  "This function is used to convert corresponding letters to numbers and then test the different rock-paper-scissors
  combinations and create numeric result according to formula"
  [i j]
  (let [i (cond
            (= i "A") 1
            (= i "B") 2
            (= i "C") 3)
        j (cond
            (= j "X") 1
            (= j "Y") 2
            (= j "Z") 3)]
    (+
     j
     (cond
       (= i j) 3
       (and (= i 1) (= j 3)) 0
       (and (= i 2) (= j 1)) 0
       (and (= i 3) (= j 2)) 0
       :else 6))))

(defn part-1
  "Splits each line into two players then uses test function on each line to get score for each round
  which is then added up"
  [_]
  (->> input
       (map #(str/split % #" "))
       (map #(test-line (first %) (last %)))
       (apply +)))

(defn test-line-2
  "Finds the move needed to win/lose/draw based on opponent"
  [i j]
  (if (= j "Y")
    (match [i]
           ["A"] 4
           ["B"] 5
           ["C"] 6)
    (cond
      (= j "Z") (match [i]
                       ["A"] 8
                       ["B"] 9
                       ["C"] 7)
      (= j "X") (match [i]
                       ["A"] 3
                       ["B"] 1
                       ["C"] 2))))

(defn part-2
  [_]
  (->> input
       (map #(str/split % #" "))
       (map #(test-line-2 (first %) (last %)))
       (apply +)))
