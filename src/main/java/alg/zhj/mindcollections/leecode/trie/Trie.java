package alg.zhj.mindcollections.leecode.trie;

/**
 * Created by zhaohongjie on 2019/2/12.
 */
public class Trie {

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode ws = root;
        for (char c : word.toCharArray()) {
            if (ws.children[c - 'a'] == null) {
                ws.children[c - 'a'] = new TrieNode(c);
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode ws = root;
        for (char c : word.toCharArray()) {
            if (ws.children[c - 'a'] == null) {
                return false;
            }
            ws = ws.children[c - 'a'];
        }

        return ws.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for (char c : prefix.toCharArray()) {
            if (ws.children[c - 'a'] == null) {
                return false;
            }
            ws = ws.children[c - 'a'];
        }

        return true;
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
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 true
    }

}
