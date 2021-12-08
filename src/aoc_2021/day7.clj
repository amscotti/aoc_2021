(ns aoc-2021.day7
  (:require [aoc-2021.common :as common]
            [clojure.string :as string]))

(defn format-input [input]
  (->> (string/split (first input) #",")
       (map #(Integer/parseInt %))
       (frequencies)))

(defn get-change [to-position position]
  (Math/abs (- to-position position)))

(defn fuel-logic-part1 [to-position [position n]]
  (* n (get-change to-position position)))

(defn fuel-logic-part2 [to-position [position n]]
  (let [change (get-change to-position position)]
    (* n (/ (* change (+ change 1)) 2))))

(defn costs-of-fuel [fuel-logic-fn positions to-position]
  (->> positions
       (map (partial fuel-logic-fn to-position))
       (reduce +)))

(defn lowest-costs-of-fuel [fuel-logic-fn input]
  (let [positions (keys input)
        min-position (reduce min positions)
        max-position (reduce max positions)]
    (->> (range min-position (inc max-position))
         (map (partial costs-of-fuel fuel-logic-fn input))
         (reduce min))))

(defn first-part [input]
  (->> input
       format-input
       (lowest-costs-of-fuel fuel-logic-part1)))

(defn second-part [input]
  (->> input
       format-input
       (lowest-costs-of-fuel fuel-logic-part2)))

(defn solution []
  (let [day "Day 7: The Treachery of Whales"
        input (common/get-input "day7")
        first (first-part input)
        second (second-part input)]
    (println (common/format-solutions day first second))))