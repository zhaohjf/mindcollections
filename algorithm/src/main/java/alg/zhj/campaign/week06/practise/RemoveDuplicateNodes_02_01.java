package alg.zhj.campaign.week06.practise;

import alg.zhj.mindcollections.interview.linkedlist.LinkedListUtils;
import alg.zhj.mindcollections.interview.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhaohongjie on 2020/7/8.
 */
public class RemoveDuplicateNodes_02_01 {

    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> set = new HashSet<>();
        ListNode prev = head, cur = head.next;
        set.add(prev.val);
        while (cur != null) {
            if (set.contains(cur.val)) {
                prev.next = cur.next;
            } else {
                set.add(cur.val);
                prev = prev.next;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode list = LinkedListUtils.getLinkedList(1, 2, 3, 3, 2, 1);
        ListNode node = removeDuplicateNodes(list);
        LinkedListUtils.printList(node);
    }
}
