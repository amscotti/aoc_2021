(ns aoc-2021.day5-test
  (:require
   [clojure.test :refer [deftest is]]
   [aoc-2021.day5 :as subject]))


(def sample ["0,9 -> 5,9"
             "8,0 -> 0,8"
             "9,4 -> 3,4"
             "2,2 -> 2,1"
             "7,0 -> 7,4"
             "6,4 -> 2,0"
             "0,9 -> 2,9"
             "3,4 -> 1,4"
             "0,0 -> 8,8"
             "5,5 -> 8,2"])

(deftest first-part-test
  (is (= 5
         (subject/first-part sample))))

(deftest second-part-test
  (is (= 12
         (subject/second-part sample))))