package alg.zhj.practise.tree;

import alg.zhj.util.TreeNode;
import alg.zhj.util.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaohongjie on 2020/7/31.
 */
public class AverageOfLevel {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> sumList = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        dfs(root, sumList, count, 0);
        List<Double> ans = new ArrayList<>();
        for (int i = 0; i < sumList.size(); i++) {
            ans.add(sumList.get(i) / count.get(i));
        }
        return ans;
    }

    private void dfs(TreeNode root, List<Double> sumList, List<Integer> count, int level) {
        if (root == null) {
            return;
        }
        if (sumList.size() <= level) {
            sumList.add(0D);
            count.add(0);
        }
        sumList.set(level, sumList.get(level) + root.val);
        count.set(level, count.get(level) + 1);
        dfs(root.left, sumList, count, level + 1);
        dfs(root.right, sumList, count, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.getTree();
        AverageOfLevel obj = new AverageOfLevel();
        List<Double> res = obj.averageOfLevels(root);
        System.out.print(res);
    }
}
