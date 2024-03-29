package com.alg.twoPointers;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringNoRepeating {
    /**
     * Runtime: 12 ms, faster than 54.10% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 46.2 MB, less than 26.33% of Java online submissions for Longest Substring Without Repeating Characters.
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> dictionarySet = new HashSet<>();
        int MAX = 0;
        if(s.length() == 0 || s.length() == 1) return s.length();

        int left = 0, right = 0;
        while (right < s.length()) {
            // If the new char on right is not in set, add to set and count++
            if (!dictionarySet.contains(s.charAt(right)) || left == right) {
                dictionarySet.add(s.charAt(right));
//                System.out.println("+" + s.charAt(right)+ " at " + right);
                right++;
            } else {
                // If the new char on right is already in the set, move the pointer on left till no duplicated characters in the sub string
                int size = dictionarySet.size();
                MAX = Math.max(size, MAX); // If current size is bigger than previous MAX, replace the MAX size
                while(left < right && dictionarySet.contains(s.charAt(right))) {
                    dictionarySet.remove(s.charAt(left));
//                    System.out.println("-" + s.charAt(left)+ " on " + left);
                    left++;
                }
                dictionarySet.add(s.charAt(right));// When finished removing the duplicated Char(with right pointer) from substring by moving left pointer, add the char on right pointer
                right++;
//                System.out.println("+" + s.charAt(right) + " on " + right);
            }
        }
        int size = dictionarySet.size();
        MAX = Math.max(size, MAX);

        return MAX;
    }

    /**
     * Tried to write again in 2022-03-14
     * Runtime: 13 ms, faster than 47.57% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 45.5 MB, less than 34.28% of Java online submissions for Longest Substring Without Repeating Characters.
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        Set<Character> windowSet = new HashSet<>();
        int l = 0;
        int r = 0;
        int max = 0;
        while(l <= r && r < s.length()) {
            while(r < s.length() && !windowSet.contains(s.charAt(r))) {
                windowSet.add(s.charAt(r));
                max = max < windowSet.size() ? windowSet.size() : max;
                r++;
            }
            windowSet.remove(s.charAt(l));
            l++;
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubStringNoRepeating solution = new LongestSubStringNoRepeating();
        String str = new String("ab");// 2
        String str_1 = "abac";//3
        String str_2 = "";// 0
        String str_3 = "abcabcabc";// 3
        String str_4 = "gssfvrv";// 4
        System.out.println(solution.lengthOfLongestSubstring(str));
        System.out.println(solution.lengthOfLongestSubstring(str_1));
        System.out.println(solution.lengthOfLongestSubstring(str_2));
        System.out.println(solution.lengthOfLongestSubstring(str_3));
        System.out.println(solution.lengthOfLongestSubstring(str_4));

    }
}
