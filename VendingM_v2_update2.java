package kr.co.checkpoint;

import java.util.Arrays;
import java.util.Scanner;

public class VendingM_v2_update2 {

	public static void main(String[] args) {
		// ���Ǳ� bye
		//1���� 2���� 3����

		
		final String PASSWORD = "JAVA9987";
		final int DRINGKCOUNT   = 7;

		Scanner scan   = new Scanner(System.in);
		//�޴�
		// �����ڸ�� �޴��� 100.������������ �� ��� �߰�
		String[] sMenu = {"�������", "��������̴�","�䷹Ÿ",
				         "���̽��Ƹ޸�ī��","���Ʈ������","�ڹ�Ĩ����Ǫġ��","�����", "98.����"  ,"99.�ܾ׹���"};
		
		//============================== 2�����迭 0���� ����,1���� ���
		final int PRICE = 0;
		final int STOCK = 1;
		
		int nMenu[][] = { {1500,1500,3000,3500,1500,3000,3500},
						  {2,2,1,0,2,1,0} };
//		�Ž����� �迭�����ϱ� - ���� 10��, ��õ�� 7�� õ�� ����� ���
		int changeM[] = {10,7,20,14,10};  // �Ž����� ��������

		// �޾Ƽ� ����� �ֵ�
		int nMoney = 0, nSelectmenu = 0, i = 0, nGetMoney = 0;
		int ntmp = 0,  nstockvalue = 0, npricevalue = 0, nTab = 0;
		String str = "", sMenuvalue = "", sTab = "";
		
		//���� ���� ����
		int nChangeMenu = 0  , nChangeMenuprice = 0, nChangestock = 0;
		String sChangeMenu = "";
		
		boolean bStockCheck = true, bCoinCheck = true;
		
		System.out.println("[�������Ǳ�]");
		nMoney = 0;
		


		while (nSelectmenu != 98) {
			
			//=============================================�޴� ===============//
			// �����üũ
			bStockCheck = false;
			for (i=0;i < nMenu[STOCK].length;i++)
			{
				if ((nMenu[STOCK][i] > 0)) {  // ��� �ϳ��� ������.
					bStockCheck= true;
					break; 
				}
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
			
			//=================================== �޴�

			
			for(i=0;i < nMenu[PRICE].length;i++) {
				str = "";
				nTab = 11-(int)(sMenu[i].length()*(float)1.3)*100/100;
				sTab = " ";
				for (int k=0;k<nTab;k++) {
					sTab += " ";
				}
				
				ntmp = nMenu[STOCK][i];
				str = String.format("%2d. %s%s%5d%6s",
						(i+1),sMenu[i],sTab,nMenu[PRICE][i],((ntmp > 0) ?"�Ǹ���":"ǰ��"));

				System.out.println(str);
			} 
			System.out.printf("98. ����%n");
			System.out.printf("99. �ܾ׹���%n");
		
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
			
			if ((nSelectmenu >= 1)&&(nSelectmenu <= 7)) {
				sMenuvalue  = sMenu[nSelectmenu-1];
				npricevalue = nMenu[PRICE][nSelectmenu-1]; 
				nstockvalue = nMenu[STOCK][nSelectmenu-1];
			} 
			
			//=============================================�޴��� ���� ���� ===============//
			switch (nSelectmenu) {
				case 1 : case 2 : case 3 : 
				case 4 : case 5 : case 6 : case 7 :
					System.out.printf("%n%s �޴� ����, �����ܾ�: %d��%n", sMenuvalue, nMoney);
					
					if (nMoney >= npricevalue) {
						if (nstockvalue > 0) {
							nMoney = nMoney - npricevalue;       //�ݾ� ���
							--nMenu[STOCK][nSelectmenu-1];		 //��� �ϳ� ��������.	
//							System.out.printf("%s�� ���Խ��ϴ�. �����ܾ�: %d��%n", sMenuvalue, nMoney);
							System.out.printf("%s�� ���Խ��ϴ�.%n", sMenuvalue, nMoney);
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
//					�޼ҵ� �����ϴ� �� ����.
//					System.out.println( Arrays.toString(changeM)); //
					Returnofchange(nMoney, changeM);
//					System.out.println( Arrays.toString(changeM)); //debug
					nMoney = 0;
					
					if (nSelectmenu == 98) {
						System.out.println("�ȳ��� �輼�� ������ ���� ���Ǳ⸦ ��Ĩ�ϴ�");
					}
					break;
				case 100 :
					//���� �޴� ����  �����ڸ��� �޴����� 100�� ������ ����.
					//������ ��� �޴� ���÷���.
					System.out.print("�����ڸ�� ����)) PASSWORD�� �Է��ϼ���:");
					str = scan.nextLine();
					
					if (!str.equals(PASSWORD)) {
						System.out.println("��й�ȣ�� ��ġ ���� �ʽ��ϴ�.");
						break;
					}
					
					System.out.println("\n@@�����ڸ�� : ���� �޴� �� ���@@");
					System.out.println(">�ʱ�ȭ������ ���ư��÷��� -1�� �Է����ּ���\n");

					
					
					for(i=0;i < nMenu[STOCK].length;i++) {
						str = "";
						nTab = 11-(int)(sMenu[i].length()*(float)1.3)*100/100;
						sTab = " ";
						for (int k=0;k<nTab;k++) {
							sTab += " ";
						}
						
						str = String.format("%2d. %s%s%5d ���:%s",
								(i+1),sMenu[i],sTab,nMenu[PRICE][i],nMenu[STOCK][i]);

						System.out.println(str);
					} 					
					
					
					System.out.println("\n���� �޴��� �����մϴ�");
					System.out.print("������ ���� �޴��� �����ϼ���:");
					nChangeMenu = Integer.parseInt(scan.nextLine());
					
					if (nChangeMenu == -1) {
						System.out.println("�޴������� �ߴ��ϰ� �ʱ�޴��� ���ư��ϴ�.");
						break;
					}
					
					if (!((nChangeMenu >= 1) &&((nChangeMenu <= 7)))) {
						System.out.println("���� �޴� ��ȣ�� ���������� ������ �ʾҽ��ϴ�. (1~7)������ ���� �Է����ּ���.");
						break;
					}
					
					System.out.print("\n ������ ������ �̸��� �Է����ּ���:");
					sChangeMenu = scan.nextLine();
					
					if (sChangeMenu.indexOf("-1") >= 0) {
						System.out.println("�޴������� �ߴ��ϰ� �ʱ�޴��� ���ư��ϴ�.");
						break;
					}
					if ((sChangeMenu.equals("")) ||
						(sChangeMenu.indexOf("����") >= 0 ) ||
						(sChangeMenu.indexOf("�ܾ׹���")>= 0)){
						System.out.println("������ �̸��� ���������� ������ �ʾҽ��ϴ�.");
						break;
					}
					System.out.print("\n ������ ������ ������ �Է����ּ���:");
					nChangeMenuprice = Integer.parseInt(scan.nextLine());
					if (nChangeMenuprice == -1) {
						System.out.println("�޴������� �ߴ��ϰ� �ʱ�޴��� ���ư��ϴ�.");
						break;
					}  
					
					if (nChangeMenuprice < 0) {
						System.out.println("������ ������ ������ ���������� ������ �ʾҽ��ϴ�.");
						break;
					}
					
					System.out.print(" ������ ������ ������ �Է����ּ���:");
					nChangestock = Integer.parseInt(scan.nextLine()); 
					if (nChangestock == -1) {
						System.out.println("�޴������� �ߴ��ϰ� �ʱ�޴��� ���ư��ϴ�.");
						break;
					}					
					if (nChangestock < 0) {
						System.out.println("������ ������ ����� ���������� ������ �ʾҽ��ϴ�.");
						break;
					}
					
					//���� ����� �޾� ó��
					if ((nChangeMenu >= 1)&&(nChangeMenu <= 7)) {
						sMenuvalue  = sMenu[nChangeMenu-1];
						nstockvalue = nMenu[STOCK][nChangeMenu-1];
					} 			
					
					System.out.printf("%s �� ���� ��� %d�� ��ȯ�ϰ� ���� �޴��� �����մϴ�.", 
							          sMenuvalue, nstockvalue);
					
					// ������ ��� �ش� ������ ����
					if ((nChangeMenu >= 1)&&(nChangeMenu <= 7)) {
						sMenu[nChangeMenu-1]= sChangeMenu;
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
	


	static int Returnofchange(int value, int[] coin) {
		String fStr = "";
		int nfCnt = 0, nLossMoney= 0, fi = 0;
		int nUnit = 0;
		
//		System.out.println("funtion:"+ Arrays.toString(coin));// debug
		
		if (value > 0) {
			//������ 10000 5000 1000 500 100��¥��������
			for (fi = 0; fi<5;fi++) {
				switch (fi) {
					case 0 :
						nUnit = 10000;
						break;
					case 1 :
						nUnit = 5000;
						break;
					case 2 :
						nUnit = 1000;
						break;
					case 3 :
						nUnit = 500;
						break;
					case 4 :
						nUnit = 100;
						break;
				}
				if (value >= nUnit) {
					nfCnt = (value/nUnit); 
					if (coin[fi] < 1) {
						//������ �����뿡 ���̾�����
						//�ƹ��͵�����
					} else {
						if ((coin[fi] * nUnit) >= (value/nUnit*nUnit)){
							//�����뿡 �ټ��ִ� ��ŭ ���� ������.
							coin[fi] -= (value/nUnit);  //���������� �ְ�
							fStr += String.format("%d�� %d��,", nUnit, (value/nUnit));
//							System.out.printf("%d�� %d��,",nUnit, (value/nUnit));
							value = value % nUnit;
						} else {
							value -= value - (coin[fi]*nUnit);  //������ �ټ��ִ� ��ŭ �ְ�
							coin[fi] = 0;
							//������ �ܵ����� �ѱ��.
						}
						
					}
				}
				
				
			}// end of for
			if (fStr.length()> 1) {
				fStr = fStr.substring(0,fStr.length()-2);
				System.out.printf(fStr);
			}
			System.out.printf("�� �����մϴ�.%n");
			if (value > 0) {
				System.out.printf("%d���Ž������� �����մϴ� %n �����ڿ��� �����ϼ��� %n ������: ������ 010-xxxx-xxxx%n",value);
			}
		}
		
		value = 0;
		return value;
		/*
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
		 */
	}// end of Returnofchange
}


