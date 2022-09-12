package kr.co.checkpoint;

import java.util.Arrays;
import java.util.Scanner;

public class VendingM_v2_jio {

	public static void main(String[] args) {
//      1차원(2차원) 배열로 자판기를 구현하자
//      음료의 종류는 5가지 이상입니다. 종류, 가격, 재고는 있어야지용

		Scanner scan = new Scanner(System.in);
		final int PASS = 1234; // 관리자모드 진행시 비밀번호
		final int SIZE = 7; // 음료의 재고

		String[] drinkName = { "콜라", "사이다", "환타", "포카리", "토레타", "아아", "라떼" }; // 음료수 이름
		String[] drinkState = { " ", " ", " ", " ", " ", " ", " " }; // 판매 현황(판매중, 품절)
		int[] drinkPrice = { 1500, 1300, 1000, 2000, 1400, 1200, 2400 }; // 음료가격
		int[] drinkStock = { 5, 1, 4, 2, 3, 8, 7 }; // 음료의 재고

		int menu = 0; // 메뉴
		int adminPw = 0; // 관리자 모드 비밀번호

		int addPrice = 0; // 추가 금액
		String dName = " "; // 음료 변경
		int dPrice = 0; // 음료 가격 변경
		int dStock = 0; // 음료 재고 변경
		int adminMenu = 0; // 관리자 모드 메뉴

		boolean stop = false;
		boolean admin = false;

		while (!stop) {
			// 판매 현황
			for (int i = 0; i < drinkState.length; i++) {
				if (drinkStock[i] <= 0) {
					drinkState[i] = "품절";
				} else {
					drinkState[i] = "판매중";
				}
			}

			System.out.println("-----------------[메뉴]-----------------");
			System.out.println("1. 음료 뽑기 99. 종료 100. 관리자 모드");
			System.out.println("---------------------------------------");
			System.out.print("메뉴 선택 >> ");
			menu = Integer.parseInt(scan.nextLine());

			switch (menu) {
			case 1:
				System.out.println("===============[음료수 메뉴]===============");

				for (int i = 0; i < drinkName.length; i++) {
					System.out.println((i + 1) + ") " + drinkName[i] + "(" + drinkPrice[i] + "원) - " + drinkState[i]);
				}
				System.out.print("원하는 음료의 숫자를 입력하세요.(1~7)>>");
				menu = Integer.parseInt(scan.nextLine());

				if ((menu > 0) && (menu <= 7)) {
					for (int i = 0; i <= drinkName.length; i++) {
						if (menu == i) {
							System.out.print("금액을 입력하세요. >>");
							dPrice = Integer.parseInt(scan.nextLine());

							if (dPrice == drinkPrice[i - 1]) { // 입력 금액과 음료 금액이 같다면
								System.out.println("잔액>>" + (drinkPrice[i - 1] - dPrice) + "원");
								System.out.println(drinkName[i - 1] + "가 나왔습니다.");
								drinkStock[i - 1] -= 1;
								break;
							} else if (dPrice < drinkPrice[i - 1]) { // 입력 금액이 음료 금액보다 작다면
								while (dPrice < drinkPrice[i - 1]) {// 추가 금액 받기(금액이 같아질때까지)
									System.out.println("잔액 부족! 잔액>>" + (drinkPrice[i - 1] - dPrice));
									System.out.printf("추가 금액 입력>>");
									addPrice = Integer.parseInt(scan.nextLine());
									dPrice += addPrice;

									if (dPrice > drinkPrice[i - 1]) { // 추가 금액이 음료 금액보다 크면 잔액 반환
										System.out.println((dPrice - drinkPrice[i - 1]) + "원 반환");
									}
								}
								System.out.println(drinkName[i - 1] + "가 나왔습니다.");
								drinkStock[i - 1] -= 1;
								break;
							} else if (dPrice > drinkPrice[i - 1]) { // 입력 금액이 음료 금액보다 크다면 잔액 반환
								System.out.println((dPrice - drinkPrice[i - 1]) + "원 반환");
								System.out.println(drinkName[i - 1] + "가 나왔습니다.");
								drinkStock[i - 1] -= 1;
								break;
							}
						}
					}
				} else {
					System.out.println("1~7중 입력해주세요.");
				}
				break;

			case 99:
				System.out.println("[자판기 종료 합니당]");
				stop = true;
				break;

			case 100: // 관리자 모드
				System.out.print("관리자 모드 비밀번호 >>");
				adminPw = Integer.parseInt(scan.nextLine());

				if (PASS == adminPw) { // 비밀번호가 같으면 관리자 모드에 들어감
					System.out.println("============[관리자 모드]============");
					for (int i = 0; i < drinkName.length; i++) {
						System.out
								.println((i + 1) + ") " + drinkName[i] + "(" + drinkPrice[i] + "원) - " + drinkState[i]);
					}
					System.out.println("\n1. 음료 종류 변경");
					System.out.println("2. 음료 가격 변경");
					System.out.println("3. 재고 추가");
					System.out.println("4. 관리자모드 종료");
					System.out.printf("관리하실 메뉴 숫자를 입력하세요.(1~4) >>");
					adminMenu = Integer.parseInt(scan.nextLine());

					switch (adminMenu) {
					case 1: // 메뉴 변경
						System.out.printf("변경하고 싶은 메뉴를 선택해주세요.(1~7) >> ");
						menu = Integer.parseInt(scan.nextLine());

						if ((menu > 0) && (menu <= 7)) {
							System.out.print("변경할 메뉴 이름 입력>>");
							dName = scan.nextLine();
							drinkName[menu - 1] = dName;
						} else {
							System.out.println("1~7중에서 골라주세요");
						}
						System.out.println("--------------[변경 후 메뉴]--------------");
						System.out.println(Arrays.toString(drinkName));
						break;

					case 2: // 가격 변경
						System.out.printf("가격 변경하고 싶은 메뉴를 선택해주세요.(1~7) >> ");
						menu = Integer.parseInt(scan.nextLine());

						if ((menu > 0) && (menu <= 7)) {
							System.out.print("변경할 가격 입력>> ");
							dPrice = Integer.parseInt(scan.nextLine());
							drinkPrice[menu - 1] = dPrice;
						} else {
							System.out.println("1~7중에서 골라주세요");
						}
						System.out.println("--------------[가격 변경 후 메뉴]--------------");
						System.out.println(Arrays.toString(drinkPrice));
						break;

					case 3: // 재고 추가
						System.out.printf("재고 추가할 메뉴를 선택해주세요.(1~7) >>");
						menu = Integer.parseInt(scan.nextLine());

						if ((menu > 0) && (menu <= 7)) {
							System.out.print("추가할 재고 개수 입력>> ");
							dStock = Integer.parseInt(scan.nextLine());
							drinkStock[menu - 1] += dStock;
						} else {
							System.out.println("1~7중에서 골라주세요");
						}
						System.out.println("--------------[재고 변경 후 메뉴]--------------");
						System.out.println(Arrays.toString(drinkStock));
						break;

					case 4:
						System.out.println("=====[관리자 모드 종료]=====");
						System.out.println("판매모드로 돌아갑니다.");
						admin = true;
						break;

					default:
						System.out.println("1~4중 입력하세요.");
					}

				} else {
					System.out.println("비밀번호가 틀렸습니다.");
				}
				break;

			default:
				System.out.println("1, 99, 100중에서 입력하세요.");
			}
		}
		scan.close();
	}
}