package step1;

import java.util.Scanner;

public class GameController {
    private int turn;
    NumberPuzzle numberPuzzle;
    InputHandler inputHandler;

    public GameController(int bound) {
        this.numberPuzzle = new NumberPuzzle(bound);
        this.inputHandler = new InputHandler();
        this.turn = 1;
    }

    public void gameStart() {
        Scanner sc = new Scanner(System.in);
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(numberPuzzle.getNumbers().length);
        numberPuzzle.setNumbers(randomNumberGenerator.getRandomNumbers());

        System.out.println("간단 숫자 퍼즐");
        displayGameStatus();
        while (true) {
            System.out.print("교환할 두 숫자를 입력> ");
            try {
                String str = sc.next();
                String[] strArr = inputHandler.parseInputNumbers(str);
                int num1 = Integer.parseInt(strArr[0]);
                int num2 = Integer.parseInt(strArr[1]);
                numberPuzzle.swapNumber(num1, num2);
                turn++;
                displayGameStatus();
                if (numberPuzzle.isPuzzleSolved()) {
                    displayCompletionMessage();
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
            } catch (NumberFormatException e) {
                // 숫자 변환 실패
                System.out.println("잘못된 입력입니다. 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                // swapNumber에서 발생한 예외 처리
                System.out.println(e.getMessage());
            } catch (Exception e) {
                // 기타 예외 처리
                System.out.println("알 수 없는 오류가 발생했습니다. 다시 시도해 주세요.");
            }
        }
    }

    private void displayGameStatus() {
        System.out.println("Turn " + turn);
        showNumbers();
    }

    public void showNumbers() {
        int[] numbers = numberPuzzle.getNumbers();
        System.out.print("[");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i != numbers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private void displayCompletionMessage() {
        System.out.println("축하합니다! " + turn + "턴만에 퍼즐을 완성하셨습니다!");
    }
}
