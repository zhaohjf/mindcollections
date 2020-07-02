package alg.zhj.campaign.week04.src;

import alg.zhj.mindcollections.interview.linkedlist.IntersectionNode;

import java.util.*;

/**
 * Created by zhaohongjie on 2020/7/1.
 */
public class LadderLength_127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Since all words are of same length.
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        Map<String, List<String>> allComboDict = new HashMap<>();

        wordList.forEach(word -> {
            for (int i = 0; i < L; i++) {
                // Key is the generic word
                // Value is a list of words which have the same intermediate generic word.
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, L);
                List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                allComboDict.put(newWord, transformations);
            }
        });

        // Queue for BFS
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));

        // visited to make sure we don't repeat processing the same word.
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!queue.isEmpty()) {
            Pair node = queue.poll();
            String word = node.getKey();
            Integer level = node.getValue();
            for (int i = 0; i < L; i++) {
                // Intermediate words for current word
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, L);
                // next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // Otherwise, add it to the BFS Queue. Also mark is visited.
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        queue.offer(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }
        return 0;
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
