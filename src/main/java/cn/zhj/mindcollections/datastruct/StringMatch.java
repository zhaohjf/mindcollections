package cn.zhj.mindcollections.datastruct;

/**
 * Created by zhaohongjie on 2019/2/15.
 */
public class StringMatch {

    private static final int SIZE = 256; // 全局变量或成员变量

    private void generateBC(char[] b, int m, int[] bc) {
        for (int i = 0; i < SIZE; ++i) {
            bc[i] = -1; // 初始化 bc
        }
        for (int i = 0; i < m; ++i) {
            int ascii = (int) b[i]; // 计算 b[i] 的 ASCII 值
            bc[ascii] = i;
        }
    }

    public int bm(char[] a, int n, char[] b, int m) {

        int[] bc = new int[SIZE]; // 记录模式串中每个字符最后出现的位置
        generateBC(b, m, bc); // 构建坏字符哈希表

        int i = 0; // i 表示主串与模式串对齐的第一个字符
        while (i <= n - m) {
            int j;
            for (j = m - 1; j >= 0; --j) { // 模式串从后往前匹配
                if (a[i + j] != b[j]) break; // 坏字符对应模式串中的下标是 j
            }
            if (j < 0) {
                return i; // 匹配成功，返回主串与模式串第一个匹配的字符的位置
            }
            // 这里等同于将模式串往后滑动 j-bc[(int)a[i+j]] 位
            i = i + (j - bc[(int) a[i + j]]);
        }
        return -1;
    }

    public static void main(String[] args) {
        StringMatch obj = new StringMatch();
        int bm = obj.bm("absdfds".toCharArray(), 7, "ds".toCharArray(), 2);
        System.out.println(bm);

        String a = "aaaaaaaaaaaaaaaa";
        String b = "baaa";

        //System.out.println(obj.bm(a.toCharArray(), a.length(), b.toCharArray(), b.length()));
    }
}
