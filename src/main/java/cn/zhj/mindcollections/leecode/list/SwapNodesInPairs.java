package cn.zhj.mindcollections.leecode.list;

/**
 * Created by zhaohongjie on 2018/12/22.
 */
public class SwapNodesInPairs {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode swapPairs_2(ListNode head) {

        ListNode node = new ListNode(1);
        ListNode pre = node;
        pre.next = head;

        while (pre.next != null && pre.next.next != null) {
            ListNode first = pre.next;
            ListNode second = first.next;

            first.next = second.next;
            second.next = first;
            pre.next = second;

            pre = first;
        }

        return node.next;
    }

    public static ListNode swapPairs(ListNode head) {

        ListNode prev = null;
        ListNode first = head;
        ListNode second = head.next;

        ListNode newhead = head.next;

        while (second != null) {
            first.next = second.next;
            second.next = first;
            if (prev != null) {
                prev.next = second;
            }

            prev = first;
            first = first.next;
            if (first.next == null) {
                break;
            }
            second = first.next;
        }

        return newhead;
    }

    public ListNode swapPairs_3(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode node = head.next;
        head.next = swapPairs(head.next.next);
        node.next = head;
        return node;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ListNode node = swapPairs_2(one);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
        //System.out.println(node.val);
    }
}
