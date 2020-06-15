package alg.zhj.campaign.week02.src;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的前序遍历
 *
 * Created by zhaohongjie on 2020/6/16.
 */
public class PreOrder_N_589 {

    public List<Integer> preorder(Node root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        helper(root, res);

        return res;
    }

    private void helper(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        if (root.children == null) {
            return;
        }
        for (Node node : root.children) {
            helper(node, res);
        }
    }
}
