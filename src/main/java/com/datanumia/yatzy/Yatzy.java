package com.datanumia.yatzy;

import java.util.List;

public class Yatzy {

    public int chance(DiceRoll diceRoll) {
        return diceRoll.sum();
    }

    public int yatzy(DiceRoll diceRoll) {
        return diceRoll.isYatzy() ? 50 : 0;
    }

    public int ones(DiceRoll diceRoll) {
        return diceRoll.countDice(1);
    }

    public int twos(DiceRoll diceRoll) {
        return diceRoll.countDice(2) * 2;
    }

    public int threes(DiceRoll diceRoll) {
        return diceRoll.countDice(3) * 3;
    }

    public int fours(DiceRoll diceRoll) {
        return diceRoll.countDice(4) * 4;
    }

    public int fives(DiceRoll diceRoll) {
        return diceRoll.countDice(5) * 5;
    }

    public int sixes(DiceRoll diceRoll) {
        return diceRoll.countDice(6) * 6;
    }

    public int scorePair(DiceRoll diceRoll) {
        List<Integer> pairs = diceRoll.findPairs();
        return pairs.isEmpty() ? 0 : pairs.get(0) * 2;
    }

    public int twoPair(DiceRoll diceRoll) {
        List<Integer> pairs = diceRoll.findPairs();
        if (pairs.size() >= 2) {
            return pairs.stream().mapToInt(p -> p * 2).sum();
        }
        return 0;
    }

    public int fourOfAKind(DiceRoll diceRoll) {
        return diceRoll.findDiceEqualsOrGreaterThan(4) * 4;
    }

    public int threeOfAKind(DiceRoll diceRoll) {
        return diceRoll.findDiceEqualsOrGreaterThan(3) * 3;
    }

    public int smallStraight(DiceRoll diceRoll) {
        return diceRoll.isStraight(1, 5) ? 15 : 0;
    }

    public int largeStraight(DiceRoll diceRoll) {
        return diceRoll.isStraight(2, 6) ? 20 : 0;
    }

    public int fullHouse(DiceRoll diceRoll) {
        return diceRoll.isFullHouse() ? diceRoll.sum() : 0;
    }
}



