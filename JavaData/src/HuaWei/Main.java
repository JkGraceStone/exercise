package HuaWei;

import java.util.Scanner;

import javax.swing.text.ChangedCharSetException;

public class Main {
	public static void main(String[] args) {
		Scanner  scanner = new Scanner(System.in);
		int[] a = new int[scanner.nextInt()];
		for (int i = 0; i < a.length; i++) {
			a[i] = scanner.nextInt();
		}
		int sum = change(a);
		System.out.println(sum);
	}

	private static int change(int[] a) {
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i]==1){
				count1++;
			}else if (a[i]==2) {
				count2++;
			}else {
				count3++;
			}
		}
		int a12 =0;//����2ռ��1λ�õĸ���
		int a13 = 0;//����3ռ��1λ�õĸ���
		int a21 = 0;//����1ռ��2λ�õĸ���
		int a23 = 0;//����3ռ��2λ�õĸ���
		int a31 = 0;//����1ռ��3λ�õĸ���
		int a32 = 0;//����2ռ��3λ�õĸ���
		for (int i = 0; i < count1; i++) {
			if(a[i]==1){
			}else if (a[i]==2) {
				a12++;
			}else {
				a13++;
			}
		}
		for (int i = 0; i < count2; i++) {
			if(a[i+count1]==1){
				a21++;
			}else if (a[i+count1]==2) {
			}else {
				a23++;
			}
		}
		for (int i = 0; i < count3; i++) {
			if(a[i+count1+count2]==1){
				a31++;
			}else if (a[i+count1+count2]==2) {
				a32++;
			}else {
			}
		}
		int sum = a12+a13;
		sum += Math.max(a23, a32);
		return sum;
	}

}
