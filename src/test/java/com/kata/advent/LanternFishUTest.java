package com.kata.advent;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LanternFishUTest {
    @Test
    void next_should_decrease_internal_timer_when_no_zero() {
        List<Integer> internalTimers = List.of(3, 4, 3, 1, 2);

        List<Integer> result = LanternFish.next(internalTimers, 1);

        assertThat(result).containsExactly(2, 3, 2, 0, 1);
    }

    @Test
    void next_should_decrease_internal_timer_and_add_new_internal_timer_when_one_zero() {
        List<Integer> internalTimers = List.of(2, 3, 2, 0, 1);

        List<Integer> result = LanternFish.next(internalTimers, 1);

        assertThat(result).containsExactly(1, 2, 1, 6, 0, 8);
    }

    @Test
    void next_should_return_5934_lantern_fishes_after_80_cycles() {
        List<Integer> internalTimers = List.of(3, 4, 3, 1, 2);

        internalTimers = LanternFish.next(internalTimers, 80);

        assertThat(internalTimers.size()).isEqualTo(5934);
    }
}
