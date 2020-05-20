package alg.zhj.mindcollections.interview.array;

/**
 * Created by zhaohongjie on 2020/5/20.
 */
public class FindTheLongestSubstringContainingVowelsInEvenCounts_leetcode1371 {

    public int findTheLongestSubstring(String s) {

        char[] vowles = "aeiou".toCharArray();
        int[] idx = new int[1 << 5];
        idx[0] = -1;
        for (int i = 1; i < idx.length; i++) {
            idx[i] = Integer.MAX_VALUE;
        }
        int state = 0;
        int ans = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < 5; j++) {
                if (chars[i] == vowles[j]) {
                    state ^= 1 << j;
                }
            }
            if (idx[state] == Integer.MAX_VALUE) {
                idx[state] = i;
            }
            ans = Math.max(ans, i - idx[state]);
        }

        return ans;
    }

    public static void main(String[] args) {
        FindTheLongestSubstringContainingVowelsInEvenCounts_leetcode1371 obj =
                new FindTheLongestSubstringContainingVowelsInEvenCounts_leetcode1371();
        System.out.print(obj.findTheLongestSubstring("eleetminicoworoep"));
    }
}
