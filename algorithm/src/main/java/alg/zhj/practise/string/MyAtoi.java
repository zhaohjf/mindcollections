package alg.zhj.practise.string;

public class MyAtoi {

    public int myAtoi(String str) {

        if (str == null || str.length() <= 0) {
            return 0;
        }

        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                start = i;
                break;
            }
        }

        char[] c = str.toCharArray();
        boolean positive = true;
        if (c[start] == '+') {
            start++;
        } else if (c[start] == '-'){
            positive = false;
            start++;
        }

        int minQ = Integer.MIN_VALUE / 10;
        int minR = Integer.MIN_VALUE % 10;
        int cur = 0;
        int res = 0;
        for (int i = start; i < c.length; i++) {
            if (c[i] < '0' || c[i] > '9') {
                break;
            }
            cur = '0' - c[i];
            // 因为负值最大，统一按负数处理，当结果为-2147483648时，如果positive为正，则返回正数最大值即可。
            if (res < minQ || (res == minQ && cur < minR)) {
                if (positive) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            res = res * 10 + cur;
        }

        if (positive && res == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return res;
    }

    public static void main(String[] args) {
        MyAtoi obj = new MyAtoi();
        System.out.println(obj.myAtoi("2147483648"));
    }
}
