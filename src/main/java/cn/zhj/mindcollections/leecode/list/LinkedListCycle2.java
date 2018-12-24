package cn.zhj.mindcollections.leecode.list;

/**
 * Created by zhaohongjie on 2018/12/24.
 */
public class LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {
        if(head==null)
        return null;

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null&&fast.next!=null){
            slow= slow.next;
            fast= fast.next.next;
            if(slow==fast){
                fast=head;
                while(slow!=fast){
                    fast=fast.next;
                    slow=slow.next;
                }
                return slow;
            }
        }
        return null;
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
        five.next = three;

        LinkedListCycle2 cycle2 = new LinkedListCycle2();
        ListNode node = cycle2.detectCycle(one);
        System.out.println(node.val);
    }
}
