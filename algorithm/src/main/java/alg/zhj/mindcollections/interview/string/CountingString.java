package alg.zhj.mindcollections.interview.string;

/**
 * 统计字符串
 * 输入：aaabbadddffc
 * 输出：a_3_b_2_a_1_d_3_f_2_c_1
 *
 * Created by zhaohongjie on 2019/8/16.
 */
public class CountingString {

    public String getCountingString(String str) {

        if (str == null || str.equals("")) {
            return "";
        }

        char[] chs = str.toCharArray();
        String res = String.valueOf(chs[0]);
        int num = 1;
        for (int i = 1; i < chs.length; i++) {
            if (chs[i] != chs[i - 1]) {
                res = concat(res, String.valueOf(num), String.valueOf(chs[i]));
                num = 1;
            } else {
                num++;
            }
        }

        return concat(res, String.valueOf(num), "");
    }

    private String concat(String s1, String s2, String s3) {
        return s1 + "_" + s2 + (s3.equals("") ? s3 : "_" + s3);
    }

    public static void main(String[] args) {
        CountingString obj = new CountingString();
        String res = obj.getCountingString("aaabbadddffc");
        System.out.print(res);
    }
}
