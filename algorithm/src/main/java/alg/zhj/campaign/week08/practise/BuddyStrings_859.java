package alg.zhj.campaign.week08.practise;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by zhaohongjie on 2020/8/7.
 */
public class BuddyStrings_859 {

    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        char[] c = A.toCharArray();
        int start = 0;
        while (start < c.length) {
            if (A.charAt(start) != B.charAt(start)) break;
            start++;
        }
        for (int i = start; i < c.length; i++) {
            for (int j = i + 1; j < c.length; j++) {
                swap(c, i, j);
                String next = new String(c);
                if (B.equals(next)) {
                    return true;
                } else {
                    swap(c, i, j);
                }
            }
        }
        return false;
    }

    private void swap(char[] c, int i, int j) {
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }

    public static void main(String[] args) {
        BuddyStrings_859 obj = new BuddyStrings_859();
        System.out.print(obj.buddyStrings("aa", "aa"));
        Set<String> set = Sets.newHashSet();

    }
}
