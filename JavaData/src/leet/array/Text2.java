package leet.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Text2 {

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		int[] i ={0,0,0,5,0,4};
		System.out.print(Text2.t3(i));
	}
	public static int t3(int nums[]) {
		int sum = 0;
		
		//1处理边界情况
		if (nums.length == 0) {
			return 0;
		}
		int n = nums.length / 2;
		int[] a = new int[nums.length];
		//2对数组进行排序
		Arrays.sort(nums);
		//3.1对数据进行再次改变次序，让最大的数字排在中间
		a[n] = nums[nums.length - 1];
		//3.2.1最大数的右边的初始化
		for (int i = n + 1, j = 0; i < nums.length; i += 2, j += 2) {
			a[i] = nums[j];
		}
		//3.2.2最大数的右边的初始化
		for (int i = n + 2; i < nums.length; i += 2) {
			a[i] = nums[i - 1];
		}
		//3.2.1最大数的左边的初始化
		for (int i = n-1,j=1; i > 0; i -= 2,j+=2) {
			a[i] = nums[j];
		}
		//3.2.2最大数的左边的初始化
		for (int i = n-2,j=n+2; i > 0; i -= 2,j+=2) {
			a[i] = nums[j];
		}
		//计算相邻的两个数差，用绝对值相加求和
		for (int i = 0; i < a.length-1; i++) {
			sum = Math.abs(nums[i]-nums[i+1]);
		}
		//返回绝对值差
		return sum;
	}
}
