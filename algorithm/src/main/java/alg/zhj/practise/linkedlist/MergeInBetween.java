package alg.zhj.practise.linkedlist;

import alg.zhj.util.LinkedListUtils;
import alg.zhj.util.ListNode;

public class MergeInBetween {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int i = 0;
        ListNode node = list1, preNode = null;
        ListNode nodeA = null, nodeB = null;
        while (node != null) {
            if (i == a) {
                nodeA = preNode;
            }
            if (i == b) {
                nodeB = node.next;
            }
            preNode = node;
            node = node.next;
            i++;
        }

        nodeA.next = list2;
        while (nodeA.next != null) {
            nodeA = nodeA.next;
        }
        nodeA.next = nodeB;

        return list1;
    }

    public static void main(String[] args) {
        ListNode list1 = LinkedListUtils.getLinkedList(0, 1, 2, 3, 4, 5);
        ListNode list2 = LinkedListUtils.getLinkedList(1000000, 1000001, 1000002);
        MergeInBetween obj = new MergeInBetween();
        ListNode root = obj.mergeInBetween(list1, 3, 4, list2);
        LinkedListUtils.printList(root);
    }
}
