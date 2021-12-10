(ns aoc-2021.day9
  (:require [aoc-2021.common :as common]))

(defn format-row [input-line]
  (vec (map #(Character/digit % 10) input-line)))

(defn get-value-from-matix [matix index]
  (get-in matix index 10))

(defn get-adjacent-index [[y x]]
  (for [y-range (range (dec y) (+ 2 y))
        x-range (range (dec x) (+ 2 x))
        :when (and (or (= y-range y) (= x-range x))
                   (not (and (= y-range y) (= x-range x))))]
    [y-range x-range]))

(defn get-adjacent-values [matix index]
  (map #(get-value-from-matix matix %) (get-adjacent-index index)))

(defn get-lowest-points [matix]
  (for [y (range (count matix))
        x (range (count (get matix y)))
        :let [value (get-value-from-matix matix [y x])]
        :when (< value (reduce min (get-adjacent-values matix [y x])))]
    [y x]))

(defn get-lowest-values [matix]
  (map #(get-value-from-matix matix %) (get-lowest-points matix)))

(defn get-basin-count [matix [y x]]
  (loop [checked #{} [cur & remaining] [[y x]]]
    (if (nil? cur)
      checked
      (let [c (conj checked cur)
            adjacent (filter #(< (get-value-from-matix matix %) 9) (get-adjacent-index cur))
            r (filter #(not (c %)) adjacent)]
        (recur c (set (concat remaining r)))))))


(defn first-part [input]
  (->> input
       (map format-row)
       (vec)
       (get-lowest-values)
       (map inc)
       (reduce +)))

(defn second-part [input]
  (let [matix (vec (map format-row input))]
    (->> matix
         (get-lowest-points)
         (map #(get-basin-count matix %))
         (map count)
         (sort)
         (reverse)
         (take 3)
         (reduce *))))

(defn solution []
  (let [day "Day 9: Smoke Basin"
        input (common/get-input "day9")
        first (first-part input)
        second (second-part input)]
    (println (common/format-solutions day first second))))