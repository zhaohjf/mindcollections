package alg.zhj.special.fivetimes.knapsack;

/**
 * Created by zhaohongjie on 2020/4/23.
 */
public class Test {

    public static void main(String[] args) {
        int[] w = {3,5,2,6,4};
        int[] v = {4,4,3,5,3};
        int maxw = 3;
        int[] f = new int[maxw+1];
        int i,j;
        for(i = 1; i < f.length; i++)
            f[i] = Integer.MIN_VALUE;
        for(i = 0; i < v.length; i++)
            for(j = f.length - 1; j >= w[i]; j--)
                f[j] = f[j] > (f[j-w[i]] + v[i]) ? f[j] : (f[j-w[i]] + v[i]);
        //f[j] = Math.max(f[j], f[j-w[i]] + v[i]);

        for(i = 0; i < f.length; i++)
            System.out.print(f[i] + " ");
    }
}
