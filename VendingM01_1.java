package kr.co.checkpoint;

import java.util.Scanner;

public class VendingM01_1 {

	public static void main(String[] args) {
		// ���Ǳ� bye
		//1���� 2���� 3����
		//String[] menu  = {"1.�ݶ�","2.���̴�","3.Ŀ��","4.�ڸ����̵�","98.��ȯ","99.����"};
		//int[] price    = {1500,1500,3000,3500,0,0};
		//int[] stock    = {2,2,1,0,0,0};
		
		final int DRINGKCOUNT = 4;

		Scanner scan   = new Scanner(System.in);
		//�޴�
		String menu1 = "1.����Ǫġ��", menu2 = "2.�������", menu3 = "3.��������̴�",
			   menu4 = "4.�ڸ����̵�", menu5 = "98.����", menu6 = "99.�ܾ׹���";
		
		// �����ڸ�� �޴��� 100.������������ �� ��� �߰�
		// ����
		int price1 = 1500, price2 = 1500, price3 = 3000, price4 = 3500;
		// ���
		int stock1 = 2, stock2 =2, stock3 =1, stock4 =0;
		// �޾Ƽ� ����� �ֵ�
		int nMoney = 0, nSelectmenu = 0, i = 0, nGetMoney = 0;
		int ntmp = 0,  nstockvalue = 0, npricevalue = 0;
		String str = "", stmp = "", sMenuvalue = "";
		
		//���� ���� ����
		int nChangeMenu = 0  , nChangeMenuprice = 0, 
			nChangestock = 0 , nChangeMenustock = 0;
		String sChangeMenu = "";
		
		boolean bStockCheck = true;
		
		System.out.println("[�������Ǳ�]");
		nMoney = 0;

		while (nSelectmenu != 98) {
			
			//=============================================�޴� ===============//
			// �����üũ
			bStockCheck = false;
			if ((stock1 > 0) ||
				(stock2 > 0) ||
				(stock3 > 0) ||
				(stock4 > 0) ) {
				bStockCheck= true;
			}
			
			str = "";
			if (bStockCheck) {
				str = "~�Ǹ���~";
			} else {
				str = "~��� ���� �Ǹ�����~";
			}
			
			if (nMoney > 0) {
				str += " �ܾ�:" + Integer.toString(nMoney); 
			}
			System.out.println(str);
			
			//�޴�
			System.out.printf(" %s   %s   %s   %s   %s   %s   %n",menu1, menu2, menu3,menu4, menu5, menu6);
			//����
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
					str += " �Ǹ���" + "       ";
				} else {
					str += " ǰ�� " + "       ";
				}
			}
			System.out.println(str);
			System.out.println();
			
			//=============================================���� & �޴� ���� ===============//
			System.out.print("������ �־��ּ��� :");
			nGetMoney = scan.nextInt();
			if (nGetMoney < 0) {
				System.out.println("Err. 0���� ū���� �Է����ּ���.");
				continue;
			
			} else {
				nMoney += nGetMoney; 
			}
			
			System.out.print("�޴��� �������ּ��� :");
			nSelectmenu = 0;
			nSelectmenu = scan.nextInt();
			if (nSelectmenu < 0) {
				System.out.println("Err. 0���� ū���� �Է����ּ���.");
				continue;
			}
			
			//========================= ����� �޴��� ���� �� �ޱ�
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
			
			//=============================================�޴��� ���� ���� ===============//
			switch (nSelectmenu) {
				case 1 : case 2 : case 3 : case 4 :
					System.out.printf("%n%s �޴� ����, �ܾ�: %d��%n", stmp, nMoney);
					
					if (nMoney >= npricevalue) {
						if (nstockvalue > 0) {
							nMoney = nMoney - npricevalue; 
							System.out.printf("%s �� ���Խ��ϴ�. %n", sMenuvalue);
							
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
							System.out.printf(" ��� �����մϴ�%n");
						}
					} else {
						System.out.println(" �ܾ��� �����մϴ�.");
					}

					break;
				case 98 :
					//���α׷� ����.
//					if (nMoney > 0) {
//						System.out.printf("�ܾ��� ��ȯ�մϴ� : %d%n", nMoney);
//					}
//					break;
				case 99 :
					System.out.printf("�ܾ� ���� : %d��%n", nMoney);
					//�ܾ� ���� �� ���� ������ ���� �˷���.
					if (nMoney > 0) {
						if (nMoney >= 10000) {
							System.out.printf("10000�� %d��,", (nMoney/10000));
							nMoney = nMoney % 10000;
						} 
						if (nMoney >= 1000) {
							System.out.printf("1000�� %d��,", (nMoney/1000));
							nMoney = nMoney % 1000;
						} 
						if (nMoney >= 500) {
							System.out.printf("500�� %d��,", (nMoney/500));
							nMoney = nMoney % 500;
						} 
						if (nMoney >= 100) {
							System.out.printf("100�� %d��,", (nMoney/100));
							nMoney = nMoney % 100;
						} 
						if (nMoney >= 10) {
							System.out.printf("10�� %d��,", (nMoney/10));
							nMoney = nMoney % 10;
						} 
						if (nMoney > 0) {
							System.out.printf("%d�� ", (nMoney));
						}
						System.out.printf("�� �����մϴ�.%n");
					}
					
					nMoney = 0;
					
					if (nSelectmenu == 98) {
						System.out.println("�ȳ��� �輼�� ������ ���� ���Ǳ⸦ ��Ĩ�ϴ�");
					}
					break;
				case 100 :
					//���� �޴� ����
					System.out.println("\n@@�����ڸ�� : ���� �޴� �� ���@@");
					System.out.printf(" %s(���:%d)   %s(���:%d)   %s(���:%d)   %s(���:%d)    %n"
							,menu1,stock1, menu2,stock2, menu3,stock3,menu4,stock4);
					
					System.out.println("\n ���� �޴��� �����մϴ�. ������ ���� �޴��� �����ϼ���.");
					System.out.print("< �ʱ� �޴��� ���ư����� -1�� �Է��ϼ���:");
					nChangeMenu = scan.nextInt();
					
					if (nChangeMenu == -1) {
						System.out.println("�޴������� �ߴ��ϰ� �ʱ�޴��� ���ư��ϴ�.");
						break;
					}
					
					if (!((nChangeMenu >= 1) &&((nChangeMenu <= 4)))) {
						System.out.println("���� �޴� ��ȣ�� ���������� ������ �ʾҽ��ϴ�. (1~4)������ ���� �Է����ּ���.");
						break;
					}
					
					System.out.println("\n ������ ������ �̸��� �Է����ּ���:");
					System.out.print("< �ʱ� �޴��� ���ư����� -1�� �Է��ϼ���:");
					sChangeMenu = scan.next();
					if (sChangeMenu.indexOf("-1") >= 0) {
						System.out.println("�޴������� �ߴ��ϰ� �ʱ�޴��� ���ư��ϴ�.");
						break;
					}
					
					if ((sChangeMenu == "") &&
						(sChangeMenu == menu5) &&
						(sChangeMenu == menu6)){
						System.out.println("������ �̸��� ���������� ������ �ʾҽ��ϴ�.");
						break;
					}
					System.out.print("\n������ ������ ������ �Է����ּ���:");
					nChangeMenuprice = scan.nextInt();
					if (nChangeMenuprice == -1) {
						System.out.println("�޴������� �ߴ��ϰ� �ʱ�޴��� ���ư��ϴ�.");
						break;
					}  
					
					if (nChangeMenuprice < 0) {
						System.out.println("������ ������ ������ ���������� ������ �ʾҽ��ϴ�.");
						break;
					}
					
					System.out.print("������ ������ ������ �Է����ּ���:");
					nChangestock = scan.nextInt(); 
					if (nChangestock == -1) {
						System.out.println("�޴������� �ߴ��ϰ� �ʱ�޴��� ���ư��ϴ�.");
						break;
					}					
					if (nChangestock < 0) {
						System.out.println("������ ������ ����� ���������� ������ �ʾҽ��ϴ�.");
						break;
					}
					
					//���� ����� �޾� ó��
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
					
					System.out.printf("%s �� ���� ��� %d�� ��ȯ�ϰ� ���� �޴��� �����մϴ�.", 
							          sMenuvalue, nstockvalue);
					
					// ������ ��� �ش� ������ ����
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
