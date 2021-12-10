(ns aoc-2021.day10-test
  (:require
   [clojure.test :refer [deftest is]]
   [aoc-2021.day10 :as subject]))

(def sample ["[({(<(())[]>[[{[]{<()<>>"
             "[(()[<>])]({[<{<<[]>>("
             "{([(<{}[<>[]}>{[]{[(<()>"
             "(((({<>}<{<{<>}{[]{[]{}"
             "[[<[([]))<([[{}[[()]]]"
             "[{[{({}]{}}([{[{{{}}([]"
             "{<[[]]>}<{[{[{[]{()[[[]"
             "[<(<(<(<{}))><([]([]()"
             "<{([([[(<>()){}]>(<<{{"
             "<{([{{}}[<[[[<>{}]]]>[]]"])


(deftest valid?-test

  (is (= {:type :complete :character nil}
         (subject/valid? "()")))

  (is (= {:type :complete :character nil}
         (subject/valid? "([])")))

  (is (= {:type :complete :character nil}
         (subject/valid? "{()()()}")))

  (is (= {:type :complete :character nil}
         (subject/valid? "<([{}])>")))

  (is (= {:type :complete :character nil}
         (subject/valid? "[<>({}){}[([])<>]]")))

  (is (= {:type :complete :character nil}
         (subject/valid? "(((((((((())))))))))")))

  (is (= {:type :corrupted :character \}}
         (subject/valid? "{([(<{}[<>[]}>{[]{[(<()>")))

  (is (= {:type :corrupted :character \)}
         (subject/valid? "[[<[([]))<([[{}[[()]]]")))

  (is (= {:type :corrupted :character \]}
         (subject/valid? "[{[{({}]{}}([{[{{{}}([]")))

  (is (= {:type :corrupted :character \)}
         (subject/valid? "[<(<(<(<{}))><([]([]()")))

  (is (= {:type :corrupted :character \>}
         (subject/valid? "<{([([[(<>()){}]>(<<{{")))

  (is (= {:type :incomplete :character [\} \} \] \] \) \} \) \]]}
         (subject/valid? "[({(<(())[]>[[{[]{<()<>>")))

  (is (= {:type :incomplete :character [\) \} \> \] \} \)]}
         (subject/valid? "[(()[<>])]({[<{<<[]>>(")))

  (is (= {:type :incomplete :character [\} \} \> \} \> \) \) \) \)]}
         (subject/valid? "(((({<>}<{<{<>}{[]{[]{}")))

  (is (= {:type :incomplete :character [\] \] \} \} \] \} \] \} \>]}
         (subject/valid? "{<[[]]>}<{[{[{[]{()[[[]")))

  (is (= {:type :incomplete :character [\] \) \} \>]}
         (subject/valid? "<{([{{}}[<[[[<>{}]]]>[]]"))))


(deftest first-part-test
  (is (= 26397
         (subject/first-part sample))))

(deftest second-part-test
  (is (= 288957
         (subject/second-part sample))))