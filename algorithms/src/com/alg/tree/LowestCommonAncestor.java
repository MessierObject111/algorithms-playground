package com.alg.tree;

import com.alg.common.TreeNode;

/**
 * 88. Lowest Common Ancestor of a Binary Tree
 * Divide & Conquer
 *
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
 *
 * The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 * Example 1:
 *
 * Input：{1},1,1
 * Output：1
 * Explanation：
 *  For the following binary tree（only one node）:
 *          1
 *  LCA(1,1) = 1
 * Example 2:
 *
 * Input：{4,3,7,#,#,5,6},3,5
 * Output：4
 * Explanation：
 *  For the following binary tree:
 *
 *       4
 *      / \
 *     3   7
 *        / \
 *       5   6
 *
 *  LCA(3, 5) = 4
 */
public class LowestCommonAncestor {
    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        //Return A if the children of root contains A, return B if they contain B, returns null if none of them.
        if (root == null || root == A || root == B) {
            return root;
        }
        //Divide
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        //Conquer
        if(left != null && right != null) {
            return root;
        }
        if(left != null && right == null) {
            return left;
        }
        if(left == null & right != null) {
            return right;
        }
        return null;

    }

    public static void main(String[] args) {
        LowestCommonAncestor instance = new LowestCommonAncestor();

        TreeNode node_1 = new TreeNode(-1);
        TreeNode node_2 = new TreeNode(-2);
        TreeNode node_3 = new TreeNode(-3);
        TreeNode node_4 = new TreeNode(-4);
        TreeNode node_5 = new TreeNode(-5);
        TreeNode node_6 = new TreeNode(-6);
        TreeNode node_7 = new TreeNode(-7);
        TreeNode node_8 = new TreeNode(-8);
        TreeNode node_9 = new TreeNode(-9);
        TreeNode node_10 = new TreeNode(-10);
        TreeNode node_11 = new TreeNode(-11);
        TreeNode node_12 = new TreeNode(-12);
        TreeNode node_13 = new TreeNode(-13);
        TreeNode node_14 = new TreeNode(-14);
        TreeNode node_15 = new TreeNode(-15);
        TreeNode node_16 = new TreeNode(-16);

        node_1.left = node_2;
        node_1.right = node_3;
        node_2.left = node_4;
        node_2.right = node_5;
        node_3.left = node_6;
        node_3.right = node_7;
        node_4.left = node_8;
        node_4.right = node_9;
        node_5.left = node_10;
        node_5.right = node_11;
        node_6.left = node_12;
        node_6.right = node_13;
        node_7.left = node_14;
        node_7.right = node_15;
        node_8.left = node_16;
        System.out.println(instance.lowestCommonAncestor(node_1, node_5, node_7).val);
    }
}
