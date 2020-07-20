package alg.zhj.campaign.week06.practise;

import alg.zhj.mindcollections.interview.linkedlist.ListNode;

/**
 * Created by zhaohongjie on 2020/7/9.
 */
public class ReverseList_recurse_206 {

    // cur 这个并不是每次递归都返回，只有递归到最底层时才会返回一次，head == null || head.next == null
    // 递归也是多个方法的嵌套调用，最底层函数返回后，会将这个返回值层层传递出去。
    public ListNode reverseList(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if(head==null || head.next==null) {
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = reverseList(head.next);
        //这里请配合动画演示理解
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }

    public ListNode _reverseList(ListNode head) {
    /* recursive solution */
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }
}
