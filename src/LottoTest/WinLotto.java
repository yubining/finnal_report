package LottoTest;

import java.util.Random;

/**
 * Created by yubin on 2014-12-19.
 */
public class WinLotto {

    public int[] createWinLotto() {
        int[] Winnumber = new int[6];
        Random rd = new Random();
        for (int i = 0; i < Winnumber.length; i++) {
            Winnumber[i] = rd.nextInt(45) + 1;
            for (int j = 0; j < i; j++) {
                if (Winnumber[i] == Winnumber[j]) {
                    i = i - 1;

                    break;

                }
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < i; j++) {
                if (Winnumber[i] <= Winnumber[j]) {
                    int ManualSort = Winnumber[i];
                    Winnumber[i] = Winnumber[j];
                    Winnumber[j] = ManualSort;
                }
            }
        }
        System.out.println("당첨번호: ");
        for (int i = 0; i < Winnumber.length; i++) {
            System.out.print("[" + Winnumber[i] + "]" + " ");

        }
        return Winnumber;
    }


}
