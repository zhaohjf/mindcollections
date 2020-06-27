package alg.zhj.special.fivetimes.collection.combine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaohongjie on 2020/6/27.
 */
public class Combine {

    /**
     * 遍历所有解空间，保存满足条件的值
     *
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        combine(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }
    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if(k==0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for(int i=start;i<=n;i++) {
            comb.add(i);
            combine(combs, comb, i+1, n, k-1);
            comb.remove(comb.size()-1);
        }
    }
}
