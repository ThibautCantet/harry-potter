package com.kata.advent;

import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;

class SubmarineUTest {

    private final Submarine submarine = new Submarine();

    @Nested
    class CountShouldReturn {
        @Test
        void zero_when_only_one_measurement () {
            int count = submarine.count(List.of(0));

            assertThat(count).isZero();
        }

        @Test
        void increase_measurements_when_depth_increase () {
            int count = submarine.count(asList(0, 1));

            assertThat(count).isOne();
        }

        @Test
        void zero_when_depth_decrease () {
            int count = submarine.count(asList(1, 0));

            assertThat(count).isZero();
        }

        @Test
        void count_should_return_increase_measurements_when_depth_increase_twice () {
            int count = submarine.count(asList(0, 1, 3));

            assertThat(count).isEqualTo(2);
        }
    }
}
