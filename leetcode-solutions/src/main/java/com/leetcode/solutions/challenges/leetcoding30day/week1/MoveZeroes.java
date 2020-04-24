package com.leetcode.solutions.challenges.leetcoding30day.week1;

import java.util.Arrays;

public class MoveZeroes {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(moveZeroes(new int[]{0, 1, 0, 3, 12})));
	}

	public static int[] moveZeroes(int[] nums) {
		int i = 0,  cursorNonZero = i;
		while(i < nums.length){
			if(nums[i] == 0){
				cursorNonZero = getNonZero(Math.max(cursorNonZero, i), nums);
				nums[i] = nums[cursorNonZero];
				nums[cursorNonZero] = 0;
			}
			i++;
		}
		return nums;
	}

	public static int getNonZero(int index, int[] nums){
		for(int i = index; i < nums.length; i++){
			if(nums[i] != 0){
				return i;
			}
		}
		return nums.length - 1;
	}
}
