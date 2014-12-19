package LottoTest;

import java.util.Random;

/**
 * Created by yubin on 2014-12-19.
 */
public class AutoLotto {

    public int[] matchLotto(int[][] lottosheet, int[] winLotto) {
        int lottoCountSheet = lottosheet.length;
        int[] matchCount = new int[lottoCountSheet];

        for (int i = 0; i < lottoCountSheet; i++) {
            for (int j = 0; j < 6; j++) {
                for (int z = 0; z < 6; z++) {
                    if (lottosheet[i][j] == winLotto[z]) {
                        matchCount[i]++;
                        break;
                    }
                }
            }
        }

        return matchCount;
    }

    public int[][] autoLotto(int lottoCountSheet) {
        int[][] lottosheet = new int[lottoCountSheet][6];
        for (int i = 0; i < lottoCountSheet; i++) {

            Random rd = new Random();


            for (int i1 = 0; i1 < 6; i1++) {
                lottosheet[i][i1] = rd.nextInt(45) + 1;
                for (int j = 0; j < i1; j++) {
                    if (lottosheet[i][i1] == lottosheet[i][j]) {
                        i1 = i1 - 1;
                        break;
                    }
                }
            }
            for (int i1 = 0; i1 < 6; i1++) {
                for (int j = 0; j <= i1; j++) {
                    if (lottosheet[i][i1] <= lottosheet[i][j]) {
                        int autoSort = lottosheet[i][i1];
                        lottosheet[i][i1] = lottosheet[i][j];
                        lottosheet[i][j] = autoSort;
                    }
                }
            }

        }
        return lottosheet;
    }

}
