# Advent of Code 2021

My attempts at solving the [Advent of Code 2021](https://adventofcode.com/2021) problems using Clojure.
No promises on how far I will get this year, I will keep going until it's no longer fun. :) 

# Solutions
* [Day 1: Sonar Sweep](src/aoc_2021/day1.clj)
* [Day 2: Dive!](src/aoc_2021/day2.clj)
* [Day 3: Binary Diagnostic](src/aoc_2021/day3.clj)

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
```

`lein test` will run the unit test based on sample inputs from the instructions or other test data

`lein uberjar` will build an jar file