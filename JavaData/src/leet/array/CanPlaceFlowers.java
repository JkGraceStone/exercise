package leet.array;

public class CanPlaceFlowers {
	//��ĿҪ��
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
	//˼·��ĳһ��λ��i�����Բ��������϶���[(0),0...],[...,0,(0),0,...],[...,0,0]
	//�������˼·�Ϳ��Կ�ʼд������
	//1,��ÿһλ��ȡֵ������б�����
	//2.������λ�ã�ǰһ���ͺ�һ��λ��λ�ö���0����ô���λ�þͿ�����һ�Ż��������ֻ���������1����λ���ϵ�Ҳ���ϻ��������¸�λ�õ��жϡ�
	//3.��������ֻ���λ�ÿ��Դ���ϣ���ֻ���������ô�Ϳ��С�
	
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
