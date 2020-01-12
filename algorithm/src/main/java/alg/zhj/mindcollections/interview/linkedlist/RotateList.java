package alg.zhj.mindcollections.interview.linkedlist;

/**
 * https://leetcode-cn.com/problems/rotate-list/submissions/
 *
 * Created by zhaohongjie on 2019/12/28.
 */
public class RotateList {

    /**
     * 问题变形：将链表首尾连接组成一个环
     * 问题转换：求应该从哪里将这个环断开
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || k == 0) {
            return head;
        }

        int len = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }
        cur.next = head;

        int moveStep = len - k % len;
        while (moveStep > 0) {
            moveStep--;
            cur = cur.next;
            head = head.next;
        }
        cur.next = null;

        return head;
    }

    public static void main(String[] args) {
        RotateList obj = new RotateList();
        ListNode node = obj.rotateRight(LinkedListUtils.getLinkedList(1, 2, 3, 4, 5), 2);
        LinkedListUtils.printList(node);
    }

    public ListNode rotateRight_official(ListNode head, int k) {
        // base cases
        if (head == null) return null;
        if (head.next == null) return head;

        // close the linked list into the ring
        ListNode old_tail = head;
        int n;
        for (n = 1; old_tail.next != null; n++)
            old_tail = old_tail.next;
        old_tail.next = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++)
            new_tail = new_tail.next;
        ListNode new_head = new_tail.next;

        // break the ring
        new_tail.next = null;

        return new_head;
    }
}
