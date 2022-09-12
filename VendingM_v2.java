package kr.co.checkpoint;

import java.util.Scanner;

public class VendingM_v2 {

	public static void main(String[] args) {
		// 자판기 bye
		//1하율 2으녕 3지오

		
		final int DRINGKCOUNT   = 4;

		Scanner scan   = new Scanner(System.in);
		//메뉴
		// 관리자모드 메뉴에 100.음료종류변경 및 재고 추가
		String[] sMenu = {"1.프라푸치노", "2.제로펩시","3.나랑드사이다",
				         "4.자몽에이드", "98.종료"  ,"99.잔액반출"};
		
		//============================== 2차원배열 0행은 가격,1행은 재고
		final int PRICE = 0;
		final int STOCK = 1;
		
		int nMenu[][] = { {1500,1500,3000,3500},
						  {2,2,1,0} };

		// 받아서 계산할 애들
		int nMoney = 0, nSelectmenu = 0, i = 0, nGetMoney = 0;
		int ntmp = 0,  nstockvalue = 0, npricevalue = 0;
		String str = "", sMenuvalue = "";
		
		//음료 종류 변경
		int nChangeMenu = 0  , nChangeMenuprice = 0, nChangestock = 0;
		String sChangeMenu = "";
		
		boolean bStockCheck = true;
		
		System.out.println("[음료자판기]");
		nMoney = 0;

		while (nSelectmenu != 98) {
			
			//=============================================메뉴 ===============//
			// 총재고체크
			bStockCheck = false;
			if ((nMenu[STOCK][0] > 0) ||
				(nMenu[STOCK][1] > 0) ||
				(nMenu[STOCK][2] > 0) ||
				(nMenu[STOCK][3] > 0) ) {
				bStockCheck= true;
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
			
			//=================================== 메뉴이름
			str = " ";
			for (i=0;i< sMenu.length ;i++) {
				str += sMenu[i] + "   ";
			}
			System.out.printf("%s%n",str);
			//가격
			//=================================== 메뉴별 가격
			str = " ";
			for(i=0;i < nMenu[PRICE].length;i++) {
				str +=  nMenu[PRICE][i] +"        ";
			} 
			System.out.printf("%s   %n", str);
			
			//=================================== 재고에 따른 상태표시
			str = "";
			for (i=1; i<= DRINGKCOUNT;i++) {
				ntmp = nMenu[STOCK][i-1];

				if (ntmp > 0) {
					str += " 판매중" + "       ";
				} else {
					str += " 품절 " + "       ";
				}
			}
			System.out.println(str);
			System.out.println();
			
			//=============================================현금 & 메뉴 선택 ===============//
			System.out.print("현금을 넣어주세요 :");
			nGetMoney = Integer.parseInt(scan.nextLine());
			if (nGetMoney < 0) {
				System.out.println("Err. 0보다 큰수를 입력해주세요.");
				continue;
			
			} else {
				nMoney += nGetMoney; 
			}
			
			System.out.print("메뉴를 선택해주세요 :");
			nSelectmenu = 0;
			nSelectmenu = Integer.parseInt(scan.nextLine());
			if (nSelectmenu < 0) {
				System.out.println("Err. 0보다 큰수를 입력해주세요.");
				continue;
			}
			
			//========================= 사용할 메뉴에 따른 값 받기
			sMenuvalue  = " ";
			npricevalue = 0;
			nstockvalue = 0;
			
			if ((nSelectmenu >= 1)&&(nSelectmenu <= 4)) {
				sMenuvalue  = sMenu[nSelectmenu-1];
				npricevalue = nMenu[PRICE][nSelectmenu-1]; 
				nstockvalue = nMenu[STOCK][nSelectmenu-1];
			} 
			
			//=============================================메뉴에 따른 로직 ===============//
			switch (nSelectmenu) {
				case 1 : case 2 : case 3 : case 4 :
					System.out.printf("%n%s 메뉴 선택, 현재잔액: %d원%n", sMenuvalue, nMoney);
					
					if (nMoney >= npricevalue) {
						if (nstockvalue > 0) {
							nMoney = nMoney - npricevalue;       //금액 계산
							--nMenu[STOCK][nSelectmenu-1];		 //재고를 하나 소진해줌.	
							System.out.printf("%s 가 나왔습니다. 남은잔액: %d원%n", sMenuvalue, nMenu[STOCK][nSelectmenu-1]);
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
					if (nMoney > 0) {
						if (nMoney >= 10000) {
							System.out.printf("10000원 %d장,", (nMoney/10000));
							nMoney = nMoney % 10000;
						} 
						if (nMoney >= 1000) {
							System.out.printf("1000원 %d장,", (nMoney/1000));
							nMoney = nMoney % 1000;
						} 
						if (nMoney >= 500) {
							System.out.printf("500원 %d개,", (nMoney/500));
							nMoney = nMoney % 500;
						} 
						if (nMoney >= 100) {
							System.out.printf("100원 %d개,", (nMoney/100));
							nMoney = nMoney % 100;
						} 
						if (nMoney >= 10) {
							System.out.printf("10원 %d개,", (nMoney/10));
							nMoney = nMoney % 10;
						} 
						if (nMoney > 0) {
							System.out.printf("%d원 ", (nMoney));
						}
						System.out.printf("을 지급합니다.%n");
					}
					
					nMoney = 0;
					
					if (nSelectmenu == 98) {
						System.out.println("안녕히 계세요 여러분 저는 자판기를 마칩니댜");
					}
					break;
				case 100 :
					//음료 메뉴 변경  관리자모드로 메뉴에서 100을 넣으면 나옴.
					//관리자 모드 메뉴 디스플레이.
					System.out.println("\n@@관리자모드 : 현재 메뉴 및 재고@@");
					str = " ";
					for(i=0;i<nMenu[STOCK].length;i++) {
						str += sMenu[i] + "(재고:" + nMenu[STOCK][i] + ")   ";
					}
					
					System.out.printf("%s%n", str);
					
					System.out.println("\n 음료 메뉴를 변경합니다. 변경할 음료 메뉴를 선택하세요.");
					System.out.print("< 초기 메뉴로 돌아가려면 -1을 입력하세요:");
					nChangeMenu = Integer.parseInt(scan.nextLine());
					
					if (nChangeMenu == -1) {
						System.out.println("메뉴변경을 중단하고 초기메뉴로 돌아갑니다.");
						break;
					}
					
					if (!((nChangeMenu >= 1) &&((nChangeMenu <= 4)))) {
						System.out.println("음료 메뉴 번호가 정상적으로 들어오지 않았습니다. (1~4)사이의 수를 입력해주세요.");
						break;
					}
					
					System.out.println("\n 변경할 음료의 이름을 입력해주세요");
					System.out.print("< 초기 메뉴로 돌아가려면 -1을 입력하세요:");
					sChangeMenu = scan.nextLine();
					
					if (sChangeMenu.indexOf("-1") >= 0) {
						System.out.println("메뉴변경을 중단하고 초기메뉴로 돌아갑니다.");
						break;
					}
					
					if ((sChangeMenu.equals("")) ||
						(sChangeMenu.equals(sMenu[4]) ) ||
						(sChangeMenu.equals(sMenu[5]))){
						System.out.println("음료의 이름이 정상적으로 들어오지 않았습니다.");
						break;
					}
					System.out.print("\n변경할 음료의 가격을 입력해주세요:");
					nChangeMenuprice = Integer.parseInt(scan.nextLine());
					if (nChangeMenuprice == -1) {
						System.out.println("메뉴변경을 중단하고 초기메뉴로 돌아갑니다.");
						break;
					}  
					
					if (nChangeMenuprice < 0) {
						System.out.println("변경한 음료의 가격이 정상적으로 들어오지 않았습니다.");
						break;
					}
					
					System.out.print("변경한 음료의 재고수를 입력해주세요:");
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
					if ((nChangeMenu >= 1)&&(nChangeMenu <= 4)) {
						sMenuvalue  = sMenu[nChangeMenu-1];
						nstockvalue = nMenu[STOCK][nChangeMenu-1];
					} 			
					
					System.out.printf("%s 의 남은 재고를 %d개 반환하고 음료 메뉴를 변경합니다.", 
							          sMenuvalue, nstockvalue);
					
					// 변경할 재고를 해당 변수에 대입
					if ((nChangeMenu >= 1)&&(nChangeMenu <= 4)) {
						sMenu[nChangeMenu-1]= Integer.toString(nChangeMenu) 
								              + "."
								              + sChangeMenu;
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

}
