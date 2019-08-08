package alg.zhj.mindcollections.leecode.other;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 *
 * Created by zhaohongjie on 2019/1/2.
 */
public class ValidAnagram {

    /**
     * 统计字条个数，判断相应的字符数是否相等
     *
     * 利用char数组，比hashMap的性能会好一些
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {

        /**
         * 不加这句leecode运行时间8ms
         * 加上以后减少到6ms
         *
         */
        if(s.length() != t.length()) {
            return Boolean.FALSE;
        }

        int[] a = new int[26];
        int[] b = new int[26];

        for (char c : s.toCharArray()) {
            a[c - 'a'] += 1;
        }

        for (char c : t.toCharArray()) {
            b[c - 'a'] += 1;
        }

        for (int i = 0 ; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
}
