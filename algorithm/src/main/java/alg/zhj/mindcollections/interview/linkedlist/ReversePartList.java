package alg.zhj.mindcollections.interview.linkedlist;

import java.util.List;

/**
 * 注意考虑边界条件
 *
 * Created by zhaohongjie on 2019/11/14.
 */
public class ReversePartList {

    public ListNode reversePart(ListNode head, int from, int to) {

        if (from > to || from < 1) {
            return null;
        }

        if (from == to) {
            return head;
        }

        int len = 0;
        ListNode node1 = head;
        ListNode preStartNode = null, afterEndNode = null;

        while (node1 != null) {
            len++;
            preStartNode = len == from - 1 ? node1 : preStartNode;
            afterEndNode = len == to + 1 ? node1 : afterEndNode;
            node1 = node1.next;
        }

        if (to > len) {
            return null;
        }

        ListNode pre = afterEndNode;
        // 如果部分翻转包含头节点的话
        ListNode hNode = preStartNode == null ? head : preStartNode.next;
        ListNode next = null;

        while (hNode != afterEndNode) {
            next = hNode.next;
            hNode.next = pre;
            pre = hNode;
            hNode = next;
        }

        // 如果翻转部分包含了头节点的话
        if (preStartNode != null) {
            preStartNode.next = pre;
            return head;
        } else {
            return pre;
        }
    }

    public static void main(String[] args) {
        ListNode list = LinkedListUtils.getLinkedList(1, 2, 3, 4, 5);

        ReversePartList obj = new ReversePartList();
        ListNode reversePartHead = obj.reversePart(list, 1, 5);

        LinkedListUtils.printList(reversePartHead);
    }
}
