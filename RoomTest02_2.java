//===================?€μ°¨μ λ°°μ΄λ‘? λ°κΎΈκΈ? λ²μ  ==========================made ??¨

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

public class RoomTest02_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//0		int[] room = new int[12];            // ??½??.
//1		int[] roomNo = new int[12];          // ?Έ?€λ²νΈ
//2		int[] code = new int[12];            // ?¬?©?κ°? ?? ₯?? ??½λ²νΈ 
		
		final  int AROOM     = 0;
		final  int AROOMNO = 1;
		final  int ACODE     = 2;
		int[][] room = new int[3][12];            // ??½??.
		
		String[] User = new String[12];      //??½?λͺ?

		//String[] roomInfo = new String[12];  // ?Έ?€? λ³?.
		
		int i = 0, nSelectMenu = 0, nReserve = -1, nCode = -1, nSubMenu = -1, nReserveNAME = -1;
		int nRoomNum = 0;
		Scanner scan = new Scanner(System.in);
		String str = "", sUserName = "";
		Boolean bCheck = false;
		
		
		//??½κ°??₯ ??λ‘? ? 
		nRoomNum = 0;
		for (i=0;i < room[AROOM].length; i++) {			
			if ((i%3==0)) {
				nRoomNum += 100;
			}
			room[AROOM][i] = 0;
			room[AROOMNO][i] += nRoomNum + (i%3)+1;
			room[ACODE][i] = -1;
			
			User[i] = "";
		}
		
		
		while(nSelectMenu != 99) {
			System.out.println("[λ©λ΄]");
			System.out.println("1. ??½?κΈ?   2. ??½μ·¨μ   3. ?Έ?€λ³΄κΈ°   99.μ’λ£");
			System.out.print("select :");
			
			nSelectMenu = Integer.parseInt(scan.next());
			
			switch(nSelectMenu) {
				case 1  : //==================================??½?κΈ? 1==========================//
						nReserve = -1;
						System.out.println("\n[??½?κΈ?] : μ΄κΈ°?λ©΄μΌλ‘? κ°??? €λ©? -2λ₯? ?? ₯?΄μ£ΌμΈ?.");
						while (!(0 <= nReserve)&&(nReserve <= 11)) {  // ? ?? ?Όλ‘? ??½ λ²νΈλ₯? λ°μΌλ©? ????€κ°? ??¨.
							System.out.print("??½? ???? ?Έ?€ λ²νΈλ₯? ??¬μ£ΌμΈ?:");
							nReserveNAME = Integer.parseInt(scan.next());
							if (nReserveNAME == -2) {
								System.out.println("μ§νμ€μΈ λ©λ΄λ₯? μ’λ£?©??€.");
								break;
							}
							
							nReserve = returnRoomIndex(nReserveNAME, room[AROOMNO]);
							if ((0 <= nReserve)&&(nReserve <= 11)) {  // ? ??λ‘? ?? ₯??Όλ©?
								if (room[AROOM][nReserve] == 0) {
									
									System.out.printf("%2d ?Έ?€(%2d): ??½κ°??₯ %n",room[AROOMNO][nReserve],nReserve);
									System.out.print("??½?λΆ? ?±?¨? ?? ₯?΄μ£ΌμΈ?:");
									
									sUserName = scan.next();
									
									if (sUserName == "-2") {
										System.out.println("μ§νμ€μΈ λ©λ΄λ₯? μ’λ£?©??€.");
									}									
									User[nReserve] = sUserName;
									
									nCode  = -1;
									//??½? λ²νΈλ₯? ?¬?©?κ°? ?? ₯ , κΈ°μ‘΄? λ²νΈ?? μ€λ³΅?¬?μ§? ??Έ? λ°ν
									while(nCode == -1) {  
										System.out.print("???? ??½ λ²νΈλ₯? ??¬μ£ΌμΈ?, ??½??Έ?? ?¬?©?©??€.:");
										
										nCode = Integer.parseInt(scan.next());
										
										//nCode =(int)(Math.random()*100)+1;
										if (nCode == -2) {
											User[nReserve] = "";
											System.out.println("μ§νμ€μΈ λ©λ΄λ₯? μ’λ£?©??€.");
										}											
										bCheck = false;
										for (i=0;i<room[ACODE].length;i++) {
											if (room[ACODE][i] == nCode) {
												bCheck = true;
												nCode  = -1;
												System.out.println("?΄λ―? ?¬?©μ€μΈ ??½λ²νΈ???€.");
												break;
											}
										}
										if (nCode != -1) {
											room[ACODE][nReserve] = nCode;
										}
									}
									
									System.out.printf("%dλ²? ?Έ?€(%2d) %s ? : ??½?¨:? ??½λ²νΈ:%d%n%n",room[AROOMNO][nReserve],nReserve, User[nReserve], room[ACODE][nReserve]);
									room[AROOM][nReserve] = 1;
								} else {                               
									System.out.printf("%dλ²? ?Έ?€(%2d)?? ?΄λ―? ??½? λ°©μ??€, ??½?΄ λΆκ??₯ ?©??€.%n%n",room[AROOMNO][nReserve],nReserve);
									nReserve = -1;
								}
								
							} else {                                     //  ?λͺ? ?? ₯??Όλ©?
								System.out.println("?? ?Έ? λ²νΈ ???€. \n");
								nReserve = -1;
							}
						}
						break;
				case 2  : //==================================??½μ·¨μ 2==========================//
					nReserve = -1;
					System.out.println("\n[??½μ·¨μ] : μ΄κΈ°?λ©΄μΌλ‘? κ°??? €λ©? -2λ₯? ?? ₯?΄μ£ΌμΈ?.");
					while (!(0 <= nReserve)&&(nReserve <= 11)) {     // ? ?? ?Όλ‘? ??½μ·¨μκ°? ??λ©? ????€ μ’λ£.
						System.out.print("??½μ·¨μλ₯? ???? ?Έ?€ ?Έ?λ₯? ??¬μ£ΌμΈ?:");
						nReserveNAME = Integer.parseInt(scan.next());
						if (nReserveNAME == -2) {
							System.out.println("μ§νμ€μΈ λ©λ΄λ₯? μ’λ£?©??€.");
							break;
						}
						
						nReserve  = returnRoomIndex(nReserveNAME, room[AROOMNO]);
						if ((0 <= nReserve)&&(nReserve <= 11)) {     // ? ??λ‘? ?? ₯??Όλ©?
							if (room[AROOM][nReserve] == 1) {
								System.out.print("??½? ??Έ ?©??€, λ©λ΄λ₯? ? ??΄μ£ΌμΈ?. \n1:?±?¨??Έ , 2:??½λ²νΈ??Έ :");
								nSubMenu = Integer.parseInt(scan.next());
								
								if (nSubMenu == -2) {
									System.out.println("μ§νμ€μΈ λ©λ΄λ₯? μ’λ£?©??€.");
									break;
								}								
								switch(nSubMenu) {
									case 1 : // ?±?¨
										System.out.print("??½?λΆ? ?±?¨? ?? ₯?΄μ£ΌμΈ?:");
										sUserName = scan.next();
										if (sUserName.equals("-2")) {
											System.out.println("μ§νμ€μΈ λ©λ΄λ₯? μ’λ£?©??€.");
											break;
										}	
										if (sUserName.equals(User[nReserve])) {
											System.out.printf("%dλ²? ?Έ?€(%2d) : (??½λ²νΈ:%d) %s? ??½μ·¨μ ?λ£? %n%n",room[AROOMNO][nReserve] ,nReserve,room[ACODE][nReserve],  User[nReserve] );
											room[AROOM][nReserve] = 0;
											room[ACODE][nReserve] = -1;
										} else {
											System.out.println("??½?λΆ? ?±?¨?΄ ?ΌμΉ? ?μ§? ??΅??€. ??½? ??Έ?΄μ£ΌμΈ?.\n\n");
										}
										break;
									case 2 : // ??½?λ²νΈ ??Έ
										System.out.print("??½?λΆ? ??½λ²νΈλ₯? ?? ₯?΄μ£ΌμΈ?:");
										nCode = Integer.parseInt(scan.next());
										if (nCode == -2) {
											System.out.println("μ§νμ€μΈ λ©λ΄λ₯? μ’λ£?©??€.");
											break;
										}	
										
										if (nCode == room[ACODE][nReserve]) {
											System.out.printf("%dλ²? ?Έ?€(%2d) : (??½λ²νΈ:%d) %s? ??½μ·¨μ ?λ£? %n%n",room[AROOMNO][nReserve], nReserve,room[ACODE][nReserve],  User[nReserve] );
											room[AROOM][nReserve] = 0;
											room[ACODE][nReserve] = -1;
										} else {
											System.out.println("??½?λΆ? ??½λ²νΈκ°? ?ΌμΉ? ?μ§? ??΅??€. ??½? ??Έ?΄μ£ΌμΈ?.\n\n");
										}
										break;
									default :
										System.out.println("λ©λ΄λ₯? ?λͺ? ?λ₯΄μ¨?΅??€.");
										nReserve = -1;
								}
								
							} else {
								System.out.println("??½?΄ ??Έ ?μ§? ???΅??€. ??½? ??Έ?΄μ£ΌμΈ?.\n\n");
								nReserve = -1;
							}
						} else {
							System.out.println("?? ?Έ? λ²νΈ ???€. \n");
							nReserve = -1;
						}
					}
					break;						
				case 3  :  //==================================?Έ?€λ³΄κΈ° 3==========================//
					System.out.println("\n[?Έ?€λ³΄κΈ°]");
					for (i=0;i<room[AROOM].length;i++) {
						str = "";
						if (room[AROOM][i] == 0) {
							str = String.format("%3dλ²? ?Έ?€(%2d) : ??½κ°??₯? " , room[AROOMNO][i],  i );
						} else if(room[AROOM][i] == 1) {
							str = String.format("%3dλ²? ?Έ?€(%2d) : ??½?¨:? ??½? :%5s ??½λ²νΈ :%5d",  room[AROOMNO][i],  i, User[i], room[ACODE][i]);
						} else {
							
						}
						if (str !="") {
							System.out.println(str + ((i== room[AROOM].length-1) ? "\n" : ""));
						}
					}
					break;
				case 99 : //==================================?λ‘κ·Έ?¨ μ’λ£ 99==========================//
					System.out.println("\n[μ’λ£]");
					System.out.println("???κ°??Έ?©");
					break;
				default : 
					System.out.println("λ©λ΄λ₯? ?λͺ? ?λ₯΄μ¨?΅??€.");
					break;
			}
			
			
		}
		scan.close();

	}
	
	//============ ?¬?©?κ°? ?? ₯? λ£Έμ΄λ¦? ? λ°°μ΄?? μ°Ύμ? ?Έ?±?€λ₯? λ¦¬ν΄??€.
	static Integer returnRoomIndex(int roomNum, int[] roomarry) {
		int value = -9999, k = 0;			
		
		for (k = 0;k<roomarry.length;k++) {
			if (roomNum == roomarry[k]) {
				value = k;
				break;
			}
		}
		
		return value;
	}


}
