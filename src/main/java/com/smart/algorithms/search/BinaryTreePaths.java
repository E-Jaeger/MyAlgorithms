package com.smart.algorithms.search;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * 二叉树的所有路径
 */
public class BinaryTreePaths {

    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        dfs(root, res, "");
        return res;
    }

    private static void dfs(TreeNode root, List<String> res, String path) {
        if (root != null) {
            StringBuilder str = new StringBuilder(path);
            str.append(root.val);
            if (root.left == null && root.right == null) {
                res.add(str.toString());
            } else {
                str.append("->");
                dfs(root.left, res, str.toString());
                dfs(root.right, res, str.toString());
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n5 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n2.right = n5;
        root.right = n3;
        root.left = n2;

        List<String> strings = binaryTreePaths(root);
        System.out.println(strings);
    }
}



