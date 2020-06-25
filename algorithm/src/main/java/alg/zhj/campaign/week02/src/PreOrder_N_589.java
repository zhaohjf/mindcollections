package alg.zhj.campaign.week02.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    /**
     * 非递归方式
     *
     * @param root
     * @return
     */
    public List<Integer> _preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            ans.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--) {
                stack.push(root.children.get(i));
            }
        }
        return ans;
    }
}
