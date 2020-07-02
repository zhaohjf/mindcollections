package alg.zhj.campaign.week04.src;

/**
 * Created by zhaohongjie on 2020/7/2.
 */
public class LemonadeChange_860 {

    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length <= 0) {
            return true;
        }
        int five = 0, ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                five--;
                ten++;
            } else if (ten > 0) {
                five--;
                ten--;
            } else {
                five -= 3;
            }
            if (five < 0) {
                return false;
            }
        }
        return true;
    }
}
