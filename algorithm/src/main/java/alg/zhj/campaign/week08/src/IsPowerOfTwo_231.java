package alg.zhj.campaign.week08.src;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。

 示例 1:

 输入: 1
 输出: true
 解释: 20 = 1
 示例 2:

 输入: 16
 输出: true
 解释: 24 = 16
 示例 3:

 输入: 218
 输出: false
 *
 * Created by zhaohongjie on 2020/7/28.
 */
public class IsPowerOfTwo_231 {

    public boolean isPowerOfTwo(int n) {
        if (n > 0) {
            return (n & (n - 1)) == 0;
        }
        return false;
    }
}
