package alg.zhj.mindcollections.interview.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/comments/
 *
 * Created by zhaohongjie on 2020/1/12.
 */
public class MergeKSortedLists {

    /**
     * 维护一个最小堆，大小为lists.size，由每个链表的头节点构成这个最小堆；
     * 每次从中选出最小节点，将最小节点的next节点再加入到这个最小堆中。
     *
     * 当一个链表被遍历完时，其最后个节点被取出后，不再生成新堆节点，直至堆中为空。
     *
     * 7ms
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> o1.val - o2.val);

        for (ListNode head : lists) {
            if (head != null) {
                queue.add(head);
            }
        }

        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (!queue.isEmpty()) {
            ListNode next = queue.poll();
            if (next.next != null) {
                queue.add(next.next);
            }
            cur.next = next;
            cur = cur.next;
        }

        return head.next;
    }

    /**
     * 分治，是一种我们常用的简化问题的方法，可以有提高并行度、简化逻辑（不易出错）等优点
     *
     * 这里如果使用分治的话，可以将问题分解为求两个有序链表的合并（最小基本单元），这样就可以通过分治并行的特点
     * 来对任意多个有序链表进行合并以提升速度，同时它的单元运算逻辑只是合并两个有序链表（足够简单）——简单的好处就是robust!!!
     *
     * 分治很棒、很厉害！但有些问题总是会有一些更好的解法，这才是最有意思的。
     *
     * 通过合适的数据结构进行抽象，它也可以形成一个足够简单的逻辑、并有着更优越的性能，这也就算法最吸引人的地方。
     *
     */
    public static void main(String[] args) {
        ListNode list1 = LinkedListUtils.getLinkedList(1, 3, 5, 7, 9);
        ListNode list2 = LinkedListUtils.getLinkedList(2, 4, 6, 8);
        ListNode list3 = LinkedListUtils.getLinkedList(10, 19);

        MergeKSortedLists obj = new MergeKSortedLists();
        ListNode res = obj.mergeKLists(new ListNode[]{list1, list2, list3});
        LinkedListUtils.printList(res);

    }

    /**
     * 2ms
     *
     * 分治的速度快可能是因为数据结构比较简单吧，上面使用了java的最小堆可能影响了效率
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists_divideAndConquer(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        // 将n个链表以中间为对称，合并，即合并
        while(len>1) {
            for (int i=0; i<len/2; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[len-1-i]);
            }
            len = (len+1)/2;
        }
        return lists[0];
    }

    // 合并两个链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        } else if (l2 != null) {
            p.next = l2;
        }
        return head.next;
    }
}
