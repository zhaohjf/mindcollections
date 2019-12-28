package alg.zhj.mindcollections.interview.linkedlist;

import org.w3c.dom.NodeList;

/**
 * Created by zhaohongjie on 2019/12/15.
 */
public class CircleListCollections {

    /**
     * 检测链表是否存在环，若存在，则返回第一个进入环的节点
     *
     * 运行时间：1ms
     *
     * @param head
     * @return
     */
    public ListNode getLoopNode(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        ListNode slow = head.next, fast = head.next.next;
        while (slow != fast) {
            // 到达null, 退出
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

    /**
     * 检测并返回入环的第一个节点
     *
     * 运行时间：0ms
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        if (head == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    /**
     * 两个链表相交的关系，两个链表相交的话，只能可能在最末端
     *
     * 思路：遍历两个链表到末节点，并记录每个链表的节点数量；
     * 1，如果最后的节点end1 != end2，说明链表不相交，返回null;
     * 2，如果最后的节点end1 == end2，说相交；转3
     * 3，假设链表1较长，则它先走len1 - len2步，然后两个链表一起走，当发现有两个节点相同时，该节点则为相交的节点
     *
     * 1ms
     *
     * @param head1
     * @param head2
     * @return
     */
    public ListNode noLoop(ListNode head1, ListNode head2) {

        if (head1 == null || head2 == null) {
            return null;
        }

        ListNode cur1 = head1;
        ListNode cur2 = head2;
        int n = 0;

        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }

        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }

        if (cur1 != cur2) {
            return null;
        }

        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);

        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }

        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;
    }

    /**
     * 更好的方式
     *
     * 实现：两个指针都走相同的路长，当headA起到尽头时，指针指向headB；当headB走到尽头时，指针指向headA;
     * 这样两个指针走的都是相同长度的路径，在第二圈的时候，肯定会在相交点碰面。
     *
     * 1ms
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }

    // TODO 如何判断两个有环链表是否相交
    

    public static void main(String[] args) {
        ListNode list = LinkedListUtils.getCircleLinkedList(1, 2, 3, 4, 5);

        CircleListCollections obj = new CircleListCollections();
        ListNode loopNode = obj.getLoopNode(list);
        System.out.println(loopNode);
    }
}
