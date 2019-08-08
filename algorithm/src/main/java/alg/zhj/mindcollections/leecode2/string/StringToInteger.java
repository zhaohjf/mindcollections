package alg.zhj.mindcollections.leecode2.string;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 *
 * Created by zhaohongjie on 2019/4/1.
 */
public class StringToInteger {

    public int myAtoi(String str) {

        // 参数校验
        if (str == null || str.equals("")) {
            return 0;
        }

        // 处理前缀
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                start = i;
                break;
            }
        }

        char[] chas = str.toCharArray();

        boolean posi = true;
        if (chas[start] == '+') {
            posi = true;
            start++;
        } else if (chas[start] == '-') {
            posi = false;
            start++;
        }

        int minq = Integer.MIN_VALUE / 10;
        int minr = Integer.MIN_VALUE % 10;
        int res = 0;
        int cur = 0;
        for (int i = start; i < chas.length; i++) {

            if (chas[i] < '0' || chas[i] > '9') {
                break;
            }

            cur = '0' - chas[i];
            if ((res < minq) || (res == minq && cur < minr)) {
                if (posi) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            res = res * 10 + cur;
        }

        if (posi && res == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        return posi ? -res : res;
    }

    public static void main(String[] args) {
        StringToInteger obj = new StringToInteger();
        System.out.println(obj.myAtoi("+1"));
    }
}
