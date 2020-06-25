package alg.zhj.campaign.week03.practise;

import alg.zhj.mindcollections.leecode.binarytree.search.TreeNode;

/**
 * Created by zhaohongjie on 2020/6/25.
 */
public class RangeSumBST_938 {

    int ans = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {

        if (root == null) {
            return 0;
        }

        if (L <= root.val && root.val <= R) {
            ans += root.val;
        }
        if (root.val > L) {
            rangeSumBST(root.left, L, R);
        }
        if (root.val < R) {
            rangeSumBST(root.right, L, R);
        }

        return ans;
    }

    public int _rangeSumBST(TreeNode root, int L, int R) {

        if (root == null) {
            return 0;
        }

        _rangeSumBST(root.left, L, R);
        if (L <= root.val && root.val <= R) {
            ans += root.val;
        }
        _rangeSumBST(root.right, L, R);

        return ans;
    }

    /**
     * 10,5,15,3,7,null,18
     * @param args
     */
    public static void main(String[] args) {
        TreeNode ten = new TreeNode(10);
        TreeNode five = new TreeNode(5);
        TreeNode fifteen = new TreeNode(15);
        TreeNode three = new TreeNode(3);
        TreeNode seven = new TreeNode(7);
        TreeNode eigthteen = new TreeNode(18);

        ten.left = five;
        ten.right = fifteen;

        five.left = three;
        five.right = seven;

        fifteen.right = eigthteen;

        RangeSumBST_938 obj = new RangeSumBST_938();
        System.out.println(obj._rangeSumBST(ten, 7, 15));


    }
}
