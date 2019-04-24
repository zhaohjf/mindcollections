package alg.zhj.mindcollections.leecode.trie;

/**
 * https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/
 *
 * Created by zhaohongjie on 2019/2/13.
 */
public class WordDictionary {

    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode(' ');
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode ws = root;
        for (char c : word.toCharArray()) {
            if (ws.children[c - 'a'] == null) {
                ws.children[c - 'a'] = new TrieNode(c);
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    /**
     * Returns if the word is in the data structure.
     * A word could contain the dot character '.' to represent any one letter.
     *
     **/
    public boolean search(String word) {
        TrieNode ws = root;
        return search_dfs(word.toCharArray(), ws, 0);
    }

    private boolean search_dfs(char[] words, TrieNode node, int index) {

        if (index == words.length) {
            return node.isWord;
        }

        char c = words[index];
        if ('.' != c) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            return search_dfs(words, node.children[c - 'a'], index + 1);
        } else {
            for (TrieNode nextNode : node.children) {
                if (nextNode != null && search_dfs(words, nextNode, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class TrieNode {

        public char val;
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];

        public TrieNode() {

        }

        TrieNode(char c) {
            this.val = c;
        }
    }


    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }
}
