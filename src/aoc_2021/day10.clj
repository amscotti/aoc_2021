(ns aoc-2021.day10
  (:require [aoc-2021.common :as common]
            [clojure.set :as set]))

(def part1-points {\) 3
                   \] 57
                   \} 1197
                   \> 25137})


(def part2-points {\) 1
                   \] 2
                   \} 3
                   \> 4})

(def open {\( \)
           \[ \]
           \{ \}
           \< \>})

(def close (set/map-invert open))

(defn valid? [input]
  (loop [i input stack `()]
    (let [cur (first i)]
      (cond
        (empty? i) (if (empty? stack)
                     {:type :complete :character nil}
                     {:type :incomplete :character (map open stack)})
        (get open cur) (recur (rest i) (conj stack cur))
        (= (first stack) (get close cur)) (recur (rest i) (rest stack))
        (get close cur) {:type :corrupted :character cur}
        :else (recur (rest i) stack)))))

(defn score-incomplete-lines [characters]
  (->> characters
       (map part2-points)
       (reduce #(+ (* %1 5) %2) 0)))

(defn first-part [input]
  (->> input
       (map valid?)
       (filter #(= :corrupted (:type %)))
       (map :character)
       (map part1-points)
       (reduce +)))

(defn second-part [input]
  (->> input
       (map valid?)
       (filter #(= :incomplete (:type %)))
       (map :character)
       (map score-incomplete-lines)
       (sort)
       (vec)
       (#(% (quot (count %) 2)))))

(defn solution []
  (let [day "Day 10: Syntax Scoring"
        input (common/get-input "day10")
        first (first-part input)
        second (second-part input)]
    (println (common/format-solutions day first second))))