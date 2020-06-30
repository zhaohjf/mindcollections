package alg.zhj.campaign.week04.practise;

/**
 * Created by zhaohongjie on 2020/6/29.
 */
public class SortString_1370 {

    public String sortString(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray())
            count[c - 'a'] += 1;
        StringBuilder res = new StringBuilder();
        while(res.length() != s.length()){
            for(int i = 0; i < 26; i++){
                if(count[i] == 0)
                    continue;
                res.append((char)(i + 'a'));
                count[i] -= 1;
            }
            for(int i = 25; i >= 0; i--){
                if(count[i] == 0)
                    continue;
                res.append((char)(i + 'a'));
                count[i] -= 1;
            }
        }
        return res.toString();
    }
}
