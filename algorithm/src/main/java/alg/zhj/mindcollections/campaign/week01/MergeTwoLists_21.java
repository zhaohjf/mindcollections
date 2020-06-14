package alg.zhj.mindcollections.campaign.week01;

import alg.zhj.mindcollections.interview.linkedlist.LinkedListUtils;
import alg.zhj.mindcollections.interview.linkedlist.ListNode;

/**
 * Created by zhaohongjie on 2020/6/11.
 */
public class MergeTwoLists_21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = LinkedListUtils.getLinkedList(1, 3, 5, 7, 9);
        ListNode list2 = LinkedListUtils.getLinkedList(2, 4, 6, 8, 10);

        MergeTwoLists_21 obj = new MergeTwoLists_21();
        ListNode res = obj.mergeTwoLists(list1, list2);
        LinkedListUtils.printList(res);
    }

//    public class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//        }
//    }
}
