  
package alg.zhj.mindcollections.leetcodesenior;

import java.util.ArrayList;

/**
 * 可以想一下，整数的因式分解有多少个？
 *
 * @author zhaohongjie <zhaohongjie03@kuaishou.com>
 * Created on 2020-04-13
 */
public class Lesson5_1 {

    public static long[] rewards = {1, 2, 5, 10};

    public static void get(long totalRewards, ArrayList<Long> result) {

        if (totalRewards == 0) {
            System.out.println(result);
            return;
        } else if (totalRewards < 0) {
            // 没有解 return
            return;
        } else {
            for (int i = 0; i < rewards.length; i++) {
                ArrayList<Long> newResult = (ArrayList<Long>) (result.clone());
                newResult.add(rewards[i]);
                get(totalRewards - rewards[i], newResult);
            }
        }
    }

    public static void main(String[] args) {
        int total = 10;
        Lesson5_1.get(total, new ArrayList<Long>());
    }
}
