//5.27��
package kr.co.checkpoint;

import java.util.Scanner;

public class VendingM02_2_eun {

	public static void main(String[] args) {
//		1���� (2����) �迭�� ���Ǳ⸦ ��������
//		������ ������ 5���� �̻�
//		����(������̸�), ����, ���
		
		Scanner scan = new Scanner(System.in);
		boolean stop = false;
		
		final int PASS = 4568721; // �����ڸ�������
//		int pass = 1234; // �����ڸ�������
		final int SIZE = 7;    // ������ ����
		
//		String [] drinkName = new String [SIZE];  // ������̸�
//		int [] drinkPrice = new int [SIZE];       // ���� ����    
//		int [] drinkStock = new int [SIZE];       // ���� ���

		String [] drinkName = {"���̽� �Ƹ޶�ī��","ī���","�ݵ���","�ٴҶ��","���ǳӶ�","�����","����Ǫġ��"};  // ������̸�
		int [] drinkPrice = {3000,3500,3500,4000,4000,4500,4500};       // ���� ����    
		int [] drinkStock = {2,2,2,2,2,2,2};       					  // ���� ���
		
		int money=0;    // ������ ��
		
		int addMoney=0; // �߰��� ������ ��
		int sel=-1;     // �޴�����
		int change=0;   // �Ž�����
		
		// �߰����� (�����ڸ��)
//		String [] whatDrink = new String [7];
		int whatDrink=-1;      // �ٲٰ���� �޴� ���� ���� 
		String newDrink="";    // ���ο� ����� �̸�
		int newDrinkPrice=0;   // ���ο� ����� ����
		int newDrinkStock=0;   // ���ο� ����� ���
		
		while (!stop) {
			
			System.out.print("**********************************coffee ���Ǳ�**********************************");
			System.out.println("\n=====================================[�޴�]======================================");
			System.out.printf("[1.%s(%d��)][2.%s(%d��)][3.%s(%d��)][4.%s(%d��)]\n", drinkName[0],drinkPrice[0],drinkName[1],drinkPrice[1],drinkName[2],drinkPrice[2],drinkName[3],drinkPrice[3]);
			System.out.printf("[->%s : ���%d] [->%s : ���%d][->%s : ���%d][->%s : ���%d]", drinkName[0], drinkStock[0], drinkName[1], drinkStock[1], drinkName[2], drinkStock[2], drinkName[3], drinkStock[3]);
			System.out.println();
			System.out.printf("\n[5.%s(%d��)][6.%s(%d��)][7.%s(%d��)] || [99.����][00.�����ڸ��]" ,drinkName[4],drinkPrice[4],drinkName[5],drinkPrice[5],drinkName[6],drinkPrice[6]);
			System.out.printf("\n[->%s : ���%d] [->%s : ���%d][->%s : ���%d]",drinkName[4], drinkStock[4],drinkName[5], drinkStock[5],drinkName[6], drinkStock[6]);
			System.out.println("\n===============================================================================");		
			System.out.printf("\n���� ���Ա��� �־��ּ��� : ");
			money =  Integer.parseInt(scan.nextLine());
			
//			�� ���� ==============================================================
			if (money>=0) {
				System.out.println(money + "���� ���ԵǾ����ϴ�.");
				System.out.println("");
				System.out.printf("�޴����� ���Ḧ �����ϼ��� : ");
				sel = Integer.parseInt(scan.nextLine());
				
//			�޴� ���� ==============================================================	
				switch (sel) {
					case 1 : case 2 : case 3 : case 4 : case 5 : case 6 : case 7 :
						if (drinkStock[sel-1] == 0) {
							System.out.println(drinkName[sel-1] + "�� ǰ���Դϴ�.");
							System.out.println(money + "���� ��ȯ�Ǿ����ϴ�.");
						} 
						else {
							System.out.printf("%s�� �����Ͽ����ϴ�\n", drinkName[sel-1]);
							while (money < drinkPrice[sel-1]) {
								System.out.println("���� �� �������ּ��� : ");
								addMoney = Integer.parseInt(scan.nextLine());
								money += addMoney;
							}
								change = money - drinkPrice[sel-1];
								System.out.printf("->%s ���Խ��ϴ�.\n", drinkName[sel-1]);
								drinkStock[sel-1] = drinkStock[sel-1]-1;
								System.out.printf("�Ž����� '%d��'�� ��ȯ�Ǿ����ϴ�.", change);
								System.out.println("");
						}
						break;
				
//					���� ==============================================================	
					case 99 :
						System.out.println("���Ǳ� ����");
						System.out.printf("�� '%d��'�� ��ȯ�Ǿ����ϴ�.", money);
						System.out.println("\n-end-");
					
						stop = true;
						break;
				
//					�����ڸ��	==========================================================
					case 00 :
						System.out.println(">�����ڸ���Դϴ�< ��й�ȣ�� �Է����ּ��� : <");
						int npass = -9999;
						npass = Integer.parseInt(scan.nextLine());
						
						if (npass == PASS) {
							System.out.print("Ȯ�εǾ����ϴ�. ������ �ʿ��� ���Ḧ �����ϼ��� : ");
							whatDrink = Integer.parseInt(scan.nextLine());
						
							switch (whatDrink) {
								case 1 : case 2 : case 3 : case 4 : case 5 : case 6 : case 7 :
										System.out.print("������ �̸��� �ۼ����ּ��� : ");
										newDrink = scan.nextLine();
										System.out.print("�󸶷� å���Ͻðڽ��ϱ�? : ");
										newDrinkPrice = Integer.parseInt(scan.nextLine());
										System.out.print("�� �� �����ðڽ��ϱ�? :" );
										newDrinkStock = Integer.parseInt(scan.nextLine());
										drinkName [whatDrink-1] = newDrink;
										drinkPrice [whatDrink-1] = newDrinkPrice;  
										drinkStock [whatDrink-1] = newDrinkStock;
									break;
							}  // switch (whatDrink) ��
						}
						else {
							System.out.println("�߸��ԷµǾ����ϴ�. �ʱ�޴��� ���ư��ϴ�.");
						}
						
							default :
							
				}  //switch (sel) ��
			} // if (money>0) �ݱ� 
			else if (money<0) {
				System.out.println("���� ����� �������ּ���");
			}
			
				System.out.println();
		} //while (!stop) ��
		
	}

}
