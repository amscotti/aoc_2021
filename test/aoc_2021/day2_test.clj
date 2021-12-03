(ns aoc-2021.day2-test
  (:require
   [clojure.test :refer [deftest is]]
   [aoc-2021.day2 :as subject]))


(def sample ["forward 5"
             "down 5"
             "forward 8"
             "up 3"
             "down 8"
             "forward 2"])

(deftest first-part-test
  (is (= 150
         (subject/first-part sample))))

(deftest second-part-test
  (is (= 900
         (subject/second-part sample))))