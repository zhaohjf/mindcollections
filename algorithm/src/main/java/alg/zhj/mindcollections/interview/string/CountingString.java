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

    /**
     * 在压缩后的字符串上找到对应index的字符
     *
     * 当遇到'_'时要转换阶段，从遇到字符阶段转换到遇到连续字符统计（将两个'_'符号间的字符转换为数字）阶段
     *
     * @param cstr
     * @param index
     * @return
     */
    public char getCharAt(String cstr, int index) {
        if (cstr == null || cstr.equals("")) {
            return 0;
        }
        char[] chs = cstr.toCharArray();
        boolean stage = true;
        char curr = 0;
        int num = 0;
        int sum = 0;
        for (int i = 0; i != chs.length; i++) {
            if (chs[i] == '_') {
                stage = !stage;
            } else if (stage) {
                sum += num;
                if (sum > index) {
                    return curr;
                }
                num = 0;
                curr = chs[i];
            } else {
                num = num * 10 + chs[i] - '0';
            }
        }

        // 每个字符的统计都会在遇到新的字符时加到sum上，所以当遍历完成时，最一个字条的统计个数并不会加到sum上，
        // 要单独加。
        return sum + num > index ? curr : 0;
    }

    private String concat(String s1, String s2, String s3) {
        return s1 + "_" + s2 + (s3.equals("") ? s3 : "_" + s3);
    }

    public static void main(String[] args) {
        CountingString obj = new CountingString();
        String res = obj.getCountingString("aaabbadddffc");
        System.out.println(res);

        System.out.println(obj.getCharAt(res, 8));
    }
}
