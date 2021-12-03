(ns aoc-2021.day1-test
  (:require
   [clojure.test :refer [deftest is]]
   [aoc-2021.day1 :as subject]))

(def sample [199 200 208 210 200 207 240 269 260 263])

(deftest first-part-test
  (is (= 7 (subject/first-part sample))))

(deftest second-part-test
  (is (= 5 (subject/second-part sample))))