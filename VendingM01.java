package kr.co.checkpoint;

import java.util.Scanner;

public class VendingM01 {

	public static void main(String[] args) {
		// 자판기 bye
		//1하율 2으녕 3지오
		Scanner scan   = new Scanner(System.in);
		String[] menu  = {"1.콜라","2.사이다","3.커피","4.자몽에이드","98.반환","99.종료"};
		int[] price    = {1500,1500,3000,3500,0,0};
		int[] stock    = {2,2,1,0,0,0};
		
		int nMoney = 0, nSelectmenu = 0, nMode = 0,  i = 0;
		String str = "";
		boolean bStockCheck = true;
		
		System.out.println("[음료자판기]");
		nMoney = 0;

		while (nSelectmenu != 99) {
			
			//=============================================메뉴 ===============//
			bStockCheck = false;
			for (i=0; i<stock.length-2;i++) {
				if (stock[i] > 0) {
					bStockCheck= true;
					break;
				}
			}
			
			str = "";
			if (bStockCheck) {
				str = "~판매중~";
			} else {
				str = "~재고 소진~";
			}
			
			if (nMoney > 0) {
				str += " 잔액:" + Integer.toString(nMoney); 
			}
			System.out.println(str);
			
			
			str = "";
			for (i=0; i<menu.length;i++) {
				str += menu[i] + "   ";
			}
			System.out.println(str);
			
			str = "";
			for (i=0; i<price.length-2;i++) {
				str +=  " " + Integer.toString(price[i])+ "   ";
			}
			System.out.println(str);
			
			str = "";
			for (i=0; i<stock.length-2;i++) {
				if (stock[i] > 0) {
					str += " 판매중" + "   ";
				} else {
					str += " 품절 " + "   ";
				}
			}
			System.out.println(str);
			System.out.println();
			
			//=============================================현금 & 메뉴 선택 ===============//
			System.out.print("현금을 입력해주세요 :");
			nMoney += scan.nextInt();
			
			System.out.print("메뉴를 선택해주세요 :");
			nSelectmenu = 0;
			nSelectmenu = scan.nextInt();
			
			//=============================================메뉴에 따른 로직 ===============//
			if ((1<=nSelectmenu) && (nSelectmenu <= 4)) {
				System.out.printf("%n%s 메뉴 선택, 잔액: %d%n", menu[nSelectmenu-1], nMoney);
				if (nMoney >= price[nSelectmenu-1]) {
					if (stock[nSelectmenu-1] > 0) {
						nMoney = nMoney - price[nSelectmenu-1]; 
						System.out.printf("%s 가 나왔습니다. %n", menu[nSelectmenu-1]);
						
						System.out.printf("잔액 반출 : %d%n", nMoney);
						nMoney = 0;
					} else {
						System.out.printf("재고가 부족합니다%n");
					}
				} else {
					System.out.println("잔액이 부족합니다.");
				}
			}else if (nSelectmenu == 98) {
				System.out.printf("잔액 반출 : %d%n", nMoney);
				nMoney = 0;
			} else if (nSelectmenu == 99) {
				//프로그램 종료.
				if (nMoney > 0) {
					System.out.printf("잔액을 반환합니다 : %d%n", nMoney);
				}
				System.out.println("안녕히 계세요 여러분 저는 자판기를 마칩니댜");
			}
			System.out.println();
			
		} //end of while
		
		scan.close();
	}

}
