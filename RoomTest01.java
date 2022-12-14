/*
 * ?€λ³΄λ? ?? ?? ₯ ??±.
 * 12? λ°©μ΄ μ‘΄μ¬ - int[]room = new int[12];
 * μ΄κΈ°κ°μ? 0 - ??½κ°??₯, 1- ??½ λΆκ?
 * λ°λ³΅?κΈ?
 * [λ©λ΄]
 * 1. ??½?κΈ?   2. ??½μ·¨μ   3. ?Έ?€λ³΄κΈ°   99.μ’λ£
 * select :
 * -------------
 * * - 3? ?λ₯Έκ²½?°? ?Έ?€λ³΄κΈ°  => 1?΄λ©? "??½?¨:? ", 0?΄λ©?  "??½κ°??₯?"
 * 0λ²? ?Έ?€ : ??½κ°??₯?
 * 1λ²? ?Έ?€ : ??½κ°??₯?
 * 2λ²? ?Έ?€ : ??½?¨:?
 * 12λ²? ?Έ?€ : ??½κ°??₯?
 * - 1? ?λ₯Έκ²½?° 
 * -> ?Έ?€λ²νΈ ? ?(1~12)  -> ??½???¬λΆ???Έ
 * -> ??½κ°??₯?? -> ??½?€?
 * -> ??½λΆκ???  -> λ©λ΄λ‘? λ³΅κ? ?? ?Έ?€λ²νΈ? ??Όλ‘β­
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
		
		
		//??½κ°??₯ ??λ‘? ? 
		for (i=0;i < room.length; i++) {
			room[i] = 0;
			User[i] = "";
			code[i] = -1;
		}
		
		
		while(nSelectMenu != 99) {
			System.out.println("[λ©λ΄]");
			System.out.println("1. ??½?κΈ?   2. ??½μ·¨μ   3. ?Έ?€λ³΄κΈ°   99.μ’λ£");
			System.out.print("select :");
			
			nSelectMenu = Integer.parseInt(scan.next());
			
			switch(nSelectMenu) {
				case 1  : //==================================??½?κΈ? 1==========================//
						nReserve = -1;
						System.out.println("\n[??½?κΈ?]");
						while (!(0 <= nReserve)&&(nReserve <= 11)) {  // ? ?? ?Όλ‘? ??½ λ²νΈλ₯? λ°μΌλ©? ????€κ°? ??¨.
							System.out.print("??½? ???? ?Έ?€ λ²νΈλ₯? ??¬μ£ΌμΈ?:");
							nReserve = Integer.parseInt(scan.next());
							if ((0 <= nReserve)&&(nReserve <= 11)) {  // ? ??λ‘? ?? ₯??Όλ©?
								if (room[nReserve] == 0) {
									
									System.out.printf("%2dλ²? ?Έ?€: ??½κ°??₯ %n",nReserve);
									System.out.print("??½?λΆ? ?±?¨? ?? ₯?΄μ£ΌμΈ?:");
									
									sUserName = scan.next();
									User[nReserve] = sUserName;
									
									nCode  = -1;
									//??½? λ²νΈλ₯? ??€?Όλ‘? ??±, κΈ°μ‘΄? λ²νΈ?? μ€λ³΅?¬?μ§? ??Έ? λ°ν
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
									
									System.out.printf("%2dλ²? ?Έ?€ %s ? : ??½?¨:? ??½λ²νΈ:%d%n%n",nReserve, User[nReserve], code[nReserve]);
									room[nReserve] = 1;
								} else {                               
									System.out.printf("%2dλ²? ?Έ?€?? ?΄λ―? ??½? λ°©μ??€, ??½?΄ λΆκ??₯ ?©??€.%n%n",nReserve);
									//nReserve = -1;
								}
								
							} else {                                     //  ?λͺ? ?? ₯??Όλ©?
								System.out.println("0?Έ λΆ??° 11?Έ ?¬?΄ ? ?«?λ₯? ??¬μ£ΌμΈ?. \n");
							}
						}
						break;
				case 2  : //==================================??½μ·¨μ 2==========================//
					nReserve = -1;
					System.out.println("\n[??½μ·¨μ]");
					while (!(0 <= nReserve)&&(nReserve <= 11)) {     // ? ?? ?Όλ‘? ??½μ·¨μκ°? ??λ©? ????€ μ’λ£.
						System.out.print("??½μ·¨μλ₯? ???? ?Έ?€ λ²νΈλ₯? ??¬μ£ΌμΈ?:");
						nReserve = Integer.parseInt(scan.next());
						if ((0 <= nReserve)&&(nReserve <= 11)) {     // ? ??λ‘? ?? ₯??Όλ©?
							if (room[nReserve] == 1) {
								System.out.print("??½? ??Έ ?©??€, λ©λ΄λ₯? ? ??΄μ£ΌμΈ?. (1: ?±?¨??Έ),(2:??½λ²νΈ??Έ):");
								nSubMenu = Integer.parseInt(scan.next());
								
								switch(nSubMenu) {
									case 1 : // ?±?¨
										System.out.print("??½?λΆ? ?±?¨? ?? ₯?΄μ£ΌμΈ?:");
										sUserName = scan.next();
										if (sUserName.equals(User[nReserve])) {
											System.out.printf("%2dλ²? ?Έ?€ : (??½λ²νΈ:%d) %s? ??½μ·¨μ ?λ£? %n%n",nReserve,code[nReserve],  User[nReserve] );
//											System.out.printf("%2dλ²? ?Έ?€ : %s? ??½μ·¨μ ?λ£? %n%n",nReserve, User[nReserve] );
											room[nReserve] = 0;
											code[nReserve] = -1;
										} else {
											System.out.println("??½?λΆ? ?±?¨?΄ ?ΌμΉ? ?μ§? ??΅??€. ??½? ??Έ?΄μ£ΌμΈ?.\n\n");
										}
										break;
									case 2 : // ??½?λ²νΈ ??Έ
										System.out.print("??½?λΆ? ??½λ²νΈλ₯? ?? ₯?΄μ£ΌμΈ?:");
										nCode = Integer.parseInt(scan.next());
										if (nCode == code[nReserve]) {
											System.out.printf("%2dλ²? ?Έ?€ : (??½λ²νΈ:%d) %s? ??½μ·¨μ ?λ£? %n%n",nReserve,code[nReserve],  User[nReserve] );
											room[nReserve] = 0;
											code[nReserve] = -1;
										} else {
											System.out.println("??½?λΆ? ??½λ²νΈκ°? ?ΌμΉ? ?μ§? ??΅??€. ??½? ??Έ?΄μ£ΌμΈ?.\n\n");
										}
										break;
									default :
										System.out.println("λ©λ΄λ₯? ?λͺ? ?λ₯΄μ¨?΅??€.");
								}
								
							} else {
								System.out.println("??½?΄ ??Έ ?μ§? ???΅??€. ??½? ??Έ?΄μ£ΌμΈ?.\n\n");
								//nReserve = -1;
							}
						} else {
							System.out.println("0?Έ λΆ??° 11?Έ ?¬?΄ ? ?«?λ₯? ??¬μ£ΌμΈ?. \n");
						}
					}
					break;						
				case 3  :  //==================================?Έ?€λ³΄κΈ° 3==========================//
					System.out.println("\n[?Έ?€λ³΄κΈ°]");
					for (i=0;i<room.length;i++) {
						str = "";
						if (room[i] == 0) {
							str = String.format("%2dλ²? ?Έ?€ : ??½κ°??₯? ", i);
						} else if(room[i] == 1) {
							str = String.format("%2dλ²? ?Έ?€ : ??½?¨:? ??½? :%s ??½λ²νΈ :%d", i, User[i], code[i]);
						} else {
							
						}
						if (str !="") {
							System.out.println(str + ((i== room.length-1) ? "\n" : ""));
						}
					}
					break;
				case 99 : //==================================?λ‘κ·Έ?¨ μ’λ£ 99==========================//
					System.out.println("\n[μ’λ£]");
					System.out.println("?λ‘κ·Έ?¨ μ’λ£");
					break;
				default : 
					System.out.println("λ©λ΄λ₯? ?λͺ? ?λ₯΄μ¨?΅??€.");
					break;
			}
			
			
		}
		scan.close();

	}

}
