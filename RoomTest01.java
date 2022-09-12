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
		
		
		//?˜ˆ?•½ê°??Š¥ ?ƒ?ƒœë¡? ?‘ 
		for (i=0;i < room.length; i++) {
			room[i] = 0;
			User[i] = "";
			code[i] = -1;
		}
		
		
		while(nSelectMenu != 99) {
			System.out.println("[ë©”ë‰´]");
			System.out.println("1. ?˜ˆ?•½?•˜ê¸?   2. ?˜ˆ?•½ì·¨ì†Œ   3. ?˜¸?‹¤ë³´ê¸°   99.ì¢…ë£Œ");
			System.out.print("select :");
			
			nSelectMenu = Integer.parseInt(scan.next());
			
			switch(nSelectMenu) {
				case 1  : //==================================?˜ˆ?•½?•˜ê¸? 1==========================//
						nReserve = -1;
						System.out.println("\n[?˜ˆ?•½?•˜ê¸?]");
						while (!(0 <= nReserve)&&(nReserve <= 11)) {  // ? •?ƒ? ?œ¼ë¡? ?˜ˆ?•½ ë²ˆí˜¸ë¥? ë°›ìœ¼ë©? ?‹œ???Š¤ê°? ??‚¨.
							System.out.print("?˜ˆ?•½?„ ?›?•˜?‹œ?Š” ?˜¸?‹¤ ë²ˆí˜¸ë¥? ?ˆŒ?Ÿ¬ì£¼ì„¸?š”:");
							nReserve = Integer.parseInt(scan.next());
							if ((0 <= nReserve)&&(nReserve <= 11)) {  // ? œ??ë¡? ?…? ¥?–‡?œ¼ë©?
								if (room[nReserve] == 0) {
									
									System.out.printf("%2dë²? ?˜¸?‹¤: ?˜ˆ?•½ê°??Š¥ %n",nReserve);
									System.out.print("?˜ˆ?•½?ë¶? ?„±?•¨?„ ?…? ¥?•´ì£¼ì„¸?š”:");
									
									sUserName = scan.next();
									User[nReserve] = sUserName;
									
									nCode  = -1;
									//?˜ˆ?•½? ë²ˆí˜¸ë¥? ?œ?¤?œ¼ë¡? ?ƒ?„±, ê¸°ì¡´?— ë²ˆí˜¸?? ì¤‘ë³µ?¬?Š”ì§? ?™•?¸?›„ ë°œí–‰
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
									
									System.out.printf("%2dë²? ?˜¸?‹¤ %s ?‹˜ : ?˜ˆ?•½?¨:?˜… ?˜ˆ?•½ë²ˆí˜¸:%d%n%n",nReserve, User[nReserve], code[nReserve]);
									room[nReserve] = 1;
								} else {                               
									System.out.printf("%2dë²? ?˜¸?‹¤?? ?´ë¯? ?˜ˆ?•½?œ ë°©ì…?‹ˆ?‹¤, ?˜ˆ?•½?´ ë¶ˆê??Š¥ ?•©?‹ˆ?‹¤.%n%n",nReserve);
									//nReserve = -1;
								}
								
							} else {                                     //  ?˜ëª? ?…? ¥?–ˆ?œ¼ë©?
								System.out.println("0?˜¸ ë¶??„° 11?˜¸ ?‚¬?´ ?˜ ?ˆ«?ë¥? ?ˆŒ?Ÿ¬ì£¼ì„¸?š”. \n");
							}
						}
						break;
				case 2  : //==================================?˜ˆ?•½ì·¨ì†Œ 2==========================//
					nReserve = -1;
					System.out.println("\n[?˜ˆ?•½ì·¨ì†Œ]");
					while (!(0 <= nReserve)&&(nReserve <= 11)) {     // ? •?ƒ? ?œ¼ë¡? ?˜ˆ?•½ì·¨ì†Œê°? ??‚˜ë©? ?‹œ???Š¤ ì¢…ë£Œ.
						System.out.print("?˜ˆ?•½ì·¨ì†Œë¥? ?›?•˜?‹œ?Š” ?˜¸?‹¤ ë²ˆí˜¸ë¥? ?ˆŒ?Ÿ¬ì£¼ì„¸?š”:");
						nReserve = Integer.parseInt(scan.next());
						if ((0 <= nReserve)&&(nReserve <= 11)) {     // ? œ??ë¡? ?…? ¥?–ˆ?œ¼ë©?
							if (room[nReserve] == 1) {
								System.out.print("?˜ˆ?•½?„ ?™•?¸ ?•©?‹ˆ?‹¤, ë©”ë‰´ë¥? ?„ ?ƒ?•´ì£¼ì„¸?š”. (1: ?„±?•¨?™•?¸),(2:?˜ˆ?•½ë²ˆí˜¸?™•?¸):");
								nSubMenu = Integer.parseInt(scan.next());
								
								switch(nSubMenu) {
									case 1 : // ?„±?•¨
										System.out.print("?˜ˆ?•½?ë¶? ?„±?•¨?„ ?…? ¥?•´ì£¼ì„¸?š”:");
										sUserName = scan.next();
										if (sUserName.equals(User[nReserve])) {
											System.out.printf("%2dë²? ?˜¸?‹¤ : (?˜ˆ?•½ë²ˆí˜¸:%d) %s?‹˜ ?˜ˆ?•½ì·¨ì†Œ ?™„ë£? %n%n",nReserve,code[nReserve],  User[nReserve] );
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
										if (nCode == code[nReserve]) {
											System.out.printf("%2dë²? ?˜¸?‹¤ : (?˜ˆ?•½ë²ˆí˜¸:%d) %s?‹˜ ?˜ˆ?•½ì·¨ì†Œ ?™„ë£? %n%n",nReserve,code[nReserve],  User[nReserve] );
											room[nReserve] = 0;
											code[nReserve] = -1;
										} else {
											System.out.println("?˜ˆ?•½?ë¶? ?˜ˆ?•½ë²ˆí˜¸ê°? ?¼ì¹? ?•˜ì§? ?•Š?Šµ?‹ˆ?‹¤. ?˜ˆ?•½?„ ?™•?¸?•´ì£¼ì„¸?š”.\n\n");
										}
										break;
									default :
										System.out.println("ë©”ë‰´ë¥? ?˜ëª? ?ˆ„ë¥´ì…¨?Šµ?‹ˆ?‹¤.");
								}
								
							} else {
								System.out.println("?˜ˆ?•½?´ ?™•?¸ ?˜ì§? ?•Š?•˜?Šµ?‹ˆ?‹¤. ?˜ˆ?•½?„ ?™•?¸?•´ì£¼ì„¸?š”.\n\n");
								//nReserve = -1;
							}
						} else {
							System.out.println("0?˜¸ ë¶??„° 11?˜¸ ?‚¬?´ ?˜ ?ˆ«?ë¥? ?ˆŒ?Ÿ¬ì£¼ì„¸?š”. \n");
						}
					}
					break;						
				case 3  :  //==================================?˜¸?‹¤ë³´ê¸° 3==========================//
					System.out.println("\n[?˜¸?‹¤ë³´ê¸°]");
					for (i=0;i<room.length;i++) {
						str = "";
						if (room[i] == 0) {
							str = String.format("%2dë²? ?˜¸?‹¤ : ?˜ˆ?•½ê°??Š¥?˜† ", i);
						} else if(room[i] == 1) {
							str = String.format("%2dë²? ?˜¸?‹¤ : ?˜ˆ?•½?¨:?˜… ?˜ˆ?•½? :%s ?˜ˆ?•½ë²ˆí˜¸ :%d", i, User[i], code[i]);
						} else {
							
						}
						if (str !="") {
							System.out.println(str + ((i== room.length-1) ? "\n" : ""));
						}
					}
					break;
				case 99 : //==================================?”„ë¡œê·¸?¨ ì¢…ë£Œ 99==========================//
					System.out.println("\n[ì¢…ë£Œ]");
					System.out.println("?”„ë¡œê·¸?¨ ì¢…ë£Œ");
					break;
				default : 
					System.out.println("ë©”ë‰´ë¥? ?˜ëª? ?ˆ„ë¥´ì…¨?Šµ?‹ˆ?‹¤.");
					break;
			}
			
			
		}
		scan.close();

	}

}
