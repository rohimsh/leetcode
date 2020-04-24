package com.leetcode.solutions.challenges.leetcoding30day.week2;

import java.util.Arrays;

public class MiddleOfLinkedList {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
 }
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		printLinkedList(middleNode(head));
	}

	public static ListNode middleNode(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy, fast = dummy;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return fast == null ? slow : slow.next;
	}

	public static void printLinkedList(ListNode node){
		while(node != null){
			System.out.print("node = " + node);
			node = node.next;
		}
	}

}
