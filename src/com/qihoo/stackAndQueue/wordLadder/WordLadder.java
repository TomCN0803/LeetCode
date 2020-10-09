package com.qihoo.stackAndQueue.wordLadder;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String beginWord = "hit", endWord = "cog";
        String[] wordArr = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = Arrays.asList(wordArr);
        int res = solution.ladderLength(beginWord, endWord, wordList);
        System.out.println(res);
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0) return 0;
        Map<String, List<String>> patternMap = new HashMap<>();
        int wordLen = beginWord.length();
        wordList.forEach((word) -> {
            for (int i = 0; i < wordLen; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1, wordLen);
                if (!patternMap.containsKey(pattern)) {
                    patternMap.put(pattern, new LinkedList<>());
                }
                patternMap.get(pattern).add(word);
            }
        });

        Map<String, Boolean> visited = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        int level = 1;
        queue.offer(beginWord);
        visited.put(beginWord, true);
        while (!queue.isEmpty()) {
            int qLen = queue.size();
            level++;
            for (int n = 0; n < qLen; n++) {
                String word = queue.poll();
                assert word != null;
                for (int i = 0; i < wordLen; i++) {
                    String wordPattern = word.substring(0, i) + "*" + word.substring(i + 1, wordLen);
                    List<String> patternList = patternMap.get(wordPattern);
                    if (patternList == null) continue;
                    for (String w : patternList) {
                        if (w.equals(endWord)) {
                            return level;
                        }
                        if (!visited.containsKey(w)) {
                            queue.add(w);
                            visited.put(w, true);
                        }
                    }
                }
            }
        }

        return 0;
    }
}
