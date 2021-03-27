package com.smart.algorithms.search;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-ladder-ii/
 *单词接龙 II
 */
public class FindLadders {

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);
        LinkedList<String> tmp = new LinkedList<>();
        tmp.add(beginWord);
        //bfs
        if (bfs(wordSet, beginVisited, endVisited, map, true)) {
            //dfs
            dfs(res, beginWord, endWord, map, tmp);
        }
        return res;
    }

    private static void dfs(List<List<String>> res, String beginWord, String endWord, Map<String, List<String>> map, LinkedList<String> path) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        List<String> words = map.getOrDefault(beginWord, new ArrayList<>());
        for (String word : words) {
            path.addLast(word);
            dfs(res, word, endWord, map, path);
            path.removeLast();
        }
    }


    //双向bfs
    private static boolean bfs(Set<String> wordSet, Set<String> beginVisited, Set<String> endVisited, Map<String, List<String>> map, boolean isFront) {
        if (beginVisited.size() == 0) {
            return false;
        }
        if (beginVisited.size() > endVisited.size()) {
            return bfs(wordSet, endVisited, beginVisited, map, !isFront);
        }
        wordSet.removeAll(beginVisited);
        boolean isMeet = false;
        Set<String> nextLevel = new HashSet<>();
        for (String word : beginVisited) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                char tmp = chars[i];
                for (char k = 'a'; k <= 'z'; k++) {
                    if (tmp == k) {
                        continue;
                    }
                    chars[i] = k;
                    String newWord = new String(chars);
                    if (wordSet.contains(newWord)) {
                        nextLevel.add(newWord);
                        String key = isFront ? word : newWord;
                        String nextWord = isFront ? newWord : word;
                        if (endVisited.contains(newWord)) {
                            isMeet = true;
                        }
                        if (!map.containsKey(key)) {
                            map.put(key, new ArrayList<>());
                        }
                        map.get(key).add(nextWord);
                    }
                }
                chars[i] = tmp;
            }
        }
        if (isMeet) {
            return true;
        }
        return bfs(wordSet, nextLevel, endVisited, map, isFront);
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye");
        List<List<String>> ladders = findLadders("qa", "sq", list);
        System.out.println(ladders);
    }
}
