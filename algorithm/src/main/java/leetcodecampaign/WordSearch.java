package leetcodecampaign;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch {

    private Set<String> ans = new HashSet<>();

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
                backTrace(board, trie, visited, "", i, j);
            }
        }

        return new ArrayList<>(ans);
    }

    private void backTrace(char[][] board, Trie trie, boolean[][] visited, String word, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        word += board[i][j];
        if (!trie.startsWith(word)) {
            return;
        }
        if (trie.search(word)) {
            ans.add(word);
        }

        visited[i][j] = true;
        backTrace(board, trie, visited, word, i + 1, j);
        backTrace(board, trie, visited, word, i - 1, j);
        backTrace(board, trie, visited, word, i, j + 1);
        backTrace(board, trie, visited, word, i, j - 1);
        visited[i][j] = false;
    }
}
