//5.27금
package kr.co.checkpoint;

import java.util.Scanner;

public class VendingM02_2_eun {

	public static void main(String[] args) {
//		1차원 (2차원) 배열로 자판기를 구현하자
//		음료의 종류는 5가지 이상
//		종류(음료수이름), 가격, 재고
		
		Scanner scan = new Scanner(System.in);
		boolean stop = false;
		
		final int PASS = 4568721; // 관리자모드진행시
//		int pass = 1234; // 관리자모드진행시
		final int SIZE = 7;    // 음료의 종류
		
//		String [] drinkName = new String [SIZE];  // 음료수이름
//		int [] drinkPrice = new int [SIZE];       // 음료 가격    
//		int [] drinkStock = new int [SIZE];       // 음료 재고

		String [] drinkName = {"아이스 아메라카노","카페라떼","콜드브루","바닐라라떼","토피넛라떼","딸기라떼","프라푸치노"};  // 음료수이름
		int [] drinkPrice = {3000,3500,3500,4000,4000,4500,4500};       // 음료 가격    
		int [] drinkStock = {2,2,2,2,2,2,2};       					  // 음료 재고
		
		int money=0;    // 투입한 돈
		
		int addMoney=0; // 추가로 투입한 돈
		int sel=-1;     // 메뉴변수
		int change=0;   // 거스름돈
		
		// 추가변수 (관리자모드)
//		String [] whatDrink = new String [7];
		int whatDrink=-1;      // 바꾸고싶은 메뉴 선택 변수 
		String newDrink="";    // 새로운 음료수 이름
		int newDrinkPrice=0;   // 새로운 음료수 가격
		int newDrinkStock=0;   // 새로운 음료수 재고
		
		while (!stop) {
			
			System.out.print("**********************************coffee 자판기**********************************");
			System.out.println("\n=====================================[메뉴]======================================");
			System.out.printf("[1.%s(%d원)][2.%s(%d원)][3.%s(%d원)][4.%s(%d원)]\n", drinkName[0],drinkPrice[0],drinkName[1],drinkPrice[1],drinkName[2],drinkPrice[2],drinkName[3],drinkPrice[3]);
			System.out.printf("[->%s : 재고%d] [->%s : 재고%d][->%s : 재고%d][->%s : 재고%d]", drinkName[0], drinkStock[0], drinkName[1], drinkStock[1], drinkName[2], drinkStock[2], drinkName[3], drinkStock[3]);
			System.out.println();
			System.out.printf("\n[5.%s(%d원)][6.%s(%d원)][7.%s(%d원)] || [99.종료][00.관리자모드]" ,drinkName[4],drinkPrice[4],drinkName[5],drinkPrice[5],drinkName[6],drinkPrice[6]);
			System.out.printf("\n[->%s : 재고%d] [->%s : 재고%d][->%s : 재고%d]",drinkName[4], drinkStock[4],drinkName[5], drinkStock[5],drinkName[6], drinkStock[6]);
			System.out.println("\n===============================================================================");		
			System.out.printf("\n돈을 투입구에 넣어주세요 : ");
			money =  Integer.parseInt(scan.nextLine());
			
//			돈 투입 ==============================================================
			if (money>=0) {
				System.out.println(money + "원이 투입되었습니다.");
				System.out.println("");
				System.out.printf("메뉴에서 음료를 선택하세요 : ");
				sel = Integer.parseInt(scan.nextLine());
				
//			메뉴 선택 ==============================================================	
				switch (sel) {
					case 1 : case 2 : case 3 : case 4 : case 5 : case 6 : case 7 :
						if (drinkStock[sel-1] == 0) {
							System.out.println(drinkName[sel-1] + "은 품절입니다.");
							System.out.println(money + "원이 반환되었습니다.");
						} 
						else {
							System.out.printf("%s를 선택하였습니다\n", drinkName[sel-1]);
							while (money < drinkPrice[sel-1]) {
								System.out.println("돈을 더 투입해주세요 : ");
								addMoney = Integer.parseInt(scan.nextLine());
								money += addMoney;
							}
								change = money - drinkPrice[sel-1];
								System.out.printf("->%s 나왔습니다.\n", drinkName[sel-1]);
								drinkStock[sel-1] = drinkStock[sel-1]-1;
								System.out.printf("거스름돈 '%d원'이 반환되었습니다.", change);
								System.out.println("");
						}
						break;
				
//					종료 ==============================================================	
					case 99 :
						System.out.println("자판기 종료");
						System.out.printf("돈 '%d원'이 반환되었습니다.", money);
						System.out.println("\n-end-");
					
						stop = true;
						break;
				
//					관리자모드	==========================================================
					case 00 :
						System.out.println(">관리자모드입니다< 비밀번호를 입력해주세요 : <");
						int npass = -9999;
						npass = Integer.parseInt(scan.nextLine());
						
						if (npass == PASS) {
							System.out.print("확인되었습니다. 변경이 필요한 음료를 선택하세요 : ");
							whatDrink = Integer.parseInt(scan.nextLine());
						
							switch (whatDrink) {
								case 1 : case 2 : case 3 : case 4 : case 5 : case 6 : case 7 :
										System.out.print("변경할 이름을 작성해주세요 : ");
										newDrink = scan.nextLine();
										System.out.print("얼마로 책정하시겠습니까? : ");
										newDrinkPrice = Integer.parseInt(scan.nextLine());
										System.out.print("몇 개 넣으시겠습니까? :" );
										newDrinkStock = Integer.parseInt(scan.nextLine());
										drinkName [whatDrink-1] = newDrink;
										drinkPrice [whatDrink-1] = newDrinkPrice;  
										drinkStock [whatDrink-1] = newDrinkStock;
									break;
							}  // switch (whatDrink) 끝
						}
						else {
							System.out.println("잘못입력되었습니다. 초기메뉴로 돌아갑니다.");
						}
						
							default :
							
				}  //switch (sel) 끝
			} // if (money>0) 닫기 
			else if (money<0) {
				System.out.println("돈을 제대로 투입해주세요");
			}
			
				System.out.println();
		} //while (!stop) 끝
		
	}

}
