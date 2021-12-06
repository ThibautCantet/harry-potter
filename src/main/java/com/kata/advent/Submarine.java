package com.kata.advent;

import java.util.List;

public class Submarine {
    public int count(List<Integer> measurements) {

        int count = 0;
        for (int i = 0; i < measurements.size() -1; i++) {
            if (measurements.get(i+1) > measurements.get(i)) {
                count++;
            }
        }

        return count;
    }
}
