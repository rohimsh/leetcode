package com.leetcode.solutions.challenges.leetcoding30day.week2;

import java.util.Arrays;
import java.util.Stack;

public class BackspaceStringCompare {
	public static void main(String[] args) {
		System.out.println(backspaceCompare("ab#c", "ad#c"));
	}

	public static boolean backspaceCompare(String S, String T) {
		Stack<Character> stackS = new Stack<>();
		Stack<Character> stackT = new Stack<>();

		for(Character ch : S.toCharArray()){
			if('#' == ch){
				if(!stackS.isEmpty())
					stackS.pop();
			} else
				stackS.push(ch);
		}
		for(Character ch : T.toCharArray()){
			if('#' == ch){
				if(!stackT.isEmpty())
					stackT.pop();
			} else
				stackT.push(ch);
		}

		while(!stackS.isEmpty() && !stackT.isEmpty()){
			if(stackS.pop() != stackT.pop())
				return false;
		}
		return stackS.isEmpty() && stackT.isEmpty();
	}
}
