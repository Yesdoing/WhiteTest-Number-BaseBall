import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class baseBall {
	public static void main(String[] args) {
		System.out.println("숫자 야구게임에 오신 것을 환영합니다!!");

		String[] computer = randomNumArr();

		while (playGame(computer)) {
		}
	}

	private static String[] randomNumArr() {
		String[] array = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };

		Collections.shuffle(Arrays.asList(array));
		return array;
	}

	private static String[] inputNumber() {
		Scanner scan = new Scanner(System.in);
		String[] input = new String[3];

		for (int i = 0; i < input.length; i++) {
			System.out.print(i + 1 + "번째 숫자를 입력해주세요 : ");
			input[i] = scan.nextLine();
		}

		return input;
	}

	private static boolean playGame(String[] computer) {
		String com = "";
		String player = "";
		String[] playerArr = inputNumber();
		int strike = 0;
		int ball = 0;
 
		
		for (int i = 0; i < 3; i++) {
			com += computer[i];
			player += playerArr[i];
		}
				
		for (int i = 0; i < 3; i++) {
			if (com.charAt(i) == player.charAt(i)) {
				strike++;
			} else if (com.contains(player.charAt(i) + "")) {
				ball++;
			}
		}

		System.out.println("결과!!");
		if (strike != 0)
			System.out.println(strike + "스트라이크");
		if (ball != 0)
			System.out.println(ball + "볼");
		if (strike == 0 && ball == 0)
			System.out.println("낫싱");
		if (strike == 3) {
			System.out.println("축하합니다. 게임이 종료됩니다.");
			return false;
		} else {
			System.out.println("다시 숫자를 입력해주세요.");
			return true;
		}
	}
}
