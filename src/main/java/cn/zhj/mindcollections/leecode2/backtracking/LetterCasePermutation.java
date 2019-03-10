package cn.zhj.mindcollections.leecode2.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/letter-case-permutation/
 * <p>
 * Created by zhaohongjie on 2019/3/8.
 */
public class LetterCasePermutation {

    List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {

        dfs(S.toCharArray(), "", 0);

        return res;
    }

    /**
     * 过于执着于回溯了，其实不用
     *
     * 思路问题，不适合继续沿这个思路走了
     *
     * 每个字符都有两个状态：大写、小写
     *
     * @param s
     * @param temp
     * @param index
     */
    private void dfs(char[] s, String temp, int index) {

        if (s.length == index) {
            res.add(temp);
            return;
        }

        //for (int i = index; i < s.length; i++) {
        if (!Character.isDigit(s[index])) {
            temp = temp + s[index];
            dfs(s, temp, index + 1);
            temp = temp + String.valueOf(s[index]).toUpperCase();
            dfs(s, temp, index + 1);
            //temp = temp.substring(0, temp.length() - 1);
        } else {
            temp = temp + s[index];
            dfs(s, temp, index + 1);
        }
        //temp = temp.substring(0, temp.length() - 1);
        //}
    }

    //=====================上面自己写的是垃圾==============================

    public List<String> letterCasePermutation_1(String S) {
        List<String> list = new ArrayList<String>();
        helper_1(S.toCharArray(), list, 0);
        return list;
    }

    private void helper_1(char[] c, List<String> list, int i) {
        if (i == c.length) list.add(new String(c));
        else if (Character.isLetter(c[i])) {
            c[i] = Character.toLowerCase(c[i]);
            helper_1(c, list, i + 1);
            c[i] = Character.toUpperCase(c[i]);
            helper_1(c, list, i + 1);
        } else {
            helper_1(c, list, i + 1);
        }
    }






    //===================================================

    public List<String> letterCasePermutation_2(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);

        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) continue;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                char[] chs = cur.toCharArray();

                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));

                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));
            }
        }

        return new LinkedList<>(queue);
    }






    //===================================================

    public List<String> letterCasePermutation_3(String S) {
        if (S == null) {
            return new LinkedList<>();
        }

        List<String> res = new LinkedList<>();
        helper(S.toCharArray(), res, 0);
        return res;
    }

    public void helper(char[] chs, List<String> res, int pos) {
        if (pos == chs.length) {
            res.add(new String(chs));
            return;
        }
        if (chs[pos] >= '0' && chs[pos] <= '9') {
            helper(chs, res, pos + 1);
            return;
        }

        chs[pos] = Character.toLowerCase(chs[pos]);
        helper(chs, res, pos + 1);

        chs[pos] = Character.toUpperCase(chs[pos]);
        helper(chs, res, pos + 1);
    }

    public static void main(String[] args) {

        LetterCasePermutation obj = new LetterCasePermutation();
        List<String> list_1 = obj.letterCasePermutation_1("a1b2");
        List<String> list = obj.letterCasePermutation("a1b2");

        list.forEach(c -> System.out.print(c + ", "));
    }
}
