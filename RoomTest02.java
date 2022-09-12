/*
 * ?‚¤ë³´ë“œ?— ?˜?•œ ?…? ¥ ?‘?„±.
 * 12?˜ ë°©ì´ ì¡´ì¬ - int[]room = new int[12];
 * ì´ˆê¸°ê°’ì? 0 - ?˜ˆ?•½ê°??Š¥, 1- ?˜ˆ?•½ ë¶ˆê?
 * ë°˜ë³µ?•˜ê¸?
 * [ë©”ë‰´]
 * 1. ?˜ˆ?•½?•˜ê¸?   2. ?˜ˆ?•½ì·¨ì†Œ   3. ?˜¸?‹¤ë³´ê¸°   99.ì¢…ë£Œ
 * select :
 * -------------
 * * - 3?„ ?ˆ„ë¥¸ê²½?š°?Š” ?˜¸?‹¤ë³´ê¸°  => 1?´ë©? "?˜ˆ?•½?¨:?˜… ", 0?´ë©?  "?˜ˆ?•½ê°??Š¥?˜†"
 * 0ë²? ?˜¸?‹¤ : ?˜ˆ?•½ê°??Š¥?˜†
 * 1ë²? ?˜¸?‹¤ : ?˜ˆ?•½ê°??Š¥?˜†
 * 2ë²? ?˜¸?‹¤ : ?˜ˆ?•½?¨:?˜…
 * 12ë²? ?˜¸?‹¤ : ?˜ˆ?•½ê°??Š¥?˜†
 * - 1?„ ?ˆ„ë¥¸ê²½?š° 
 * -> ?˜¸?‹¤ë²ˆí˜¸ ?„ ?ƒ(1~12)  -> ?˜ˆ?•½?ƒ?ƒœ?—¬ë¶??™•?¸
 * -> ?˜ˆ?•½ê°??Š¥?ƒ?ƒœ -> ?˜ˆ?•½?‹¤?‹œ
 * -> ?˜ˆ?•½ë¶ˆê??ƒ?ƒœ  -> ë©”ë‰´ë¡? ë³µê? ?˜?Š” ?˜¸?‹¤ë²ˆí˜¸?„ ?ƒ?œ¼ë¡œâ­
 */
package kr.co.checkpoint;

import java.util.Scanner;

public class RoomTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] room = new int[12];            // ?˜ˆ?•½?ƒ?ƒœ.
		
		String[] User = new String[12];      //?˜ˆ?•½?ëª?
		int[] code = new int[12];            // ?‚¬?š©?ê°? ?…? ¥?•˜?Š” ?˜ˆ?•½ë²ˆí˜¸ 

		int[] roomNo = new int[12];          // ?˜¸?‹¤ë²ˆí˜¸
		//String[] roomInfo = new String[12];  // ?˜¸?‹¤? •ë³?.
		
		int i = 0, nSelectMenu = 0, nReserve = -1, nCode = -1, nSubMenu = -1, nReserveNAME = -1;
		int nRoomNum = 0;
		Scanner scan = new Scanner(System.in);
		String str = "", sUserName = "";
		Boolean bCheck = false;
		
		
		//?˜ˆ?•½ê°??Š¥ ?ƒ?ƒœë¡? ?‘ 
		nRoomNum = 0;
		for (i=0;i < room.length; i++) {
			if ((i%3==0)) {
				nRoomNum += 100;
			}
			room[i] = 0;
			User[i] = "";
			code[i] = -1;
			roomNo[i]  += nRoomNum + (i%3) +1;
		}
		
		
		while(nSelectMenu != 99) {
			System.out.println("[ë©”ë‰´]");
			System.out.println("1. ?˜ˆ?•½?•˜ê¸?   2. ?˜ˆ?•½ì·¨ì†Œ   3. ?˜¸?‹¤ë³´ê¸°   99.ì¢…ë£Œ");
			System.out.print("select :");
			
			nSelectMenu = Integer.parseInt(scan.next());
			
			switch(nSelectMenu) {
				case 1  : //==================================?˜ˆ?•½?•˜ê¸? 1==========================//
						nReserve = -1;
						System.out.println("\n[?˜ˆ?•½?•˜ê¸?] : ì´ˆê¸°?™”ë©´ìœ¼ë¡? ê°??‹œ? ¤ë©? -2ë¥? ?…? ¥?•´ì£¼ì„¸?š”.");
						while (!(0 <= nReserve)&&(nReserve <= 11)) {  // ? •?ƒ? ?œ¼ë¡? ?˜ˆ?•½ ë²ˆí˜¸ë¥? ë°›ìœ¼ë©? ?‹œ???Š¤ê°? ??‚¨.
							System.out.print("?˜ˆ?•½?„ ?›?•˜?‹œ?Š” ?˜¸?‹¤ ë²ˆí˜¸ë¥? ?ˆŒ?Ÿ¬ì£¼ì„¸?š”:");
							nReserveNAME = Integer.parseInt(scan.next());
							if (nReserveNAME == -2) {
								System.out.println("ì§„í–‰ì¤‘ì¸ ë©”ë‰´ë¥? ì¢…ë£Œ?•©?‹ˆ?‹¤.");
								break;
							}
							
							nReserve = returnRoomIndex(nReserveNAME, roomNo);
							if ((0 <= nReserve)&&(nReserve <= 11)) {  // ? œ??ë¡? ?…? ¥?–‡?œ¼ë©?
								if (room[nReserve] == 0) {
									
									System.out.printf("%2d ?˜¸?‹¤(%2d): ?˜ˆ?•½ê°??Š¥ %n",roomNo[nReserve],nReserve);
									System.out.print("?˜ˆ?•½?ë¶? ?„±?•¨?„ ?…? ¥?•´ì£¼ì„¸?š”:");
									
									sUserName = scan.next();
									
									if (sUserName == "-2") {
										System.out.println("ì§„í–‰ì¤‘ì¸ ë©”ë‰´ë¥? ì¢…ë£Œ?•©?‹ˆ?‹¤.");
									}									
									User[nReserve] = sUserName;
									
									nCode  = -1;
									//?˜ˆ?•½? ë²ˆí˜¸ë¥? ?‚¬?š©?ê°? ?…? ¥ , ê¸°ì¡´?— ë²ˆí˜¸?? ì¤‘ë³µ?¬?Š”ì§? ?™•?¸?›„ ë°œí–‰
									while(nCode == -1) {  
										System.out.print("?›?•˜?‹œ?Š” ?˜ˆ?•½ ë²ˆí˜¸ë¥? ?ˆŒ?Ÿ¬ì£¼ì„¸?š”, ?˜ˆ?•½?™•?¸?‹œ?— ?‚¬?š©?©?‹ˆ?‹¤.:");
										
										nCode = Integer.parseInt(scan.next());
										
										//nCode =(int)(Math.random()*100)+1;
										if (nCode == -2) {
											User[nReserve] = "";
											System.out.println("ì§„í–‰ì¤‘ì¸ ë©”ë‰´ë¥? ì¢…ë£Œ?•©?‹ˆ?‹¤.");
										}											
										bCheck = false;
										for (i=0;i<code.length;i++) {
											if (code[i] == nCode) {
												bCheck = true;
												nCode  = -1;
												System.out.println("ì¤‘ë³µ?œ ?˜ˆ?•½ë²ˆí˜¸?…?‹ˆ?‹¤.");
												break;
											}
										}
										if (nCode != -1) {
											code[nReserve] = nCode;
										}
									}
									
									System.out.printf("%dë²? ?˜¸?‹¤(%2d) %s ?‹˜ : ?˜ˆ?•½?¨:?˜… ?˜ˆ?•½ë²ˆí˜¸:%d%n%n",roomNo[nReserve],nReserve, User[nReserve], code[nReserve]);
									room[nReserve] = 1;
								} else {                               
									System.out.printf("%dë²? ?˜¸?‹¤(%2d)?? ?´ë¯? ?˜ˆ?•½?œ ë°©ì…?‹ˆ?‹¤, ?˜ˆ?•½?´ ë¶ˆê??Š¥ ?•©?‹ˆ?‹¤.%n%n",roomNo[nReserve],nReserve);
									nReserve = -1;
								}
								
							} else {                                     //  ?˜ëª? ?…? ¥?–ˆ?œ¼ë©?
								System.out.println("?—†?Š” ?˜¸?ˆ˜ ë²ˆí˜¸ ?…?‹ˆ?‹¤. \n");
								nReserve = -1;
							}
						}
						break;
				case 2  : //==================================?˜ˆ?•½ì·¨ì†Œ 2==========================//
					nReserve = -1;
					System.out.println("\n[?˜ˆ?•½ì·¨ì†Œ] : ì´ˆê¸°?™”ë©´ìœ¼ë¡? ê°??‹œ? ¤ë©? -2ë¥? ?…? ¥?•´ì£¼ì„¸?š”.");
					while (!(0 <= nReserve)&&(nReserve <= 11)) {     // ? •?ƒ? ?œ¼ë¡? ?˜ˆ?•½ì·¨ì†Œê°? ??‚˜ë©? ?‹œ???Š¤ ì¢…ë£Œ.
						System.out.print("?˜ˆ?•½ì·¨ì†Œë¥? ?›?•˜?‹œ?Š” ?˜¸?‹¤ ?˜¸?ˆ˜ë¥? ?ˆŒ?Ÿ¬ì£¼ì„¸?š”:");
						nReserveNAME = Integer.parseInt(scan.next());
						if (nReserveNAME == -2) {
							System.out.println("ì§„í–‰ì¤‘ì¸ ë©”ë‰´ë¥? ì¢…ë£Œ?•©?‹ˆ?‹¤.");
							break;
						}
						
						nReserve  = returnRoomIndex(nReserveNAME, roomNo);
						if ((0 <= nReserve)&&(nReserve <= 11)) {     // ? œ??ë¡? ?…? ¥?–ˆ?œ¼ë©?
							if (room[nReserve] == 1) {
								System.out.print("?˜ˆ?•½?„ ?™•?¸ ?•©?‹ˆ?‹¤, ë©”ë‰´ë¥? ?„ ?ƒ?•´ì£¼ì„¸?š”. (1: ?„±?•¨?™•?¸),(2:?˜ˆ?•½ë²ˆí˜¸?™•?¸):");
								nSubMenu = Integer.parseInt(scan.next());
								
								if (nSubMenu == -2) {
									System.out.println("ì§„í–‰ì¤‘ì¸ ë©”ë‰´ë¥? ì¢…ë£Œ?•©?‹ˆ?‹¤.");
									break;
								}								
								switch(nSubMenu) {
									case 1 : // ?„±?•¨
										System.out.print("?˜ˆ?•½?ë¶? ?„±?•¨?„ ?…? ¥?•´ì£¼ì„¸?š”:");
										sUserName = scan.next();
										if (sUserName.equals("-2")) {
											System.out.println("ì§„í–‰ì¤‘ì¸ ë©”ë‰´ë¥? ì¢…ë£Œ?•©?‹ˆ?‹¤.");
											break;
										}	
										if (sUserName.equals(User[nReserve])) {
											System.out.printf("%dë²? ?˜¸?‹¤(%2d) : (?˜ˆ?•½ë²ˆí˜¸:%d) %s?‹˜ ?˜ˆ?•½ì·¨ì†Œ ?™„ë£? %n%n",roomNo[nReserve],nReserve,code[nReserve],  User[nReserve] );
//											System.out.printf("%2dë²? ?˜¸?‹¤ : %s?‹˜ ?˜ˆ?•½ì·¨ì†Œ ?™„ë£? %n%n",nReserve, User[nReserve] );
											room[nReserve] = 0;
											code[nReserve] = -1;
										} else {
											System.out.println("?˜ˆ?•½?ë¶? ?„±?•¨?´ ?¼ì¹? ?•˜ì§? ?•Š?Šµ?‹ˆ?‹¤. ?˜ˆ?•½?„ ?™•?¸?•´ì£¼ì„¸?š”.\n\n");
										}
										break;
									case 2 : // ?˜ˆ?•½?ë²ˆí˜¸ ?™•?¸
										System.out.print("?˜ˆ?•½?ë¶? ?˜ˆ?•½ë²ˆí˜¸ë¥? ?…? ¥?•´ì£¼ì„¸?š”:");
										nCode = Integer.parseInt(scan.next());
										if (nCode == -2) {
											System.out.println("ì§„í–‰ì¤‘ì¸ ë©”ë‰´ë¥? ì¢…ë£Œ?•©?‹ˆ?‹¤.");
											break;
										}	
										
										if (nCode == code[nReserve]) {
											System.out.printf("%dë²? ?˜¸?‹¤(%2d) : (?˜ˆ?•½ë²ˆí˜¸:%d) %s?‹˜ ?˜ˆ?•½ì·¨ì†Œ ?™„ë£? %n%n",roomNo[nReserve], nReserve,code[nReserve],  User[nReserve] );
											room[nReserve] = 0;
											code[nReserve] = -1;
										} else {
											System.out.println("?˜ˆ?•½?ë¶? ?˜ˆ?•½ë²ˆí˜¸ê°? ?¼ì¹? ?•˜ì§? ?•Š?Šµ?‹ˆ?‹¤. ?˜ˆ?•½?„ ?™•?¸?•´ì£¼ì„¸?š”.\n\n");
										}
										break;
									default :
										System.out.println("ë©”ë‰´ë¥? ?˜ëª? ?ˆ„ë¥´ì…¨?Šµ?‹ˆ?‹¤.");
										nReserve = -1;
								}
								
							} else {
								System.out.println("?˜ˆ?•½?´ ?™•?¸ ?˜ì§? ?•Š?•˜?Šµ?‹ˆ?‹¤. ?˜ˆ?•½?„ ?™•?¸?•´ì£¼ì„¸?š”.\n\n");
								nReserve = -1;
							}
						} else {
							System.out.println("?—†?Š” ?˜¸?ˆ˜ ë²ˆí˜¸ ?…?‹ˆ?‹¤. \n");
							nReserve = -1;
						}
					}
					break;						
				case 3  :  //==================================?˜¸?‹¤ë³´ê¸° 3==========================//
					System.out.println("\n[?˜¸?‹¤ë³´ê¸°]");
					for (i=0;i<room.length;i++) {
						str = "";
						if (room[i] == 0) {
							str = String.format("%3dë²? ?˜¸?‹¤(%2d) : ?˜ˆ?•½ê°??Š¥?˜† " , roomNo[i],  i );
						} else if(room[i] == 1) {
							str = String.format("%3dë²? ?˜¸?‹¤(%2d) : ?˜ˆ?•½?¨:?˜… ?˜ˆ?•½? :%5s ?˜ˆ?•½ë²ˆí˜¸ :%5d",  roomNo[i],  i, User[i], code[i]);
						} else {
							
						}
						if (str !="") {
							System.out.println(str + ((i== room.length-1) ? "\n" : ""));
						}
					}
					break;
				case 99 : //==================================?”„ë¡œê·¸?¨ ì¢…ë£Œ 99==========================//
					System.out.println("\n[ì¢…ë£Œ]");
					System.out.println("?•ˆ?…•?ˆê°??„¸?š©");
					break;
				default : 
					System.out.println("ë©”ë‰´ë¥? ?˜ëª? ?ˆ„ë¥´ì…¨?Šµ?‹ˆ?‹¤.");
					break;
			}
			
			
		}
		scan.close();

	}
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
