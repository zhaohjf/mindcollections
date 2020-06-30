package alg.zhj.special.fivetimes.collection.combine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaohongjie on 2020/6/27.
 */
public class Combine {

    /**
     * 遍历所有解空间，保存满足条件的值 27ms
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

    /**
     * 剪枝
     * for (int i = level; i <= n - k + 1; i++)
     *
     * For anyone stumped by why this change is necessary, it's because you should not continue exploring (recursing)
     * when you know that there won't be enough numbers left until n to fill the needed k slots. If n = 10, k = 5,
     * and you're in the outermost level of recursion, you choose only i = 1...6 , because if you pick i=7 and
     * go into backTracking() you only have 8,9,10 to pick from, so at most you will get [7,8,9,10]... but we need 5 elements!
     *
     * I think we can do better ... if taking into account the number of values already accumulated in the temp list.
     * for (int i = start; i <= n - (k - tempList.size()) + 1; i ++)
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> _1ms_combine(int n, int k) {

        if (n <= 0 || k > n) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        dfs(result, new ArrayList<>(), n, k, 1);

        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> temp, int n, int k, int level) {

        if (k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = level; i <= n - k + 1; i++) {
            temp.add(i);
            dfs(result, temp, n, k - 1, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
