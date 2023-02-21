package days;

import importer.AdventOfCodeInputImporter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Day20b extends AbstractDay{

    public Day20b() {
        super(2022, 20, 1);
    }

    /**
     * Class representing an integer. I cannot use Integer because for Integer, same values are the same object.
     * @see Integer
     */
    static class LongClass {
        private final long value;

        public LongClass(long value) {
            this.value = value;
        }

        public long getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @Override
    public long solution(AdventOfCodeInputImporter input) {        long decryptionKey = 811589153;
        String line;
        ArrayList<LongClass> data = new ArrayList<>();
        while ((line = input.readLine()) != null) {
            data.add(new LongClass(decryptionKey*Integer.parseInt(line)));
        }
        ArrayList<LongClass> toMix = new ArrayList<>(data);
        LongClass zero = null;
        for(int i = 0; i < 10; i++) {
            for(LongClass number: data) {
                if (number.getValue() == 0) {
                    zero = number;
                }
                int index = toMix.indexOf(number);
                toMix.remove(index);
                long shift = number.getValue() % toMix.size();
                toMix.add((int)((index + shift) % toMix.size() + toMix.size()) % toMix.size(), number);
            }
        }
        int zeroIndex = toMix.indexOf(zero);
        return toMix.get((zeroIndex + 1000)% toMix.size()).value +
                toMix.get((zeroIndex + 2000)% toMix.size()).value +
                toMix.get((zeroIndex + 3000)% toMix.size()).value;
    }
}
