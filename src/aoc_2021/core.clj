(ns aoc-2021.core
  (:require [aoc-2021.day1 :as day1]
            [aoc-2021.day2 :as day2]
            [aoc-2021.day3 :as day3]
            [aoc-2021.day4 :as day4]
            [aoc-2021.day5 :as day5]
            [aoc-2021.day6 :as day6]
            [aoc-2021.day7 :as day7])
  (:gen-class))

(defn -main []
  (println "# Advent of Code 2021\n")
  (day1/solution)
  (day2/solution)
  (day3/solution)
  (day4/solution)
  (day5/solution)
  (day6/solution)
  (day7/solution))