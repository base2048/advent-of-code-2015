## [AoC 2015 Day 19: Medicine for Rudolph](https://adventofcode.com/2015/day/19)

A brute force solution is not capable of completing the task from part two in a reasonable amount of time. Therefore, a different approach was taken. So we start with the end result and try to get to the beginning by reverse engineering. Previously the replacement list was sorted, one time ascending which did not lead to success, and one time descending, which finally produced a valid result. Of course, this is not a generally applicable approach, but in our specific case for our input data it works. The test input data provided by AoC will end in an infinite loop!

---

![AoC 2015 Day 19](day19--Medicine_for_Rudolph.png?raw=true)
