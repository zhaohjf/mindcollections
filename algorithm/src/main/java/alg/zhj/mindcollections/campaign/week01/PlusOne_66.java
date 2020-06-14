package alg.zhj.mindcollections.campaign.week01;

import java.util.Arrays;

/**
 * Created by zhaohongjie on 2020/6/12.
 */
public class PlusOne_66 {

    public int[] plusOne(int[] digits) {

        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if ((digits[i] + 1) % 10 == 0) {
                carry = 1;
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                carry = 0;
                break;
            }
        }

        if (carry == 1) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }

        return digits;
    }

    public int[] _plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] a = {9, 9, 8};
        PlusOne_66 obj = new PlusOne_66();
        int[] ints = obj.plusOne(a);

        Arrays.stream(ints).forEach(System.out::print);
    }
}
