package leet.array;

public class FindMaxConsecutiveOnes {
	public static int findMaxConsecutiveOnes(int[] nums) {
        int largeCount = 0 ,count = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 1){
                count++;
            }else{
                count=0;
            }
            largeCount = Math.max(count , largeCount);
        }
        return largeCount;
    }
	public int findMaxConsecutiveOnes1(int[] nums) {
        int maxHere = 0, max = 0;
        for (int n : nums)
            max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
        return max; 
    } 

	public static void main(String[] args) {
		int[] nums = {1,0,1,1,0,1};
		System.out.println(findMaxConsecutiveOnes(nums));
	}

}
