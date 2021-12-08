(ns aoc-2021.day7-test
  (:require
   [clojure.test :refer [deftest is]]
   [aoc-2021.day7 :as subject]))

(def sample ["16,1,2,0,4,2,7,1,2,14"])

(deftest format-input-test
  (is (= '(16 1 2 0 4 2 7 1 2 14)
         (subject/format-input sample))))


(deftest costs-of-fuel-test
  (is (= 37
         (subject/costs-of-fuel subject/fuel-logic-part1 (subject/format-input sample) 2)))

  (is (= 41
         (subject/costs-of-fuel subject/fuel-logic-part1 (subject/format-input sample) 1)))

  (is (= 39
         (subject/costs-of-fuel subject/fuel-logic-part1 (subject/format-input sample) 3)))

  (is (= 71
         (subject/costs-of-fuel subject/fuel-logic-part1 (subject/format-input sample) 10)))

  (is (= 168
         (subject/costs-of-fuel subject/fuel-logic-part2 (subject/format-input sample) 5)))

  (is (= 206
         (subject/costs-of-fuel subject/fuel-logic-part2 (subject/format-input sample) 2))))


(deftest lowest-costs-of-fuel-test
  (is (= 37
         (subject/lowest-costs-of-fuel subject/fuel-logic-part1 (subject/format-input sample))))

  (is (= 168
         (subject/lowest-costs-of-fuel subject/fuel-logic-part2 (subject/format-input sample)))))
