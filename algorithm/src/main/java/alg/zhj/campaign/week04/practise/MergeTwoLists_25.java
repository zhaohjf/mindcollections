package alg.zhj.campaign.week04.practise;

import alg.zhj.mindcollections.interview.linkedlist.ListNode;

/**
 * Created by zhaohongjie on 2020/6/29.
 */
public class MergeTwoLists_25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0), cur = dum;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }

    public ListNode _mergeTwoLists(ListNode linked1, ListNode linked2) {
        if (linked1 == null)
            return linked2;
        if (linked2 == null)
            return linked1;
        if (linked1.val < linked2.val) {
            linked1.next = _mergeTwoLists(linked1.next, linked2);
            return linked1;
        } else {
            linked2.next = _mergeTwoLists(linked1, linked2.next);
            return linked2;
        }
    }
}
