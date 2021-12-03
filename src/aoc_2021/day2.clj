(ns aoc-2021.day2
  (:require [aoc-2021.common :as common]))

(def starting {:horizontal 0
               :depth 0
               :aim 0})

(defn- get-command [command-string]
  (let [[_ i c] (re-matches #"^(forward|down|up)\s(\d*)?$" command-string)]
    {:command (keyword i)
     :unit (Integer/parseInt c)}))


(defn- part1-updates [{command :command unit :unit} position]
  (condp = command
    :forward (update position :horizontal + unit)
    :down (update position :depth + unit)
    :up (update position :depth - unit)))


(defn- part2-updates [{command :command unit :unit} position]
  (condp = command
    :forward (merge position {:horizontal (+ (:horizontal position) unit)
                              :depth (+ (:depth position) (* (:aim position) unit))})
    :down (update position :aim + unit)
    :up (update position :aim - unit)))


(defn- decode-commands
  ([update-fn commands] (decode-commands starting update-fn commands))
  ([starting-position update-fn commands]
   (loop [[cur & remaining] commands position starting-position]
     (if (nil? cur)
       position
       (recur remaining (update-fn cur position))))))


(defn- calculate [{horizontal :horizontal depth :depth}]
  (* horizontal depth))


(defn first-part [input]
  (->> input
       (map get-command)
       (decode-commands part1-updates)
       (calculate)))

(defn second-part [input]
  (->> input
       (map get-command)
       (decode-commands part2-updates)
       (calculate)))

(defn solution []
  (let [day "Day 2: Dive!"
        input (common/get-input "day2")
        first (first-part input)
        second (second-part input)]
    (println (common/format-solutions day first second))))