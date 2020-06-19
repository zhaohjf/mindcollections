package alg.zhj.campaign.week02.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaohongjie on 2020/6/19.
 */
public class NumJewelsInStones_771 {

    public int _numJewelsInStones(String J, String S) {
        int ans = 0;
        for (char s: S.toCharArray()) // For each stone...
            for (char j: J.toCharArray()) // For each jewel...
                if (j == s) {  // If the stone is a jewel...
                    ans++;
                    break; // Stop searching whether this stone 's' is a jewel
                }
        return ans;
    }

    public int numJewelsInStones(String J, String S) {

        char[] sc = S.toCharArray();
        Map<Character, Integer> count = new HashMap<>();
        for (char c : sc) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        char[] jc = J.toCharArray();
        int ans = 0;
        for (char c : jc) {
            ans = ans + count.getOrDefault(c, 0);
        }

        return ans;
    }

    /**
     * 输入: J = "aA", S = "aAAbbbb"
     * 输出: 3
     *
     * @param args
     */
    public static void main(String[] args) {

    }
}
