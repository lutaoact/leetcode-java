package com.lutaoact;

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] indexes = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                Integer index = map.get(numbers[i]);
                indexes[0] = index + 1;
                indexes[1] = i + 1;
                return indexes;
            } else {
                map.put(target - numbers[i], i);
            }
        }
        return indexes;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode((l1.val + l2.val) % 10);
        ListNode result = node;

        int carry = (l1.val + l2.val) / 10;
        ListNode l1Current = l1.next;
        ListNode l2Current = l2.next;
        while (l1Current != null || l2Current != null) {
            if (l1Current == null) {
                node.next = new ListNode((l2Current.val + carry) % 10);
                node = node.next;
                carry = (l2Current.val + carry) / 10;
                l2Current = l2Current.next;
            } else if (l2Current == null) {
                node.next = new ListNode((l1Current.val + carry) % 10);
                node = node.next;
                carry = (l1Current.val + carry) / 10;
                l1Current = l1Current.next;
            } else {
                node.next = new ListNode((l1Current.val + l2Current.val + carry) % 10);
                node = node.next;
                carry = (l1Current.val + l2Current.val + carry) / 10;
                l1Current = l1Current.next;
                l2Current = l2Current.next;
            }
        }
        if (carry > 0) {
            node.next = new ListNode(carry);
        }
        return result;
    }
    public ListNode copyList(ListNode listNode) {
        if (listNode == null) return null;

        ListNode node = new ListNode(listNode.val);
        ListNode result = node;

        ListNode current = listNode.next;
        while (current != null) {
            node.next = new ListNode(current.val);
            node = node.next;
            current = current.next;
        }
        return result;
    }
}
