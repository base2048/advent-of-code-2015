## [AoC 2015 Day 20: Infinite Elves and Infinite Houses](https://adventofcode.com/2015/day/20)

To solve this problem in proper time we use the Sieve of Eratosthenes. Due to this fact, we cannot check directly every time we deliver to a house if it is the one we are looking for. This is because the algorithm does not continuously deliver to the houses. We must first wait for the total deliveries and then look up the target house. The selected maximum number of 1,000,000 houses is an arbitrary estimate. Refactoring duplicate code was not done for the sake of clarity.

---

![AoC 2015 Day 20](day20--Infinite_Elves_and_Infinite_Houses.png?raw=true)
