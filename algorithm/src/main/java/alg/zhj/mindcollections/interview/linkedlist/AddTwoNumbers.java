package alg.zhj.mindcollections.interview.linkedlist;

import alg.zhj.mindcollections.interview.binarytree.Node;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/submissions/
 *
 * Created by zhaohongjie on 2019/12/11.
 */
public class AddTwoNumbers {

    /**
     * leecode 3ms
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 反转链表
        ListNode reverseL1 = reverseList(l1);
        ListNode reverseL2 = reverseList(l2);

        int n1 = 0;
        int n2 = 0;
        int ca = 0;
        int n = 0;

        ListNode r1 = reverseL1;
        ListNode r2 = reverseL2;
        ListNode pre = null;
        ListNode node = null;

        while (r1 != null || r2 != null) {

            n1 = r1 != null ? r1.val : 0;
            n2 = r2 != null ? r2.val : 0;

            n = n1 + n2 + ca;
            node = new ListNode(n % 10);
            ca = n / 10;
            node.next = pre;
            pre = node;

            r1 = r1 != null ? r1.next : null;
            r2 = r2 != null ? r2.next : null;
        }

        if (ca == 1) {
            node = new ListNode(1);
            node.next = pre;
            pre = node;
        }

        return pre;
    }

    /**
     * 反转链表
     *
     * @param node
     * @return
     */
    private ListNode reverseList(ListNode node) {

        ListNode pre = null;
        ListNode head = node;
        while (node != null) {
            node = node.next;
            head.next = pre;
            pre = head;
            head = node;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode list = LinkedListUtils.getLinkedList(2, 3, 4, 5);
        ListNode list2 = LinkedListUtils.getLinkedList(7, 7, 3, 4);
        AddTwoNumbers obj = new AddTwoNumbers();
        //LinkedListUtils.printList(obj.reverseList(list));

        LinkedListUtils.printList(obj.addTwoNumbers(list, list2));
    }
}
