package alg.zhj.campaign.week04.practise;

/**
 * Created by zhaohongjie on 2020/6/29.
 */
public class FreqAlphabets_1309 {

    public String freqAlphabets(String s) {
        if (s == null) {
            return s;
        }
        char[] c = s.toCharArray();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < c.length) {
            if (i + 2 < c.length && c[i + 2] == '#') {
                int n = (c[i] - '0') * 10 + (c[i + 1] - '0');
                char m = (char) ('a' + n - 1);
                sb.append(m);
                i += 3;
            } else {
                sb.append((char) ('a' + (c[i] - '0') - 1));
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "10#11#12";
        FreqAlphabets_1309 obj = new FreqAlphabets_1309();
        System.out.print(obj.freqAlphabets(str));
    }
}
