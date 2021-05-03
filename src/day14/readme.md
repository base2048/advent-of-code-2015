## [AoC 2015 Day 14: Reindeer Olympics](https://adventofcode.com/2015/day/14)

Part one is pretty straightforward. Part two, on the other hand, was a bit more complex to implement, especially if you try to do it entirely using the Stream-API.

To meet the requirements, at every second during the race, we need to know which reindeer is currently in the lead. To achieve this, we split a race, say 10 seconds long, into 10 single races, starting with a length of one second, each race then increasing by one second.

The required 2503 races are managed by the outer *IntStream*. The inner *reindeer* stream determines the winners of the particular races and puts them into a TreeMap, grouped by their covered distances, with the distances as keys and the names as values. This way we get a Map sorted by distance in which the last entry contains all currently leading reindeer.

This intermediate result is then passed to the outer stream where, here now referring to the *getHighScore()* method, each reindeer, which was in the lead for a short time, collects its points via the DownStream method *summingInt* - again in a TreeMap, which spares a final sorting. The *getScoreboard()* method is quite similar, except that it does not determine the winner directly, but returns a scoreboard that can then be used to get the winner.

---

![AoC 2015 Day 14](day14--Reindeer_Olympics.png?raw=true)
