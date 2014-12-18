package LottoTest;

import java.util.*;

public class Customer {
    public static void main(String[] args) {
        ServiceCounter CS = new ServiceCounter();
        Scanner sn = new Scanner(System.in);
        CS.buyRequest(sn);
    }
}
