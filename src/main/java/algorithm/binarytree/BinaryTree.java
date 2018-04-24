package algorithm.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinaryTree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		int[] array = {13,65,5,97,25,0,37,22,0,4,28,0,0,32};
		TreeNode root = makeBinaryTreeByArray(array, 0);
//		tree.dfs(root);
//		tree.bfs(root);
		tree.preorder(root);
		System.out.println();
		tree.preorderNonRecursive(root);
		System.out.println();
		tree.inorder(root);
		System.out.println();
		tree.inorderNonRecursive(root);
		System.out.println();
		tree.postorder(root);
		System.out.println();
		tree.postorderNonRecursive(root);
		System.out.println();
		tree.postorderNonRecursive0(root);
		System.out.println();
		
	}
	
	/** 
     * 采用递归的方式创建一颗二叉树
     * 传入的是二叉树的数组表示法，广度优先，数组中某个值为0表示该位置为null，无节点
     * 构造后是二叉树的二叉链表表示法 
     */
	public static TreeNode makeBinaryTreeByArray(int[] array, int index) {
		if (index < array.length) {
			int val = array[index];
			if (val != 0) {
				TreeNode t = new TreeNode(val);
				array[index] = 0;
				t.left = makeBinaryTreeByArray(array, index * 2 + 1);
				t.right = makeBinaryTreeByArray(array, index * 2 + 2);
				return t;
			}
		}
		return null;
	}
	
	/** 
     * 深度优先遍历，相当于先根遍历，非递归实现，需要辅助数据结构：栈 
     */ 
	public void dfs(TreeNode root) {
		if (root == null) {
			System.out.println("Empty Tree");
			return;
		}
		ArrayDeque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode t = stack.pop();
			System.out.format("%4d", t.val);
			if (t.right != null)
				stack.push(t.right);
			if (t.left != null)
				stack.push(t.left);
		}
	}
	
	/*
	 * 广度优先遍历，非递归实现，采用队列
	 */
	public void bfs(TreeNode root) {
		if (root == null) {
			System.out.println("Empty Tree");
			return;
		}
		ArrayDeque<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode t = queue.remove();
			System.out.format("%4d", t.val);
			if (t.left != null)
				queue.add(t.left);
			if (t.right != null)
				queue.add(t.right);
		}
		System.out.println();
	}
	
	// 参考：http://www.cnblogs.com/dolphin0520/archive/2011/08/25/2153720.html
	// 递归前序遍历
	public void preorder(TreeNode root) {
		if (root != null) {
			System.out.format("%4d", root.val);
			preorder(root.left);
			preorder(root.right);
		}
	}
	// 递归中序遍历
	public void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.format("%4d", root.val);
			inorder(root.right);
		}
	}
	// 递归后序遍历
	public void postorder(TreeNode root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.format("%4d", root.val);
		}
	}
	
	// 非递归前序遍历
	public void preorderNonRecursive(TreeNode root) {
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode p = root;
		while (p != null || !stack.isEmpty()) {
			while (p != null) {
				System.out.format("%4d", p.val);
				stack.push(p);
				p = p.left;
			}
			if (!stack.isEmpty()) {
				p = stack.pop();
				p = p.right;
			}
		}
	}
	
	// 非递归中序遍历
	public void inorderNonRecursive(TreeNode root) {
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode p = root;
		while (p != null || !stack.isEmpty()) {
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
			if (!stack.isEmpty()) {
				p = stack.pop();
				System.out.format("%4d", p.val);
				p = p.right;
			}
		}
	}
	
	// 非递归后序遍历，较复杂
	// 思路1：需要多设置一个变量标识结点是否是第一次出现在栈顶，如果是，则需要先遍历右子树，如果不是，则遍历之
	public void postorderNonRecursive(TreeNode root) {
		Deque<TempNode> stack = new ArrayDeque<>();
		TreeNode p = root;
		TempNode t;
		while (p != null || !stack.isEmpty()) {
			while (p != null) {
				stack.push(new TempNode(p, true));
				p = p.left;
			}
			if (!stack.isEmpty()) {
				t = stack.pop();
				if (t.isFirst) {
					t.isFirst = false;
					stack.push(t);
					p = t.node.right;
				} else {
					System.out.format("%4d", t.node.val);
					p = null;
				}
			}
		}
	}
	// 辅助非递归后序遍历
	static class TempNode {
		TreeNode node;
		boolean isFirst;
		public TempNode (TreeNode node, boolean isFirst) {
			this.node = node;
			this.isFirst = isFirst;
		}
	}
	
	// 非递归后序遍历，较复杂
	// 思路2：要保证根结点在左孩子和右孩子访问之后才能访问，因此对于任一结点P，先将其入栈。
	// 如果P不存在左孩子和右孩子，则可以直接访问它；或者P存在左孩子或者右孩子，但是其左孩子和右孩子都已被访问过了，则同样可以直接访问该结点。
	// 若非上述两种情况，则将P的右孩子和左孩子依次入栈，这样就保证了每次取栈顶元素的时候，左孩子在右孩子前面被访问，左孩子和右孩子都在根结点前面被访问。
	public void postorderNonRecursive0(TreeNode root) {
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode cur = null; // 当前节点
		TreeNode pre = null; // 记录前一次访问的节点
		stack.push(root);
		while (!stack.isEmpty()) {
			cur = stack.peek();
			if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
				System.out.format("%4d", cur.val);  //如果当前结点没有孩子结点或者孩子节点都已被访问过
				stack.pop();
				pre = cur;
			} else {
				if (cur.right != null)
					stack.push(cur.right);
				if (cur.left != null)
					stack.push(cur.left);
			}
		}
	}
	
}
