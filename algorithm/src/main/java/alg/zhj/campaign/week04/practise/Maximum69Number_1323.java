package alg.zhj.campaign.week04.practise;

/**
 * Created by zhaohongjie on 2020/6/29.
 */
public class Maximum69Number_1323 {
    public int maximum69Number(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '6') {
                chars[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }
}
