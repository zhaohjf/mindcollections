package cn.zhj.mindcollections.leecode.list;

/**
 * Created by zhaohongjie on 2018/12/22.
 */
public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
