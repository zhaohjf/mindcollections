package cn.zhj.mindcollections.leecode.trie;

/**
 * Created by zhaohongjie on 2019/2/12.
 */
public class TrieNode {

    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];

    public TrieNode() {

    }

    TrieNode(char c) {
        this.val = c;
    }
}
