# [Advent of Code 2015](https://adventofcode.com/2015)

|   # | Challenge                                                                     | Solution              | Keywords                    |
|:---:|:-----------------------------------------------------------------------------:|:---------------------:|:----------------------------|
|   1 | [Not Quite Lisp](https://adventofcode.com/2015/day/1)                         | [Solution](src/day01) |                             |
|   2 | [I Was Told There Would Be No Math](https://adventofcode.com/2015/day/2)      | [Solution](src/day02) |                             |
|   3 | [Perfectly Spherical Houses in a Vacuum](https://adventofcode.com/2015/day/3) | [Solution](src/day03) |                             |
|   4 | [The Ideal Stocking Stuffer](https://adventofcode.com/2015/day/4)             | [Solution](src/day04) |                             |
|   5 | [Doesn't He Have Intern-Elves For This?](https://adventofcode.com/2015/day/5) | [Solution](src/day05) | Predicates                  |
|   6 | [Probably a Fire Hazard](https://adventofcode.com/2015/day/6)                 | [Solution](src/day06) |                             |
|   7 | [Some Assembly Required](https://adventofcode.com/2015/day/7)                 | [Solution](src/day07) | FI Assigned to Enumerals    |
|   8 | [Matchsticks](https://adventofcode.com/2015/day/8)                            | [Solution](src/day08) |                             |
|   9 | [All in a Single Night](https://adventofcode.com/2015/day/9)                  | [Solution](src/day09) | Recursion, TSP, Permutation |
|  10 | [Elves Look, Elves Say](https://adventofcode.com/2015/day/10)                 | [Solution](src/day10) | Look-and-Say                |
|  11 | [Corporate Policy](https://adventofcode.com/2015/day/11)                      | [Solution](src/day11) | Incrementing Strings        |
|  12 | [JSAbacusFramework.io](https://adventofcode.com/2015/day/12)                  | [Solution](src/day12) | Recursion, JavaScript       |
|  13 | [Knights of the Dinner Table](https://adventofcode.com/2015/day/13)           | [Solution](src/day13) | Recursion, TSP              |
|  14 | [Reindeer Olympics](https://adventofcode.com/2015/day/14)                     | [Solution](src/day14) | Weird Streams               |
|  15 | [Science for Hungry People](https://adventofcode.com/2015/day/15)             | [Solution](src/day15) |                             |
|  16 | [Aunt Sue](https://adventofcode.com/2015/day/16)                              | [Solution](src/day16) |                             |
|  17 | [No Such Thing as Too Much](https://adventofcode.com/2015/day/17)             | [Solution](src/day17) | Recursion, Kind of Knapsack |
|  18 | [Like a GIF For Your Yard](https://adventofcode.com/2015/day/18)              | [Solution](src/day18) | 2D Cellular Automaton       |
|  19 | [Medicine for Rudolph](https://adventofcode.com/2015/day/19)                  | [Solution](src/day19) |                             |
|  20 | [Infinite Elves and Infinite Houses](https://adventofcode.com/2015/day/20)    | [Solution](src/day20) | Sieve of Eratosthenes       |
|  21 | [RPG Simulator 20XX](https://adventofcode.com/2015/day/21)                    | [Solution](src/day21) |                             |
|  22 | [Wizard Simulator 20XX](https://adventofcode.com/2015/day/22)                 | [Solution](src/day22) | OOP, SpellsLineupGenerator  |
|  23 | [Opening the Turing Lock](https://adventofcode.com/2015/day/23)               | [Solution](src/day23) | Turing Machine              |
|  24 | [It Hangs in the Balance](https://adventofcode.com/2015/day/24)               | [Solution](src/day24) | Recursion, Kind of Knapsack |
|  25 | [Let It Snow](https://adventofcode.com/2015/day/25)                           | [Solution](src/day25) |                             |

All challenges were implemented in Java, except for day 12, which was done in JavaScript. Interesting challenges can be found on [Day 14](src/day14), [Day 17](src/day17) and [Day 23](src/day23), perhaps [Day 22](src/day22) should also be mentioned due to its complexity.

A click on the challenge link directly leads to the corresponding challenge page on [Advent of Code](https://adventofcode.com). As long as part one of the daily challenge has not been completed successfully, part two is not visible. Therefore, a screenshot with the complete challenge information was added to the source folder of the day. A click on *Solution* leads straight to the daily folder.

The challenges are all structured in the same way. The *Main* file is the entry point. In it, an instance of *Challenge* is created. The input data, which can be found in *data.txt*, is passed to the challenge constructor by means of *Parser*. The parser usually prepares the input data in a boilerplate manner, but sometimes, as for example on [Day 13](src/day13) or [Day 16](src/day16), interesting logic can already be found here. The actual business logic is then located in *Challenge* and further classes.

Code blocks in the *readme* files did not make it into the final versions. Usually these are alternate implementations, but I consider the final ones to be nicer, more modern or simply faster. Please think of this code as additional information only.

An explicit check for accuracy of the input data as well as of the passed parameter values within the implementation has been omitted in the interest of clarity and readability. We assume that both the input data and the passed values are correct. Of course, I have checked the code and the results and can confirm that everything is fine.

---

![AoC 2015 Tree](src/tree.png?raw=true)
