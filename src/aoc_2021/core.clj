(ns aoc-2021.core
  (:require [aoc-2021.day1 :as day1]
            [aoc-2021.day2 :as day2]
            [aoc-2021.day3 :as day3]
            [aoc-2021.day4 :as day4]
            [aoc-2021.day5 :as day5]
            [aoc-2021.day6 :as day6]
            [aoc-2021.day7 :as day7]
            [aoc-2021.day8 :as day8]
            [aoc-2021.day9 :as day9]
            [aoc-2021.day10 :as day10]
            [aoc-2021.day11 :as day11])
  (:gen-class))

(defn -main []
  (println "# Advent of Code 2021\n")
  (day1/solution)
  (day2/solution)
  (day3/solution)
  (day4/solution)
  (day5/solution)
  (day6/solution)
  (day7/solution)
  (day8/solution)
  (day9/solution)
  (day10/solution)
  (day11/solution))