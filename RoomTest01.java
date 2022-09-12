/*
 * ?��보드?�� ?��?�� ?��?�� ?��?��.
 * 12?�� 방이 존재 - int[]room = new int[12];
 * 초기값�? 0 - ?��?���??��, 1- ?��?�� 불�?
 * 반복?���?
 * [메뉴]
 * 1. ?��?��?���?   2. ?��?��취소   3. ?��?��보기   99.종료
 * select :
 * -------------
 * * - 3?�� ?��른경?��?�� ?��?��보기  => 1?���? "?��?��?��:?�� ", 0?���?  "?��?���??��?��"
 * 0�? ?��?�� : ?��?���??��?��
 * 1�? ?��?�� : ?��?���??��?��
 * 2�? ?��?�� : ?��?��?��:?��
 * 12�? ?��?�� : ?��?���??��?��
 * - 1?�� ?��른경?�� 
 * -> ?��?��번호 ?��?��(1~12)  -> ?��?��?��?��?���??��?��
 * -> ?��?���??��?��?�� -> ?��?��?��?��
 * -> ?��?��불�??��?��  -> 메뉴�? 복�? ?��?�� ?��?��번호?��?��?��로⭐
 */
package kr.co.checkpoint;

import java.util.Scanner;

public class RoomTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] room = new int[12];
		String[] User = new String[12];
		int[] code = new int[12];
		int i = 0, nSelectMenu = 0, nReserve = -1, nCode = -1, nSubMenu = -1;
		Scanner scan = new Scanner(System.in);
		String str = "", sUserName = "";
		Boolean bCheck = false;
		
		
		//?��?���??�� ?��?���? ?��
		for (i=0;i < room.length; i++) {
			room[i] = 0;
			User[i] = "";
			code[i] = -1;
		}
		
		
		while(nSelectMenu != 99) {
			System.out.println("[메뉴]");
			System.out.println("1. ?��?��?���?   2. ?��?��취소   3. ?��?��보기   99.종료");
			System.out.print("select :");
			
			nSelectMenu = Integer.parseInt(scan.next());
			
			switch(nSelectMenu) {
				case 1  : //==================================?��?��?���? 1==========================//
						nReserve = -1;
						System.out.println("\n[?��?��?���?]");
						while (!(0 <= nReserve)&&(nReserve <= 11)) {  // ?��?��?��?���? ?��?�� 번호�? 받으�? ?��???���? ?��?��.
							System.out.print("?��?��?�� ?��?��?��?�� ?��?�� 번호�? ?��?��주세?��:");
							nReserve = Integer.parseInt(scan.next());
							if ((0 <= nReserve)&&(nReserve <= 11)) {  // ?��??�? ?��?��?��?���?
								if (room[nReserve] == 0) {
									
									System.out.printf("%2d�? ?��?��: ?��?���??�� %n",nReserve);
									System.out.print("?��?��?���? ?��?��?�� ?��?��?��주세?��:");
									
									sUserName = scan.next();
									User[nReserve] = sUserName;
									
									nCode  = -1;
									//?��?��?�� 번호�? ?��?��?���? ?��?��, 기존?�� 번호?? 중복?��?���? ?��?��?�� 발행
									while(nCode == -1) {             
										nCode =(int)(Math.random()*100)+1;
										bCheck = false;
										for (i=0;i<code.length;i++) {
											if (code[i] == nCode) {
												bCheck = true;
												nCode  = -1;
												break;
											}
										}
										if (nCode != -1) {
											code[nReserve] = nCode;
										}
									}
									
									System.out.printf("%2d�? ?��?�� %s ?�� : ?��?��?��:?�� ?��?��번호:%d%n%n",nReserve, User[nReserve], code[nReserve]);
									room[nReserve] = 1;
								} else {                               
									System.out.printf("%2d�? ?��?��?? ?���? ?��?��?�� 방입?��?��, ?��?��?�� 불�??�� ?��?��?��.%n%n",nReserve);
									//nReserve = -1;
								}
								
							} else {                                     //  ?���? ?��?��?��?���?
								System.out.println("0?�� �??�� 11?�� ?��?�� ?�� ?��?���? ?��?��주세?��. \n");
							}
						}
						break;
				case 2  : //==================================?��?��취소 2==========================//
					nReserve = -1;
					System.out.println("\n[?��?��취소]");
					while (!(0 <= nReserve)&&(nReserve <= 11)) {     // ?��?��?��?���? ?��?��취소�? ?��?���? ?��???�� 종료.
						System.out.print("?��?��취소�? ?��?��?��?�� ?��?�� 번호�? ?��?��주세?��:");
						nReserve = Integer.parseInt(scan.next());
						if ((0 <= nReserve)&&(nReserve <= 11)) {     // ?��??�? ?��?��?��?���?
							if (room[nReserve] == 1) {
								System.out.print("?��?��?�� ?��?�� ?��?��?��, 메뉴�? ?��?��?��주세?��. (1: ?��?��?��?��),(2:?��?��번호?��?��):");
								nSubMenu = Integer.parseInt(scan.next());
								
								switch(nSubMenu) {
									case 1 : // ?��?��
										System.out.print("?��?��?���? ?��?��?�� ?��?��?��주세?��:");
										sUserName = scan.next();
										if (sUserName.equals(User[nReserve])) {
											System.out.printf("%2d�? ?��?�� : (?��?��번호:%d) %s?�� ?��?��취소 ?���? %n%n",nReserve,code[nReserve],  User[nReserve] );
//											System.out.printf("%2d�? ?��?�� : %s?�� ?��?��취소 ?���? %n%n",nReserve, User[nReserve] );
											room[nReserve] = 0;
											code[nReserve] = -1;
										} else {
											System.out.println("?��?��?���? ?��?��?�� ?���? ?���? ?��?��?��?��. ?��?��?�� ?��?��?��주세?��.\n\n");
										}
										break;
									case 2 : // ?��?��?��번호 ?��?��
										System.out.print("?��?��?���? ?��?��번호�? ?��?��?��주세?��:");
										nCode = Integer.parseInt(scan.next());
										if (nCode == code[nReserve]) {
											System.out.printf("%2d�? ?��?�� : (?��?��번호:%d) %s?�� ?��?��취소 ?���? %n%n",nReserve,code[nReserve],  User[nReserve] );
											room[nReserve] = 0;
											code[nReserve] = -1;
										} else {
											System.out.println("?��?��?���? ?��?��번호�? ?���? ?���? ?��?��?��?��. ?��?��?�� ?��?��?��주세?��.\n\n");
										}
										break;
									default :
										System.out.println("메뉴�? ?���? ?��르셨?��?��?��.");
								}
								
							} else {
								System.out.println("?��?��?�� ?��?�� ?���? ?��?��?��?��?��. ?��?��?�� ?��?��?��주세?��.\n\n");
								//nReserve = -1;
							}
						} else {
							System.out.println("0?�� �??�� 11?�� ?��?�� ?�� ?��?���? ?��?��주세?��. \n");
						}
					}
					break;						
				case 3  :  //==================================?��?��보기 3==========================//
					System.out.println("\n[?��?��보기]");
					for (i=0;i<room.length;i++) {
						str = "";
						if (room[i] == 0) {
							str = String.format("%2d�? ?��?�� : ?��?���??��?�� ", i);
						} else if(room[i] == 1) {
							str = String.format("%2d�? ?��?�� : ?��?��?��:?�� ?��?��?�� :%s ?��?��번호 :%d", i, User[i], code[i]);
						} else {
							
						}
						if (str !="") {
							System.out.println(str + ((i== room.length-1) ? "\n" : ""));
						}
					}
					break;
				case 99 : //==================================?��로그?�� 종료 99==========================//
					System.out.println("\n[종료]");
					System.out.println("?��로그?�� 종료");
					break;
				default : 
					System.out.println("메뉴�? ?���? ?��르셨?��?��?��.");
					break;
			}
			
			
		}
		scan.close();

	}

}
