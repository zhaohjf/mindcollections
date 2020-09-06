package alg.zhj.subject.string;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * <p>
 * 通过次数226,398提交次数569,529
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by zhaohongjie on 2020/9/6.
 */
public class StrStr_28 {

    /**
     * 简单遍历
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        int l = haystack.length();
        int m = needle.length();
        for (int i = 0; i <= l - m; i++) {
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static int _strStr(String haystack, String needle) {
        int l = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int pn = 0;
        while (pn <= l - m) {
            // 不相等，下一个
            while (pn <= l - m && haystack.charAt(pn) != needle.charAt(0)) pn++;
            int currLen = 0, pm = 0;
            while (pn < l && pm < m && haystack.charAt(pn) == needle.charAt(pm)) {
                currLen++;
                pm++;
                pn++;
            }
            if (currLen == m) return pn - m;
            pn = pn - currLen + 1;
        }
        return -1;
    }

    // function to convert character to integer
    public int charToInt(int idx, String s) {
        return (int)s.charAt(idx) - (int)'a';
    }

    public int __strStr(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L > n) return -1;

        // base value for the rolling hash function
        int a = 26;
        // modulus value for the rolling hash function to avoid overflow
        long modulus = (long)Math.pow(2, 31);

        // compute the hash of strings haystack[:L], needle[:L]
        long h = 0, ref_h = 0;
        for (int i = 0; i < L; ++i) {
            h = (h * a + charToInt(i, haystack)) % modulus;
            ref_h = (ref_h * a + charToInt(i, needle)) % modulus;
        }
        if (h == ref_h) return 0;

        // const value to be used often : a**L % modulus
        long aL = 1;
        for (int i = 1; i <= L; ++i) aL = (aL * a) % modulus;

        for (int start = 1; start < n - L + 1; ++start) {
            // compute rolling hash in O(1) time
            h = (h * a - charToInt(start - 1, haystack) * aL
                    + charToInt(start + L - 1, haystack)) % modulus;
            if (h == ref_h) return start;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(_strStr("hello", "ll"));
    }
}



















