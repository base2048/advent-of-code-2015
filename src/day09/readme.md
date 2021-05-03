## [AoC 2015 Day 9: All in a Single Night](https://adventofcode.com/2015/day/9)

TSP: Traveling Santa Problem

Fortunately, the number of locations to be visited is small enough to solve the TSP in an adequate amount of time.

Not necessarily, but just for fun, two different solutions have been implemented: a fully recursive one which calculates all routes and their distances in one pass (*runRoutes()* for part one), and one which first stores all permutations recursively bottom-to-top in an external ArrayList and calculates the distances afterwards (*runRoutesOneWay()* for part two).

In the first solution, we compute routes with the help of a separate *Route* class. As a constructor argument we pass a reference to the *locationToDistanceByLocation* map, so that we can use the *addLocation()* method on the *Route* class without additional complicated logic. The use of an ArrayDeque data structure in the parameter list of *runRoutes()* doesn't put any extra benefit on the table - however, Santa said to keep it that way.

---

![AoC 2015 Day 9](day09--All_in_a_Single_Night.png?raw=true)
