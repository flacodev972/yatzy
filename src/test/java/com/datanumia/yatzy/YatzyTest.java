package com.datanumia.yatzy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class YatzyTest {

    @Test
    void chance() {
        assertEquals(15, new Yatzy().chance(new DiceRoll(2, 3, 4, 5, 1)));
        assertEquals(16, new Yatzy().chance(new DiceRoll(3, 3, 4, 5, 1)));
        assertEquals(14, new Yatzy().chance(new DiceRoll(1, 1, 3, 3, 6)));
        assertEquals(21, new Yatzy().chance(new DiceRoll(4, 5, 5, 6, 1)));
    }

    @Test
    void yatzy() {
        assertEquals(50, new Yatzy().yatzy(new DiceRoll(4, 4, 4, 4, 4)));
        assertEquals(50, new Yatzy().yatzy(new DiceRoll(6, 6, 6, 6, 6)));
        assertEquals(0, new Yatzy().yatzy(new DiceRoll(6, 6, 6, 6, 3)));
    }

    @Test
    void ones() {
        assertEquals(1, new Yatzy().ones(new DiceRoll(1, 2, 3, 4, 5)));
        assertEquals(2, new Yatzy().ones(new DiceRoll(1, 2, 1, 4, 5)));
        assertEquals(0, new Yatzy().ones(new DiceRoll(6, 2, 2, 4, 5)));
        assertEquals(4, new Yatzy().ones(new DiceRoll(1, 2, 1, 1, 1)));
    }

    @Test
    void pair() {
        assertEquals(4, new Yatzy().twos(new DiceRoll(1, 2, 3, 2, 6)));
        assertEquals(10, new Yatzy().twos(new DiceRoll(2, 2, 2, 2, 2)));
    }

    @Test
    void test_threes() {
        assertEquals(6, new Yatzy().threes(new DiceRoll(1, 2, 3, 2, 3)));
        assertEquals(12, new Yatzy().threes(new DiceRoll(2, 3, 3, 3, 3)));
    }

    @Test
    void fours_test() {
        assertEquals(12, new Yatzy().fours(new DiceRoll(4, 4, 4, 5, 5)));
        assertEquals(8, new Yatzy().fours(new DiceRoll(4, 4, 5, 5, 5)));
        assertEquals(4, new Yatzy().fours(new DiceRoll(4, 5, 5, 5, 5)));
    }

    @Test
    void fives() {
        assertEquals(10, new Yatzy().fives(new DiceRoll(4, 4, 4, 5, 5)));
        assertEquals(15, new Yatzy().fives(new DiceRoll(4, 4, 5, 5, 5)));
        assertEquals(20, new Yatzy().fives(new DiceRoll(4, 5, 5, 5, 5)));
    }

    @Test
    void sixes_test() {
        assertEquals(0, new Yatzy().sixes(new DiceRoll(4, 4, 4, 5, 5)));
        assertEquals(6, new Yatzy().sixes(new DiceRoll(4, 4, 6, 5, 5)));
        assertEquals(18, new Yatzy().sixes(new DiceRoll(6, 5, 6, 6, 5)));
    }

    @Test
    void one_pair() {
        assertEquals(6, new Yatzy().scorePair(new DiceRoll(3, 4, 3, 5, 6)));
        assertEquals(10, new Yatzy().scorePair(new DiceRoll(5, 3, 3, 3, 5)));
        assertEquals(12, new Yatzy().scorePair(new DiceRoll(5, 3, 6, 6, 5)));
        assertEquals(0, new Yatzy().scorePair(new DiceRoll(5, 3, 6, 1, 2)));
    }

    @Test
    void two_Pair() {
        assertEquals(16, new Yatzy().twoPair(new DiceRoll(3, 3, 5, 4, 5)));
        assertEquals(16, new Yatzy().twoPair(new DiceRoll(3, 3, 5, 5, 5)));
        assertEquals(0, new Yatzy().twoPair(new DiceRoll(3, 3, 3, 3, 1)));
    }

    @Test
    void three_of_a_kind() {
        assertEquals(9, new Yatzy().threeOfAKind(new DiceRoll(3, 3, 3, 4, 5)));
        assertEquals(15, new Yatzy().threeOfAKind(new DiceRoll(5, 3, 5, 4, 5)));
        assertEquals(9, new Yatzy().threeOfAKind(new DiceRoll(3, 3, 3, 3, 5)));
        assertEquals(9, new Yatzy().threeOfAKind(new DiceRoll(3, 3, 3, 3, 3)));
    }

    @Test
    void four_of_a_knd() {
        assertEquals(12, new Yatzy().fourOfAKind(new DiceRoll(3, 3, 3, 3, 5)));
        assertEquals(20, new Yatzy().fourOfAKind(new DiceRoll(5, 5, 5, 4, 5)));
    }

    @Test
    void smallStraight() {
        assertEquals(15, new Yatzy().smallStraight(new DiceRoll(1, 2, 3, 4, 5)));
        assertEquals(15, new Yatzy().smallStraight(new DiceRoll(2, 3, 4, 5, 1)));
        assertEquals(0, new Yatzy().smallStraight(new DiceRoll(1, 2, 2, 4, 5)));
    }

    @Test
    void largeStraight() {
        assertEquals(20, new Yatzy().largeStraight(new DiceRoll(6, 2, 3, 4, 5)));
        assertEquals(20, new Yatzy().largeStraight(new DiceRoll(2, 3, 4, 5, 6)));
        assertEquals(0, new Yatzy().largeStraight(new DiceRoll(1, 2, 2, 4, 5)));
    }

    @Test
    void fullHouse() {
        assertEquals(18, new Yatzy().fullHouse(new DiceRoll(6, 2, 2, 2, 6)));
        assertEquals(0, new Yatzy().fullHouse(new DiceRoll(2, 3, 4, 5, 6)));
    }
}
