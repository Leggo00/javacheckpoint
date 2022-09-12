package kr.co.checkpoint;

import java.util.Arrays;
import java.util.Scanner;

public class VendingM_v2_update2 {

	public static void main(String[] args) {
		// 자판기 bye
		//1하율 2으녕 3지오

		
		final String PASSWORD = "JAVA9987";
		final int DRINGKCOUNT   = 7;

		Scanner scan   = new Scanner(System.in);
		//메뉴
		// 관리자모드 메뉴에 100.음료종류변경 및 재고 추가
		String[] sMenu = {"제로펩시", "나랑드사이다","토레타",
				         "아이스아메리카노","요거트스무디","자바칩프라푸치노","우엉차", "98.종료"  ,"99.잔액반출"};
		
		//============================== 2차원배열 0행은 가격,1행은 재고
		final int PRICE = 0;
		final int STOCK = 1;
		
		int nMenu[][] = { {1500,1500,3000,3500,1500,3000,3500},
						  {2,2,1,0,2,1,0} };
//		거스름돈 배열구성하기 - 만원 10개, 오천원 7개 천원 오백원 백원
		int changeM[] = {10,7,20,14,10};  // 거스름돈 보관상자

		// 받아서 계산할 애들
		int nMoney = 0, nSelectmenu = 0, i = 0, nGetMoney = 0;
		int ntmp = 0,  nstockvalue = 0, npricevalue = 0, nTab = 0;
		String str = "", sMenuvalue = "", sTab = "";
		
		//음료 종류 변경
		int nChangeMenu = 0  , nChangeMenuprice = 0, nChangestock = 0;
		String sChangeMenu = "";
		
		boolean bStockCheck = true, bCoinCheck = true;
		
		System.out.println("[음료자판기]");
		nMoney = 0;
		


		while (nSelectmenu != 98) {
			
			//=============================================메뉴 ===============//
			// 총재고체크
			bStockCheck = false;
			for (i=0;i < nMenu[STOCK].length;i++)
			{
				if ((nMenu[STOCK][i] > 0)) {  // 재고가 하나라도 있으면.
					bStockCheck= true;
					break; 
				}
			}
			
			str = "";
			if (bStockCheck) {
				str = "~판매중~";
			} else {
				str = "~재고 소진 판매종료~";
			}
			
			if (nMoney > 0) {
				str += " 잔액:" + Integer.toString(nMoney); 
			}
			System.out.println(str);
			
			//=================================== 메뉴

			
			for(i=0;i < nMenu[PRICE].length;i++) {
				str = "";
				nTab = 11-(int)(sMenu[i].length()*(float)1.3)*100/100;
				sTab = " ";
				for (int k=0;k<nTab;k++) {
					sTab += " ";
				}
				
				ntmp = nMenu[STOCK][i];
				str = String.format("%2d. %s%s%5d%6s",
						(i+1),sMenu[i],sTab,nMenu[PRICE][i],((ntmp > 0) ?"판매중":"품절"));

				System.out.println(str);
			} 
			System.out.printf("98. 종료%n");
			System.out.printf("99. 잔액반출%n");
		
			System.out.println();
			
			//=============================================현금 & 메뉴 선택 ===============//
			System.out.print("메뉴를 선택해주세요 :");
			nSelectmenu = 0;
			nSelectmenu = Integer.parseInt(scan.nextLine());
			if (nSelectmenu < 0) {
				System.out.println("Err. 0보다 큰수를 입력해주세요.");
				continue;
			}
			
			if ((nSelectmenu >= 1)&&(nSelectmenu <= DRINGKCOUNT)) {
				System.out.print("현금을 넣어주세요 :");
				nGetMoney = Integer.parseInt(scan.nextLine());
				if (nGetMoney < 0) {
					System.out.println("Err. 0보다 큰수를 입력해주세요.");
					continue;
					
				} else {
					nMoney += nGetMoney; 
				}
			}
			
			//========================= 사용할 메뉴에 따른 값 받기
			sMenuvalue  = " ";
			npricevalue = 0;
			nstockvalue = 0;
			
			if ((nSelectmenu >= 1)&&(nSelectmenu <= 7)) {
				sMenuvalue  = sMenu[nSelectmenu-1];
				npricevalue = nMenu[PRICE][nSelectmenu-1]; 
				nstockvalue = nMenu[STOCK][nSelectmenu-1];
			} 
			
			//=============================================메뉴에 따른 로직 ===============//
			switch (nSelectmenu) {
				case 1 : case 2 : case 3 : 
				case 4 : case 5 : case 6 : case 7 :
					System.out.printf("%n%s 메뉴 선택, 현재잔액: %d원%n", sMenuvalue, nMoney);
					
					if (nMoney >= npricevalue) {
						if (nstockvalue > 0) {
							nMoney = nMoney - npricevalue;       //금액 계산
							--nMenu[STOCK][nSelectmenu-1];		 //재고를 하나 소진해줌.	
//							System.out.printf("%s가 나왔습니다. 남은잔액: %d원%n", sMenuvalue, nMoney);
							System.out.printf("%s가 나왔습니다.%n", sMenuvalue, nMoney);
						} else {
							System.out.printf(" 재고가 부족합니다%n");
						}
					} else {
						System.out.println(" 잔액이 부족합니다.");
					}

					break;
				case 98 :
					
					//프로그램 종료.
//					if (nMoney > 0) {
//						System.out.printf("잔액을 반환합니다 : %d%n", nMoney);
//					}
//					break;
				case 99 :
					System.out.printf("잔액 반출 : %d원%n", nMoney);
					//잔액 반출 시 지폐 단위로 나눠 알려줌.
//					메소드 구성하는 게 편함.
//					System.out.println( Arrays.toString(changeM)); //
					Returnofchange(nMoney, changeM);
//					System.out.println( Arrays.toString(changeM)); //debug
					nMoney = 0;
					
					if (nSelectmenu == 98) {
						System.out.println("안녕히 계세요 여러분 저는 자판기를 마칩니댜");
					}
					break;
				case 100 :
					//음료 메뉴 변경  관리자모드로 메뉴에서 100을 넣으면 나옴.
					//관리자 모드 메뉴 디스플레이.
					System.out.print("관리자모드 진입)) PASSWORD를 입력하세요:");
					str = scan.nextLine();
					
					if (!str.equals(PASSWORD)) {
						System.out.println("비밀번호가 일치 하지 않습니다.");
						break;
					}
					
					System.out.println("\n@@관리자모드 : 현재 메뉴 및 재고@@");
					System.out.println(">초기화면으로 돌아가시려면 -1을 입력해주세요\n");

					
					
					for(i=0;i < nMenu[STOCK].length;i++) {
						str = "";
						nTab = 11-(int)(sMenu[i].length()*(float)1.3)*100/100;
						sTab = " ";
						for (int k=0;k<nTab;k++) {
							sTab += " ";
						}
						
						str = String.format("%2d. %s%s%5d 재고:%s",
								(i+1),sMenu[i],sTab,nMenu[PRICE][i],nMenu[STOCK][i]);

						System.out.println(str);
					} 					
					
					
					System.out.println("\n음료 메뉴를 변경합니다");
					System.out.print("변경할 음료 메뉴를 선택하세요:");
					nChangeMenu = Integer.parseInt(scan.nextLine());
					
					if (nChangeMenu == -1) {
						System.out.println("메뉴변경을 중단하고 초기메뉴로 돌아갑니다.");
						break;
					}
					
					if (!((nChangeMenu >= 1) &&((nChangeMenu <= 7)))) {
						System.out.println("음료 메뉴 번호가 정상적으로 들어오지 않았습니다. (1~7)사이의 수를 입력해주세요.");
						break;
					}
					
					System.out.print("\n 변경할 음료의 이름을 입력해주세요:");
					sChangeMenu = scan.nextLine();
					
					if (sChangeMenu.indexOf("-1") >= 0) {
						System.out.println("메뉴변경을 중단하고 초기메뉴로 돌아갑니다.");
						break;
					}
					if ((sChangeMenu.equals("")) ||
						(sChangeMenu.indexOf("종료") >= 0 ) ||
						(sChangeMenu.indexOf("잔액반출")>= 0)){
						System.out.println("음료의 이름이 정상적으로 들어오지 않았습니다.");
						break;
					}
					System.out.print("\n 변경할 음료의 가격을 입력해주세요:");
					nChangeMenuprice = Integer.parseInt(scan.nextLine());
					if (nChangeMenuprice == -1) {
						System.out.println("메뉴변경을 중단하고 초기메뉴로 돌아갑니다.");
						break;
					}  
					
					if (nChangeMenuprice < 0) {
						System.out.println("변경한 음료의 가격이 정상적으로 들어오지 않았습니다.");
						break;
					}
					
					System.out.print(" 변경한 음료의 재고수를 입력해주세요:");
					nChangestock = Integer.parseInt(scan.nextLine()); 
					if (nChangestock == -1) {
						System.out.println("메뉴변경을 중단하고 초기메뉴로 돌아갑니다.");
						break;
					}					
					if (nChangestock < 0) {
						System.out.println("변경한 음료의 재고값이 정상적으로 들어오지 않았습니다.");
						break;
					}
					
					//기존 재고값을 받아 처리
					if ((nChangeMenu >= 1)&&(nChangeMenu <= 7)) {
						sMenuvalue  = sMenu[nChangeMenu-1];
						nstockvalue = nMenu[STOCK][nChangeMenu-1];
					} 			
					
					System.out.printf("%s 의 남은 재고를 %d개 반환하고 음료 메뉴를 변경합니다.", 
							          sMenuvalue, nstockvalue);
					
					// 변경할 재고를 해당 변수에 대입
					if ((nChangeMenu >= 1)&&(nChangeMenu <= 7)) {
						sMenu[nChangeMenu-1]= sChangeMenu;
						nMenu[PRICE][nChangeMenu-1] = nChangeMenuprice;
						nMenu[STOCK][nChangeMenu-1] = nChangestock;
						
					} 					
					break;   
				default : 
					break;
			
			}//end of switch	
	
			System.out.println();
		} //end of while
		
		scan.close();

	}
	


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
						//없으면 동전통에 돈이없으면
						//아무것도안함
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
				System.out.printf("%d원거스름돈이 부족합니다 %n 관리자에게 연락하세요 %n 관리자: 조성민 010-xxxx-xxxx%n",value);
			}
		}
		
		value = 0;
		return value;
		/*
			if (value >= 1000) {
				System.out.printf("1000원 %d장,", (value/1000));
				value = value % 1000;
			} 
			if (value >= 500) {
				System.out.printf("500원 %d개,", (value/500));
				value = value % 500;
			} 
			if (value >= 100) {
				System.out.printf("100원 %d개,", (value/100));
				value = value % 100;
			} 
			if (value >= 10) {
				System.out.printf("10원 %d개,", (value/10));
				value = value % 10;
			} 
			if (value > 0) {
				System.out.printf("%d원 ", (value));
			}
		 */
	}// end of Returnofchange
}


