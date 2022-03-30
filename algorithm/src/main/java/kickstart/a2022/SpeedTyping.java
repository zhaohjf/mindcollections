package kickstart.a2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhaohongjie <zhaohongjie03@kuaishou.com>
 * Created on 2022-03-30
 */
public class SpeedTyping {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nCases = Integer.valueOf(scanner.nextLine());

        for (int i = 1; i <= nCases; ++i) {
            String I = scanner.nextLine();
            String P = scanner.nextLine();
            String res = typingCheck2(I, P);
            System.out.println("Case #" + i + ": " + res);
        }
    }

    /**
     * 考虑顺序情况下
     *
     * abc
     * acb
     * IMPOSSIBLE
     *
     * test 1 & test 2 passed
     *
     * @param init
     * @param product
     * @return
     */
    private static String typingCheck2(String init, String product) {

        int il = init.length();
        int pl = product.length();
        char[] ic = init.toCharArray();
        char[] pc = product.toCharArray();

        int count = 0;
        int i = 0, j = 0;
        while (j < pl && i < il) {
            if (ic[i] == pc[j]) {
                i++;
                j++;
            } else {
                j++;
                count++;
            }
        }

        if (i == il) {
            return String.valueOf(count + pl - j);
        } else {
            return "IMPOSSIBLE";
        }
    }

    /**
     * test 1 passed
     * @param init
     * @param product
     * @return
     */
    private static String typingCheck(String init, String product) {

        Map<Character, Integer> initIndex = new HashMap<>();
        Map<Character, Integer> productIndex = new HashMap<>();

        initIndex(init, initIndex);
        initIndex(product, productIndex);

        for (Character c : initIndex.keySet()) {
            if (!productIndex.containsKey(c)) {
                return "IMPOSSIBLE";
            }
            Integer pSize = productIndex.get(c);
            Integer iSize = initIndex.get(c);
            if (iSize > pSize) {
                return "IMPOSSIBLE";
            } else {
                productIndex.put(c, pSize - iSize);
            }
        }

        int count = 0;
        Iterator<Map.Entry<Character, Integer>> iterator = productIndex.entrySet().iterator();
        while (iterator.hasNext()) {
            count += iterator.next().getValue();
        }

        return String.valueOf(count);
    }

    private static void initIndex(String s, Map<Character, Integer> index) {
        for (Character c : s.toCharArray()) {
            if (!index.containsKey(c)) {
                index.put(c, 0);
            }
            index.put(c, index.get(c) + 1);
        }
    }
}

/**
 * Problem
 * Barbara is a speed typer. In order to check her typing speed, she performs a speed test. She is given a string I that she is supposed to type.
 *
 * While Barbara is typing, she may make some mistakes, such as pressing the wrong key. As her typing speed is important to her, she does not want to spend additional time correcting the mistakes, so she continues to type with the errors until she finishes the speed test. After she finishes the speed test, she produces a P.
 *
 * Now she wonders how many extra letters she needs to delete in order to get I from P. It is possible that Barbara made a mistake and P cannot be converted back to I just by deleting some letters. In particular, it is possible that Barbara missed some letters.
 *
 * Help Barbara find out how many extra letters she needs to remove in order to obtain I or if I cannot be obtained from P by removing letters then output IMPOSSIBLE.
 *
 * Input
 * The first line of the input gives the number of test cases, T. T test cases follow.
 *
 * Each test case has 2 lines. The first line of each test case is an input string I (that denotes the string that the typing test has provided). The next line is the produced string P (that Barbara has entered).
 *
 * Output
 * For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the number of extra letters that need to be removed in order to obtain I. If it is not possible to obtain I then output IMPOSSIBLE as y.
 *
 * Limits
 * Memory limit: 1 GB.
 * 1≤T≤100.
 * Both the strings contain letters from a-z and A-Z.
 * Length of the given strings will be 1≤|I|,|P|≤105.
 * Test Set 1
 * Time limit: 20 seconds.
 * All letters in I are the same.
 *
 * Test Set 2
 * Time limit: 40 seconds.
 * Sample
 * Note: there are additional samples that are not run on submissions down below.
 * Sample Input
 * save_alt
 * content_copy
 * 2
 * aaaa
 * aaaaa
 * bbbbb
 * bbbbc
 * Sample Output
 * save_alt
 * content_copy
 * Case #1: 1
 * Case #2: IMPOSSIBLE
 * In the first test case, P contains one extra a, so she needs to remove 1 extra letter in order to obtain I.
 * In the second test case, Barbara typed only 4 letters b, while I consists of 5 letters b so the answer is IMPOSSIBLE.
 *
 *
 * Additional Sample - Test Set 2
 * The following additional sample fits the limits of Test Set 2. It will not be run against your submitted solutions.
 * Sample Input
 * save_alt
 * content_copy
 * 2
 * Ilovecoding
 * IIllovecoding
 * KickstartIsFun
 * kkickstartiisfun
 * Sample Output
 * save_alt
 * content_copy
 * Case #1: 2
 * Case #2: IMPOSSIBLE
 * In the first test case, P has 2 extra letters, I and l. The other letters are in the order given in I. So she needs to remove 2 letters in order to obtain I.
 * In the second test case, there is no letter K in P so the answer is IMPOSSIBLE.
 * */
