(ns aoc-2021.common
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

(defn get-input
  ([day file parse-fn]
   (->> (slurp (io/resource (str day "/" file)))
        (string/split-lines)
        (map parse-fn)))
  ([day parse-fn]
   (get-input day "input.txt" parse-fn))
  ([day]
   (get-input day "input.txt" identity)))

(defn format-solutions [title first-part second-part]
  (str "## " title "\n* Part 1: " first-part "\n* Part 2: " second-part "\n"))