package alg.zhj.mindcollections.interview.linkedlist;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * Created by zhaohongjie on 2019/11/2.
 */
public class MergeSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode pre = new ListNode(0);
        ListNode head = pre;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                pre.next = new ListNode(l2.val);
                l2 = l2.next;
            }

            pre = pre.next;
        }

        while (l1 != null) {
            pre.next = new ListNode(l1.val);
            pre = pre.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            pre.next = new ListNode(l2.val);
            pre = pre.next;
            l2 = l2.next;
        }

        return head.next;
    }

    /**
     * 递归思路：
     * 子问题——比较两个列表的头节点，并返回最值最小的节点
     *
     * 20200322 重新温习了下思路
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode recursion(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = recursion(l1.next, l2);
            return l1;
        } else {
            l2.next = recursion(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        MergeSortedList obj = new MergeSortedList();
        ListNode head1 = LinkedListUtils.getLinkedList(2, 3, 6, 7, 9);
        ListNode head2 = LinkedListUtils.getLinkedList(1, 2, 6, 9);

//        ListNode list = obj.mergeTwoLists(head1, head2);
        ListNode list = obj.recursion(head1, head2);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }
}
