package com.datanumia.yatzy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DiceRoll {

    private final List<Integer> dices;
    public DiceRoll(int d1, int d2, int d3, int d4, int d5) {
        this.dices = Arrays.asList(d1, d2, d3, d4, d5);
    }

    /**
     * Counts the number of time each side of the die comes out
     */
    public Map<Integer, Integer> counts(){
        return dices.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.reducing(0, (p, c) -> p + 1)));
    }

    /**
     * Sum all the dices
     */
    public int sum() {
        return dices.stream().mapToInt(Integer::intValue).sum();
    }

    /**
     * Get the count of a given side of a die
     * @param side the side of a die
     * @return the count of the given side
     */
    public int countDice(int side) {
        return counts().getOrDefault(side, 0);
    }

    public boolean isYatzy() {
        return counts().values().stream().anyMatch(c -> c == 5);
    }

    /**
     * Retrieves pairs between the dice rolls
     */
    public List<Integer> findPairs() {
        return filterDiceEqualsOrGreaterThan(2)
            .sorted(Comparator.reverseOrder())
            .toList();
    }

    /**
     * Retrieves die with n occurrences
     */
    public int findDiceEqualsOrGreaterThan(int n) {
        return filterDiceEqualsOrGreaterThan(n)
            .findFirst()
            .orElse(0);
    }

    public boolean isStraight(int start, int end) {
        Map<Integer, Integer> counts = counts();
        return IntStream.rangeClosed(start, end).allMatch(i -> counts.get(i) == 1);
    }

    public boolean isFullHouse() {
        boolean hasThreeOfAKind = findDiceEqualsOrGreaterThan(3) != 0;
        boolean hasAPair = !findPairs().isEmpty();
        boolean isNotYatzy = !isYatzy();
        return hasThreeOfAKind && hasAPair && isNotYatzy;
    }

    private Stream<Integer> filterDiceEqualsOrGreaterThan(int n) {
        return counts().entrySet().stream()
            .filter(e -> e.getValue() >= n)
            .map(Map.Entry::getKey);
    }
}

