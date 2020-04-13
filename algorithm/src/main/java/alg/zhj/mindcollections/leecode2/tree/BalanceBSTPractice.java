package alg.zhj.mindcollections.leecode2.tree;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by zhaohongjie on 2020/4/14.
 */
public class BalanceBSTPractice {

    public TreeNode balanceBST(TreeNode root) {

        if (root == null) {
            return null;
        }

        List<Integer> inOrderList = Lists.newArrayList();
        inOrder(root, inOrderList);

        System.out.println(inOrderList);
        return doBuild(inOrderList, 0, inOrderList.size() - 1);
    }

    private void inOrder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        inOrder(root.left, ans);
        ans.add(root.val);
        inOrder(root.right, ans);
    }

    private TreeNode doBuild(List<Integer> ans, int left, int right) {

        if (left > right) {
            return null;
        }

        int min = left + ((right - left) >> 1);
        TreeNode root = new TreeNode(ans.get(min));
        root.left = doBuild(ans, left, min - 1);
        root.right = doBuild(ans, min + 1, right);

        return root;
    }

}
