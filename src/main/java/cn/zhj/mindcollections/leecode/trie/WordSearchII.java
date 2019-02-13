package cn.zhj.mindcollections.leecode.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/word-search-ii/
 *
 * Created by zhaohongjie on 2019/2/13.
 */
public class WordSearchII {

    /**
     * 这里用List是有问题的，当输入为 new char[][]{{'a', 'a'}}, new String[]{"a"}
     *
     */
    Set<String> result = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {

        if (board == null || board.length <= 0) {
            return new ArrayList<>();
        }

        if (words == null || words.length <= 0) {
            return new ArrayList<>();
        }

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, "", i, j, trie);
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, boolean[][] visited, String str, int x, int y, Trie trie) {

        // 越界
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }

        // 访问过的
        if (visited[x][y]) {
            return;
        }

        str += board[x][y];
        if (!trie.startsWith(str)) {
            return;
        }

        if (trie.search(str)) {
            result.add(str);
        }
        visited[x][y] = true;
        dfs(board, visited, str, x + 1, y, trie);
        dfs(board, visited, str, x - 1, y, trie);
        dfs(board, visited, str, x, y + 1, trie);
        dfs(board, visited, str, x, y - 1, trie);
        visited[x][y] = false;
    }

    public static void main(String[] args) {
        WordSearchII wordSearchII = new WordSearchII();
        List<String> words = wordSearchII.findWords(new char[][]{{'a', 'a'}}, new String[]{"a"});

        words.forEach(c -> System.out.println(c));
    }
}
