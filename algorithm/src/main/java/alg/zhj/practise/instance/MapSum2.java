package alg.zhj.practise.instance;

import java.util.HashMap;
import java.util.Map;

public class MapSum2 {

    class TrieNode {
        int val;
        TrieNode[] children = new TrieNode[26];
    }

    TrieNode root;
    Map<String, Integer> map;

    public MapSum2() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode node = root;
        for (char c : key.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
            node.val += delta;
        }
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return 0;
            }
            node = node.children[c - 'a'];
        }
        return node.val;
    }

    public static void main(String[] args) {
        MapSum2 mapSum = new MapSum2();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
//        System.out.println(mapSum.sum("ap"));
        mapSum.insert("apple", 2);
        System.out.println(mapSum.sum("ap"));
    }
}
