package com.leetcode.solutions.challenges.leetcoding30day.week1;

import java.util.HashMap;
import java.util.Map;

public class CountingElements {
	public static void main(String[] args) {
		System.out.println(countElements(new int[]{1,1,3,3,5,5,7,7}));
	}

	public static int countElements(int[] arr) {
		final Map<Integer, Integer> map = new HashMap<>();
		for (int value : arr) {
			map.putIfAbsent(value, 0);
			map.put(value, map.get(value) + 1);
		}
		int result = 0;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			int key = entry.getKey();
			if(key != Integer.MAX_VALUE && map.containsKey(key + 1)){
				result += entry.getValue();
			}
		}
		return result;
	}

}
