package com.leetcode.solutions.challenges.leetcoding30day.week2;

import java.util.Stack;

public class MinStack {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.push(10);
		obj.pop();
		System.out.println(obj.top());;
		System.out.println(obj.getMin());;
	}


	public MinStack() {
		stack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int x) {
		stack.push(x);
		if(minStack.isEmpty() || x <= minStack.peek())
			minStack.push(x);
	}

	public void pop() {
		if(top() == getMin()){
			minStack.pop();
		}
		stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}
