package HuaWei;

import java.util.Scanner;

public class DistributeString {
	public static void main(String[] args) {
		// ��һ������������
		Scanner scanner = new Scanner(System.in);
		String  str1 = scanner.next();
		String str2 = scanner.next();
		change(str1);
		change(str2);
	}

	public static void change(String str) {
		// ���㳤�ȣ�����Ҫ���������
		if (str == null || str.equals("")) return ;
		int num = str.length();
		char[] c =str.toCharArray();
//		int j = 0;
//		for (int i = num,j = 0; i > 0;i--,j++) {
//			System.out.print(c[j]);
//			if ((j + 1) % 8 == 0) {
//				System.out.println();
//			}
//		}
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i]);
			if ((i + 1) % 8 == 0) {
				System.out.println();
			}
		}
		// ������Ҫ���ӵ�0�ĸ���
		int addnum = 0;
		if(num%8 != 0)
		addnum = 8 - num % 8;
		for (int i = 0; i < addnum ; i++) {
			System.out.print(0);
		}
		System.out.println();
	}
}