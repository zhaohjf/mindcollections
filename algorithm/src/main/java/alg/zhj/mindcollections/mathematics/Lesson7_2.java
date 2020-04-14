package alg.zhj.mindcollections.mathematics;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaohongjie on 2020/4/14.
 */
public class Lesson7_2 {

    /**
     * 全排列
     *
     * 这个递归的逻辑还真挻绕的，没事儿多看看
     *
     * @param letters
     * @param result
     */
    public static void permutate(ArrayList<String> letters, ArrayList<String> result) {

        if (letters.size() == 0) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < letters.size(); i++) {
            ArrayList<String> newResult = (ArrayList<String>) (result.clone());
            newResult.add(letters.get(i));

            ArrayList<String> restLetters = (ArrayList<String>) (letters.clone());
            restLetters.remove(i);

            permutate(restLetters, newResult);
        }
    }

    /**
     * 这位哥们的逻辑更简单，不过他这个是允许一个元素被使用多次
     *
     * @param l
     * @param result
     */
    public static void calLetterList(ArrayList<String> l, ArrayList<String> result) {
        if (result.size() == l.size()) {
            System.out.println(result);
            return;
        }

        for (String letter : l) {
            ArrayList<String> newResult = (ArrayList<String>) result.clone();
            newResult.add(letter);
            calLetterList(l, newResult);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> letters = Lists.newArrayList("a", "d", "e");
        calLetterList(letters, new ArrayList<String>());
    }
}
