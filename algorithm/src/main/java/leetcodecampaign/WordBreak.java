package leetcodecampaign;

import com.google.common.collect.Lists;

import java.util.*;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictSet = new HashSet<>(wordDict);
        // dp[i] s前i个字符可以由 wordDict 组合而成
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public List<String> wordBreak2(String s, List<String> wordDict) {
        Set<String> dictSet = new HashSet<>(wordDict);
        List<String> ans = new ArrayList<>();
        backTrace(s, 0, dictSet, new ArrayList<>(), ans);
        return ans;
    }

    /**
     * dfs 深度优先搜索？ 回溯？
     *
     * @param s
     * @param index
     * @param temp
     * @param ans
     */
    private void backTrace(String s, int index, Set<String> wordDict, List<String> temp, List<String> ans) {
        int length = s.length();
        if (index >= length) {
            ans.add(String.join(" ", temp));
        }
        for (int i = index; i < length; i++) {
            if (wordDict.contains(s.substring(index, i + 1))) {
                temp.add(s.substring(index, i + 1));
            } else {
                continue;
            }
            backTrace(s, i + 1, wordDict, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        WordBreak obj = new WordBreak();
        List<String> ans = obj.wordBreak2("catsanddog", Lists.newArrayList("cat", "cats", "and", "sand", "dog"));
        ans.stream().forEach(x -> System.out.println(x));
    }
}
