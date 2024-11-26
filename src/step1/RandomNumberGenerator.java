package step1;

import java.util.Random;

public class RandomNumberGenerator {
    int bound;
    int[] numbers;

    public RandomNumberGenerator(int bound) {
        this.bound = bound;
        this.numbers = new int[bound];
    }

    public int[] getRandomNumbers() {
        Random random = new Random();
        int count = 0;
        while(count != bound) {
            int number = random.nextInt(bound) + 1;
            if (isUnique(number)) {
                numbers[count] = number;
                count++;
            }
        }
        return numbers;
    }

    private boolean isUnique(int number) {
        for (int i = 0; i < numbers.length; i++) {
            if (number == numbers[i]) {
                return false;
            }
        }
        return true;
    }

}
