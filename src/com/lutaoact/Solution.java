package com.lutaoact;

import java.util.HashMap;

public class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length == 0) return "";

        char[] chars = s.toCharArray();
        boolean[][] flags = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= i; j--) {
                flags[i][j] = true;
                for (int m = i, n = j; m <= n; m++, n--) {
                    if (chars[m] != chars[n]) {
                        flags[i][j] = false;
                        break;
                    }
                }
            }
        }
        int maxLength = 0;
        int beginIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (flags[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    beginIndex = i;
                    endIndex = j + 1;
                }
            }
        }
        return s.substring(beginIndex, endIndex);
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int start = 0;
        boolean[] flags = new boolean[256];
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];
            if (flags[current]) {
                maxLength = Math.max(i - start, maxLength);
                for (int k = start; k < i; k++) {
                    if (chars[k] == current) {
                        start = k + 1;
                        break;
                    }
                    flags[chars[k]] = false;
                }
            } else {
                flags[current] = true;
            }
        }

        maxLength = Math.max(maxLength, chars.length - start);
        return maxLength;
    }

//    public int lengthOfLongestSubstring(String s) {
//        int maxLength = 0;
//        String[] strings = s.split("");
//        HashMap<String, Integer> map = new HashMap<String, Integer>();
//        for (int i = 0; i < strings.length; i++) {
//            if (map.containsKey(strings[i])) {
//                if (map.size() > maxLength) {
//                    maxLength = map.size();
//                }
//                i = map.get(strings[i]); //from next value
//                map.clear();
//            } else {
//                map.put(strings[i], i);
//            }
//        }
//        if (map.size() > maxLength) {
//            maxLength = map.size();
//        }
//        return maxLength;
//    }

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
