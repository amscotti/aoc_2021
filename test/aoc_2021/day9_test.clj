(ns aoc-2021.day9-test
  (:require
   [clojure.test :refer [deftest is]]
   [aoc-2021.day9 :as subject]))

(def sample ["2199943210"
             "3987894921"
             "9856789892"
             "8767896789"
             "9899965678"])


(deftest first-part-test
  (is (= 15
         (subject/first-part sample))))

(deftest second-part-test
  (is (= 1134
         (subject/second-part sample))))