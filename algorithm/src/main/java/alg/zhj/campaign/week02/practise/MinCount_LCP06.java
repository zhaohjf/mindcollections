package alg.zhj.campaign.week02.practise;

/**
 * Created by zhaohongjie on 2020/6/20.
 */
public class MinCount_LCP06 {

    public static int minCount(int[] coins) {
        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            count = count + coins[i] / 2; // 是coins[i], 不是i =。=~~
            if (coins[i] % 2 == 1) {
                count++;
            }
        }

        return count;
    }

    public static int _minCount(int[] coins) {
        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            count = count + coins[i] / 2 + coins[i] % 2; // 是coins[i], 不是i =。=~~
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 1};
        System.out.println(_minCount(a));
    }
}
