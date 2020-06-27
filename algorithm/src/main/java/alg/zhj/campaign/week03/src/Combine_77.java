package alg.zhj.campaign.week03.src;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaohongjie on 2020/6/26.
 */
public class Combine_77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n <= 0 || k > n) {
            return ans;
        }
        dfs(ans, new ArrayList<>(), n, k, 1);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> tmp, int n, int k, int level) {
        if (k == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = level; i <= n - k + 1; i++) {
            tmp.add(i);
            dfs(ans, tmp, n, k - 1, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combine_77 obj = new Combine_77();
        System.out.println(obj.combine(4, 2));
    }
}
