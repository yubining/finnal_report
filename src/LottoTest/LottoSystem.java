package LottoTest;

import java.util.*;

public class LottoSystem {
	int lottoSelect,lottoCountSheet;
	int[][] lottosheet;
	public LottoSystem(int lottoselect, int lottoCountSheet) {
		// TODO Auto-generated constructor stub
		this.lottoSelect = lottoselect;
		this.lottoCountSheet = lottoCountSheet;
	}
	public LottoSystem(int[][] lottosheet) {
		// TODO Auto-generated constructor stub
		this.lottosheet = lottosheet;
	}
	
	
	public int[] matchLotto(int[][] lottosheet,int[] winLotto){
		int lottoCountSheet = lottosheet.length;
		int[] matchCount = new int[lottoCountSheet];
		
		for(int i = 0 ; i<lottoCountSheet;i++){
			for(int j =0; j<6;j++){
				for(int z=0;z<6;z++){
					if(lottosheet[i][j] == winLotto[z]){
						matchCount[i]++;
						break;
					}
				}
			}
		}
		
		return matchCount;
		
	}
	public int[][] autoLotto(int lottoCountSheet) {
		lottosheet = new int[lottoCountSheet][6];
		for(int i=0 ; i<lottoCountSheet;i++){

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
	
	public int[] createWinLotto(){
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
