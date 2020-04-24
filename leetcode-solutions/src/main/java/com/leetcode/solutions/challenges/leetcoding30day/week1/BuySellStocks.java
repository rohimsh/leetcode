package com.leetcode.solutions.challenges.leetcoding30day.week1;


import java.util.Stack;

public class BuySellStocks {

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
	}

	public static int maxProfit(int[] prices) {
		int profit = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int price : prices) {
			if (stack.isEmpty() || stack.peek() > price) {
				stack.push(price);
			} else if (stack.peek() < price) {
				profit += price - stack.pop();
				stack.push(price);
			}
		}
		return profit;
	}
}
