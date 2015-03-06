package com.lutaoact;

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int[] indexes = new int[2];
    	
    	for (int i = 0; i < numbers.length; i++) {
    		map.put(numbers[i], i);
    	}
    	for (int i = 0; i < numbers.length; i++) {
    		Integer index = map.get(target - numbers[i]);
    		if (index != null && index != i) {
    			indexes[0] = i + 1;
    			indexes[1] = index + 1;
    			return indexes;
    		}
    	}
        return indexes;
    }
}