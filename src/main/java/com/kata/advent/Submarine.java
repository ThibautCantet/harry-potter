package com.kata.advent;

import java.util.List;

public class Submarine {

    private int horizontalPosition = 0;
    private int depth = 0;
    private byte gamma;

    public int count(List<Integer> measurements) {

        int count = 0;
        for (int i = 0; i < measurements.size() -1; i++) {
            if (measurements.get(i+1) > measurements.get(i)) {
                count++;
            }
        }

        return count;
    }

    public int getHorizontalPosition() {
        return horizontalPosition;
    }

    public int getDepth() {
        return depth;
    }

    public void command(List<Command> commands) {
        for (Command command:
             commands) {
            if (command instanceof Forward) {
                horizontalPosition += command.value();
            } else if (command instanceof Down) {
                depth += command.value();
            } else {
                depth -= command.value();
                depth = Math.max(depth, 0);
            }
        }
    }

    public int getDive() {
        return depth * horizontalPosition;
    }

    public void diagnosis(byte [] report) {
        for (byte line :
                report) {
        }
    }

    public byte getGamma() {
        return gamma;
    }
}
