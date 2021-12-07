(ns aoc-2021.day6-test
  (:require
   [clojure.test :refer [deftest is]]
   [aoc-2021.day6 :as subject]))


(def sample ["3,4,3,1,2"])


(deftest format-state-test
  (is (= {0 1, 1 0, 2 0, 3 0, 4 0, 5 0, 6 0, 7 0, 8 0}
         (subject/format-state ["0"])))
  (is (= {0 0, 1 0, 2 0, 3 0, 4 0, 5 0, 6 0, 7 0, 8 1}
         (subject/format-state ["8"])))
  (is (= {0 1, 1 1, 2 1, 3 1, 4 1, 5 1, 6 1, 7 1, 8 1}
         (subject/format-state ["0,1,2,3,4,5,6,7,8"])))
  (is (= {0 0, 1 1, 2 1, 3 2, 4 1, 5 0 6 0, 7 0, 8 0}
         (subject/format-state sample))))


(deftest increase-day-test
  (is (= (subject/format-state ["2,3,2,0,1"])
         (subject/increase-day (subject/format-state sample))))
  
  (is (= (subject/format-state ["1,2,1,6,0,8"])
         (subject/increase-day (subject/format-state ["2,3,2,0,1"]))))

  (is (= (subject/format-state ["0,1,0,5,6,7,8"])
         (subject/increase-day (subject/format-state ["1,2,1,6,0,8"]))))

  (is (= (subject/format-state ["6,0,6,4,5,6,7,8,8"])
         (subject/increase-day (subject/format-state ["0,1,0,5,6,7,8"]))))
  
  (is (= (subject/format-state ["5,6,5,3,4,5,6,7,7,8"])
         (subject/increase-day (subject/format-state ["6,0,6,4,5,6,7,8,8"]))))
  
  (is (= (subject/format-state ["4,5,4,2,3,4,5,6,6,7"])
         (subject/increase-day (subject/format-state ["5,6,5,3,4,5,6,7,7,8"])))))


(deftest first-part-test
  (is (= 5934 (subject/first-part sample))))

(deftest second-part-test
  (is (= 26984457539 (subject/second-part sample))))