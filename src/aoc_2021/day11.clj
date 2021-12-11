(ns aoc-2021.day11
  (:require [aoc-2021.common :as common]))

(defn format-row [input-line]
  (map #(Character/digit % 10) input-line))

(defn create-octopus [row column value]
  {:row row
   :column column
   :energy value
   :flashed? false
   :flash-count 0})

(defn create-octopuses [rows]
  (for [[r row] (map-indexed vector rows)
        [c val] (map-indexed vector row)]
    (create-octopus r c val)))

(defn get-adjacent-index [octopuses index]
  (let [{r :row c :column} (get octopuses index  {:row -1, :column -1})]
    (for [row (range (dec r) (+ 2 r))
          column (range (dec c) (+ 2 c))
          :when (and (not (and (= row r) (= column c)))
                     (and (<= 0 row) (<= 0 column))
                     (and (> 10 row) (> 10 column)))]
      [row column])))

(defn update-octopus-energy [octopuses [r c]]
  (let [i (first (keep-indexed #(when (and (= (:row %2) r) (= (:column %2) c)) %1) octopuses))
        {flashed? :flashed?} (get octopuses i)]
    (if (and i (not flashed?))
      (update-in octopuses [i :energy] inc)
      octopuses)))

(defn spread-flash [octopuses i]
  (let [octopus (get-adjacent-index octopuses i)]
    (reduce #(update-octopus-energy %1 %2) octopuses octopus)))


(defn flashed-octopus [octopuses index]
  (reduce #(%2 %1) octopuses [#(assoc-in % [index :energy] 0)
                              #(assoc-in % [index :flashed?] true)
                              #(update-in % [index :flash-count] inc)]))

(defn get-flashable-octopus [octopuses]
  (keep-indexed #(when (and (> (:energy %2) 9) (not (:flashed? %2))) %1) octopuses))

(defn flash-octopus [octopuses]
  (let [octopus (get-flashable-octopus octopuses)]
    (loop [[i] octopus o octopuses]
      (if (nil? i)
        o
        (let [o (spread-flash (flashed-octopus o i) i)
              r (get-flashable-octopus o)]
          (recur r o))))))

(defn update-all-octopus-energy [octopuses]
  (vec (map #(merge % {:energy (inc (:energy %)) :flashed? false}) octopuses)))

(defn step [octopuses]
  (flash-octopus (update-all-octopus-energy octopuses)))

(defn get-flash-count [octopuses]
  (->> octopuses
       (map :flash-count)
       (reduce +)))

(defn all-flashed? [octopuses]
  (->> octopuses
       (map :flashed?)
       (every? true?)))

(defn format-input [input]
  (->> input
       (map format-row)
       (create-octopuses)
       (vec)))

(defn first-part [input]
  (->> input
       (format-input)
       (iterate step)
       (take (inc 100))
       (last)
       (get-flash-count)))

(defn second-part [input]
  (->> input
       (format-input)
       (iterate step)
       (take-while #(not (all-flashed? %)))
       (count)))

(defn solution []
  (let [day "Day 11: Dumbo Octopus"
        input (common/get-input "day11")
        first (first-part input)
        second (second-part input)]
    (println (common/format-solutions day first second))))