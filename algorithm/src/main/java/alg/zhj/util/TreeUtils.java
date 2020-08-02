package alg.zhj.util;

/**
 * Created by zhaohongjie on 2020/7/31.
 */
public class TreeUtils {

    /**
     *              3
     *          9       20
     *              15      7
     *
     * @return
     */
    public static TreeNode getTree() {
        TreeNode n_3 = new TreeNode(3);
        TreeNode n_9 = new TreeNode(9);
        TreeNode n_20 = new TreeNode(20);
        TreeNode n_15 = new TreeNode(15);
        TreeNode n_7 = new TreeNode(7);

        n_3.left = n_9;
        n_3.right = n_20;

        n_20.left = n_15;
        n_20.right = n_7;

        return n_3;
    }
}
