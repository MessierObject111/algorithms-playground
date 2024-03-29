package com.alg.list;

/**
 * We have some permutation A of [0, 1, ..., N - 1], where N is the length of A.
 *
 * The number of (global) inversions is the number of i < j with 0 <= i < j < N and A[i] > A[j].
 *
 * The number of local inversions is the number of i with 0 <= i < N and A[i] > A[i+1].
 *
 * Return true if and only if the number of global inversions is equal to the number of local inversions.
 *
 * Example 1:
 *
 * Input: A = [1,0,2]
 * Output: true
 * Explanation: There is 1 global inversion, and 1 local inversion.
 * Example 2:
 *
 * Input: A = [1,2,0]
 * Output: false
 * Explanation: There are 2 global inversions, and 1 local inversion.
 * Note:
 *
 * A will be a permutation of [0, 1, ..., A.length - 1].
 * A will have length in range [1, 5000].
 * The time limit for this problem has been reduced.
 */
public class GlobalAndLocalInversions {
    public boolean isIdealPermutation(int[] A) {
        if(A.length <= 1) return true;
        int globalCount = 0;
        int localCount = 0;
        for(int i = 0; i < A.length - 1; i++) {
            if(A[i] > A[i+1]) localCount++;
            for(int j = i+1; j < A.length; j++){
                if(A[i] > A[j]) {
                    globalCount++;
                }
            }
        }
        boolean result = globalCount == localCount;
        return result;
    }

    public static void main(String[] args) {
        int[] case_1 = {0};
        int[] case_2 = {1,0,2};
        int[] case_3 = {1,2,0};
        GlobalAndLocalInversions sol = new GlobalAndLocalInversions();
        System.out.println(sol.isIdealPermutation(case_1));
        System.out.println(sol.isIdealPermutation(case_2));
        System.out.println(sol.isIdealPermutation(case_3));
    }
}
