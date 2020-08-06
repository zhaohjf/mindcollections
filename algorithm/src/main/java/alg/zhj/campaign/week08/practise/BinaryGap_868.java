package alg.zhj.campaign.week08.practise;

/**
 * Created by zhaohongjie on 2020/8/6.
 */
public class BinaryGap_868 {

    public static int binaryGap(int N) {
        int ans = 0, count = 0;
        while((N & 1) == 0) {
            N = N >> 1;
        }
        N = N >> 1;
        while (N > 0) {
            if ((N & 1) == 1) {
                ans = Math.max(ans, count);
                count = 0;
            } else {
                count++;
            }
            N = N >> 1;
        }
        return ans;
    }

    public static int _binaryGap(int N) {
        int last = -1, ans = 0;
        for (int i = 0; i < 32; ++i)
            if (((N >> i) & 1) > 0) {
                if (last >= 0)
                    ans = Math.max(ans, i - last);
                last = i;
            }

        return ans;
    }

    public static void main(String[] args) {
        System.out.print(binaryGap(8));
    }
}
