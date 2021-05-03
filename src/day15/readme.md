## [AoC 2015 Day 15: Science for Hungry People](https://adventofcode.com/2015/day/15)

The first solution, with which probably almost every programmer comes around the corner first, was a classic one with nested loops, resulting an overall good performance by brute force (156,849 steps to get all cookies baked).

```Java
for (int i = 1; i <= 100 - 3; i++) {
    for (int j = 1; j <= 100 - i - 2; j++) {
        for (int k = 1; k <= 100 - i - j - 1; k++) {
            int l = 100 - i - j - k;
```

However, hard coding is never a good idea and in this case it also prevented testing the code with samples provided by AoC. A more flexible implementation was required. The next solution was implemented recursively but took over 4,000,000 steps for part one - too much. During my research for a more performant approach I found this one: [ShittyFrogMeme AoC Day15](https://www.reddit.com/r/adventofcode/comments/3wwj84/day_15_solutions/cy0l04r/?utm_source=share&utm_medium=web2x&context=3).

Some extra rounds are also made here, which can probably be reduced only by using additional argument variables. Since the runtime is relatively good, and I don't want to complicate the readability anymore, I will leave it at that to finally reach the goal with 328,450 steps. The only improvement that was made was to set the ternary operation query in the for loop from `numIngredients > 1 ? 0 : remainingSpoons` to `numIngredients > 1 ? 1 : remainingSpoons` which reduced the original step count from 358,954  down to 328,450.

---

![AoC 2015 Day 15](day15--Science_for_Hungry_People.png?raw=true)
