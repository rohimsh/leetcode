package com.leetcode.solutions.challenges.leetcoding30day.week1;

import java.util.Arrays;

public class MaximumSubarray {
	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));;
	}

	public static int maxSubArray(int[] nums) {
		int sumSoFar = nums[0];
		int maxSum = nums[0];

		for(int i = 1; i < nums.length; i++){
			if(nums[i] + sumSoFar > nums[i]){
				sumSoFar += nums[i];
			} else {
				sumSoFar = nums[i];
			}
			maxSum = Math.max(sumSoFar, maxSum);
		}
		return maxSum;
	}
}
