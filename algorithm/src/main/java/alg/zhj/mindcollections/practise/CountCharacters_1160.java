package alg.zhj.mindcollections.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaohongjie on 2020/7/14.
 */
public class CountCharacters_1160 {

    public static int countCharacters(String[] words, String chars) {
        Map<Character, Integer> index = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            index.put(chars.charAt(i), index.getOrDefault(chars.charAt(i), 0) + 1);
        }
        int ans = 0;
        for (String str : words) {
            Map<Character, Integer> wordMap = new HashMap<>();
            for (int j = 0; j < str.length(); j++) {
                wordMap.put(str.charAt(j), wordMap.getOrDefault(str.charAt(j), 0) + 1);
            }
            boolean flag = true;
            for(char key : wordMap.keySet()) {
                int count = index.getOrDefault(key, 0);
                if (count < wordMap.get(key)) {
                    flag = false;
                }
            }
            if (flag) {
                ans += str.length();
            }
        }
        return ans;
    }

    /**
     * ["cat","bt","hat","tree"]
     * "atach"
     * @param args
     */
    public static void main(String[] args) {
        int atach = countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach");
        System.out.print(atach);
    }
}
