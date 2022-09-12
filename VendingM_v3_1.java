package kr.co.checkpoint;

import java.util.Arrays;
import java.util.Scanner;

public class VendingM_v3_1 {


	
	static	final int PRICE = 0;
	static	final int STOCK = 1;
	static	final int MNAME = 2;

	static Scanner scan   = new Scanner(System.in);
	static int nSelectmenu = 0;
	static final int DRINGKCOUNT   = 7;

	public static void main(String[] args) {
		String sMenu[][] = { 
				{"1500","1500","3000","3500","1500","3000","3500"},
				{"2","2","1","0","2","1","0"}, 
				{"제로펩시", "나랑드사이다","토레타","아이스아메리카노","요거트스무디","자바칩프라푸치노","우엉차"}
		        };
		int changeM[] = {10,7,20,14,10};  // 거스름돈 보관상자
		int nMoney = 0;
		final String PASSWORD = "JAVA9987";

		
		System.out.println("[음료자판기]");
		
		while (nSelectmenu != 98) {
			ViewMenu(1, nMoney,sMenu);
			nMoney = SelectMenu(nMoney, sMenu);
			nMoney = VendingRun(nMoney, sMenu, changeM, PASSWORD);
			System.out.println();
		} 
		
		scan.close();
	}
	
	


	private static int SelectMenu(int aMoney, String[][] sMenu ) {
		int nGetMoney= 0;
		int nCheck = 0;
		
		System.out.print("메뉴를 선택해주세요 :");
		nSelectmenu = 0;
		nSelectmenu = Integer.parseInt(scan.nextLine());
		if (nSelectmenu < 0) {
			System.out.println("Err. 0보다 큰수를 입력해주세요.");
			return aMoney;
		}
		for (String s :sMenu[PRICE]) {
			if (Integer.parseInt(s) > nCheck) {
				nCheck = Integer.parseInt(s);
			}
		}
		
		if (nCheck <= aMoney) {
			//가지고있는 잔액이, 현재 메뉴중 가장 비싼 음료보다 돈이 더 많으면 
			// 현금을 넣어달라고 하지 않는다.
		} else {
			if ((nSelectmenu >= 1)&&(nSelectmenu <= DRINGKCOUNT)) {
				System.out.print("현금을 넣어주세요 :");
				nGetMoney = Integer.parseInt(scan.nextLine());
				if (nGetMoney < 0) {
					System.out.println("Err. 0보다 큰수를 입력해주세요.");
					return aMoney;
					
				} else {
					aMoney += nGetMoney; 
				}
			}
		}
		
		return aMoney;
	}

	private static int VendingRun(int aMoney, String[][] sMenu, int[] changeM, String sPassword) {
		// 음료메뉴
		String sMenuvalue = " ";
		int npricevalue = 0, nstockvalue = 0;
		// 100번
		String str = ""; 

		sMenuvalue  = " ";
		npricevalue = 0;
		nstockvalue = 0;
		
		if ((nSelectmenu >= 1)&&(nSelectmenu <= DRINGKCOUNT)) {
			sMenuvalue  = sMenu[MNAME][nSelectmenu-1];
			npricevalue = Integer.parseInt( sMenu[PRICE][nSelectmenu-1] ); 
			nstockvalue = Integer.parseInt( sMenu[STOCK][nSelectmenu-1] );
		} 
		
		switch (nSelectmenu) {
			case 1 : case 2 : case 3 : 
			case 4 : case 5 : case 6 : case 7 :
				aMoney = drinkService(sMenuvalue, aMoney,npricevalue
						,nstockvalue,sMenu);
				return aMoney;
			case 98 :
				//프로그램 종료.  99로 가서 잔액 반출 하고 종료.
			case 99 :
				System.out.printf("잔액 반출 : %d원%n", aMoney);
				aMoney = Returnofchange(aMoney, changeM);
				
				if (nSelectmenu == 98) {
					System.out.println("안녕히 계세요 여러분 저는 자판기를 마칩니댜");
				}
				return aMoney;
			case 100 :
				//음료 메뉴 변경  관리자모드로 메뉴에서 100을 넣으면 나옴.
				
				if (! AdminCheck(sPassword)) {  // 패스워드 확인
					return aMoney;
				}
				ViewMenu(2,-9999, sMenu);     // 관리자모드 디스플레이
				AdiminRUN(sMenu);           // 음료변경및 재고 
				return aMoney;
			default: 
				return aMoney;
		}
	}//end of VendingRun

	private static void AdiminRUN(String[][] sMenu) {
		int nChangeMenu = 0  , nChangeMenuprice = 0, nChangestock = 0;
		String sChangeMenu = "";		
		String sMenuvalue = " ";
		int nstockvalue = 0;

		
		//========================= 변경할 음료 선택
		System.out.println("\n음료 메뉴를 변경합니다");
		System.out.print("변경할 음료 메뉴를 선택하세요:");
		nChangeMenu = Integer.parseInt(scan.nextLine());
		
		if (nChangeMenu == -1) {
			System.out.println("메뉴변경을 중단하고 초기메뉴로 돌아갑니다.");
			return;
		}
		
		if (!((nChangeMenu >= 1) &&((nChangeMenu <= DRINGKCOUNT)))) {
			System.out.println("음료 메뉴 번호가 정상적으로 들어오지 않았습니다. (1~7)사이의 수를 입력해주세요.");
			return;
		}
		
		//========================= 음료명 변경
		System.out.print("\n 변경할 음료의 이름을 입력해주세요:");
		sChangeMenu = scan.nextLine();
		
		if (sChangeMenu.indexOf("-1") >= 0) {
			System.out.println("메뉴변경을 중단하고 초기메뉴로 돌아갑니다.");
			return;
		}
		if ((sChangeMenu.equals("")) ||
			(sChangeMenu.indexOf("종료") >= 0 ) ||
			(sChangeMenu.indexOf("잔액반출")>= 0)){
			System.out.println("음료의 이름이 정상적으로 들어오지 않았습니다.");
			return;
		}
		//========================= 음료 가격 변경
		System.out.print("\n 변경할 음료의 가격을 입력해주세요:");
		nChangeMenuprice = Integer.parseInt(scan.nextLine());
		if (nChangeMenuprice == -1) {
			System.out.println("메뉴변경을 중단하고 초기메뉴로 돌아갑니다.");
			return;
		}  
		
		if (nChangeMenuprice < 0) {
			System.out.println("변경한 음료의 가격이 정상적으로 들어오지 않았습니다.");
			return;
		}
		
		//========================= 음료 재고수 변경
		System.out.print(" 변경한 음료의 재고수를 입력해주세요:");
		nChangestock = Integer.parseInt(scan.nextLine()); 
		if (nChangestock == -1) {
			System.out.println("메뉴변경을 중단하고 초기메뉴로 돌아갑니다.");
			return;
		}					
		if (nChangestock < 0) {
			System.out.println("변경한 음료의 재고값이 정상적으로 들어오지 않았습니다.");
			return;
		}
		
		//기존 재고값을 받아 처리
		if ((nChangeMenu >= 1)&&(nChangeMenu <= DRINGKCOUNT)) {
			sMenuvalue  = sMenu[MNAME][nChangeMenu-1];
			nstockvalue = Integer.parseInt(sMenu[STOCK][nChangeMenu-1]);
		} 			
		
		System.out.printf("%s 의 남은 재고를 %d개 반환하고 음료 메뉴를 변경합니다.", 
				          sMenuvalue, nstockvalue);
		
		// 변경할 재고를 해당 변수에 대입
		if ((nChangeMenu >= 1)&&(nChangeMenu <= DRINGKCOUNT)) {
			sMenu[MNAME][nChangeMenu-1]= sChangeMenu;
			sMenu[PRICE][nChangeMenu-1] = Integer.toString( nChangeMenuprice );
			sMenu[STOCK][nChangeMenu-1] = Integer.toString( nChangestock );
		} 	
		
	}//end of AdiminRUN


	private static int drinkService(String asMenuvalue, int bMoney, int anpricevalue, int anstockvalue, String[][] sMenu) {
		int  ntmp = 0;
		System.out.printf("%n%s 메뉴 선택, 현재잔액: %d원%n", asMenuvalue, bMoney);
		
		if (bMoney >= anpricevalue) {
			if (anstockvalue > 0) {
				bMoney = bMoney - anpricevalue;       //금액 계산
				
				ntmp = Integer.parseInt(sMenu[STOCK][nSelectmenu-1]);
				--ntmp;
				sMenu[STOCK][nSelectmenu-1] = Integer.toString(ntmp);		 //재고를 하나 소진해줌.	
				System.out.printf("%s가 나왔습니다.%n", asMenuvalue, bMoney);
			} else {
				System.out.printf(" 재고가 부족합니다%n");
			}
		} else {
			System.out.println(" 잔액이 부족합니다.");
		}
		return bMoney;
	}//end of drinkService

	private static boolean AdminCheck(String sPassword) {
		boolean result = true;
		String str = " ";

		System.out.print("관리자모드 진입)) PASSWORD를 입력하세요:");
		str = scan.nextLine();
		
		if (!str.equals(sPassword)) {
			System.out.println("비밀번호가 일치 하지 않습니다.");
			result = false;
		}
		return result;
	}//end of AdminCheck

	static void ViewMenu(int nMode, int fMoney, String[][] sMenu) {	
		String str = "", sTab = "";
		int ntmp = 0, nTab = 0;
		boolean bStockCheck = false;
		//mode 1 이면 메인메뉴,  mode 2 이면 관리자모드
		switch(nMode) {
			case 1 :
				for (int i=0;i < sMenu[STOCK].length;i++)
				{
					ntmp = Integer.parseInt(sMenu[STOCK][i] );
					if ((ntmp > 0)) {  // 재고가 하나라도 있으면.
						bStockCheck= true;
						break; 
					}
				}
				//============ 총재고 확인
				str = "";
				if (bStockCheck) {
					str = "~판매중~";
				} else {
					str = "~재고 소진 판매종료~";
				}
				
				if (fMoney > 0) {
					str += " 잔액:" + Integer.toString(fMoney); 
				}
				System.out.println(str);
				break;
			case 2 : 
				System.out.println("\n@@관리자모드 : 현재 메뉴 및 재고@@");
				System.out.println(">초기화면으로 돌아가시려면 -1을 입력해주세요\n");
				break;
			default : 
				break;
		} 
		
		// -----------------메뉴 디스플레이 띄여쓰기 정렬
		for(int i=0;i < sMenu[PRICE].length;i++) {
			str = "";
			nTab = 11-(int)(sMenu[MNAME][i].length()*1.3f)*100/100;
			sTab = " ";
			for (int k=0;k<nTab;k++) {
				sTab += " ";
			}
			
			ntmp = Integer.parseInt( sMenu[STOCK][i] );
			switch(nMode) {
				case 1 :
					str = String.format("%2d. %s%s%5s%6s",
							(i+1),sMenu[MNAME][i],sTab,sMenu[PRICE][i],((ntmp > 0) ?"판매중":"품절"));
					break;
				case 2 :
					str = String.format("%2d. %s%s%5s 재고:%s",
							(i+1),sMenu[MNAME][i],sTab,sMenu[PRICE][i],sMenu[STOCK][i]);
					break;
			}

			System.out.println(str);
		} 
		
		//기타메뉴 디스플레이
		switch(nMode) {
			case 1 :
				System.out.printf("98. 종료%n");
				System.out.printf("99. 잔액반출%n");
				System.out.println();
				break;
			default :
				break;
		}
	}//end of ViewMenu
	
	static int Returnofchange(int value, int[] coin) {
		String fStr = "";
		int nfCnt = 0, nLossMoney= 0, fi = 0;
		int nUnit = 0;
		
//		System.out.println("funtion:"+ Arrays.toString(coin));// debug
		
		if (value > 0) {
			//단위는 10000 5000 1000 500 100원짜리까지만
			for (fi = 0; fi<5;fi++) {
				switch (fi) {
					case 0 :
						nUnit = 10000;
						break;
					case 1 :
						nUnit = 5000;
						break;
					case 2 :
						nUnit = 1000;
						break;
					case 3 :
						nUnit = 500;
						break;
					case 4 :
						nUnit = 100;
						break;
				}
				if (value >= nUnit) {
					nfCnt = (value/nUnit); 
					if (coin[fi] < 1) {
						//없으면 동전통에 돈이없으면 아무것도안함
					} else {
						if ((coin[fi] * nUnit) >= (value/nUnit*nUnit)){
							//동전통에 줄수있는 만큼 돈이 많으면.
							coin[fi] -= (value/nUnit);  //동전개수를 주고
							fStr += String.format("%d원 %d장,", nUnit, (value/nUnit));
//							System.out.printf("%d원 %d장,",nUnit, (value/nUnit));
							value = value % nUnit;
						} else {
							value -= value - (coin[fi]*nUnit);  //없으면 줄수있는 만큼 주고
							coin[fi] = 0;
							//나머지 잔돈으로 넘긴다.
						}
						
					}
				}
				
				
			}// end of for
			if (fStr.length()> 1) {
				fStr = fStr.substring(0,fStr.length()-2);
				System.out.printf(fStr);
			}
			System.out.printf("을 지급합니다.%n");
			if (value > 0) {
				System.out.printf("%d원거스름돈이 부족합니다 %n 관리자에게 연락하세요%n",value);
			}
		}
		
		value = 0;
		return value;

	}// end of Returnofchange
}


