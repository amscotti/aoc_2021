(ns aoc-2021.day6
  (:require [aoc-2021.common :as common]
            [clojure.string :as string]))

(def default-state {0 0
                    1 0
                    2 0
                    3 0
                    4 0
                    5 0
                    6 0
                    7 0
                    8 0})

(defn format-state [state-text]
  (->> (string/split (first state-text) #",")
       (map #(Integer/parseInt %))
       (vec)
       (frequencies)
       (merge default-state)))

(defn increase-day [state]
  (assoc default-state
         0 (state 1)
         1 (state 2)
         2 (state 3)
         3 (state 4)
         4 (state 5)
         5 (state 6)
         6 (+ (state 0) (state 7))
         7 (state 8)
         8 (state 0)))

(defn count-after-days [days initial-state]
  (->> initial-state
       (iterate increase-day)
       (take (inc days))
       (last)
       (vals)
       (reduce +)))

(defn first-part [input]
  (->> input
       (format-state)
       (count-after-days 80)))

(defn second-part [input]
  (->> input
       (format-state)
       (count-after-days 256)))

(defn solution []
  (let [day "Day 6: Lanternfish"
        input (common/get-input "day6")
        first (first-part input)
        second (second-part input)]
    (println (common/format-solutions day first second))))