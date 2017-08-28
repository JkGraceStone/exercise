package nowcoder.LeetCode;

public class TreeMinDeep {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		public TreeNode() {
		}
	}
	public static void main(String[] args) {

	}
	public int run(TreeNode root) {
		// 1,�������õݹ飬Ȼ�������Ż��������������Ժ󣬾��������ơ���дα���룬���Ҳ��һ���ص㡣
		// �֌����a���@�Ǻ���Ҫ�ļ��ܣ�Ҳ�Ǻܶ��˲���ġ�
		int deep = 0;
		TreeNode node = new TreeNode();
		if (root.left == null && root.right == null) {
			return deep = 1;
		}
		int a = 0, b = 0;
		if (root.left != null)
			return a = run(node = root.left);
		if (root.right != null)
			return b = run(node = root.right);
		return 1+(a < b ? a : b);
	}
	public class Solution {
	    public int run(TreeNode root) {
	        if(root==null)
	            return 0;
	        if(root.left==null)
	            return 1+run(root.right);
	        if(root.right==null)
	            return 1+run(root.left);
	        return 1+Math.min(run(root.left), run(root.right));
	    }
	}

	// �����õĵݹ�
	public int run1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		if (root.left == null || root.right == null) {
			return Math.max(run(root.left), run(root.right)) + 1;
		}
		return Math.min(run(root.left), run(root.right)) + 1;
	}
	// ������������Ҫ��������β�ݹ����ѭ������������˼·�������漰DFS����Ҫ���õݹ����ջʵ�֣�����BFS����Ҫ���ö���ʵ�֣���ʣ�µ�ֻ��Ҫ������Щ˼·���ɡ�

}