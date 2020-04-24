package com.leetcode.solutions.challenges.leetcoding30day.week2;

public class DiameterOfBinaryTree {
	public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
	}
	private static int diameter = 0;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		System.out.println(diameterOfBinaryTree(root));
	}

	public static int diameterOfBinaryTree(TreeNode root) {
		diameter = 0;
		diameter(root);
		return diameter;
	}

	public static int diameter(TreeNode root){
		if(root == null)
			return 0;
		int left = diameter(root.left);
		int right = diameter(root.right);
		diameter = Math.max(diameter, left + right);
		return Math.max(left, right) + 1;
	}
}
