package kr.co.checkpoint;

import java.util.Scanner;

public class VendingM01_1 {

	public static void main(String[] args) {
		// 자판기 bye
		//1하율 2으녕 3지오
		//String[] menu  = {"1.콜라","2.사이다","3.커피","4.자몽에이드","98.반환","99.종료"};
		//int[] price    = {1500,1500,3000,3500,0,0};
		//int[] stock    = {2,2,1,0,0,0};
		
		final int DRINGKCOUNT = 4;

		Scanner scan   = new Scanner(System.in);
		//메뉴
		String menu1 = "1.프라푸치노", menu2 = "2.제로펩시", menu3 = "3.나랑드사이다",
			   menu4 = "4.자몽에이드", menu5 = "98.종료", menu6 = "99.잔액반출";
		
		// 관리자모드 메뉴에 100.음료종류변경 및 재고 추가
		// 가격
		int price1 = 1500, price2 = 1500, price3 = 3000, price4 = 3500;
		// 재고
		int stock1 = 2, stock2 =2, stock3 =1, stock4 =0;
		// 받아서 계산할 애들
		int nMoney = 0, nSelectmenu = 0, i = 0, nGetMoney = 0;
		int ntmp = 0,  nstockvalue = 0, npricevalue = 0;
		String str = "", stmp = "", sMenuvalue = "";
		
		//음료 종류 변경
		int nChangeMenu = 0  , nChangeMenuprice = 0, 
			nChangestock = 0 , nChangeMenustock = 0;
		String sChangeMenu = "";
		
		boolean bStockCheck = true;
		
		System.out.println("[음료자판기]");
		nMoney = 0;

		while (nSelectmenu != 98) {
			
			//=============================================메뉴 ===============//
			// 총재고체크
			bStockCheck = false;
			if ((stock1 > 0) ||
				(stock2 > 0) ||
				(stock3 > 0) ||
				(stock4 > 0) ) {
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
			
			//메뉴
			System.out.printf(" %s   %s   %s   %s   %s   %s   %n",menu1, menu2, menu3,menu4, menu5, menu6);
			//가격
			System.out.printf(" %d        %d        %d        %d   %n",price1,price2,price3,price4);
			
			str = "";
			for (i=1; i<= DRINGKCOUNT;i++) {
				if (i == 1) {
					ntmp = stock1;
				} else if (i == 2) {
					ntmp = stock2;
				} else if (i == 3) {
					ntmp = stock3;
				} else if (i == 4) {
					ntmp = stock4;
				} 

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
			nGetMoney = scan.nextInt();
			if (nGetMoney < 0) {
				System.out.println("Err. 0보다 큰수를 입력해주세요.");
				continue;
			
			} else {
				nMoney += nGetMoney; 
			}
			
			System.out.print("메뉴를 선택해주세요 :");
			nSelectmenu = 0;
			nSelectmenu = scan.nextInt();
			if (nSelectmenu < 0) {
				System.out.println("Err. 0보다 큰수를 입력해주세요.");
				continue;
			}
			
			//========================= 사용할 메뉴에 따른 값 받기
			sMenuvalue  = " ";
			npricevalue = 0;
			nstockvalue = 0;
			
			if (nSelectmenu == 1) {
				sMenuvalue  = menu1;
				npricevalue = price1;
				nstockvalue = stock1;
			} else if (nSelectmenu == 2) {
				sMenuvalue  = menu2;
				npricevalue = price2;
				nstockvalue = stock2;
			} else if (nSelectmenu == 3) {
				sMenuvalue  = menu3;
				npricevalue = price3;
				nstockvalue = stock3;
			} else if (nSelectmenu == 4) {
				sMenuvalue  = menu4;
				npricevalue = price4;
				nstockvalue = stock4;
			} 
			
			//=============================================메뉴에 따른 로직 ===============//
			switch (nSelectmenu) {
				case 1 : case 2 : case 3 : case 4 :
					System.out.printf("%n%s 메뉴 선택, 잔액: %d원%n", stmp, nMoney);
					
					if (nMoney >= npricevalue) {
						if (nstockvalue > 0) {
							nMoney = nMoney - npricevalue; 
							System.out.printf("%s 가 나왔습니다. %n", sMenuvalue);
							
							if (nSelectmenu == 1) {
								--stock1;
							} else if (nSelectmenu == 2) {
								--stock2;
							} else if (nSelectmenu == 3) {
								--stock3;
							} else if (nSelectmenu == 4) {
								--stock4;
							} 						
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
					//음료 메뉴 변경
					System.out.println("\n@@관리자모드 : 현재 메뉴 및 재고@@");
					System.out.printf(" %s(재고:%d)   %s(재고:%d)   %s(재고:%d)   %s(재고:%d)    %n"
							,menu1,stock1, menu2,stock2, menu3,stock3,menu4,stock4);
					
					System.out.println("\n 음료 메뉴를 변경합니다. 변경할 음료 메뉴를 선택하세요.");
					System.out.print("< 초기 메뉴로 돌아가려면 -1을 입력하세요:");
					nChangeMenu = scan.nextInt();
					
					if (nChangeMenu == -1) {
						System.out.println("메뉴변경을 중단하고 초기메뉴로 돌아갑니다.");
						break;
					}
					
					if (!((nChangeMenu >= 1) &&((nChangeMenu <= 4)))) {
						System.out.println("음료 메뉴 번호가 정상적으로 들어오지 않았습니다. (1~4)사이의 수를 입력해주세요.");
						break;
					}
					
					System.out.println("\n 변경할 음료의 이름을 입력해주세요:");
					System.out.print("< 초기 메뉴로 돌아가려면 -1을 입력하세요:");
					sChangeMenu = scan.next();
					if (sChangeMenu.indexOf("-1") >= 0) {
						System.out.println("메뉴변경을 중단하고 초기메뉴로 돌아갑니다.");
						break;
					}
					
					if ((sChangeMenu == "") &&
						(sChangeMenu == menu5) &&
						(sChangeMenu == menu6)){
						System.out.println("음료의 이름이 정상적으로 들어오지 않았습니다.");
						break;
					}
					System.out.print("\n변경할 음료의 가격을 입력해주세요:");
					nChangeMenuprice = scan.nextInt();
					if (nChangeMenuprice == -1) {
						System.out.println("메뉴변경을 중단하고 초기메뉴로 돌아갑니다.");
						break;
					}  
					
					if (nChangeMenuprice < 0) {
						System.out.println("변경한 음료의 가격이 정상적으로 들어오지 않았습니다.");
						break;
					}
					
					System.out.print("변경한 음료의 재고수를 입력해주세요:");
					nChangestock = scan.nextInt(); 
					if (nChangestock == -1) {
						System.out.println("메뉴변경을 중단하고 초기메뉴로 돌아갑니다.");
						break;
					}					
					if (nChangestock < 0) {
						System.out.println("변경한 음료의 재고값이 정상적으로 들어오지 않았습니다.");
						break;
					}
					
					//기존 재고값을 받아 처리
					if (nChangeMenu == 1) {
						sMenuvalue  = menu1;
						nstockvalue = stock1;
					} else if (nChangeMenu == 2) {
						sMenuvalue  = menu2;
						nstockvalue = stock2;
					} else if (nChangeMenu == 3) {
						sMenuvalue  = menu3;
						nstockvalue = stock3;
					} else if (nChangeMenu == 4) {
						sMenuvalue  = menu4;
						nstockvalue = stock4;
					} 					
					
					System.out.printf("%s 의 남은 재고를 %d개 반환하고 음료 메뉴를 변경합니다.", 
							          sMenuvalue, nstockvalue);
					
					// 변경할 재고를 해당 변수에 대입
					if (nChangeMenu == 1) {
						menu1  = "1."+ sChangeMenu;
						price1 = nChangeMenuprice;
						stock1 = nChangestock;
					} else if (nChangeMenu == 2) {
						menu2  = "2."+ sChangeMenu;
						price2 = nChangeMenuprice;
						stock2 = nChangestock;
					} else if (nChangeMenu == 3) {
						menu3  = "3."+ sChangeMenu;
						price3 = nChangeMenuprice;
						stock3 = nChangestock;
					} else if (nChangeMenu == 4) {
						menu4  = "4."+ sChangeMenu;
						price4 = nChangeMenuprice;
						stock4 = nChangestock;
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
