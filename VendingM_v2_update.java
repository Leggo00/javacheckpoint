package kr.co.checkpoint;

import java.util.Scanner;

public class VendingM_v2_update {

	public static void main(String[] args) {
		// ���Ǳ� bye
		//1���� 2���� 3����

		
		final int DRINGKCOUNT   = 4;

		Scanner scan   = new Scanner(System.in);
		//�޴�
		// �����ڸ�� �޴��� 100.������������ �� ��� �߰�
		String[] sMenu = {"����Ǫġ��", "�������","��������̴�",
				         "�ڸ����̵�", "98.����"  ,"99.�ܾ׹���"};
		
		//============================== 2�����迭 0���� ����,1���� ���
		final int PRICE = 0;
		final int STOCK = 1;
		
		int nMenu[][] = { {1500,1500,3000,3500},
						  {2,2,1,0} };
//		�Ž����� �迭�����ϱ� - ���� 10��, ��õ�� 7�� õ�� ����� ���
		int changeM[] = {10,7,20,14,10};  // �Ž����� ��������

		// �޾Ƽ� ����� �ֵ�
		int nMoney = 0, nSelectmenu = 0, i = 0, nGetMoney = 0;
		int ntmp = 0,  nstockvalue = 0, npricevalue = 0;
		String str = "", sMenuvalue = "";
		
		//���� ���� ����
		int nChangeMenu = 0  , nChangeMenuprice = 0, nChangestock = 0;
		String sChangeMenu = "";
		
		boolean bStockCheck = true;
		
		System.out.println("[�������Ǳ�]");
		nMoney = 0;

		while (nSelectmenu != 98) {
			
			//=============================================�޴� ===============//
			// �����üũ
			bStockCheck = false;
			if ((nMenu[STOCK][0] > 0) ||
				(nMenu[STOCK][1] > 0) ||
				(nMenu[STOCK][2] > 0) ||
				(nMenu[STOCK][3] > 0) ) {
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
			
			//=================================== �޴��̸�
			str = " ";
			for (i=0;i< sMenu.length ;i++) {
				str += sMenu[i] + "   ";
			}
			System.out.printf("%s%n",str);
			//����
			//=================================== �޴��� ����
			
			
			for(i=0;i < nMenu[PRICE].length;i++) {
				str = "";
				str = String.format("%2d.%s",(i+1),sMenu[i]);
				if (str.length() < 11) {
					for (int j=0; j<11 - str.length();j++) {
						str += " ";
					}
				}
				str += String.format(":%6d",nMenu[PRICE][i]);
				if (str.length() < 25) {
					for (int j=0; j<25 - str.length();j++) {
						str += " ";
					}
				} 
				str += String.format("%s",((ntmp > 0) ?"�Ǹ���":"ǰ��") );
				System.out.println(str);
				//System.out.printf("%d.%s(%d��)    %s%n",, , nMenu[PRICE][i], ((ntmp > 0) ?"�Ǹ���":"ǰ��") );
			} 
			System.out.printf(sMenu[4]+"%n");
			System.out.printf(sMenu[5]+"%n");
			
			str = " ";
			for(i=0;i < nMenu[PRICE].length;i++) {
				str +=  nMenu[PRICE][i] +"        ";
			} 
			System.out.printf("%s   %n", str);
			
			//=================================== ����� ���� ����ǥ��
			str = "";
			for (i=1; i<= DRINGKCOUNT;i++) {
				ntmp = nMenu[STOCK][i-1];

				if (ntmp > 0) {
					str += " �Ǹ���" + "       ";
				} else {
					str += " ǰ�� " + "       ";
				}
			}
			System.out.println(str);
			System.out.println();
			
			//=============================================���� & �޴� ���� ===============//
			System.out.print("�޴��� �������ּ��� :");
			nSelectmenu = 0;
			nSelectmenu = Integer.parseInt(scan.nextLine());
			if (nSelectmenu < 0) {
				System.out.println("Err. 0���� ū���� �Է����ּ���.");
				continue;
			}
			
			if ((nSelectmenu >= 1)&&(nSelectmenu <= DRINGKCOUNT)) {
				System.out.print("������ �־��ּ��� :");
				nGetMoney = Integer.parseInt(scan.nextLine());
				if (nGetMoney < 0) {
					System.out.println("Err. 0���� ū���� �Է����ּ���.");
					continue;
					
				} else {
					nMoney += nGetMoney; 
				}
			}
			
			//========================= ����� �޴��� ���� �� �ޱ�
			sMenuvalue  = " ";
			npricevalue = 0;
			nstockvalue = 0;
			
			if ((nSelectmenu >= 1)&&(nSelectmenu <= 4)) {
				sMenuvalue  = sMenu[nSelectmenu-1];
				npricevalue = nMenu[PRICE][nSelectmenu-1]; 
				nstockvalue = nMenu[STOCK][nSelectmenu-1];
			} 
			
			//=============================================�޴��� ���� ���� ===============//
			switch (nSelectmenu) {
				case 1 : case 2 : case 3 : case 4 :
					System.out.printf("%n%s �޴� ����, �����ܾ�: %d��%n", sMenuvalue, nMoney);
					
					if (nMoney >= npricevalue) {
						if (nstockvalue > 0) {
							nMoney = nMoney - npricevalue;       //�ݾ� ���
							--nMenu[STOCK][nSelectmenu-1];		 //����� �ϳ� ��������.	
							System.out.printf("%s �� ���Խ��ϴ�. �����ܾ�: %d��%n", sMenuvalue, nMoney);
						} else {
							System.out.printf(" ����� �����մϴ�%n");
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
//					�޼ҵ� �����ϴ� �� ����.
					Returnofchange(nMoney);
					nMoney = 0;
					
					if (nSelectmenu == 98) {
						System.out.println("�ȳ��� �輼�� ������ ���� ���Ǳ⸦ ��Ĩ�ϴ�");
					}
					break;
				case 100 :
					//���� �޴� ����  �����ڸ��� �޴����� 100�� ������ ����.
					//������ ��� �޴� ���÷���.
					System.out.println("\n@@�����ڸ�� : ���� �޴� �� ���@@");
					str = " ";
					for(i=0;i<nMenu[STOCK].length;i++) {
						str += sMenu[i] + "(���:" + nMenu[STOCK][i] + ")   ";
					}
					
					System.out.printf("%s%n", str);
					
					System.out.println("\n ���� �޴��� �����մϴ�. ������ ���� �޴��� �����ϼ���.");
					System.out.print("< �ʱ� �޴��� ���ư����� -1�� �Է��ϼ���:");
					nChangeMenu = Integer.parseInt(scan.nextLine());
					
					if (nChangeMenu == -1) {
						System.out.println("�޴������� �ߴ��ϰ� �ʱ�޴��� ���ư��ϴ�.");
						break;
					}
					
					if (!((nChangeMenu >= 1) &&((nChangeMenu <= 4)))) {
						System.out.println("���� �޴� ��ȣ�� ���������� ������ �ʾҽ��ϴ�. (1~4)������ ���� �Է����ּ���.");
						break;
					}
					
					System.out.println("\n ������ ������ �̸��� �Է����ּ���");
					System.out.print("< �ʱ� �޴��� ���ư����� -1�� �Է��ϼ���:");
					sChangeMenu = scan.nextLine();
					
					if (sChangeMenu.indexOf("-1") >= 0) {
						System.out.println("�޴������� �ߴ��ϰ� �ʱ�޴��� ���ư��ϴ�.");
						break;
					}
					
					if ((sChangeMenu.equals("")) ||
						(sChangeMenu.equals(sMenu[4]) ) ||
						(sChangeMenu.equals(sMenu[5]))){
						System.out.println("������ �̸��� ���������� ������ �ʾҽ��ϴ�.");
						break;
					}
					System.out.print("\n������ ������ ������ �Է����ּ���:");
					nChangeMenuprice = Integer.parseInt(scan.nextLine());
					if (nChangeMenuprice == -1) {
						System.out.println("�޴������� �ߴ��ϰ� �ʱ�޴��� ���ư��ϴ�.");
						break;
					}  
					
					if (nChangeMenuprice < 0) {
						System.out.println("������ ������ ������ ���������� ������ �ʾҽ��ϴ�.");
						break;
					}
					
					System.out.print("������ ������ ������� �Է����ּ���:");
					nChangestock = Integer.parseInt(scan.nextLine()); 
					if (nChangestock == -1) {
						System.out.println("�޴������� �ߴ��ϰ� �ʱ�޴��� ���ư��ϴ�.");
						break;
					}					
					if (nChangestock < 0) {
						System.out.println("������ ������ ������� ���������� ������ �ʾҽ��ϴ�.");
						break;
					}
					
					//���� ������� �޾� ó��
					if ((nChangeMenu >= 1)&&(nChangeMenu <= 4)) {
						sMenuvalue  = sMenu[nChangeMenu-1];
						nstockvalue = nMenu[STOCK][nChangeMenu-1];
					} 			
					
					System.out.printf("%s �� ���� ����� %d�� ��ȯ�ϰ� ���� �޴��� �����մϴ�.", 
							          sMenuvalue, nstockvalue);
					
					// ������ ����� �ش� ������ ����
					if ((nChangeMenu >= 1)&&(nChangeMenu <= 4)) {
						sMenu[nChangeMenu-1]= Integer.toString(nChangeMenu) 
								              + "."
								              + sChangeMenu;
						nMenu[PRICE][nChangeMenu-1] = nChangeMenuprice;
						nMenu[STOCK][nChangeMenu-1] = nChangestock;
						
					} 					
					break;   
				default : 
					break;
			
			}//end of switch	
	
			System.out.println();
		} //end of while
		
		scan.close();

	}
	
	static int Returnofchange(int value ) {
		if (value > 0) {
			if (value >= 10000) {
				System.out.printf("10000�� %d��,", (value/10000));
				value = value % 10000;
			} 
			if (value >= 1000) {
				System.out.printf("1000�� %d��,", (value/1000));
				value = value % 1000;
			} 
			if (value >= 500) {
				System.out.printf("500�� %d��,", (value/500));
				value = value % 500;
			} 
			if (value >= 100) {
				System.out.printf("100�� %d��,", (value/100));
				value = value % 100;
			} 
			if (value >= 10) {
				System.out.printf("10�� %d��,", (value/10));
				value = value % 10;
			} 
			if (value > 0) {
				System.out.printf("%d�� ", (value));
			}
			System.out.printf("�� �����մϴ�.%n");
		}	
		return 0;
	}
}

