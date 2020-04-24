package com.leetcode.solutions.challenges.leetcoding30day.week1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	private static Set<Integer> loop = new HashSet<>();

	public static void main(String[] args) {
		System.out.println(isHappy(19));
	}

	public static boolean isHappy(int n) {
		loop.add(1);
		while(!loop.contains(n)){
			loop.add(n);
			n = sumOfDigits(n);
			// System.out.println(n);
		}
		return n == 1;
	}

	public static int sumOfDigits(int n ){
		int result = 0;
		while(n != 0){
			int num = n % 10;
			n = n/10;
			result += num * num;
		}
		return result;
	}


}
