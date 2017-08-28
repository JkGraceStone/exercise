package leet.array;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray581 {
	//题目要求：
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
	//【思路】
	/*1.对array进行排序，对比排序前部和后部，然后计算出结果。*/
	    public int findUnsortedSubarray(int[] nums) {
	        int count = nums.length;
	        int[] a = nums.clone();
	        //int[] a = nums;//【注意】复制这样a和nums是同一个数组
	        //System.out.println(a==nums);//【注意】调试性语句，输出这两个数组是否是同一个数组。
	        Arrays.sort(a);
	        for (int i = 0; i < nums.length; i++) {
				if (a[i]==nums[i]) {
					count--;
				}else {
					break;
				}
			}
	        //【细节】考虑如果输入的数组是有序的情况。所以要加入这句话语。
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
	//【反思：】如果光看别人写，总感觉别人考虑周全，代码功力很牛。殊不知，其实都是思想转换为代码，一步一步加以成功的。
	    //所以编程这种东西，是要靠自己动手，自己思考，自己编写代码，自己调试调出来的。没有其他更好的学习方式。
	    //这也是最好，最快的学习方式。所以以后学到什么，都迫不及待的动手试试，是最好的。
	    //这种代码让别人看，别人也觉得你很牛，其实都是一步一步写过来的，不是天生就会。
	    
	    
	   /* 第二种思路：1从脚标从前向后找，找到没有在后面开始有序的位置（就是后面再没有）。(这种方法比第一种方法好很多。这个可以积累。因为很多时候我们排序要花很多时间。所以排序不好，更多的时候，我们是要找到数组的头部有序的位置。)*/
	    
	    //2.从后往前找，找到前面都是asc的位置。（这个寻找的方法比较巧妙。）
	    //上面的这种表述还是不好理解。现在我们换一个场景。现在有一个升序数组[1,3......],但是有一些位置的数值不小心调换了，请找出这个数组中原本前后部还有序的位置。（不用排序）
	    //提示要从后面开始找最小位置。从前面开始遍历找最大的位置。
}
