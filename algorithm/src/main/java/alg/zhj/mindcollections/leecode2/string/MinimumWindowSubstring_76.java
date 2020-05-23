package alg.zhj.mindcollections.leecode2.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/minimum-window-substring/solution/hua-dong-chuang-kou-ji-bai-liao-100de-javayong-hu-/
 *
 * 最小覆盖子串，快慢指针遍历：
 * 1，快指针先走，等快慢指针之间已经包含了所有要求的字符时，记录长度及当前字符子串；
 * 2，然后向右移动慢指针，如果slow指向的不是要求的字符，slow继续右移，否则，记录formed -= 1，离完成还差一个字符，
 * 然后重复以上步骤。
 *
 * Created by zhaohongjie on 2020/5/23.
 */
public class MinimumWindowSubstring_76 {

    public String minWindow(String s, String t) {

        if (s == null || s.length() == 0 || t == null || t.length() == 0
                || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> dict = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (dict.containsKey(c)) {
                dict.put(c, dict.get(c) + 1);
            } else {
                dict.put(c, 1);
            }
        }

        int formed = 0; // 还欠几个
        int slow = 0;

        String minStr = "";
        int minLength = Integer.MIN_VALUE - 1;

        char[] source = s.toCharArray();
        for (int fast = 0; fast < source.length; fast ++) {
            char c = source[fast];
            // skip if source[fast] doesn't matter
            if (!dict.containsKey(c)) {
                continue;
            }
            // use c update dict
            Integer old = dict.get(c);
            dict.put(c, old - 1);
            if (dict.get(c) == 0) {
                formed += 1;
            }
            // If all character art satisfied, then move the left pointer
            while (formed == dict.size() && slow <= fast) {
                // save the result
                int currLength = fast - slow;
                if (currLength < minLength) {
                    minLength = currLength;
                    minStr = String.valueOf(Arrays.copyOfRange(source, slow, fast + 1));
                }
                // update the left boundary
                char c1 = source[slow];
                slow += 1;
                if (!dict.containsKey(c1)) {
                    continue;
                }
                dict.put(c1, dict.get(c1) + 1);
                if (dict.get(c1) == 1) {
                    formed -= 1;
                }
            }
        }

        return minStr;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring_76 obj = new MinimumWindowSubstring_76();
        System.out.println(obj.minWindow("aa", "aa"));
    }
}
