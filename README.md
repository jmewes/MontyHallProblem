# Monty Hall Problem
> Suppose you're on a game show, and you're given the choice of three doors: Behind one door is a car; behind the others, goats. You pick a door, say No. 1, and the host, who knows what's behind the doors, opens another door, say No. 3, which has a goat. He then says to you, "Do you want to pick door No. 2?" Is it to your advantage to switch your choice?

([Wikipedia](https://en.wikipedia.org/wiki/Monty_Hall_problem))

# Solution
You should always switch your answer as you will have a success probability of 67% in this case. If you stick with your original answer you will have a success probability of only 33%.

# Try it out
Some people don't believe that this solution is right as it is counter-intutive for them. If this is the case for you, you can run the [ProbabilityTest](https://github.com/jmewes/MontyHallProblem/blob/master/src/test/java/ProbabilityTest.java) from this project by yourself.
## Dependencies
```
sudo apt-get install openjdk-8-jdk
sudo apt-get install gradle
```
## Run the tests
```
gradle test
```

# Explanation
[The Monty Hall Problem](https://www.youtube.com/watch?v=mhlc7peGlGg) | Ron Clarke
