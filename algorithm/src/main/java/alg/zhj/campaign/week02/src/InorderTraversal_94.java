package alg.zhj.campaign.week02.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhaohongjie on 2020/6/17.
 */
public class InorderTraversal_94 {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        // 左 根 右
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                ans.add(root.val);
                root = root.right;
            }
        }

        return ans;
    }
}
