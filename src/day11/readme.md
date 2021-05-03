## [AoC 2015 Day 11: Corporate Policy](https://adventofcode.com/2015/day/11)

This challenge contains some nice little tasks. The heart of the challenge is definitely the incremental counting of a String. For this, we convert the input String into a base 26 int-Array and handle the last carry separately in case the String needs to be extended by one character. Afterwards the int-Array is converted back into a String.

---

![AoC 2015 Day 11](day11--Corporate_Policy.png?raw=true)
