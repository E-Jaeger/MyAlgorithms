package com.smart.algorithms.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/minimum-height-trees/
 * 最小高度树
 */
public class FindMinHeightTrees {

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        //各个节点的度
        int[] degree = new int[n];
        //邻接表
        List<List<Integer>> adjacent = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjacent.add(new ArrayList<>());
        }
        //构建邻接表和各个节点的度
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            adjacent.get(edge[0]).add(edge[1]);
            adjacent.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        //一度节点入队
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        int residue = n;
        //单独处理只有一个节点的情况
        if (residue == 1) {
            ans.add(0);
        }
        //剩余的节点不是一个或两个,将叶子节点(度为1)一层一层剥离,最后暴露出来的就是根
        //最后的根节点只可能是一个或者两个
        while (residue != 1 && residue != 2) {
            int size = queue.size();
            residue -= size;
            for (int i = 0; i < size; i++) {
                Integer cur = queue.poll();
                for (Integer node : adjacent.get(cur)) {
                    if (degree[node] > 0) {
                        degree[node]--;
                    }
                    if (degree[node] == 1) {
                        queue.offer(node);
                    }
                }
            }
        }
        //队列中最后剩下的就是根
        while (!queue.isEmpty()) {
            ans.add(queue.poll());
        }
        return ans;
    }

    public static List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        int[] degree = new int[n];
        List<List<Integer>> adjacent = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacent.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            adjacent.get(edge[0]).add(edge[1]);
            adjacent.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            res = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer cur = queue.poll();
                res.add(cur);
                List<Integer> neighbors = adjacent.get(cur);
                for (Integer neighbor : neighbors) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> minHeightTrees = findMinHeightTrees2(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}});
        System.out.println(minHeightTrees);
    }
}
