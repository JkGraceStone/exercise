package leet.array;

import javax.xml.transform.Templates;

public class RotateArray189 {

	public void rotate(int[] nums,int k){
		if(k<0)
		{
			return ;
		}
		int length = nums.length;
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
		System.out.println();
		for (int i = 0; i < k; i++) {
			int temp = nums[length-1];
			for (int j = length -1; j > 0; j--) {
				nums[j] = nums[j-1];				
			}
			nums[0]= temp;
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
	}
	public void rotate1(int[] nums ,int k){
		k %= nums.length;
		int[] tem = new int[k];
		//1记录后k个数据：（这个顺序倒着正着都可以，自己转换的时候记得就可以[5,6,7]=>[7,6,5]）
		for (int i = 0; i < k; i++) {
			tem[i] = nums[nums.length-1-i];
		}
		//2前n-k个分别向后移动后k个位置
		for (int i = nums.length - 1 - k; i >= 0; i--) {
			nums[i+k] = nums[i];
		}
		//3后记录的k个位置的信息放到最前面
		for (int i = 0; i < k; i++) {
			nums[i]=tem[k-1-i];
		}
		//4打印rotate之后的信息
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
	}
	public static void main(String[] args) {
		RotateArray189 rotateArray189 = new RotateArray189();
		int[] a = {1};
		int k = 0;
		
		rotateArray189.rotate1(a, k);
	}

}
