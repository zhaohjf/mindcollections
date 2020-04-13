package alg.zhj.mindcollections.leecode.segmenttree;

/**
 * 线段树 segment tree
 * https://leetcode-cn.com/problems/range-sum-query-mutable/submissions/
 *
 * Created by zhaohongjie on 2020/3/29.
 */
public class NumArray {

    private INode root;
    private int[] nums;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            this.nums = nums;
            this.root = buildTree(nums, 0, nums.length - 1);
        }
    }

    private INode buildTree(int[] val, int start, int end) {

        if (start == end) {
            return new INode(val[start], start, end);
        }

        int mid = start + (end - start) / 2;
        INode left = buildTree(val, start, mid);
        INode right = buildTree(val, mid + 1, end);

        return new INode(left.sum + right.sum, start, end, left, right);
    }

    public void update(int i, int val) {
        updateTree(root, i, val, 0, nums.length - 1);
    }

    private void updateTree(INode root, int i, int val, int start, int end) {

        if (root.start == root.end && root.start == i) {
            root.sum = val;
            return;
        }

        int mid = start + (end - start) / 2;
        if (i <= mid) {
            updateTree(root.left, i, val, start, mid);
        } else {
            updateTree(root.right, i, val, mid + 1, end);
        }

        root.sum = root.left.sum + root.right.sum;
    }

    public int sumRange(int i, int j) {

        if (i > j) {
            i = i ^ j;
            j = i ^ j;
            i = i ^ j;
        }

        return querySum(root, i, j, 0, nums.length - 1);
    }

    public int querySum(INode root, int i, int j, int start, int end) {

        if (root.start == i && root.end == j) {
            return root.sum;
        }

        int mid = start + (end - start) / 2;
        if (mid >= j) {
            return querySum(root.left, i, j, start, mid);
        } else if (mid < i) {
            return querySum(root.right, i, j, mid + 1, end);
        } else {
            return querySum(root.left, i, mid, start, mid) + querySum(root.right, mid + 1, j, mid + 1, end);
        }
    }

    public static class INode {

        private int sum;

        private int start;

        private int end;

        INode left;

        INode right;

        public INode(int val, int start, int end) {
            this.sum = val;
            this.start = start;
            this.end = end;
        }

        public INode(int val, int start, int end, INode left, INode right) {
            this.sum = val;
            this.start = start;
            this.end = end;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * ["NumArray","sumRange","sumRange","sumRange","update","update","update","sumRange","update","sumRange","update"]
     [[[0,9,5,7,3]],[4,4],[2,4],[3,3],[4,5],[1,7],[0,8],[1,2],[1,9],[4,4],[3,4]]
     *
     * @param args
     */
    public static void main(String[] args) {
        NumArray obj = new NumArray(new int[]{0, 9, 5, 7, 3});
        System.out.print(obj.sumRange(4, 4));
        System.out.print(obj.sumRange(2, 4));
        System.out.print(obj.sumRange(3, 3));
        obj.update(4, 5);
        obj.update(1, 7);
        obj.update(0, 8);
        System.out.print(obj.sumRange(1, 2));
        obj.update(1, 9);
        System.out.print(obj.sumRange(4, 4));
        obj.update(3, 4);
    }
}


