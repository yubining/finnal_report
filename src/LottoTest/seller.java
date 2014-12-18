package LottoTest;

import java.util.Scanner;

/**
 * Created by yubin on 2014-12-19.
 */
public class seller {
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
    private boolean isAuto() {
        // TODO Auto-generated method stub
        return (lottoselect == 1);
    }
}
