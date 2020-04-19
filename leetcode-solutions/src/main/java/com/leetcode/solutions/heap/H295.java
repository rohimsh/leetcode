package com.leetcode.solutions.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Question: https://leetcode.com/problems/find-median-from-data-stream/
 * My Solution: https://leetcode.com/submissions/detail/323109208/
 * Alternate Solution: https://leetcode.com/problems/find-median-from-data-stream/discuss/74062/Short-simple-JavaC%2B%2BPython-O(log-n)-%2B-O(1)
 */
public class H295 {
	private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
	private final PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());

	public void addNum(int num) {
		if(maxHeap.isEmpty() && minHeap.isEmpty()){
			minHeap.add(num);
		} else if(maxHeap.size() > minHeap.size()){
			if(maxHeap.peek() > num){
				minHeap.add(num);
			} else {
				minHeap.add(maxHeap.poll());
				maxHeap.add(num);
			}
		} else {
			if(minHeap.peek() < num){
				maxHeap.add(num);
			} else {
				maxHeap.add(minHeap.poll());
				minHeap.add(num);
			}
		}
	}

	public double findMedian() {
		if(maxHeap.isEmpty() || minHeap.isEmpty()){
			return Integer.MIN_VALUE;
		}
		if(maxHeap.size() == minHeap.size()){
			return (maxHeap.peek() + minHeap.peek())/2.0;
		} else {
			return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
		}
	}

}
