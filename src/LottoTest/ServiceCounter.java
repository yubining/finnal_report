package LottoTest;

import java.util.*;

public class ServiceCounter {

	private int lottoselect, lottoCountSheet;
	int[][] lottosheet;

	public void buyRequest(Scanner sn) {
		// TODO Auto-generated method stub
		LottoSystem lottoSystem;
		communication(sn);
		if (isAuto()) {

			lottoSystem = new LottoSystem(lottoselect, lottoCountSheet);
			lottosheet = lottoSystem.autoLotto(lottoCountSheet);
		} else {
			lottosheet = manualLotto(sn, lottoCountSheet);
			lottoSystem = new LottoSystem(lottosheet);
		}

		int[] matchCount = lottoSystem.matchLotto(lottosheet,
				lottoSystem.createWinLotto());
		System.out.println();
		System.out.println("구매한 로또");
		printSheet(lottosheet,matchCount);
	}

	public void printSheet(int[][] lottoSheet,int[] matchCount) {
		System.out.println("선택한 숫자는:");
		for (int z = 0; z < lottoSheet.length; z++) {
			for (int i = 0; i < lottoSheet[z].length; i++) {
				System.out.print("[" + lottoSheet[z][i] + "]" + " ");

			}
			System.out.println("맞은숫자 :"+matchCount[z]);
			System.out.println();
		}

	}

	public int[][] manualLotto(Scanner sn, int lottoCountSheet) {
		int[][] lottosheet = new int[lottoCountSheet][6];
		int[] userInput = new int[6];

		for (int i = 0; i < lottoCountSheet; i++) {
			System.out.println("1~45까지의 숫자를 차례대로 입력하세요");

			for (int i1 = 0; i1 < userInput.length; i1++) {
				sn = new Scanner(System.in);
				userInput[i1] = sn.nextInt();

				if (userInput[i1] > 0 && userInput[i1] < 46) {

					for (int j = 0; j < i1; j++) {
						if (userInput[i1] == userInput[j]) {
							System.out.println("중복되는 숫자입니다. 다시입력하세요");
							i1--;
						}
					}
				} else {

					System.out.println("범위를 초과 하는 숫자입니다. 다시입력하세요");
					i1--;
				}
			}
			int manualSort = 0;
			for (int i1 = 0; i1 < 6; i1++) {
				for (int j = 0; j < i1; j++) {
					if (userInput[i1] <= userInput[j]) {
						manualSort = userInput[i1];
						userInput[i1] = userInput[j];
						userInput[j] = manualSort;
					}
				}

			}

		}
		return lottosheet;
	}

	private boolean isAuto() {
		// TODO Auto-generated method stub
		return (lottoselect == 1);
	}

	private void communication(Scanner sn) {
		while (true) {
			System.out.println("자동입력은 1, 직접입력은 2를 눌러주세요");
			lottoselect = sn.nextInt();
			try {
				if (lottoselect == 1) {
					System.out.println("자동입력을 선택하였습니다.\n몇장을 사시겠습니까?");
					lottoCountSheet = sn.nextInt();

				} else if (lottoselect == 2) {
					System.out.println("직접입력을 선택하였습니다.\n몇장을 사시겠습니까?");
					lottoCountSheet = sn.nextInt();
				}
			} catch (Exception e) {
			}
			if (lottoselect == 1 || lottoselect == 2)
				break;
			System.out.println("다시입력하세요");
		}
	}
}
