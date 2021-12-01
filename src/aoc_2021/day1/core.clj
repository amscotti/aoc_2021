(ns aoc-2021.day1.core
  (:require [aoc-2021.common :as common]))

(defn- count-increases [input]
  (->> (partition 2 1 input)
       (filter #(apply < %))
       (count)))

(def first-part count-increases)

(defn second-part [input]
  (->> (partition 3 1 input)
       (map #(apply + %))
       (count-increases)))

(defn solution []
  (let [day "Day 1: Sonar Sweep"
        input (common/get-input "day1" #(Integer/parseInt %))
        first (first-part input)
        second (second-part input)]
    (println (common/format-solutions day first second))))