package tooffer;

/*
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class Solution24 {
	
	public static void main(String[] args) {
		int[] sequence = {5,7,6,9,11,10,8};
		int[] sequence2 = {7,4,6,5};
		System.out.println(new Solution24().VerifySquenceOfBST(sequence2));
	}

	public boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence == null || sequence.length == 0)
			return false;
		return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
	}

	public boolean VerifySquenceOfBST(int[] sequence, int left, int right) {
		if (right - left < 2)
			return true;
		int root = sequence[right];
		int p = left;
		// 寻找左右子树分界点，左子树均小于根节点
		for (;p < right; ++p) {
			if (sequence[p] > root)
				break;
		}
		// 只需考虑左子树正确性
		if (p > right - 2)
			return VerifySquenceOfBST(sequence, left, p - 1);
		// 判断右子树节点是否均大于根节点，若不，则直接返回false
		for (int i = p + 1; i < right; ++i) {
			if (sequence[i] < root) {
				return false;
			}
		}
		// 只需考虑右子树正确性
		if (p < left + 3)
			return VerifySquenceOfBST(sequence, p, right - 1);
		// 左右子树均需考虑
		return VerifySquenceOfBST(sequence, left, p - 1) && VerifySquenceOfBST(sequence, p, right - 1);
	}

}
