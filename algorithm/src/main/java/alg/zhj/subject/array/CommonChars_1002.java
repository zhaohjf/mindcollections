package alg.zhj.subject.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * <p>
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by zhaohongjie on 2020/8/23.
 */
public class CommonChars_1002 {

    /**
     * 执行结果：
     * 解答错误
     * 显示详情
     * 输入：
     * ["acabcddd","bcbdbcbd","baddbadb","cbdddcac","aacbcccd","ccccddda","cababaab","addcaccd"]
     * 输出：
     * ["a","b","c","c","d","d"]
     * 预期结果：
     * []
     *
     * @param A
     * @return
     */
    public List<String> _error_commonChars(String[] A) {
        int[] res = new int[26];
        for (String str : A) {
            str.chars().forEach(x -> ++res[x - 'a']);
        }
        List<String> ans = new ArrayList<>();
        int size = A.length;
        for (int i = 0; i < 26; i++) {
            int count = res[i];
            while (count >= size) {
                ans.add(String.valueOf((char) (i + 'a')));
                count -= size;
            }
        }
        return ans;
    }

    public List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<>();
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String str : A) {
            int[] cnt = new int[26];
            str.chars().forEach(c -> ++cnt[c - 'a']); // count each char's frequency in string str.
            for (int i = 0; i < 26; ++i) { count[i] = Math.min(cnt[i], count[i]); } // update minimum frequency.
        }
        for (char c = 'a'; c <= 'z'; ++c) {
            while (count[c - 'a']-- > 0) { ans.add("" + c); }
        }
        return ans;
    }
}
