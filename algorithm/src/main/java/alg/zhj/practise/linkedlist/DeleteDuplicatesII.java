package alg.zhj.practise.linkedlist;

import alg.zhj.util.ListNode;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 */
public class DeleteDuplicatesII {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode cur = preHead;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int delVal = cur.next.val;
                while (cur.next != null && cur.next.val == delVal) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return preHead.next;
    }
}
