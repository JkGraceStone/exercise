package leet.array;

public class CanPlaceFlowers {
	//题目要求：
	/*Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

	Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

	Example 1:

	Input: flowerbed = [1,0,0,0,1], n = 1
	Output: True



	Example 2:

	Input: flowerbed = [1,0,0,0,1], n = 2
	Output: False



	Note:

	1.The input array won't violate no-adjacent-flowers rule.
	2.The input array size is in the range of [1, 20000].
	3.n is a non-negative integer which won't exceed the input array size.
*/
	
	/****************************/
	//思路：某一个位置i，可以插入的情况肯定是[(0),0...],[...,0,(0),0,...],[...,0,0]
	//有了这个思路就可以开始写代码了
	//1,对每一位置取值情况进行遍历。
	//2.如果这个位置，前一个和后一个位置位置都是0，那么这个位置就可以种一颗花。可以种花的数量加1，该位置上的也中上花，便于下个位置的判断。
	//3.如果可以种花的位置可以大于希望种花的数量那么就可行。
	
	public boolean canPlaceFlowers(int[] flowerbed ,int n){
		int count = 0;
		for (int i = 0; i < flowerbed.length; i++) {
			if (flowerbed[i]==0) {
				int prov = (i==0)? 0:flowerbed[i-1];
				int next = (i==flowerbed.length-1) ? 0:flowerbed[i+1];
				if (prov==0&&next==0) {
					flowerbed[i]=1;
					count++;
				}
			}
		}
		return count >= n;
	}
	
	public static void main(String args[]){
		CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();
		int[] flowerbed = {0,1,0,0,0,1,0,0};
		int n = 2;
		System.out.println(canPlaceFlowers.canPlaceFlowers(flowerbed, n));
	}

}
