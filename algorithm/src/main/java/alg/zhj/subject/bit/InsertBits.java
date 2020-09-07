package alg.zhj.subject.bit;

/**
 * Created by zhaohongjie on 2020/9/7.
 */
public class InsertBits {

    public static int insertBits(int N, int M, int i, int j) {
        int n = ~((-1 >>> (31 - j)) & (-1 << i));
        N = N & n;
        M = M << i;
        N = M | N;
        return N;
    }

    public static int _insertBits(int N, int M, int i, int j) {
        int n=~((-1>>>(31-j))&(-1<<i));
        System.out.println(Integer.toBinaryString((-1>>>(31-j))));
        System.out.println(Integer.toBinaryString((-1<<i)));
        System.out.println(Integer.toBinaryString((-1>>>(31-j))&(-1<<i)));
        N=N&n;
        M=M<<i;
        N=M|N;
        return N;
    }

    public static void main(String[] args) {
        System.out.println(_insertBits(1024,
                19,
                2,
                6
        ));

        System.out.println(Integer.toBinaryString(-1));
    }
}
