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
        ListNode result = new ListNode(l1.val + l2.val);
        return result;
    }
}
