package com.kata.advent;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;

class SubmarineUTest {

    private final Submarine submarine = new Submarine();

    @Test
    void constructor_should_initialize_x_and_y_position_to_0_0() {
        assertThat(submarine.getHorizontalPosition()).isZero();
        assertThat(submarine.getDepth()).isZero();
    }

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

    @Nested
    class Command {
        @Test
        void forward_should_increase_horizontalPosition() {
            submarine.command(List.of(new Forward(4), new Forward(2)));

            assertThat(submarine.getHorizontalPosition()).isEqualTo(6);
            assertThat(submarine.getDepth()).isZero();
        }

        @Test
        void down_should_increase_depth() {
            submarine.command(List.of(new Down(4), new Down(2)));

            assertThat(submarine.getHorizontalPosition()).isZero();
            assertThat(submarine.getDepth()).isEqualTo(6);
        }

        @Test
        void up_should_increase_depth() {
            submarine.command(List.of(new Down(4), new Up(2), new Up(2)));

            assertThat(submarine.getHorizontalPosition()).isZero();
            assertThat(submarine.getDepth()).isZero();
        }

        @Test
        void up_should_not_increase_depth_greater_than_0() {
            submarine.command(List.of(new Down(4), new Up(2), new Up(3)));

            assertThat(submarine.getHorizontalPosition()).isZero();
            assertThat(submarine.getDepth()).isZero();
        }

        @Test
        void dive_should_return_depth_multiply_by_horizontalPosition() {
            submarine.command(List.of(
                    new Forward(5),
                    new Down(5),
                    new Forward(8),
                    new Up(3),
                    new Down(8),
                    new Forward(2)
            ));

            assertThat(submarine.getDive()).isEqualTo(150);
        }
    }


    @Nested
    class Consumption {
        @Test
        void should_equal_gamma_multiply_by_epsilon() {
            int consumption = submarine.diagnosis(List.of(
                    "00100",
                    "11110",
                    "10110",
                    "10111",
                    "10101",
                    "01111",
                    "00111",
                    "11100",
                    "10000",
                    "11001",
                    "00010",
                    "01010"));

            assertThat(consumption).isEqualTo(198);
        }
    }
}
