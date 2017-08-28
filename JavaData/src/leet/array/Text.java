package leet.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Text {
	//
	public static int[] twosum(int[] nums, int target) {
		int[] result = { 0, 0 };
		// int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
				}
			}
		}

		return result;
	}

	// 375
	public static int getMoneyAmount(int n) {
		int count = 0;
		Scanner scanner = new Scanner(System.in);
		int i = 0;
		while ((i = scanner.nextInt()) != n) {
			if (i < n) {
				System.out.println("lower");
				count += i;
			} else {
				System.out.println("higher");
				count += i;
			}
		}
		return count;
	}

	// 349
	public int[] intersection(int[] nums1, int[] nums2) {
		// Map<K, V> map = new HashMap<K, V>;
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> setNew = new HashSet<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			if (!set.contains(nums2[i])) {
				setNew.add(nums2[i]);
			}
		}
		Object[] objects = setNew.toArray();
		int[] result = new int[objects.length];
		for (int i = 0; i < objects.length; i++) {
			result[i] = (int) objects[i];
		}
		return result;
	}

	/*7. Reverse Integer 
	 */
	public static int reverse(int x) {
		int result = 0;
//		if (Math.abs(x) < 10) {
//			return x;
//		}
		//如果有了越界问题，再刚刚越界的10个范围之内的数，恰好就会小于10
		while (Math.abs(x) != 0) {
			int tail = x % 10;
			int resultNew = result * 10 + tail;
		//这里为越界问题做了解决方法。1、这个学习已经入门了，现在要提升速度了。做多了，以后有空就刷刷，有意思。这个可以一直练习下去。敲代码不会手生。
			//【注意：】这是别人的另外一种处理越界的方法if( rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
			if ((resultNew - tail) / 10 != result) {
				return 0;
			}
			result = resultNew;
			x /= 10;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// 1
		// int[] nums = {2, 7, 11, 15};
		// int target = 9;
		// int[] result = twosum(nums, target);
		// for(int i :result){
		// System.out.println(i);
		// 375
		// Scanner s = new Scanner(System.in);
		// String name = s.nextLine();
		// int ival = s.nextInt();
		// System.out.println(ival + "," + name);
		// System.out.println(getMoneyAmount(10));
		System.out.println(uniquePaths(10,10));
	}
	public static int uniquePaths(int m, int n) {
        if(m<1||n<1)return 0;
        int maxNum = Math.max(m,n),minNum = Math.min(m,n);
        long result = 1;
        int tem = 1;
        for(int i = 0;i < minNum-1 ;i++){
            result *= m+n-2-i;
            tem *= minNum-1-i;
        }
      //  int a = Integer.parseInt(String.valueOf(result));
        return (int)(result/tem);
    }


}
