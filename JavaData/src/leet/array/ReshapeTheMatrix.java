package leet.array;

public class ReshapeTheMatrix {
	/*
	 * 题目要求： In MATLAB, there is a very useful function called 'reshape', which
	 * can reshape a matrix into a new one with different size but keep its
	 * original data.
	 * 
	 * You're given a matrix represented by a two-dimensional array, and two
	 * positive integers r and c representing the row number and column number
	 * of the wanted reshaped matrix, respectively.
	 * 
	 * The reshaped matrix need to be filled with all the elements of the
	 * original matrix in the same row-traversing order as they were.
	 * 
	 * If the 'reshape' operation with given parameters is possible and legal,
	 * output the new reshaped matrix; Otherwise, output the original matrix.
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [[1,2], [3,4]] r = 1, c = 4 Output: [[1,2,3,4]]
	 * Explanation: The row-traversing of nums is [1,2,3,4]. The new reshaped
	 * matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
	 * 
	 * 
	 * 
	 * Example 2:
	 * 
	 * Input: nums = [[1,2], [3,4]] r = 2, c = 4 Output: [[1,2], [3,4]]
	 * Explanation: There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix.
	 * So output the original matrix.
	 * 
	 * 
	 * 
	 * Note:
	 * 
	 * 1.The height and width of the given matrix is in range [1, 100]. 2.The
	 * given r and c are all positive.
	 * 
	 * 【思路】 多维度先转为1维，1维再转换为另外一个多维。
	 */

	public int[][] matrixReshape(int[][] nums, int r, int c) {
		int i = nums.length;
		int j = nums[0].length;
		// 如果容量不等，就返回原数组
		if (i * j != r * c || r == c) {
			return nums;
		}
		// one将原来数组记录成一维数组
		int[] one = new int[i * j];
		// 记录转换为r行*c列的数组
		int[][] resultArr = new int[r][c];
		for (int j2 = 0; j2 < i; j2++) {
			for (int k = 0; k < j; k++) {
				one[j2 * j + k] = nums[j2][k];
			}
		}
		for (int k = 0; k < r; k++) {
			for (int k2 = 0; k2 < c; k2++) {
				resultArr[k][k2] = one[k * c + k2];
			}
		}
		return resultArr;
	}

	public static void main(String[] args) {
		ReshapeTheMatrix reshapeTheMatrix = new ReshapeTheMatrix();
		int[][] nums = { { 1, 2 }, { 3, 4 } };
		nums = reshapeTheMatrix.matrixReshape(nums, 4, 1);
		for (int j2 = 0; j2 < nums.length; j2++) {
			for (int k = 0; k < nums[0].length; k++) {
				System.out.print(nums[j2][k] + "  ");
			}
			System.out.println();
		}
	}
//第二种方法：	不用中间数组也可以做出来。
	public int[][] matrixReshape1(int[][] nums, int r, int c) {
		int n = nums.length, m = nums[0].length;
		if (r * c != n * m)
			return nums;
		int[][] res = new int[r][c];
		for (int i = 0; i < r * c; i++)
			res[i / c][i % c] = nums[i / m][i % m];
		return res;
	}


}
