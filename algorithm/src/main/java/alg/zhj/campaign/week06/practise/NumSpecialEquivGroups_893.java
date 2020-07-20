package alg.zhj.campaign.week06.practise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhaohongjie on 2020/7/10.
 */
public class NumSpecialEquivGroups_893 {

    public static int numSpecialEquivGroups(String[] A) {
        Set<String> seen = new HashSet();
        for (String S: A) {
            int[] count = new int[52];
            for (int i = 0; i < S.length(); ++i)
                count[S.charAt(i) - 'a' + 26 * (i % 2)]++;
            seen.add(Arrays.toString(count));
        }
        return seen.size();
    }

    public static void main(String[] args) {
        int i = numSpecialEquivGroups(new String[]{"abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx"});
        System.out.println(i);
    }
}
