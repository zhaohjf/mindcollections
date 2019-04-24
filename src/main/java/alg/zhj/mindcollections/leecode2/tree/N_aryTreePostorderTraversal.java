package alg.zhj.mindcollections.leecode2.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 *
 * Created by zhaohongjie on 2019/4/21.
 */
public class N_aryTreePostorderTraversal {

    List<Integer> res = new ArrayList<>();

    public List<Integer> postorder(Node root) {

        if (root == null) {
            return res;
        }

        for (Node node : root.children) {
            postorder(node);
        }
        res.add(root.val);

        return res;
    }
}
