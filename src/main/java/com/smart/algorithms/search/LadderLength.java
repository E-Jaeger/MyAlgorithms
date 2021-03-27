package com.smart.algorithms.search;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-ladder/
 * 单词接龙
 */
public class LadderLength {

    /**
     * 单向bfs
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //存入set提高效率
        HashSet<String> wordSet = new HashSet<String>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        //bfs节点队列
        Deque<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        //记录单词对应路径长度
        HashMap<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        //bfs
        while (!queue.isEmpty()) {
            String word = queue.poll();
            Integer path = map.get(word);
            //一个一个的更改单词的字母，如果后面的单词中有这个更改过的单词，说明这个单词可以被连接
            char[] chars = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                char originChar = chars[i];
                for (char k = 'a'; k <= 'z'; k++) {
                    if (originChar == k) {
                        continue;
                    }
                    chars[i] = k;
                    String newWord = new String(chars);
                    if (newWord.equals(endWord)) {
                        return path + 1;
                    }
                    if (wordSet.contains(newWord) && !map.containsKey(newWord)) {
                        map.put(newWord, path + 1);
                        queue.offer(newWord);
                    }
                }
                chars[i] = originChar;
            }
        }
        return 0;
    }

    /**
     * 双向bfs
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength2(String beginWord, String endWord, List<String> wordList){

        // 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }

        // 第 2 步：已经访问过的 word 添加到 visited 哈希表里
        Set<String> visited = new HashSet<>();
        // 分别用左边和右边扩散的哈希表代替单向 BFS 里的队列，它们在双向 BFS 的过程中交替使用
        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);

        // 第 3 步：执行双向 BFS，左右交替扩散的步数之和为所求
        int step = 1;
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            // 优先选择小的哈希表进行扩散，考虑到的情况更少
            if (beginVisited.size() > endVisited.size()) {
                Set<String> tmp = beginVisited;
                beginVisited = endVisited;
                endVisited = tmp;
            }
            // 逻辑到这里，保证 beginVisited 是相对较小的集合，nextLevelVisited 在扩散完成以后，会成为新的 beginVisited
            Set<String> nextLevelVisited = new HashSet<>();
            for (String word : beginVisited) {
                if (changeWordEveryOneLetter(word, endVisited, visited, wordSet, nextLevelVisited)) {
                    return step + 1;
                }
            }
            // 原来的 beginVisited 废弃，从 nextLevelVisited 开始新的双向 BFS
            beginVisited = nextLevelVisited;
            step++;
        }
        return 0;
    }

    /**
     * 尝试对 word 修改每一个字符，看看是不是能落在 endVisited 中，扩展得到的新的 word 添加到 nextLevelVisited 里
     * @param word
     * @param endVisited
     * @param visited
     * @param wordSet
     * @param nextLevelVisited
     * @return
     */
    private static boolean changeWordEveryOneLetter(String word,
                                                    Set<String> endVisited,
                                                    Set<String> visited,
                                                    Set<String> wordSet,
                                                    Set<String> nextLevelVisited) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char originalChar = chars[i];
            for (char k = 'a'; k <= 'z'; k++) {
                if (chars[i] == k) {
                    continue;
                }
                chars[i] = k;
                String newWord = new String(chars);
                if (wordSet.contains(newWord)) {
                    if (endVisited.contains(newWord)) {
                        return true;
                    }
                    if (!visited.contains(newWord)) {
                        visited.add(newWord);
                        nextLevelVisited.add(newWord);
                    }
                }
            }
            chars[i] = originalChar;
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int i = ladderLength2("hit", "cog", list);
        System.out.println(i);
    }
}
