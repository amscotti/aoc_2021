# Advent of Code 2021

My attempts at solving the [Advent of Code 2021](https://adventofcode.com/2021) problems using Clojure.
No promises on how far I will get this year, I will keep going until it's no longer fun. :) 

# Solutions
* [Day 1: Sonar Sweep](src/aoc_2021/day1.clj)
* [Day 2: Dive!](src/aoc_2021/day2.clj)
* [Day 3: Binary Diagnostic](src/aoc_2021/day3.clj)
* [Day 4: Giant Squid](src/aoc_2021/day4.clj)
* [Day 5: Hydrothermal Venture](src/aoc_2021/day5.clj)
* [Day 6: Lanternfish](src/aoc_2021/day6.clj)
* [Day 7: The Treachery of Whales](src/aoc_2021/day7.clj)
* [Day 8: Seven Segment Search](src/aoc_2021/day8.clj)
* [Day 9: Smoke Basin](src/aoc_2021/day9.clj)
* [Day 10: Syntax Scoring](src/aoc_2021/day10.clj)

# Leiningen
This project is using Leiningen, first install it for you can use the `lein` command.

## Run
`lein run` will output something like, 

```
# Advent of Code 2021

## Day 1: Sonar Sweep
* Part 1: 1121
* Part 2: 1065

## Day 2: Dive!
* Part 1: 1427868
* Part 2: 1568138742

## Day 3: Binary Diagnostic
* Part 1: 2954600
* Part 2: 1662846

## Day 4: Giant Squid
* Part 1: 32844
* Part 2: 4920

## Day 5: Hydrothermal Venture
* Part 1: 7142
* Part 2: 20012

## Day 6: Lanternfish
* Part 1: 380758
* Part 2: 1710623015163

## Day 7: The Treachery of Whales
* Part 1: 344138
* Part 2: 94862124

## Day 8: Seven Segment Search
* Part 1: 383
* Part 2: 998900

## Day 9: Smoke Basin
* Part 1: 550
* Part 2: 1100682

## Day 10: Syntax Scoring
* Part 1: 215229
* Part 2: 1105996483
```

`lein test` will run the unit test based on sample inputs from the instructions or other test data

`lein uberjar` will build an jar file