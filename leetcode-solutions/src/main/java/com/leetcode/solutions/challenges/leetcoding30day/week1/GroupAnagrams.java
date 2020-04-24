package com.leetcode.solutions.challenges.leetcoding30day.week1;

import java.util.*;

public class GroupAnagrams {
	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		final Map<String, List<String>> map = new HashMap<>();
		for(String str : strs){
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			String copy = new String(arr);
			map.putIfAbsent(copy, new ArrayList<>());
			map.get(copy).add(str);
		}
		return new ArrayList<>(map.values());
	}
}
