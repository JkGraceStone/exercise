package leet.array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaximumProductOfThreeNumbers {
	public int maximumProduct(int[] nums){
		int maxiThree=1;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
		for (int i = 0; i < 3; i++) {
			maxiThree*=nums[nums.length-1-i];
		}
		
		return maxiThree;
	}
	public int maximumProduct1(int[] nums){
		Arrays.sort(nums);
		return Math.max(nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3], nums[nums.length-1]*nums[0]*nums[1]);
	//	return nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
	}
	public static void main(String[] args){
		MaximumProductOfThreeNumbers maximumProductOfThreeNumbers = new MaximumProductOfThreeNumbers();
		int[] a = {-4,-3,-2,-1,60};
		System.out.println(maximumProductOfThreeNumbers.maximumProduct1(a));
	}

}
