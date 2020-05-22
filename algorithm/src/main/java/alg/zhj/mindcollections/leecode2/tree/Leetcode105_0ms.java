package alg.zhj.mindcollections.leecode2.tree;

/**
 * Created by zhaohongjie on 2020/5/22.
 */
public class Leetcode105_0ms {

    int pre = 0, in = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recursive(preorder, inorder, Integer.MAX_VALUE);
    }

    public TreeNode recursive(int[] preorder, int[] inorder, int stop) {
        if (pre >= preorder.length) return null;
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        int curVal = preorder[pre++];
        TreeNode cur = new TreeNode(curVal);
        cur.left = recursive(preorder, inorder, curVal);
        cur.right = recursive(preorder, inorder, stop);
        return cur;
    }
}
