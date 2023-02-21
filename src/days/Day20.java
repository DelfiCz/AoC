package days;

import importer.AdventOfCodeInputImporter;

import java.util.ArrayList;

public class Day20 extends AbstractDay{

    public Day20() {
        super(2022, 20, 1);
    }

    /**
     * Class representing an integer. I cannot use Integer because for Integer, same values are the same object.
     * @see Integer
     */
    static class IntClass {
        private final int value;

        public IntClass(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @Override
    public long solution(AdventOfCodeInputImporter input) {
        String line;
        ArrayList<IntClass> data = new ArrayList<>();
        while ((line = input.readLine()) != null) {
            data.add(new IntClass(Integer.parseInt(line)));
        }
        ArrayList<IntClass> toMix = new ArrayList<>(data);
        IntClass zero = null;
        for(IntClass number: data) {
            if (number.getValue() == 0) {
                zero = number;
            }
            int index = toMix.indexOf(number);
            toMix.remove(index);
            int shift = number.getValue() % toMix.size();
            toMix.add((index + shift + toMix.size()) % toMix.size(), number);
        }
        int zeroIndex = toMix.indexOf(zero);
        return toMix.get((zeroIndex + 1000)% toMix.size()).value +
                toMix.get((zeroIndex + 2000)% toMix.size()).value +
                toMix.get((zeroIndex + 3000)% toMix.size()).value;
    }
}
