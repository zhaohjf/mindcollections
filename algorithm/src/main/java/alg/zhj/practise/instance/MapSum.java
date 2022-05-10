package alg.zhj.practise.instance;

import alg.zhj.campaign.week07.src.Trie;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/map-sum-pairs/
 */
public class MapSum {
    Map<String, Integer> map;
    Map<String, Integer> prefixMap;

    public MapSum() {
        map = new HashMap<>();
        prefixMap = new HashMap<>();
    }

    // 如果有相同键插入，旧键会被替换掉
    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        for (int i = 1; i <= key.length(); i++) {
            String subKey = key.substring(0, i);
            prefixMap.put(subKey, prefixMap.getOrDefault(subKey, 0) + delta);
        }
    }

    public int sum(String prefix) {
        return prefixMap.getOrDefault(prefix, 0);
    }

    /**=======================================================================================================================*/

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
//        System.out.println(mapSum.sum("ap"));
        mapSum.insert("apple", 2);
        System.out.println(mapSum.sum("ap"));
    }
}
