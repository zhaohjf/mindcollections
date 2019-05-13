package alg.zhj.mindcollections.interview.list;

/**
 * Created by zhaohongjie on 2019/5/13.
 */
public class LinkedListShareSequence {

    /**
     * 打印链表的公共部分
     *
     * @param head1
     * @param head2
     */
    public void printCommonPart(Node head1, Node head2) {
        System.out.print("Common Part: ");
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);

        Node one1 = new Node(1);
        Node two1 = new Node(2);
        Node three1 = new Node(3);
        Node four1 = new Node(4);
        Node five1 = new Node(5);

        Node head1 = new Node(0);
        Node head2 = new Node(0);

        head1.next = one;
        head1.next.next = two;
        head1.next.next.next= three;
        head1.next.next.next.next = five;

        head2.next = two1;
        head2.next.next = three1;
        head2.next.next.next= four1;
        head2.next.next.next.next = five1;

        LinkedListShareSequence obj = new LinkedListShareSequence();
        obj.printCommonPart(head1, head2);
    }

}
