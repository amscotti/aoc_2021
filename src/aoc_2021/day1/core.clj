(ns aoc-2021.day1.core
  (:require [aoc-2021.common :as common]))

(defn- count-increases [input]
  (->> (map < input (next input))
       (filter identity)
       (count)))

(def first-part count-increases)

(defn second-part [input]
  (->> (map + input (next input) (nnext input))
       (count-increases)))

(defn solution []
  (let [day "Day 1: Sonar Sweep"
        input (common/get-input "day1" #(Integer/parseInt %))
        first (first-part input)
        second (second-part input)]
    (println (common/format-solutions day first second))))