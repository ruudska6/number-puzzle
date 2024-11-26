package step1;

import java.util.Arrays;

public class NumberPuzzle {
    private final int bound;
    private int[] numbers;
    private final int[] answerNumbers;


    NumberPuzzle(int bound) {
        this.bound = bound;
        this.numbers = new int[bound];
        this.answerNumbers = createAnswerNumbers(bound);
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    private int findNumberIdx(int number) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number)
                return i;
        }
        return -1;
    }

    public void swapNumber(int x, int y) {
        if (findNumberIdx(x) == -1 || findNumberIdx(y) == -1) {
            System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
        } else {
            int idxX = findNumberIdx(x);
            int idxY = findNumberIdx(y);
            numbers[idxX] = y;
            numbers[idxY] = x;
        }
    }

    public boolean isPuzzleSolved() {
        return Arrays.equals(numbers, answerNumbers);
    }

    private int[] createAnswerNumbers(int bound) {
        int[] answers = new int[bound];
        for (int i = 0; i < answers.length; i++) {
            answers[i] = i+1;
        }
        return answers;
    }
}
