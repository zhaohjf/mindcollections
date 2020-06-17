package alg.zhj.campaign.week02.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhaohongjie on 2020/6/17.
 */
public class PreorderTraversal_144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            ans.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }

        return ans;
    }
}
