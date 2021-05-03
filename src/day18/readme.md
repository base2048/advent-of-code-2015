## [AoC 2015 Day 18: Like a GIF For Your Yard](https://adventofcode.com/2015/day/18)

This time, different to other implementations of cellular automata (see AoC 2020), we set the state directly in the Array without using a separate class for each state. Only to cache the lights that need to be changed, we use an inner class to store the position of the corresponding light. Toggling between 0 and 1 can easily be done by applying an XOR operation `lights[pos.x][pos.y] ^= 1`, which is much nicer than using a subtraction or even an if-else condition.

---

![AoC 2015 Day 18](day18--Like_a_GIF_For_Your_Yard.png?raw=true)
