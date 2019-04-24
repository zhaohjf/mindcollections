package alg.zhj.mindcollections.leecode.list;

/**
 *
 *
 * Created by zhaohongjie on 2018/12/24.
 */
public class LinkedListCycle2 {

    /**
     * 找出循环链表中的第一个节点
     *
     * 首先，还是使用快慢指针的方法，当探测到链表存在环时，即 fast == slow；
     *
     * 此时，fast 和 slow 同时指向的节点，并不是循环开始的节点，所以接下来的处理，有点儿高级：
     *
     * 先讲处理方法：
     * 1，将fast指向head节点；
     * 2，fast 和 slow 节点每次向后移一步，判断fast 和 slow 是否相同；
     * 3，直至相同时，slow (or fast) 指向的节点就是链表循环开始的节点。
     *
     * 原理：
     * 假设 头节点到循环开始节点距离为 a（未知变量），头节点到快慢指针相遇节点时，慢指针走过距离为 a + b；
     * 因为 fast 走过距离是 slow 的两倍，因此，快指针走过的距离为 2 * (a + b)；
     *
     * 那么，综上，得知，慢节点再走 a + b 步会再次回到 相遇 节点。
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
        five.next = two;

        LinkedListCycle2 cycle2 = new LinkedListCycle2();
        ListNode node = cycle2.detectCycle(one);
        System.out.println(node.val);
    }
}
