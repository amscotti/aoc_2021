(ns aoc-2021.day3
  (:require [aoc-2021.common :as common]))

(defn- to-decimal [binary-number]
  (let [bin-digits {\0 0, \1 1}]
    (->> binary-number
         (map #(bin-digits % 0))
         (reduce (fn [acc b] (+ (* 2 acc) b))))))

(defn- common-bit [position input preference val-fn]
  (let [counts (frequencies (map #(nth % position) input))]
    (if (apply = (vals counts))
      preference
      (key (apply val-fn val counts)))))

(defn- least-common-bit [position input]
  (common-bit position input \0 min-key))

(defn- most-common-bit [position input]
  (common-bit position input \1 max-key))

(defn- get-gamma-rate [input]
  (let [size (count (first input))]
    (loop [gamma-rate "" c 0]
      (if (< c size)
        (recur (str gamma-rate (most-common-bit c input)) (inc c))
        gamma-rate))))

(defn- flip-bits [bits]
  (->> (seq bits)
       (map #(if (= \0 %) \1 \0))
       (apply str)))


(defn- filter-bits [input filter-by]
  (loop [c 0 i input]
    (if (not= 1 (count i))
      (let [common (filter-by c i)]
        (recur (inc c) (filter #(= common (nth % c)) i)))
      (first i))))

(defn- oxygen-generator-rating [input]
  (filter-bits input most-common-bit))

(defn- CO2-scrubber-rating [input]
  (filter-bits input least-common-bit))


(defn first-part [input]
  (let [gamma-rate-bits (get-gamma-rate input)
        epsilon-rate-bits (flip-bits gamma-rate-bits)]
    (* (to-decimal gamma-rate-bits) (to-decimal epsilon-rate-bits))))

(defn second-part [input]
  (let [oxygen-bits (oxygen-generator-rating input)
        CO2-bits (CO2-scrubber-rating input)]
    (* (to-decimal oxygen-bits) (to-decimal CO2-bits))))

(defn solution []
  (let [day "Day 3: Binary Diagnostic"
        input (common/get-input "day3")
        first (first-part input)
        second (second-part input)]
    (println (common/format-solutions day first second))))
