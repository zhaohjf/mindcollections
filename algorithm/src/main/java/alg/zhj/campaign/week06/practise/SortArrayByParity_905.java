package alg.zhj.campaign.week06.practise;

import java.util.Arrays;

/**
 * Created by zhaohongjie on 2020/7/11.
 */
public class SortArrayByParity_905 {

    public static int[] sortArrayByParity(int[] A) {
        int even = 0, odd = A.length - 1;
        while (even <= odd) {
            if ((A[even] & 1) == 0) {
                even++;
                continue;
            }
            if ((A[odd] & 1) == 1) {
                odd--;
                continue;
            }
            int tmp = A[even];
            A[even] = A[odd];
            A[odd] = tmp;
            even++;
            odd--;
        }
        return A;
    }

    public int[] _sortArrayByParity(int[] A) {
        Integer[] B = new Integer[A.length];
        for (int t = 0; t < A.length; ++t)
            B[t] = A[t];

        Arrays.sort(B, (a, b) -> Integer.compare(a%2, b%2));

        for (int t = 0; t < A.length; ++t)
            A[t] = B[t];
        return A;

        /* Alternative:
        return Arrays.stream(A)
                     .boxed()
                     .sorted((a, b) -> Integer.compare(a%2, b%2))
                     .mapToInt(i -> i)
                     .toArray();
        */
    }

    public int[] __sortArrayByParity(int[] A) {
        for (int i = 0, j = 0; j < A.length; j++)
            if (A[j] % 2 == 0) {
                int tmp = A[i];
                A[i++] = A[j];
                A[j] = tmp;;
            }
        return A;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2};
        int[] ans = sortArrayByParity(a);
        Arrays.stream(ans).forEach(x -> System.out.print(x + " "));
    }
}

