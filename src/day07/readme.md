## [AoC 2015 Day 7: Some Assembly Required](https://adventofcode.com/2015/day/7)

Another great seek and replace challenge. All logical gates are combined in an Enum, and their operation methods are assigned to the Enumerals as Lambdas via Functional Interface. Each individual wire gets a reference to the complete *wireByLink* map so that we can keep the entire search and replace logic closed within the *Wire* class.

During search and replace, the *getSignal()* method tries to determine the output signal for the wire based on the input signals. For this purpose, the corresponding gate operation is executed, which gets the required input signals from the *parseDepending()* method. *parseDepending()*, in turn, calls the *getSignal()* method if the gate-input signals have not yet been determined - basically a kind of hidden recursion.

---

![AoC 2015 Day 7](day07--Some_Assembly_Required.png?raw=true)
