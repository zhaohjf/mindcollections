package alg.zhj.campaign.week04.practise;

/**
 * Created by zhaohongjie on 2020/6/29.
 */
public class JudgeCircle_657 {

    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char move: moves.toCharArray()) {
            if (move == 'U') y--;
            else if (move == 'D') y++;
            else if (move == 'L') x--;
            else if (move == 'R') x++;
        }
        return x == 0 && y == 0;
    }
}
