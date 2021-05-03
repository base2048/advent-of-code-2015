## [AoC 2015 Day 13: Knights of the Dinner Table](https://adventofcode.com/2015/day/13)

Another great optimization task in the sense of the TSP. Basically almost the same challenge as from day 9, but this time with a closed graph.

Parsing and preparing the data in the right way is half of the battle here, again. Each *Guest* object contains a Map with all other guests and the corresponding happy-units. For part two these Maps have to be extended by one guest. As with day 9, the use of an ArrayDeque data structure in the parameter list of the *runArrangements()* method adds no value - however, Santa says it must be done, again.

---

![AoC 2015 Day 13](day13--Knights_of_the_Dinner_Table.png?raw=true)
