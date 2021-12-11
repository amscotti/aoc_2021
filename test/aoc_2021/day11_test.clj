(ns aoc-2021.day11-test
  (:require
   [clojure.test :refer [deftest is]]
   [aoc-2021.day11 :as subject]))


(def sample ["5483143223"
             "2745854711"
             "5264556173"
             "6141336146"
             "6357385478"
             "4167524645"
             "2176841721"
             "6882881134"
             "4846848554"
             "5283751526"])


(deftest first-part-test
  (is (= 1656
         (subject/first-part sample))))


(deftest second-part-test
  (is (= 195
         (subject/second-part sample))))