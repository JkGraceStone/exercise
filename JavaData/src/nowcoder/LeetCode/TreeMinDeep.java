package nowcoder.LeetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
		// 1,还是先用递归，然后再找优化，这样做多了以后，绝对有优势。先写伪代码，这个也是一种重点。
		// 手寫代碼，這是很重要的技能，也是很多人不会的。
		//用递归其实就是深度优先遍历。nice。复习哦。
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
	// 二叉树操作主要还是利用尾递归或者循环遍历这两种思路，进而涉及DFS（主要利用递归或者栈实现）或者BFS（主要利用队列实现）。剩下的只需要按照这些思路即可。
	//不用递归的方法。用循环遍历的方法。
	//方法1广度优先遍历，非递    归包含深度递归的算法
	public class Solution1 {
	    public int run(TreeNode root) {
	       if(root==null)
	            return 0;
	        Queue<TreeNode> que=new LinkedList<TreeNode>();
	        que.add(root);
	        int cnt=0;
	        while(!que.isEmpty())
	        {
	             
	            int size=que.size();
	            ++cnt;
	            for(int i=0;i<size;++i)
	            {
	                TreeNode cur=que.poll();
	                if(cur.left==null&&cur.right==null)         
	                    return cnt;             
	                if(cur.left!=null)          
	                    que.add(cur.left);
	                 
	                if(cur.right!=null)
	                    que.add(cur.right);
	                 
	            }
	                         
	        }
	         
	        return cnt;
	    }
	}
	//方法1广度优先遍历，非递    归包含深度递归的算法
		public class Solution2 {
		    public int run(TreeNode root) {
		       if(root==null)
		            return 0;
		       Stack<TreeNode> sta = new Stack<TreeMinDeep.TreeNode>();
		       sta.add(root);
		        int cnt=0;
		        int result = Integer.MAX_VALUE;
		        while(!sta.isEmpty())
		        {
		           // int size=sta.size();
		            ++cnt;//这里也需要修改。
		            //for(int i=0;i<size;++i)//改为广度的话，这里需要修改。
		            //{
		                TreeNode cur=sta.pop();
		                if(cur.left==null&&cur.right==null){         
		                   result = result<cnt+1? result:cnt;
		                	continue;
		                }
		                if(cur.right!=null){
		                    sta.add(cur.right);
		                    ++cnt;
		                 }
		                 if(cur.left!=null){          
		                	sta.push(cur.left);
		                	++cnt;
		                 }
		            //}
		        }
		        return cnt;
		    }
		}
}
