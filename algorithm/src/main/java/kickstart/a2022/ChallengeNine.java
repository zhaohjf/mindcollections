package kickstart.a2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ChallengeNine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nCases = Integer.valueOf(scanner.nextLine());

        for (int i = 1; i <= nCases; ++i) {
            String N = scanner.nextLine();
            String res = challengeNine(N);
            System.out.println("Case #" + i + ": " + res);
        }
    }

    private static String challengeNine(String N) {

        char[] nc = N.toCharArray();
        int sum = 0;
        for (char c : nc) {
            sum += (c - '0');
        }

        // 所有位数据之和如果是9的倍数，那么这个数字也是9的倍数
        int d = 9 - (sum % 9) == 9 ? 0 : 9 - (sum % 9);

        StringBuilder sb = new StringBuilder();
        boolean hasInserted = false;
        for (int i = 0; i < nc.length; i++) {
            if (hasInserted) {
                sb.append(nc[i]);
            } else if (i == 0 && d == 0) {
                sb.append(nc[i]).append(d);
                hasInserted = true;
            } else if (d < (nc[i] - '0')) {
                sb.append(d).append(nc[i]);
                hasInserted = true;
            } else {
                sb.append(nc[i]);
            }
        }

        return hasInserted ? sb.toString() : sb.append(d).toString();
    }
}
/**
 * Problem
 * Ada gives John a positive integer N. She challenges him to construct a new number (without leading zeros), that is a multiple of 9, by inserting exactly one digit (0 … 9) anywhere in the given number N. It is guaranteed that N does not have any leading zeros.
 *
 * As John prefers smaller numbers, he wants to construct the smallest such number possible. Can you help John?
 *
 * Input
 * The first line of the input gives the number of test cases, T. T test cases follow.
 *
 * Each test case has a single line containing a positive integer N: the number Ada gives John.
 *
 * Output
 * For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the new number constructed by John. As mentioned earlier, y cannot have leading zeros.
 *
 * Limits
 * Memory limit: 1 GB.
 * 1≤T≤100.
 * Test Set 1
 * Time limit: 20 seconds.
 * 1≤N≤105.
 * Test Set 2
 * Time limit: 40 seconds.
 * For at most 10 cases:
 * 1≤N≤10123456.
 * For the remaining cases:
 * 1≤N≤105.
 * Sample
 * Sample Input
 * save_alt
 * content_copy
 * 3
 * 5
 * 33
 * 12121
 * Sample Output
 * save_alt
 * content_copy
 * Case #1: 45
 * Case #2: 333
 * Case #3: 121212
 * In Sample Case #1, there are only two numbers that can be constructed satisfying the divisibility constraint: 45 and 54. John chooses the smaller number.
 *
 * In Sample Case #2, 333 is the only number possible.
 *
 * In Sample Case #3, there are four possible options - 212121, 122121, 121221 and 121212 - out of which the smallest number is 121212.
 * */
