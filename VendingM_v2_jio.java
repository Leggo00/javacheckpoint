package kr.co.checkpoint;

import java.util.Arrays;
import java.util.Scanner;

public class VendingM_v2_jio {

	public static void main(String[] args) {
//      1����(2����) �迭�� ���Ǳ⸦ ��������
//      ������ ������ 5���� �̻��Դϴ�. ����, ����, ���� �־������

		Scanner scan = new Scanner(System.in);
		final int PASS = 1234; // �����ڸ�� ����� ��й�ȣ
		final int SIZE = 7; // ������ ���

		String[] drinkName = { "�ݶ�", "���̴�", "ȯŸ", "��ī��", "�䷹Ÿ", "�ƾ�", "��" }; // ����� �̸�
		String[] drinkState = { " ", " ", " ", " ", " ", " ", " " }; // �Ǹ� ��Ȳ(�Ǹ���, ǰ��)
		int[] drinkPrice = { 1500, 1300, 1000, 2000, 1400, 1200, 2400 }; // ���ᰡ��
		int[] drinkStock = { 5, 1, 4, 2, 3, 8, 7 }; // ������ ���

		int menu = 0; // �޴�
		int adminPw = 0; // ������ ��� ��й�ȣ

		int addPrice = 0; // �߰� �ݾ�
		String dName = " "; // ���� ����
		int dPrice = 0; // ���� ���� ����
		int dStock = 0; // ���� ��� ����
		int adminMenu = 0; // ������ ��� �޴�

		boolean stop = false;
		boolean admin = false;

		while (!stop) {
			// �Ǹ� ��Ȳ
			for (int i = 0; i < drinkState.length; i++) {
				if (drinkStock[i] <= 0) {
					drinkState[i] = "ǰ��";
				} else {
					drinkState[i] = "�Ǹ���";
				}
			}

			System.out.println("-----------------[�޴�]-----------------");
			System.out.println("1. ���� �̱� 99. ���� 100. ������ ���");
			System.out.println("---------------------------------------");
			System.out.print("�޴� ���� >> ");
			menu = Integer.parseInt(scan.nextLine());

			switch (menu) {
			case 1:
				System.out.println("===============[����� �޴�]===============");

				for (int i = 0; i < drinkName.length; i++) {
					System.out.println((i + 1) + ") " + drinkName[i] + "(" + drinkPrice[i] + "��) - " + drinkState[i]);
				}
				System.out.print("���ϴ� ������ ���ڸ� �Է��ϼ���.(1~7)>>");
				menu = Integer.parseInt(scan.nextLine());

				if ((menu > 0) && (menu <= 7)) {
					for (int i = 0; i <= drinkName.length; i++) {
						if (menu == i) {
							System.out.print("�ݾ��� �Է��ϼ���. >>");
							dPrice = Integer.parseInt(scan.nextLine());

							if (dPrice == drinkPrice[i - 1]) { // �Է� �ݾװ� ���� �ݾ��� ���ٸ�
								System.out.println("�ܾ�>>" + (drinkPrice[i - 1] - dPrice) + "��");
								System.out.println(drinkName[i - 1] + "�� ���Խ��ϴ�.");
								drinkStock[i - 1] -= 1;
								break;
							} else if (dPrice < drinkPrice[i - 1]) { // �Է� �ݾ��� ���� �ݾ׺��� �۴ٸ�
								while (dPrice < drinkPrice[i - 1]) {// �߰� �ݾ� �ޱ�(�ݾ��� ������������)
									System.out.println("�ܾ� ����! �ܾ�>>" + (drinkPrice[i - 1] - dPrice));
									System.out.printf("�߰� �ݾ� �Է�>>");
									addPrice = Integer.parseInt(scan.nextLine());
									dPrice += addPrice;

									if (dPrice > drinkPrice[i - 1]) { // �߰� �ݾ��� ���� �ݾ׺��� ũ�� �ܾ� ��ȯ
										System.out.println((dPrice - drinkPrice[i - 1]) + "�� ��ȯ");
									}
								}
								System.out.println(drinkName[i - 1] + "�� ���Խ��ϴ�.");
								drinkStock[i - 1] -= 1;
								break;
							} else if (dPrice > drinkPrice[i - 1]) { // �Է� �ݾ��� ���� �ݾ׺��� ũ�ٸ� �ܾ� ��ȯ
								System.out.println((dPrice - drinkPrice[i - 1]) + "�� ��ȯ");
								System.out.println(drinkName[i - 1] + "�� ���Խ��ϴ�.");
								drinkStock[i - 1] -= 1;
								break;
							}
						}
					}
				} else {
					System.out.println("1~7�� �Է����ּ���.");
				}
				break;

			case 99:
				System.out.println("[���Ǳ� ���� �մϴ�]");
				stop = true;
				break;

			case 100: // ������ ���
				System.out.print("������ ��� ��й�ȣ >>");
				adminPw = Integer.parseInt(scan.nextLine());

				if (PASS == adminPw) { // ��й�ȣ�� ������ ������ ��忡 ��
					System.out.println("============[������ ���]============");
					for (int i = 0; i < drinkName.length; i++) {
						System.out
								.println((i + 1) + ") " + drinkName[i] + "(" + drinkPrice[i] + "��) - " + drinkState[i]);
					}
					System.out.println("\n1. ���� ���� ����");
					System.out.println("2. ���� ���� ����");
					System.out.println("3. ��� �߰�");
					System.out.println("4. �����ڸ�� ����");
					System.out.printf("�����Ͻ� �޴� ���ڸ� �Է��ϼ���.(1~4) >>");
					adminMenu = Integer.parseInt(scan.nextLine());

					switch (adminMenu) {
					case 1: // �޴� ����
						System.out.printf("�����ϰ� ���� �޴��� �������ּ���.(1~7) >> ");
						menu = Integer.parseInt(scan.nextLine());

						if ((menu > 0) && (menu <= 7)) {
							System.out.print("������ �޴� �̸� �Է�>>");
							dName = scan.nextLine();
							drinkName[menu - 1] = dName;
						} else {
							System.out.println("1~7�߿��� ����ּ���");
						}
						System.out.println("--------------[���� �� �޴�]--------------");
						System.out.println(Arrays.toString(drinkName));
						break;

					case 2: // ���� ����
						System.out.printf("���� �����ϰ� ���� �޴��� �������ּ���.(1~7) >> ");
						menu = Integer.parseInt(scan.nextLine());

						if ((menu > 0) && (menu <= 7)) {
							System.out.print("������ ���� �Է�>> ");
							dPrice = Integer.parseInt(scan.nextLine());
							drinkPrice[menu - 1] = dPrice;
						} else {
							System.out.println("1~7�߿��� ����ּ���");
						}
						System.out.println("--------------[���� ���� �� �޴�]--------------");
						System.out.println(Arrays.toString(drinkPrice));
						break;

					case 3: // ��� �߰�
						System.out.printf("��� �߰��� �޴��� �������ּ���.(1~7) >>");
						menu = Integer.parseInt(scan.nextLine());

						if ((menu > 0) && (menu <= 7)) {
							System.out.print("�߰��� ��� ���� �Է�>> ");
							dStock = Integer.parseInt(scan.nextLine());
							drinkStock[menu - 1] += dStock;
						} else {
							System.out.println("1~7�߿��� ����ּ���");
						}
						System.out.println("--------------[��� ���� �� �޴�]--------------");
						System.out.println(Arrays.toString(drinkStock));
						break;

					case 4:
						System.out.println("=====[������ ��� ����]=====");
						System.out.println("�ǸŸ��� ���ư��ϴ�.");
						admin = true;
						break;

					default:
						System.out.println("1~4�� �Է��ϼ���.");
					}

				} else {
					System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
				}
				break;

			default:
				System.out.println("1, 99, 100�߿��� �Է��ϼ���.");
			}
		}
		scan.close();
	}
}