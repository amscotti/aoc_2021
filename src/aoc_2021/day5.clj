(ns aoc-2021.day5
  (:require [aoc-2021.common :as common]
            [clojure.string :as string]))


(defn format-line-point-text [line-point-text]
  (->> (string/split line-point-text #",")
       (map #(Integer/parseInt %))))

(defn format-line-segment-text [line-segment-text]
  (->> (string/split line-segment-text #" -> ")
       (map format-line-point-text)))

(defn is-horizontal-and-vertical-lines? [[[x1 y1] [x2 y2]]]
  (or (= x1 x2) (= y1 y2)))

(defn change-rate [point1 point2]
  (let [rate (- point2 point1)]
    (condp apply [rate]
           neg-int? -1
           pos-int? 1
           zero? 0)))

(defn get-points [[start end]]
  (let [[x1 y1] start
        [x2 y2] end
        dx (change-rate x1 x2)
        dy (change-rate y1 y2)]
    (loop [points [start] [x y] start]
      (let [xp (+ dx x) yp (+ dy y)
            point [xp yp]]
        (if (and (= xp x2) (= yp y2))
          (conj points point)
          (recur (conj points point) point))))))

(defn overlap-count [list-of-points]
  (->> (frequencies list-of-points)
       (map second)
       (filter #(<= 2 %))
       (count)))

(defn first-part [input]
  (->> input
       (map format-line-segment-text)
       (filter is-horizontal-and-vertical-lines?)
       (map get-points)
       (reduce concat)
       (overlap-count)))

(defn second-part [input]
  (->> input
       (map format-line-segment-text)
       (map get-points)
       (reduce concat)
       (overlap-count)))

(defn solution []
  (let [day "Day 5: Hydrothermal Venture"
        input (common/get-input "day5")
        first (first-part input)
        second (second-part input)]
    (println (common/format-solutions day first second))))