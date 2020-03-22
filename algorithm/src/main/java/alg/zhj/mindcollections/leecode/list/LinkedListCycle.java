package alg.zhj.mindcollections.leecode.list;

/**
 *
 * 链表若存在环的话，有且仅有一个环。
 *
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
    public boolean hasCycle(ListNode head) {

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

    /**
     * 20200322
     * 出错点：
     * 1，head 不用提前判空，while循环条件里已经做了这部分工作
     * 2，必须在快慢指针都向前走了一步之后，才判断其是否相等（因为，初始状态它俩都指向头节点，初始状态下是永远相等的）
     *
     * @param head
     * @return
     */
    public boolean cycle_20200322(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.val == slow.val) {
                return true;
            }
        }

        return false;
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

        LinkedListCycle obj = new LinkedListCycle();
        System.out.println(obj.cycle_20200322(one));
    }
}
