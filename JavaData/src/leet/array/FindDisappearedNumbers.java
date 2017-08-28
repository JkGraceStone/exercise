package leet.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

public class FindDisappearedNumbers {
	/* 思路：初始化list，1~数组长度。然后遍历数组，遍历数组，从list中删除掉遍历到的元素。 */
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			list.add(i + 1);
		}
		for (int i = 0; i < nums.length; i++) {
			list.remove((Integer) nums[i]);
		}
		/*
		 * Iterator<Integer> iterator = list.iterator();
		 * while(iterator.hasNext()){ System.out.print(iterator.next()+" "); }
		 */
		return list;
	}

	// 以上的这种方法在测试用例的（30/34）出现超时问题，提供下面两种解题方法（两种思路同工之妙）
	// method1;利用脚标，利用取负数（取绝对值还原），
	public static List<Integer> findDisappearedNumbers2(int[] nums) {
		List<Integer> res = new ArrayList<>();
		int n = nums.length;
		for (int i = 0; i < nums.length; i++) {
			nums[Math.abs(nums[i]) - 1] = -Math
					.abs(nums[Math.abs(nums[i]) - 1]);
		}
		for (int i = 0; i < nums.length; i++)
			if (nums[i] > 0)
				res.add(i + 1);
		return res;
	}

	// method2写法二The basic idea is that we iterate through the input array and
	// mark elements as negative using nums[nums[i] -1] = -nums[nums[i]-1]. In
	// this way all the numbers that we have seen will be marked as negative. In
	// the second iteration, if a value is not marked as negative, it implies we
	// have never seen that index before, so just add it to the return list.
	/*
	 * public List<Integer> findDisappearedNumbers2(int[] nums) { List<Integer>
	 * ret = new ArrayList<Integer>();
	 * 
	 * for (int i = 0; i < nums.length; i++) { int val = Math.abs(nums[i]) - 1;
	 * if (nums[val] > 0) { nums[val] = -nums[val]; } }
	 * 
	 * for (int i = 0; i < nums.length; i++) { if (nums[i] > 0) { ret.add(i +
	 * 1); } } return ret; }
	 */

	// method2;利用脚标，利用取n余数（取余还原）
	public static List<Integer> findDisappearedNumbers3(int[] nums) {
		List<Integer> res = new ArrayList<>();
		int n = nums.length;
		for (int i = 0; i < nums.length; i++)
			nums[(nums[i] - 1) % n] += n;
		for (int i = 0; i < nums.length; i++)
			if (nums[i] <= n)
				res.add(i + 1);
		return res;
	}

	public int removeElement(int[] nums, int val) {
		int length = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[length] = nums[i];
				length++;
			}
		}
		return length;
	}

	public static int thirdMax(int[] nums) {
		Set<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		int[] arr = new int[set.size()];
		int i = 0;
		for (int k : set) {
			arr[i++] = k;
		}
		return arr.length < 3 ? arr[arr.length - 1] : arr[arr.length - 3];
	}

	

	// 這個方法是排序后放0；
	public static void moveZeroes(int[] nums) {
		for (int i = 0; i < nums.length; i++)
			if (nums[i] == 0)
				nums[i] = Integer.MAX_VALUE;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++)
			if (nums[i] == Integer.MAX_VALUE)
				nums[i] = 0;
		for (int i = 0; i < nums.length; i++)
			System.out.println(nums[i]);
	}

	// 不排序，就只是把0提取出来，放入到尾部
	public static void moveZeroes1(int[] nums) {
		if (nums == null) {
			return;
		}
		int count = 0;
		int[] arr = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				count++;
			} else {
				arr[i - count] = nums[i];
			}
		}
		for (int i = 0; i < count; i++) {
			arr[nums.length - count] = 0;
		}
		nums = arr;
		for (int i = 0; i < nums.length; i++)
			System.out.println(nums[i]);
	}

	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length == 0) {
			return null;
		}
		int[] tem = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] == target) {
					tem[0] = i;
					tem[1] = j;
					return tem;
				}
			}
		}
		return tem;
	}

	public static int removeDuplicates(int[] nums) {
		int result = 1;
        if(nums == null){
            result = 0;
        }
        for(int i = 0; i<nums.length-1;i++){
            while(nums[i]==nums[++i]){
                for(int j = i+1 ;j<nums.length-1;j++){
                    nums[j] = nums[j+1];
                }
                nums[nums.length-1] = nums[i];
            }
            if(nums[i]>nums[i+1]){
                return i+1;
            }else{
                result ++;
            }
        }
        return result;
	    }
	public static int removeDuplicates1(int[] A) {
	    if (A.length==0) return 0;
	    int j=0;
	    for (int i=0; i<A.length; i++)
	        if (A[i]!=A[j])
	        	A[++j]=A[i];
	    return ++j;
	}
	public static void main(String[] args) {
		int[] nums = { 1,1,2};
		// System.out.println(findDisappearedNumbers(nums));
		//System.out.println(removeDuplicates1(nums));
		removeDuplicates1(nums);
		
		int[] a = new int[1];
		System.out.println(a[0]);
	}
	 public int majorityElement(int[] nums) {
	        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	        for(int i :nums){
	            map.put(i, map.getOrDefault(i, 0)+1);
	        }
	        for (Map.Entry<Integer, Integer> entry :map.entrySet()) {
				if (entry.getValue()>= nums.length/2) {
					return entry.getKey();
				}
			}
	        return 0;
	    }
}
