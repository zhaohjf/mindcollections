package alg.zhj.campaign.week04.src;

import java.util.*;

/**
 * Created by zhaohongjie on 2020/7/1.
 */
public class LadderLength_II_127 {

    private int L;
    private Map<String, List<String>> allComboDict;

    public LadderLength_II_127() {
        this.L = 0;
        this.allComboDict = new HashMap<>();
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        this.L = beginWord.length();
        wordList.forEach(word -> {
            for (int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, L);
                List<String> transformations = this.allComboDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                this.allComboDict.put(newWord, transformations);
            }
        });

        Queue<Pair> queue_begin = new LinkedList<>();
        Queue<Pair> queue_end = new LinkedList<>();
        queue_begin.add(new Pair(beginWord, 1));
        queue_end.add(new Pair(endWord, 1));

        Map<String, Integer> visitedBegin = new HashMap<>();
        Map<String, Integer> visitedEnd = new HashMap<>();
        visitedBegin.put(beginWord, 1);
        visitedEnd.put(endWord, 1);

        while (!queue_begin.isEmpty() && !queue_end.isEmpty()) {
            int ans = visitWordNode(queue_begin, visitedBegin, visitedEnd);
            if (ans > -1) {
                return ans;
            }
            ans = visitWordNode(queue_end, visitedEnd, visitedBegin);
            if (ans > -1) {
                return ans;
            }
        }
        return 0;
    }

    private int visitWordNode(
            Queue<Pair> Q,
            Map<String, Integer> visited,
            Map<String, Integer> othersVisited) {
        Pair node = Q.poll();
        String word = node.getKey();
        Integer level = node.getValue();

        for (int i = 0; i < this.L; i++) {
            String newWord = word.substring(0, i) + "*" + word.substring(i + 1, L);
            for (String adjacentWord : this.allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                if (othersVisited.containsKey(adjacentWord)) {
                    return level + othersVisited.get(adjacentWord);
                }
                if (!visited.containsKey(adjacentWord)) {
                    visited.put(adjacentWord, level + 1);
                    Q.offer(new Pair(adjacentWord, level + 1));
                }
            }
        }
        return -1;
    }


    static class Pair {

        private final String key;

        private final Integer value;

        public Pair(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }
    }
}
