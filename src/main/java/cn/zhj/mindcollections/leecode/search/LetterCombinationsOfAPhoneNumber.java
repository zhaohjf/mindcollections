package cn.zhj.mindcollections.leecode.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaohongjie on 2019/1/29.
 */
public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();

        String[] charItems = new String[digits.length()];

        for (int i = 0; i < digits.length(); i++) {
            switch (digits.charAt(i)) {
                case '2':
                    charItems[i] = "abc";
                    break;
                case '3':
                    charItems[i] = "def";
                    break;
                case '4':
                    charItems[i] = "ghi";
                    break;
                case '5':
                    charItems[i] = "jkl";
                    break;
                case '6':
                    charItems[i] = "mno";
                    break;
                case '7':
                    charItems[i] = "pqrs";
                    break;
                case '8':
                    charItems[i] = "tuv";
                    break;
                case '9':
                    charItems[i] = "wxyz";
                    break;
            }
        }

        combineEach_3(result, charItems, 0, "");

        return result;
    }

    /**
     * 利用递归来进行排列组合
     * <p>
     * 利用递归来实现多层嵌套遍历
     *
     * @param result
     * @param charItems
     * @param i
     * @param temp
     */
    private void combineEach(List<String> result, String[] charItems, int i, String temp) {

        if (i < charItems.length - 1) {
            for (int j = 0; j < charItems[i].length(); j++) {
                combineEach(result, charItems, i + 1, temp + charItems[i].charAt(j));
            }
            i++;
        } else {
            for (int j = 0; j < charItems[i].length(); j++) {
                result.add(temp + charItems[i].charAt(j));
            }
        }
    }

    /**
     * 这个递归函数相比于上面更好理解，代码也更简洁
     *
     * 上面代码唯一好处就是少了一层递归
     *
     * @param result
     * @param charItems
     * @param i
     * @param temp
     */
    private void combineEach_2(List<String> result, String[] charItems, int i, String temp) {

        if (i < charItems.length) {
            for (int j = 0; j < charItems[i].length(); j++) {
                combineEach_2(result, charItems, i + 1, temp + charItems[i].charAt(j));
            }
            i++;
        } else {
            result.add(temp);
        }
    }

    /**
     * 控制变量要相对少一些，但要注意下边界条件
     *
     * @param result
     * @param charItems
     * @param i
     * @param temp
     */
    private void combineEach_3(List<String> result, String[] charItems, int i, String temp) {

        for (char c : charItems[i].toCharArray()) {
            if (i == charItems.length - 1) {
                result.add(temp + c);
            } else {
                combineEach_3(result, charItems, i + 1, temp + c);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber obj = new LetterCombinationsOfAPhoneNumber();
        List<String> stringList = obj.letterCombinations("23");

        stringList.forEach(c -> System.out.println(c));
    }
}
