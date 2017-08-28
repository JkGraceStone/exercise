package leet.array;

public class MaxAverSbuArr {

	public double findMaxAverage(int[] nums, int k) {
		// ����˼·����ÿһ������Ϊ4��subArr��������average��Ȼ��������ֵ��maxAverage
		// 1.�ҳ�subArr�ĸ���=arrlen-k+1��
		// ��ʼֵλ�����
		if (k <= 0 || k > nums.length) {
			return 0.0;
		}
		// double maximumAver = Double.MIN_VALUE;
		double maximumAver = -10000;
		// 1.��һsubarr��average�������
		double average = nums[0];
		if (k == 1) {
			maximumAver = nums[0];
		}
		for (int i = 1; i < k; i++) {
			average = (average + nums[i]);
		}
		average = average / k;
		maximumAver = average;
		if (nums.length > k) {
			for (int i = 1; i < nums.length - k + 1; i++) {
				// 2.�����һ��subarr��average��ֵ
//				if (nums[i - 1] > nums[i + k - 1]) {
//					continue;
//				}
				average = average - (double) nums[i - 1] / k;
				average = average + (double) nums[i + k - 1] / k;
				if (average > maximumAver) {
					maximumAver = average;
				}
			}
		}
		return maximumAver;
	}
	

	public double findMaxAverage1(int[] nums, int k) {
		if (k < 0 || k > nums.length) {
			return 0.0;
		}
		// double maximumAver = Double.MIN_VALUE;
		double maximumAver = -100000;
		for (int i = 0; i < nums.length - k + 1; i++) {
			// 2.���subarr��average��ֵ
			double average = 0;
			for (int j = i; j < i + k; j++) {
				average = (average + nums[j]);
			}
			average /= k;
			if (average > maximumAver) {
				maximumAver = average;
			}
		}
		return maximumAver;
	}

	
	public double findMaxAverage2(int[] nums, int k) {
        long sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        long max = sum;
        
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        
        return max / 1.0 / k;
    }
	
	public static void main(String[] args) {
		MaxAverSbuArr maxAverSbuArr = new MaxAverSbuArr();
		int[] a = { 1, 12, -5, -6, 50, 3 };
		int k = 1;
		System.out.println(maxAverSbuArr.findMaxAverage1(a, k));
		System.out.println(maxAverSbuArr.findMaxAverage(a, k));
		System.out.println(maxAverSbuArr.findMaxAverage2(a, k));

	}

}
