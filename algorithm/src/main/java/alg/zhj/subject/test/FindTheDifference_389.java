package alg.zhj.subject.test;

/**
 * Created by zhaohongjie on 2020/8/29.
 */
public class FindTheDifference_389 {

    public static char findTheDifference(String s, String t) {
        int[] count = new int[26];
        char[] tc = t.toCharArray();
        for (int i = 0; i < tc.length; i++) {
            count[tc[i] - 'a']++;
        }
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            count[sc[i] - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) return (char) ('a' + i);
        }

        return ' ';
    }

    public char _findTheDifference(String s, String t) {
        char res = 0;
        int lens = s.length();
        for (int i = 0; i < lens; i ++) {
            res ^= s.charAt(i)^ t.charAt(i);
        }
        res ^= t.charAt(lens);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));
    }
}
