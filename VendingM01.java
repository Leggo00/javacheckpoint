package kr.co.checkpoint;

import java.util.Scanner;

public class VendingM01 {

	public static void main(String[] args) {
		// ���Ǳ� bye
		//1���� 2���� 3����
		Scanner scan   = new Scanner(System.in);
		String[] menu  = {"1.�ݶ�","2.���̴�","3.Ŀ��","4.�ڸ����̵�","98.��ȯ","99.����"};
		int[] price    = {1500,1500,3000,3500,0,0};
		int[] stock    = {2,2,1,0,0,0};
		
		int nMoney = 0, nSelectmenu = 0, nMode = 0,  i = 0;
		String str = "";
		boolean bStockCheck = true;
		
		System.out.println("[�������Ǳ�]");
		nMoney = 0;

		while (nSelectmenu != 99) {
			
			//=============================================�޴� ===============//
			bStockCheck = false;
			for (i=0; i<stock.length-2;i++) {
				if (stock[i] > 0) {
					bStockCheck= true;
					break;
				}
			}
			
			str = "";
			if (bStockCheck) {
				str = "~�Ǹ���~";
			} else {
				str = "~��� ����~";
			}
			
			if (nMoney > 0) {
				str += " �ܾ�:" + Integer.toString(nMoney); 
			}
			System.out.println(str);
			
			
			str = "";
			for (i=0; i<menu.length;i++) {
				str += menu[i] + "   ";
			}
			System.out.println(str);
			
			str = "";
			for (i=0; i<price.length-2;i++) {
				str +=  " " + Integer.toString(price[i])+ "   ";
			}
			System.out.println(str);
			
			str = "";
			for (i=0; i<stock.length-2;i++) {
				if (stock[i] > 0) {
					str += " �Ǹ���" + "   ";
				} else {
					str += " ǰ�� " + "   ";
				}
			}
			System.out.println(str);
			System.out.println();
			
			//=============================================���� & �޴� ���� ===============//
			System.out.print("������ �Է����ּ��� :");
			nMoney += scan.nextInt();
			
			System.out.print("�޴��� �������ּ��� :");
			nSelectmenu = 0;
			nSelectmenu = scan.nextInt();
			
			//=============================================�޴��� ���� ���� ===============//
			if ((1<=nSelectmenu) && (nSelectmenu <= 4)) {
				System.out.printf("%n%s �޴� ����, �ܾ�: %d%n", menu[nSelectmenu-1], nMoney);
				if (nMoney >= price[nSelectmenu-1]) {
					if (stock[nSelectmenu-1] > 0) {
						nMoney = nMoney - price[nSelectmenu-1]; 
						System.out.printf("%s �� ���Խ��ϴ�. %n", menu[nSelectmenu-1]);
						
						System.out.printf("�ܾ� ���� : %d%n", nMoney);
						nMoney = 0;
					} else {
						System.out.printf("��� �����մϴ�%n");
					}
				} else {
					System.out.println("�ܾ��� �����մϴ�.");
				}
			}else if (nSelectmenu == 98) {
				System.out.printf("�ܾ� ���� : %d%n", nMoney);
				nMoney = 0;
			} else if (nSelectmenu == 99) {
				//���α׷� ����.
				if (nMoney > 0) {
					System.out.printf("�ܾ��� ��ȯ�մϴ� : %d%n", nMoney);
				}
				System.out.println("�ȳ��� �輼�� ������ ���� ���Ǳ⸦ ��Ĩ�ϴ�");
			}
			System.out.println();
			
		} //end of while
		
		scan.close();
	}

}
