package cn.zhj.mindcollections.leecode.list;

/**
 * Created by zhaohongjie on 2018/12/22.
 */
public class LinkedListCycle {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static boolean hasCycle(ListNode head) {

        ListNode fast = head, slow = head;
        while (fast != null && slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
