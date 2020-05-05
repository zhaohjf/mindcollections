package math.zhj.mindcollections;

/**
 * 寻找最少硬币数问题
 *
 * Created by zhaohongjie on 2020/4/28.
 */
public class Lesson10_2 {

    private static final int[] MONEY = new int[]{1, 2, 3, 7};

    public static int findFewestMethod(int total) {

        int[] c = new int[total];
        c[0] = 0;

        int temp;
        for (int i = 1; i < total; i++) {
            int tempMin = total;
            for (int j = 0; j < MONEY.length; j++) {
                int diff = i - MONEY[j];
                if (0 <= diff) {
                    temp = c[diff] + 1;
                } else {
                    // 此情况表示该纸币无效，选择最大值。
                    temp = total;
                }
                // 求出最小值
                if (temp < tempMin) {
                    tempMin = temp;
                }
            }
            c[i] = tempMin;
        }

        return c[total - 1];
    }

    public static void main(String[] args) {
        int minMoney = findFewestMethod(100);
        System.out.println(minMoney);
    }
}
