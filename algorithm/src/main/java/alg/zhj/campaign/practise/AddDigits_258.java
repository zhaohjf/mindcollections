package alg.zhj.campaign.practise;

/**
 * Created by zhaohongjie on 2020/7/28.
 */
public class AddDigits_258 {

    public int addDigits(int num) {
        return num == 0 ? 0 : 1 + (num - 1) % 9;
    }

    public int _addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return addDigits(sum);
    }
}
