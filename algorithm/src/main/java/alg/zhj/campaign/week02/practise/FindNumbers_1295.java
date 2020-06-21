package alg.zhj.campaign.week02.practise;

/**
 * Created by zhaohongjie on 2020/6/20.
 */
public class FindNumbers_1295 {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (odd(num)) {
                count++;
            }
        }

        return count;
    }

    private boolean odd(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num = num / 10;
        }

        return (count & 1) == 0; // bug == 0 的情况才是偶数
    }

    public static void main(String[] args) {
        int[] a = {12, 345, 2, 6, 7896};
        FindNumbers_1295 obj = new FindNumbers_1295();
        int numbers = obj.findNumbers(a);
        System.out.print(numbers);
    }
}
