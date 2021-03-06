package HuaWei;

import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

public class ZhouWei {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];

		if (n > 0) {
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
		}

		int result = 0;
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			max = max > nums[i] ? max : nums[i];
		}
		result = max * max;
		System.out.println(haha(nums, result));

	}

	// 1.数组求和,数据求最大值
	/**
	 * 
	 * @param arr
	 * @return 区间计算值。
	 */
	public static int sumArray(int[] arr) {
		int sum = 0;
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			min = min < arr[i] ? min : arr[i];
		}
		return sum * min;
	}

	// 计算子区间,先不管优化吧
	public static int[] subArray(int[] arr, int n, int len) {
		int[] a = new int[len];
		for (int i = 0; i < len; i++) {
			a[i] = arr[n + i];
		}
		return a;
	}

	// 遍历得到每一个子数组。找最大值。
	public static int haha(int[] arr, int n) {
		for (int i = 2; i <= arr.length; i++) {
			for (int j = 0; j + i <= arr.length; j++) {
				int y = sumArray(subArray(arr, j, i));
				n = n > y ? n : y;
			}
		}
		return n;
	}
}
