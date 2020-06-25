package alg.zhj.campaign.week02.practise;

import alg.zhj.mindcollections.interview.linkedlist.LinkedListUtils;
import alg.zhj.mindcollections.interview.linkedlist.ListNode;

/**
 * Created by zhaohongjie on 2020/6/20.
 */
public class GetDecimalValue_1290 {

    public static int getDecimalValue(ListNode head) {

        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }

        int sum = 0;
        cur = head;
        int index = 1;
        while (cur != null) {
            sum = sum + (cur.val << (count - index)); // 这堆括号要注意下
            index++;
            cur = cur.next;
        }

        return sum;
    }

    /**
     * 这个要重点背下，比自己想的解法好太多
     *
     * @param head
     * @return
     */
    public int _getDecimalValue(ListNode head) {
        int sum = 0;
        while(head != null){
            sum = (sum << 1) + head.val;
            head = head.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        ListNode list = LinkedListUtils.getLinkedList(1, 0, 1);
        System.out.println(_20200625_getDecimalValue(list));
    }

    public static int _20200625_getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        int sum = 0;
        while (head != null) {
            if (head.val == 1) {
                sum += 1;
            }
            if (head.next != null) {
                sum = sum << 1;
            }
            head = head.next;
        }
        return sum;
    }
}
