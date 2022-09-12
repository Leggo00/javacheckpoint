package kr.co.checkpoint;

import java.util.Arrays;
import java.util.Scanner;

public class VendingM_v3 {

	static String[] sMenu = {"�������", "��������̴�","�䷹Ÿ",
			"���̽��Ƹ޸�ī��","���Ʈ������","�ڹ�Ĩ����Ǫġ��","�����", 
			"98.����"  ,"99.�ܾ׹���"};
	
	static	final int PRICE = 0;
	static	final int STOCK = 1;
	
	static	int nMenu[][] = { {1500,1500,3000,3500,1500,3000,3500},
			{2,2,1,0,2,1,0} };
	static int changeM[] = {10,7,20,14,10};  // �Ž����� ��������
	
	static final String PASSWORD = "JAVA9987";
	static final int DRINGKCOUNT   = 7;
	static Scanner scan   = new Scanner(System.in);

	static int nSelectmenu = 0;

	public static void main(String[] args) {
		// �޾Ƽ� ����� �ֵ�
		int nMoney = 0;
		
		nMoney = init(nMoney);

		while (nSelectmenu != 98) {
			ViewMenu(1, nMoney);
			nMoney = SelectMenu(nMoney);
			nMoney = VendingRun(nMoney);
			System.out.println();
		} 
		
		scan.close();
	}
	
	
	private static int init(int aMoney) {
		System.out.println("[�������Ǳ�]");
		aMoney = 0;
		return aMoney;
	}

	private static int SelectMenu(int aMoney) {
		int nGetMoney= 0;
		
		System.out.print("�޴��� �������ּ��� :");
		nSelectmenu = 0;
		nSelectmenu = Integer.parseInt(scan.nextLine());
		if (nSelectmenu < 0) {
			System.out.println("Err. 0���� ū���� �Է����ּ���.");
			return aMoney;
		}
		if (Arrays.stream(nMenu[PRICE]).max().getAsInt() <= aMoney) {
			//�������ִ� �ܾ���, ���� �޴��� ���� ��� ���Ẹ�� ���� �� ������ 
			// ������ �־�޶�� ���� �ʴ´�.
		} else {
			if ((nSelectmenu >= 1)&&(nSelectmenu <= DRINGKCOUNT)) {
				System.out.print("������ �־��ּ��� :");
				nGetMoney = Integer.parseInt(scan.nextLine());
				if (nGetMoney < 0) {
					System.out.println("Err. 0���� ū���� �Է����ּ���.");
					return aMoney;
					
				} else {
					aMoney += nGetMoney; 
				}
			}
		}
		
		return aMoney;
	}

	private static int VendingRun(int aMoney) {
		// ����޴�
		String sMenuvalue = " ";
		int npricevalue = 0, nstockvalue = 0;
		// 100��
		String str = ""; 

		sMenuvalue  = " ";
		npricevalue = 0;
		nstockvalue = 0;
		
		if ((nSelectmenu >= 1)&&(nSelectmenu <= DRINGKCOUNT)) {
			sMenuvalue  = sMenu[nSelectmenu-1];
			npricevalue = nMenu[PRICE][nSelectmenu-1]; 
			nstockvalue = nMenu[STOCK][nSelectmenu-1];
		} 
		
		switch (nSelectmenu) {
			case 1 : case 2 : case 3 : 
			case 4 : case 5 : case 6 : case 7 :
				aMoney = drinkService(sMenuvalue, aMoney,npricevalue,nstockvalue);
				return aMoney;
			case 98 :
				//���α׷� ����.  99�� ���� �ܾ� ���� �ϰ� ����.
			case 99 :
				System.out.printf("�ܾ� ���� : %d��%n", aMoney);
				aMoney = Returnofchange(aMoney, changeM);
				
				if (nSelectmenu == 98) {
					System.out.println("�ȳ��� �輼�� ������ ���� ���Ǳ⸦ ��Ĩ�ϴ�");
				}
				return aMoney;
			case 100 :
				//���� �޴� ����  �����ڸ��� �޴����� 100�� ������ ����.
				
				if (! AdminCheck()) {  // �н����� Ȯ��
					return aMoney;
				}
				ViewMenu(2,-9999);     // �����ڸ�� ���÷���
				AdiminRUN();           // ���ắ��� ��� 
				return aMoney;
			default: 
				return aMoney;
		}
	}//end of VendingRun

	private static void AdiminRUN() {
		int nChangeMenu = 0  , nChangeMenuprice = 0, nChangestock = 0;
		String sChangeMenu = "";		
		String sMenuvalue = " ";
		int nstockvalue = 0;

		
		//========================= ������ ���� ����
		System.out.println("\n���� �޴��� �����մϴ�");
		System.out.print("������ ���� �޴��� �����ϼ���:");
		nChangeMenu = Integer.parseInt(scan.nextLine());
		
		if (nChangeMenu == -1) {
			System.out.println("�޴������� �ߴ��ϰ� �ʱ�޴��� ���ư��ϴ�.");
			return;
		}
		
		if (!((nChangeMenu >= 1) &&((nChangeMenu <= DRINGKCOUNT)))) {
			System.out.println("���� �޴� ��ȣ�� ���������� ������ �ʾҽ��ϴ�. (1~7)������ ���� �Է����ּ���.");
			return;
		}
		
		//========================= ����� ����
		System.out.print("\n ������ ������ �̸��� �Է����ּ���:");
		sChangeMenu = scan.nextLine();
		
		if (sChangeMenu.indexOf("-1") >= 0) {
			System.out.println("�޴������� �ߴ��ϰ� �ʱ�޴��� ���ư��ϴ�.");
			return;
		}
		if ((sChangeMenu.equals("")) ||
			(sChangeMenu.indexOf("����") >= 0 ) ||
			(sChangeMenu.indexOf("�ܾ׹���")>= 0)){
			System.out.println("������ �̸��� ���������� ������ �ʾҽ��ϴ�.");
			return;
		}
		//========================= ���� ���� ����
		System.out.print("\n ������ ������ ������ �Է����ּ���:");
		nChangeMenuprice = Integer.parseInt(scan.nextLine());
		if (nChangeMenuprice == -1) {
			System.out.println("�޴������� �ߴ��ϰ� �ʱ�޴��� ���ư��ϴ�.");
			return;
		}  
		
		if (nChangeMenuprice < 0) {
			System.out.println("������ ������ ������ ���������� ������ �ʾҽ��ϴ�.");
			return;
		}
		
		//========================= ���� ���� ����
		System.out.print(" ������ ������ ������ �Է����ּ���:");
		nChangestock = Integer.parseInt(scan.nextLine()); 
		if (nChangestock == -1) {
			System.out.println("�޴������� �ߴ��ϰ� �ʱ�޴��� ���ư��ϴ�.");
			return;
		}					
		if (nChangestock < 0) {
			System.out.println("������ ������ ����� ���������� ������ �ʾҽ��ϴ�.");
			return;
		}
		
		//���� ����� �޾� ó��
		if ((nChangeMenu >= 1)&&(nChangeMenu <= DRINGKCOUNT)) {
			sMenuvalue  = sMenu[nChangeMenu-1];
			nstockvalue = nMenu[STOCK][nChangeMenu-1];
		} 			
		
		System.out.printf("%s �� ���� ��� %d�� ��ȯ�ϰ� ���� �޴��� �����մϴ�.", 
				          sMenuvalue, nstockvalue);
		
		// ������ ��� �ش� ������ ����
		if ((nChangeMenu >= 1)&&(nChangeMenu <= DRINGKCOUNT)) {
			sMenu[nChangeMenu-1]= sChangeMenu;
			nMenu[PRICE][nChangeMenu-1] = nChangeMenuprice;
			nMenu[STOCK][nChangeMenu-1] = nChangestock;
		} 	
		
	}//end of AdiminRUN


	private static int drinkService(String asMenuvalue, int bMoney, int anpricevalue, int anstockvalue) {
		System.out.printf("%n%s �޴� ����, �����ܾ�: %d��%n", asMenuvalue, bMoney);
		
		if (bMoney >= anpricevalue) {
			if (anstockvalue > 0) {
				bMoney = bMoney - anpricevalue;       //�ݾ� ���
				--nMenu[STOCK][nSelectmenu-1];		 //��� �ϳ� ��������.	
				System.out.printf("%s�� ���Խ��ϴ�.%n", asMenuvalue, bMoney);
			} else {
				System.out.printf(" ��� �����մϴ�%n");
			}
		} else {
			System.out.println(" �ܾ��� �����մϴ�.");
		}
		return bMoney;
	}//end of drinkService

	private static boolean AdminCheck() {
		boolean result = true;
		String str = " ";

		System.out.print("�����ڸ�� ����)) PASSWORD�� �Է��ϼ���:");
		str = scan.nextLine();
		
		if (!str.equals(PASSWORD)) {
			System.out.println("��й�ȣ�� ��ġ ���� �ʽ��ϴ�.");
			result = false;
		}
		return result;
	}//end of AdminCheck

	static void ViewMenu(int nMode, int fMoney) {	
		String str = "", sTab = "";
		int ntmp = 0, nTab = 0;
		boolean bStockCheck = false;
		//mode 1 �̸� ���θ޴�,  mode 2 �̸� �����ڸ��
		switch(nMode) {
			case 1 :
				for (int i=0;i < nMenu[STOCK].length;i++)
				{
					if ((nMenu[STOCK][i] > 0)) {  // ��� �ϳ��� ������.
						bStockCheck= true;
						break; 
					}
				}
				//============ ����� Ȯ��
				str = "";
				if (bStockCheck) {
					str = "~�Ǹ���~";
				} else {
					str = "~��� ���� �Ǹ�����~";
				}
				
				if (fMoney > 0) {
					str += " �ܾ�:" + Integer.toString(fMoney); 
				}
				System.out.println(str);
				break;
			case 2 : 
				System.out.println("\n@@�����ڸ�� : ���� �޴� �� ���@@");
				System.out.println(">�ʱ�ȭ������ ���ư��÷��� -1�� �Է����ּ���\n");
				break;
			default : 
				break;
		} 
		
		// -----------------�޴� ���÷��� �翩���� ����
		for(int i=0;i < nMenu[PRICE].length;i++) {
			str = "";
			nTab = 11-(int)(sMenu[i].length()*1.3f)*100/100;
			sTab = " ";
			for (int k=0;k<nTab;k++) {
				sTab += " ";
			}
			
			ntmp = nMenu[STOCK][i];
			switch(nMode) {
				case 1 :
					str = String.format("%2d. %s%s%5d%6s",
							(i+1),sMenu[i],sTab,nMenu[PRICE][i],((ntmp > 0) ?"�Ǹ���":"ǰ��"));
					break;
				case 2 :
					str = String.format("%2d. %s%s%5d ���:%s",
							(i+1),sMenu[i],sTab,nMenu[PRICE][i],nMenu[STOCK][i]);
					break;
			}

			System.out.println(str);
		} 
		
		//��Ÿ�޴� ���÷���
		switch(nMode) {
			case 1 :
				System.out.printf("98. ����%n");
				System.out.printf("99. �ܾ׹���%n");
				System.out.println();
				break;
			default :
				break;
		}
	}//end of ViewMenu
	
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
						//������ �����뿡 ���̾����� �ƹ��͵�����
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
				System.out.printf("%d���Ž������� �����մϴ� %n �����ڿ��� �����ϼ��� %n ������: �������̻�..��? 010-xxxx-xxxx%n",value);
			}
		}
		
		value = 0;
		return value;

	}// end of Returnofchange
}


