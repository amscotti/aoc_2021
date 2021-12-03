(ns aoc-2021.core
  (:require [aoc-2021.day1 :as day1]
            [aoc-2021.day2 :as day2])
  (:gen-class))

(defn -main []
  (println "# Advent of Code 2021\n")
  (day1/solution)
  (day2/solution))