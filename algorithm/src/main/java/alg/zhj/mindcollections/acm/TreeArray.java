package alg.zhj.mindcollections.acm;

/**
 * Created by zhaohongjie on 2019/3/10.
 */
public class TreeArray {

    int[] data = new int[50001], s = new int[50001], T = new int[50001];

    public int lowBit(int t) {
        return t & -t;
    }

    public int sum(int end) {
        int sum = 0;
        while (end > 0) {
            sum += T[end];
            end -= lowBit(end);
        }
        return sum;
    }

    public void plus(int pos, int num, int count) {
        while (pos <= count) {
            T[pos] += num;
            pos += lowBit(pos);
        }
    }
}
