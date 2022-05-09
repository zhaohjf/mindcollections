package alg.zhj.practise.linkedlist;

import alg.zhj.util.LinkedListUtils;
import alg.zhj.util.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class AddTwoList {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);
        int sum = r1.val + r2.val;
        ListNode ans = new ListNode(sum % 10);
        ListNode pre = ans;
        boolean carry = sum / 10 > 0 ? true : false;
        r1 = r1.next; r2 = r2.next;
        while (r1 != null && r2 != null) {
            int sum1 = r1.val + r2.val + (carry ? 1 : 0);
            ListNode cur = new ListNode(sum1 % 10);
            carry = sum1 / 10 > 0 ? true : false;
            ans.next = cur;
            ans = ans.next;
            r1 = r1.next;
            r2 = r2.next;
        }

        while (r1 != null) {
            int sum2 = r1.val + (carry ? 1 : 0);
            ListNode cur = new ListNode(sum2 % 10);
            carry = sum2 / 10 > 0 ? true : false;
            ans.next = cur;
            ans = ans.next;
            r1 = r1.next;
        }

        while (r2 != null) {
            int sum3 = r2.val + (carry ? 1 : 0);
            ListNode cur = new ListNode(sum3 % 10);
            carry = sum3 / 10 > 0 ? true : false;
            ans.next = cur;
            ans = ans.next;
            r2 = r2.next;
        }

        if (carry) {
            ans.next = new ListNode(1);
            ans = ans.next;
        }

        return reverse(pre);
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    public static void main(String[] args) {
        ListNode l1 = LinkedListUtils.getLinkedList(9, 1, 6);
        ListNode l2 = LinkedListUtils.getLinkedList(0);

        AddTwoList obj = new AddTwoList();
        LinkedListUtils.printList(obj.addTwoNumbers(l1, l2));

    }

    public ListNode addTwoNumbers_leetcode(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<Integer>();
        Deque<Integer> stack2 = new ArrayDeque<Integer>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur = a + b + carry;
            carry = cur / 10;
            cur %= 10;
            ListNode curnode = new ListNode(cur);
            curnode.next = ans;
            ans = curnode;
        }
        return ans;
    }

}
