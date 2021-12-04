(ns aoc-2021.day3-test
  (:require
   [clojure.test :refer [deftest is]]
   [aoc-2021.day3 :as subject]))

(def sample ["00100"
             "11110"
             "10110"
             "10111"
             "10101"
             "01111"
             "00111"
             "11100"
             "10000"
             "11001"
             "00010"
             "01010"])

(deftest first-part-test
  (is (= 198
         (subject/first-part sample))))

(deftest second-part-test
  (is (= 230 (subject/second-part sample))))