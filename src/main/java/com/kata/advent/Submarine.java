package com.kata.advent;

import java.util.List;

public class Submarine {

    private int horizontalPosition = 0;
    private int depth = 0;

    public int count(List<Integer> measurements) {

        int count = 0;
        for (int i = 0; i < measurements.size() - 1; i++) {
            if (measurements.get(i + 1) > measurements.get(i)) {
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
        for (Command command :
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

    public int diagnosis(List<String> report) {
        Integer[] columnSums = computeColumnSums(report);

        Diagnosis diagnosis = new Diagnosis(columnSums, report.size());

        return diagnosis.gamma * diagnosis.epsilon;
    }

    private class Diagnosis {
        int gamma;
        int epsilon;

        Diagnosis(Integer[] columnSums, int numberOfReportEntries) {
            String gammaAsBinary = "";
            String epsilonAsBinary = "";

            for (Integer sum : columnSums) {
                boolean moreZerosThanOnes = sum < numberOfReportEntries / 2;
                if (moreZerosThanOnes) {
                    gammaAsBinary += "0";
                    epsilonAsBinary += "1";
                } else {
                    epsilonAsBinary += "0";
                    gammaAsBinary += "1";
                }
            }
            this.gamma = convertBinaryStringToInt(gammaAsBinary);
            this.epsilon = convertBinaryStringToInt(epsilonAsBinary);
        }

        private int convertBinaryStringToInt(String gamma) {
            return Integer.parseInt(gamma, 2);
        }
    }

    private Integer[] computeColumnSums(List<String> report) {
        Integer[] columns = initializeColumnsWithZero(report);
        for (String line : report) {
            for (int columnIndex = 0; columnIndex < line.length(); columnIndex++) {
                char binaryAsChar = line.charAt(columnIndex);
                int columnValue = Integer.parseInt(String.valueOf(binaryAsChar));
                columns[columnIndex] += columnValue;
            }
        }
        return columns;
    }

    private Integer[] initializeColumnsWithZero(List<String> report) {
        int numberOfColumns = report.get(0).length();
        Integer[] columns = new Integer[numberOfColumns];
        for (int i = 0; i < numberOfColumns; i++) {
            columns[i] = 0;
        }
        return columns;
    }
}
