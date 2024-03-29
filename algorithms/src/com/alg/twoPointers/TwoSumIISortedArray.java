package com.alg.twoPointers;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a
 * specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must
 * be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * Example
 * Example 1:
 *
 * Input: nums = [2, 7, 11, 15], target = 9
 * Output: [1, 2]
 * Example 2:
 *
 * Input: nums = [2,3], target = 5
 * Output: [1, 2]
 * Notice
 * You may assume that each input would have exactly one solution.
 */
public class TwoSumIISortedArray {
    /**
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    results[0] = i + 1;
                    results[1] = j + 1;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 22;
        TwoSumIISortedArray ins = new TwoSumIISortedArray();
        int[] result = ins.twoSum(numbers, target);
        for(int num : result) {
            System.out.println(num);
        }
    }
}
