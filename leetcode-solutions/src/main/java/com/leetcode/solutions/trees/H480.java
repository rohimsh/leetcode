package com.leetcode.solutions.trees;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Supplier;

/**
 * Question: https://leetcode.com/problems/sliding-window-median
 * Crude Solution: https://leetcode.com/submissions/detail/323653632/
 * Alternate Solution: https://leetcode.com/problems/sliding-window-median/discuss/96346/Java-using-two-Tree-Sets-O(n-logk)
 */
public class H480 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
	}

	public static double[] medianSlidingWindow(int[] nums, int k) {
		double[] medians = new double[nums.length - k + 1];
		Comparator<Integer> comparator = (x, y) -> {
			if(nums[x] == nums[y])
				return x - y;
			return Integer.compare(nums[x], nums[y]);
		};
		TreeSet<Integer> max = new TreeSet<>(comparator);
		TreeSet<Integer> min = new TreeSet<>(comparator.reversed());

		Supplier<Double> medianSupplier = () -> {
			if(min.size() == max.size()){
				return ((double) nums[min.first()] + nums[max.first()]) / 2;
			} else
				return (double)nums[min.first()];
		};

		Runnable treeBalance = () -> {
			while(max.size() > min.size())
				min.add(max.pollFirst());
		};

		int medianIndex = 0;
		for(int i = 0; i < k; i++){
			max.add(i);
		}
		treeBalance.run();
		medians[medianIndex++] = medianSupplier.get();

		for(int i = k; i < nums.length; i++){
			if(!min.remove(i - k))
				max.remove(i - k);
			min.add(i);
			max.add(min.pollFirst());
			treeBalance.run();
			medians[medianIndex++] = medianSupplier.get();
		}
		return medians;
	}
}
