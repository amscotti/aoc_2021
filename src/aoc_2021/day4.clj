(ns aoc-2021.day4
  (:require [aoc-2021.common :as common]
            [clojure.string :as string]))

(defn format-numbers [numbers-text]
  (->>
   (string/split numbers-text #",")
   (map #(Integer/parseInt %))))

(defn format-row [row-text]
  (->> (string/split (string/trim row-text) #"\s(\s?)")
       (map #(Integer/parseInt %))))

(defn create-number [row column value]
  {:row row
   :column column
   :value value
   :marked false})

(defn create-board-numbers [rows]
  (for [[r row] (map-indexed vector rows)
        [c val] (map-indexed vector row)]
    (create-number r c val)))

(defn create-board [board-text]
  (->> board-text
       (map format-row)
       (create-board-numbers)
       (vec)))

(defn is-board-winner? [board]
  (or
   (->> board
        (group-by :row)
        (map val)
        (map #(every? :marked %))
        (some true?))
   (->> board
        (group-by :column)
        (map val)
        (map #(every? :marked %))
        (some true?))))

(defn update-marked-number [number board]
  (let [i (first (keep-indexed #(when (= (:value %2) number) %1) board))]
    (if i
      (update-in board [i :marked] not)
      board)))

(defn sum-of-unmarked [board]
  (->> board
       (remove :marked)
       (map :value)
       (reduce +)))

(defn create-boards [boards-text]
  (loop [boards [] board-rows [] [cur & remaining] boards-text]
    (cond
      (nil? cur) (conj boards (create-board board-rows))
      (not= "" cur) (recur boards (conj board-rows cur) remaining)
      (= "" cur) (recur (conj boards (create-board board-rows)) [] remaining))))

(defn bingo-subsystem-part1 [boards numbers]
  (loop [boards boards [n & remaining] numbers]
    (let [update-boards (map #(update-marked-number n %) boards)
          winner (first (filter is-board-winner? update-boards))]
      (cond
        winner {:number n :broad winner}
        (nil? n) nil
        :else (recur update-boards remaining)))))

(defn bingo-subsystem-part2 [boards numbers]
  (loop [boards boards winning-boards [] [n & remaining] numbers]
    (let [update-boards (map #(update-marked-number n %) boards)
          winners (filter is-board-winner? update-boards)]
      (cond
        (nil? n) (first winning-boards)
        :else (recur (remove is-board-winner? update-boards)
                     (concat (map #(-> {:number n :broad %}) winners) winning-boards)
                     remaining)))))

(defn first-part [[numbers-text & boards-text]]
  (let [numbers (format-numbers numbers-text)
        boards (create-boards (next boards-text))
        {number :number broad :broad} (bingo-subsystem-part1 boards numbers)]
    (* number (sum-of-unmarked broad))))

(defn second-part [[numbers-text & boards-text]]
  (let [numbers (format-numbers numbers-text)
        boards (create-boards (next boards-text))
        {number :number broad :broad} (bingo-subsystem-part2 boards numbers)]
    (* number (sum-of-unmarked broad))))

(defn solution []
  (let [day "Day 4: Giant Squid"
        input (common/get-input "day4")
        first (first-part input)
        second (second-part input)]
    (println (common/format-solutions day first second))))
