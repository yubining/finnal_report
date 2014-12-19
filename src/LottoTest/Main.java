package LottoTest;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ServiceCounter CS = new ServiceCounter();
        Scanner sn = new Scanner(System.in);
        CS.buyRequest(sn);
    }
}
