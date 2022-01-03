package com.kata.advent;

import java.util.List;
import java.util.stream.Collectors;

public class LanternFish {

    public static List<Integer> next(List<Integer> internalTimers, int cycles) {
        for (int i = 0; i < cycles; i++) {
            List<Integer> newBabies = internalTimers.stream()
                    .filter(internalTimer -> internalTimer.equals(0))
                    .map(r -> 8)
                    .toList();
            internalTimers = internalTimers.stream()
                    .map(LanternFish::mutate)
                    .collect(Collectors.toList());
            internalTimers.addAll(newBabies);
        }
        return internalTimers;
    }

    private static Integer mutate(Integer internalTimer) {
        if (internalTimer == 0) {
            return 6;
        }
        return --internalTimer;
    }
}
