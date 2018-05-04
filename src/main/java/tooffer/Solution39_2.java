package tooffer;

import algorithm.binarytree.TreeNode;

/*
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Solution39_2 {
	
	/*
	 * 判断是否平衡
	 * 思路1：仿照求二叉树深度，后序，从底向上遍历，每个节点只需遍历一次，较好
	 */
	public boolean IsBalanced_Solution(TreeNode root) {
		return getDepth0(root) != -1;
	}
	// 改造求二叉树深度的方法
	public int getDepth0(TreeNode root) {
		if (root == null)
			return 0;
		int left = getDepth0(root.left);
		if (left == -1) return -1;
		int right = getDepth0(root.right);
		if (right == -1) return -1;
		return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
	}
	
	
	/*
	 * 判断是否平衡
	 * 思路2：先序遍历，求出每个节点左右子树的深度，判断是否平衡，大量重复遍历，不好
	 */
	public boolean IsBalanced_Solution0(TreeNode root) {
		if (root == null)
			return true;
		int left = getDepth(root.left);
		int right = getDepth(root.right);
		return Math.abs(left - right) <= 1 && IsBalanced_Solution0(root.left) && IsBalanced_Solution0(root.right);
	}
	// 求二叉树深度，后序遍历
	public int getDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = getDepth(root.left);
		int right = getDepth(root.right);
		return Math.max(left, right) + 1;
	}
	
	
	/*
	 * 判断是否平衡
	 * 思路3：后序遍历，判断每个节点平衡的同时返回该节点深度，用于其父节点判断是否平衡，每个节点只需遍历一次，较好
	 * 剑指Offer推荐方式，只是在C++中入参可以传递基本类型引用来获取除了返回值之外的基本类型数据，java中只能创建对象来返回额外的状态
	 * 相当于要返回多个结果（boolean和深度int）
	 */
	public boolean IsBalanced_Solution1(TreeNode root, Depth depth) {
		if (root == null) {
			depth.depth = 0;
			return true;
		}
		Depth left = new Depth(), right = new Depth();
		if (IsBalanced_Solution1(root.left, left) && IsBalanced_Solution1(root.right, right)) {
			if (Math.abs(left.depth - right.depth) > 1) {
				return false;
			} else {
				depth.depth = Math.max(left.depth, right.depth) + 1;
				return true;
			}
		}
		return false;
	}
	// 辅助返回深度
	private class Depth {
		int depth;
	}

}
