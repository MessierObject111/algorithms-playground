package com.alg.other;

/*
You are given a list of preferences for n friends, where n is always even.

For each person i, preferences[i] contains a list of friends sorted in the order of preference. In other words, a friend
 earlier in the list is more preferred than a friend later in the list. Friends in each list are denoted by integers
 from 0 to n-1.

All the friends are divided into pairs. The pairings are given in a list pairs, where pairs[i] = [xi, yi] denotes xi is
paired with yi and yi is paired with xi.

However, this pairing may cause some of the friends to be unhappy. A friend x is unhappy if x is paired with y and there
 exists a friend u who is paired with v but:

x prefers u over y, and
u prefers x over v.
Return the number of unhappy friends.



Example 1:

Input: n = 4, preferences = [[1, 2, 3], [3, 2, 0], [3, 1, 0], [1, 2, 0]], pairs = [[0, 1], [2, 3]]
Output: 2
Explanation:
Friend 1 is unhappy because:
- 1 is paired with 0 but prefers 3 over 0, and
- 3 prefers 1 over 2.
Friend 3 is unhappy because:
- 3 is paired with 2 but prefers 1 over 2, and
- 1 prefers 3 over 0.
Friends 0 and 2 are happy.
Example 2:

Input: n = 2, preferences = [[1], [0]], pairs = [[1, 0]]
Output: 0
Explanation: Both friends 0 and 1 are happy.
Example 3:

Input: n = 4, preferences = [[1, 3, 2], [2, 3, 0], [1, 3, 0], [0, 2, 1]], pairs = [[1, 3], [0, 2]]
Output: 4


Constraints:

2 <= n <= 500
n is even.
preferences.length == n
preferences[i].length == n - 1
0 <= preferences[i][j] <= n - 1
preferences[i] does not contain i.
All values in preferences[i] are unique.
pairs.length == n/2
pairs[i].length == 2
xi != yi
0 <= xi, yi <= n - 1
Each person is contained in exactly one pair.

 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnhappyFriends {
    /**
     * Analysis:
     * input: x
     * xPref: [... u, y, ...]
     * uPref: [... x, v, ...]
     * groups [x, y], [u, v] ->
     *  xPref(u) < xPref(y) &&
     *  uPref(x) < uPref(v)
     * Which translates to brute force solution:
     * start with [x, -], x, we check x's teammate pair y's rank in xPref
     * Then, if xPref(y) isn't 0, check all the person whose xPref() values that is higher (meaning xPref(...)<xPref(y))
     * and their pair mates. Say in this loop, we have this person named i. If they got assigned with a mate j which
     * iPref(x) < iPref(j), both x and y are unhappy.
     * @param n
     * @param preferences
     * @param pairs
     * @return
     */
    private Set<Integer> unhappySet = new HashSet<>();

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int numOfPairs = pairs.length;
        for(int i = 0; i < numOfPairs; i++) {
            int x = pairs[i][0];
            int y = pairs[i][1];
            int[] prefList_x = preferences[x];
            int[] prefList_y = preferences[y];
            int xRankY = getIndexByValue(prefList_x, y);
            int yRankX = getIndexByValue(prefList_y, x);

            for(int j = 0; j < xRankY; j++) {
                int friend = prefList_x[j];
                int pair = findPair(friend, pairs);
                int[] friendPref = preferences[friend];
                boolean isUnhappy = checkUnhappy(x, friend, pair, friendPref);
                if(isUnhappy) {
                    unhappySet.add(x);
                    unhappySet.add(friend);
                }
            }

            for(int j = 0; j < yRankX; j++) {
                int friend = prefList_y[j];
                int pair = findPair(friend, pairs);
                int[] friendPref = preferences[friend];
                boolean isUnhappy = checkUnhappy(y, friend, pair, friendPref);
                if(isUnhappy) {
                    unhappySet.add(x);
                    unhappySet.add(friend);
                }
            }
        }
        return unhappySet.size();
    }

//    private void check (int rank, ) {
//        for(int j = 0; j < xRankY; j++) {
//            int friend = prefList_x[j];
//            int pair = findPair(friend, pairs);
//            int[] friendPref = preferences[friend];
//            boolean isUnhappy = checkUnhappy(x, friend, pair, friendPref);
//            if(isUnhappy) {
//                unhappySet.add(x);
//                unhappySet.add(friend);
//            }
//        }
//    }

    private int getIndexByValue(int[] prefList, int personIndex) {
        int index = 0;
        while(prefList[index] != personIndex) index++;
        return index;
    }

    private int findPair(int index, int[][] pairs) {
        int size = pairs.length;
        int result = 0;
        for(int i = 0; i< size; i++) {
            int[] pair = pairs[i];
            if(pair[0] == index) {
                result = pair[1];
                break;
            }
            if(pair[1] == index) {
                result = pair[0];
                break;
            }
        }
        return result;
    }

    private boolean checkUnhappy(int x, int friend, int pair, int[] friendPref) {
        int friendRankOfX = getIndexByValue(friendPref, x);
        int friendRankOfPair = getIndexByValue(friendPref, pair);
        if (friendRankOfX < friendRankOfPair) {
            return true; // If x has higher preference, then x and friend are not happy
        }
        return false;//Else, they are 'happy' so far
    }

    public static void main(String[] args) {
        UnhappyFriends s = new UnhappyFriends();
        int size = 4;
        int[][] preferences = {{1,2,3},{3,2,0},{3,1,0},{1,2,0}};
        int[][] pairs = {{0,1},{2,3}};
        int num = s.unhappyFriends(size, preferences, pairs);
        System.out.println(num);
    }
}