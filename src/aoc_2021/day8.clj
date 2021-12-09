(ns aoc-2021.day8
  (:require [aoc-2021.common :as common]
            [clojure.string :as string]
            [clojure.set :as set]))


(defn format-row [input-line]
  (let [[unique-signal-raw output-values-raw] (string/split input-line #"\s\|\s")
        unique-signal (map set (string/split unique-signal-raw #"\s"))
        output-values (map set (string/split output-values-raw #"\s"))]
    [unique-signal output-values]))

(defn find-unique-segments [number-map segment]
  (let [c (count segment)]
    (cond
      (= c 7) (merge number-map {8 segment})
      (= c 3) (merge number-map {7 segment})
      (= c 4) (merge number-map {4 segment})
      (= c 2) (merge number-map {1 segment})
      :else number-map)))

;; Used to find numbers based on numbers already found
(defn find-3 [number-map segments]
  (first (filter #(and (= (count %) 5) (set/subset? (number-map 1) %)) segments)))

(defn find-6 [number-map segments]
  (let [diff (set/difference (number-map 8) (number-map 3))]
    (first (filter #(and (= (count %) 6) (set/subset? diff %) (not (set/subset? (number-map 1) %))) segments))))

(defn find-5 [number-map segments]
  (first (filter #(and (= (count %) 5) (set/subset? % (number-map 6))) segments)))

(defn find-2 [number-map segments]
  (first (filter #(and (= (count %) 5) (and (not= % (number-map 5)) (not= % (number-map 3)))) segments)))

(defn find-0 [number-map segments]
  (let [diff (set/difference (number-map 8) (number-map 3))]
    (first (filter #(and (= (count %) 6) (set/subset? diff %) (not= % (number-map 6))) segments))))

(defn find-9 [number-map segments]
  (first (filter #(and (= (count %) 6) (and (not= % (number-map 6)) (not= % (number-map 0)))) segments)))

;; Used to create the mapping based on looping over the find-fns
(defn create-map [segments segment-map [number find-fn]]
  (let [found (find-fn segment-map segments)]
    (merge segment-map {number found})))

(defn create-number-mapping [segments]
  (let [mapping (reduce find-unique-segments {} segments)]
    (reduce (partial create-map segments) mapping
            [[3 find-3] [6 find-6] [5 find-5] [2 find-2] [0 find-0] [9 find-9]])))

;; Decode one line in the input and get an int
(defn decode-output [mapping output-value]
  (let [invert (set/map-invert mapping)]
    (->> (map invert output-value)
         (reduce str)
         (Integer/parseInt))))

;; Creates the mapping, and then decode the output value
(defn map-and-decode [[segments output-value]]
  (let [mapping (create-number-mapping segments)]
    (decode-output mapping output-value)))


(defn first-part [input]
  (->> input
       (map format-row)
       (mapcat second)
       (map count)
       (filter #{2 3 4 7})
       (count)))

(defn second-part [input]
  (->> input
       (map format-row)
       (map map-and-decode)
       (reduce +)))

(defn solution []
  (let [day "Day 8: Seven Segment Search"
        input (common/get-input "day8")
        first (first-part input)
        second (second-part input)]
    (println (common/format-solutions day first second))))