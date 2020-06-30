package alg.zhj.campaign.week04.practise;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by zhaohongjie on 2020/6/29.
 */
public class ToLowerCase_709 {

    public String toLowerCase(String str) {
        char[] a = str.toCharArray();
        for (int i = 0; i < a.length; i++)
            if ('A' <= a[i] && a[i] <= 'Z')
                a[i] = (char) (a[i] - 'A' + 'a');
        return new String(a);
    }

    public static void main(String[] args) {
        String str = "HeLLo";
        ToLowerCase_709 obj = new ToLowerCase_709();
        String s = str.toLowerCase();
        System.out.println();

        List<Integer> ans = Lists.newArrayList();
    }
}
