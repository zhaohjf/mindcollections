package cn.zhj.mindcollections.leecode.list;

/**
 * Created by zhaohongjie on 2018/12/22.
 */
public class LinkedListCycle {

    /**
     * 链表判断是否有环的经典做法：
     *
     * 快、慢指针，快指针每次走两步，慢指针每次走一步；当快指针追上慢指针时，证明链表有环
     *
     * 循环条件是：当前节点及下一个节点不为空
     * 循环结束条件是：快指针 == 慢指针
     *
     * @param head
     * @return
     */
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
