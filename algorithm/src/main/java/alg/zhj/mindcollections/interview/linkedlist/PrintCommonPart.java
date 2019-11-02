package alg.zhj.mindcollections.interview.linkedlist;

/**
 * Created by zhaohongjie on 2019/11/2.
 */
public class PrintCommonPart {

    public void printCommonPart(ListNode head1, ListNode head2) {

        System.out.println("Common Part: ");

        while (head1 != null && head2 != null) {
            if (head1.val == head2.val) {
                System.out.print(head1.val + ", ");
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1.val > head2.val) {
                head2 = head2.next;
            } else {
                head1 = head1.next;
            }
        }
    }

    public static void main(String[] args) {

        PrintCommonPart obj = new PrintCommonPart();
        ListNode head1 = LinkedListUtils.getLinkedList(2, 3, 6, 7, 9);
        ListNode head2 = LinkedListUtils.getLinkedList(1, 2, 6, 9);

        obj.printCommonPart(head1, head2);
    }
}
