package cn.zhj.mindcollections.leecode2.dfs;

import cn.zhj.mindcollections.leecode2.base.ListNode;
import cn.zhj.mindcollections.leecode2.base.TreeNode;

/**
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 *
 * Created by zhaohongjie on 2019/3/6.
 */
public class ConvertSortedListToBinarySearchTree {

    /**
     * 利用快慢指针找中间节点
     *
     * 由于链表没有随机访问的特性，需要使用快慢指针的方式来查找链表的中间值，每次只是查找中间值的时间复杂度就是O(N)。
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) {
            return null;
        }

        return findMidDfs(head, null);
    }

    private TreeNode findMidDfs(ListNode head, ListNode tail) {

        if (head == tail) {
            return null;
        }

        ListNode fast = head, slow = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = findMidDfs(head, slow);
        root.right = findMidDfs(slow.next, tail);

        return root;
    }

    // ==================================================

    private ListNode node;

    public TreeNode sortedListToBST_1(ListNode head) {
        if(head == null){
            return null;
        }

        int size = 0;
        ListNode runner = head;
        node = head;

        while(runner != null){
            runner = runner.next;
            size ++;
        }

        return inorderHelper(0, size - 1);
    }

    /**
     * 没看懂~~~~
     *
     * @param start
     * @param end
     * @return
     */
    public TreeNode inorderHelper(int start, int end){

        if(start > end){
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode left = inorderHelper(start, mid - 1);

        TreeNode treenode = new TreeNode(node.val);
        treenode.left = left;
        node = node.next;

        TreeNode right = inorderHelper(mid + 1, end);
        treenode.right = right;

        return treenode;
    }

    public static void main(String[] args) {

        ConvertSortedListToBinarySearchTree obj = new ConvertSortedListToBinarySearchTree();

        ListNode a = new ListNode(-10);
        ListNode b = new ListNode(-3);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(9);

        a.next = b; b.next = c; c.next = d; d.next = e;

        TreeNode treeNode = obj.sortedListToBST_1(a);
        System.out.println();
    }
}
