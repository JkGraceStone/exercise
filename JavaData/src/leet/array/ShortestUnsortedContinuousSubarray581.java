package leet.array;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray581 {
	//��ĿҪ��
	/*Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too. 

	You need to find the shortest such subarray and output its length.

	Example 1:

	Input: [2, 6, 4, 8, 10, 9, 15]
	Output: 5
	Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.



	Note:

	1.Then length of the input array is in range [1, 10,000].
	2.The input array may contain duplicates, so ascending order here means <=. 
*/
	////////////-------------------------------///
	//��˼·��
	/*1.��array�������򣬶Ա�����ǰ���ͺ󲿣�Ȼ�����������*/
	    public int findUnsortedSubarray(int[] nums) {
	        int count = nums.length;
	        int[] a = nums.clone();
	        //int[] a = nums;//��ע�⡿��������a��nums��ͬһ������
	        //System.out.println(a==nums);//��ע�⡿��������䣬��������������Ƿ���ͬһ�����顣
	        Arrays.sort(a);
	        for (int i = 0; i < nums.length; i++) {
				if (a[i]==nums[i]) {
					count--;
				}else {
					break;
				}
			}
	        //��ϸ�ڡ���������������������������������Ҫ������仰�
	        if(count==0){
	        	return count;
	        }
	        for (int i = a.length-1; i > 0; i--) {
				if (a[i]==nums[i]) {
					count--;
				}else {
					break;
				}
			}
	    	return count ;
	    }
	    public static void main(String[] args){
	    	ShortestUnsortedContinuousSubarray581 nContinuousSubarray581 = new ShortestUnsortedContinuousSubarray581();
	    	int[] nums = {2, 6, 4, 8, 10, 9, 15};
	    	//int n1 = nContinuousSubarray581.findUnsortedSubarray(nums);
	    	int n2 = nContinuousSubarray581.findUnsortedSubarray1(nums);
	    	//System.out.println(n);
	    	System.out.println(n2);
	    }
	    public int findUnsortedSubarray1(int[] A) {
	        int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];
	        for (int i=1;i<n;i++) {
	          max = Math.max(max, A[i]);
	          min = Math.min(min, A[n-1-i]);
	          if (A[i] < max) end = i;
	          if (A[n-1-i] > min) beg = n-1-i; 
	        }
	        return end - beg + 1;
	    }
	    public int findUnsortedSubarray2(int[] A) {
	        int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];
	        for (int i=1;i<n;i++) {
	          if (max > A[i]) {
				max = A[i];
	          }else {
				end=i;
	          }
	          
	          if (min < A[n-1-i]) {
				min = A[n-1-i];
	          }else {
				beg = n-1-i;
	          }
	        }
	        return end - beg + 1;
	    }
	//����˼��������⿴����д���ܸо����˿�����ȫ�����빦����ţ���ⲻ֪����ʵ����˼��ת��Ϊ���룬һ��һ�����Գɹ��ġ�
	    //���Ա�����ֶ�������Ҫ���Լ����֣��Լ�˼�����Լ���д���룬�Լ����Ե������ġ�û���������õ�ѧϰ��ʽ��
	    //��Ҳ����ã�����ѧϰ��ʽ�������Ժ�ѧ��ʲô�����Ȳ������Ķ������ԣ�����õġ�
	    //���ִ����ñ��˿�������Ҳ�������ţ����ʵ����һ��һ��д�����ģ����������ͻᡣ
	    
	    
	   /* �ڶ���˼·��1�ӽű��ǰ����ң��ҵ�û���ں��濪ʼ�����λ�ã����Ǻ�����û�У���(���ַ����ȵ�һ�ַ����úܶࡣ������Ի��ۡ���Ϊ�ܶ�ʱ����������Ҫ���ܶ�ʱ�䡣�������򲻺ã������ʱ��������Ҫ�ҵ������ͷ�������λ�á�)*/
	    
	    //2.�Ӻ���ǰ�ң��ҵ�ǰ�涼��asc��λ�á������Ѱ�ҵķ����Ƚ������
	    //��������ֱ������ǲ�����⡣�������ǻ�һ��������������һ����������[1,3......],������һЩλ�õ���ֵ��С�ĵ����ˣ����ҳ����������ԭ��ǰ�󲿻������λ�á�����������
	    //��ʾҪ�Ӻ��濪ʼ����Сλ�á���ǰ�濪ʼ����������λ�á�
}
