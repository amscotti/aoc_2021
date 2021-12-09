(ns aoc-2021.day8-test
  (:require
   [clojure.test :refer [deftest is]]
   [aoc-2021.day8 :as subject]))


(def sample ["be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe"
             "edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc"
             "fgaebd cg bdaec gdafb agbcfd gdcbef bgcad gfac gcb cdgabef | cg cg fdcagb cbg"
             "fbegcd cbd adcefb dageb afcb bc aefdc ecdab fgdeca fcdbega | efabcd cedba gadfec cb"
             "aecbfdg fbg gf bafeg dbefa fcge gcbea fcaegb dgceab fcbdga | gecf egdcabf bgf bfgea"
             "fgeab ca afcebg bdacfeg cfaedg gcfdb baec bfadeg bafgc acf | gebdcfa ecba ca fadegcb"
             "dbcfg fgd bdegcaf fgec aegbdf ecdfab fbedc dacgb gdcebf gf | cefg dcbef fcge gbcadfe"
             "bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | ed bcgafe cdgba cbgef"
             "egadfb cdbfeg cegd fecab cgb gbdefca cg fgcdab egfdb bfceg | gbdfcae bgc cg cgb"
             "gcafb gcf dcaebfg ecagb gf abcdeg gaef cafbge fdbac fegbdc | fgae cfgab fg bagce"])


(deftest format-row-test
  (is (= ['(#{\b \e} #{\a \b \c \d \e \f \g} #{\b \c \d \e \f \g} #{\a \c \d \e \f \g} #{\b \c \e \g} #{\c \d \e \f \g} #{\a \b \d \e \f \g} #{\b \c \d \e \f} #{\a \b \c \d \f} #{\b \d \e})
          '(#{\a \b \c \d \e \f \g} #{\b \c \d \e \f} #{\b \c \d \e \f \g} #{\b \c \e \g})]
         (subject/format-row (first sample)))))

(deftest first-part-test
  (is (= 26
         (subject/first-part sample))))

(deftest second-part-test
  (is (= 61229 
         (subject/second-part sample))))