package alg.zhj.campaign.week04.src;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhaohongjie on 2020/7/2.
 */
public class RobotSim_874 {

    public int robotSim(int[] commands, int[][] obstacles) {
        if (commands == null || commands.length <= 0) {
            return 0;
        }

        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0, di = 0;

        Set<String> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + " " + obstacle[1]);
        }

        int ans = 0;
        for (int cmd : commands) {
            // left
            if (cmd == -2) {
                di = (di + 3) % 4;
            } else if (cmd == -1) {
                di = (di + 1) % 4;
            } else {
                for (int i = 0; i < cmd; ++i) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    String code = nx + " " + ny;
                    if (!set.contains(code)) {
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x * x + y * y);
                    }
                }
            }
        }

        return ans;
    }

    public int _robotSim(int[] commands, int[][] obstacles) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0, di = 0;

        // Encode obstacles (x, y) as (x+30000) * (2^16) + (y+30000)
        Set<Long> obstacleSet = new HashSet();
        for (int[] obstacle: obstacles) {
            long ox = (long) obstacle[0] + 30000;
            long oy = (long) obstacle[1] + 30000;
            obstacleSet.add((ox << 16) + oy);
        }

        int ans = 0;
        for (int cmd: commands) {
            if (cmd == -2)  //left
                di = (di + 3) % 4;
            else if (cmd == -1)  //right
                di = (di + 1) % 4;
            else {
                for (int k = 0; k < cmd; ++k) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    long code = (((long) nx + 30000) << 16) + ((long) ny + 30000);
                    if (!obstacleSet.contains(code)) {
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x*x + y*y);
                    }
                }
            }
        }

        return ans;
    }

    public int __robotSim(int[] commands, int[][] obstacles) {
        int[] dx = new int[] { 0, 1, 0, -1 };
        int[] dy = new int[] { 1, 0, -1, 0 };
        int x = 0;
        int y = 0;
        int di = 0;

        // Encode obstacles (x, y) as (x + 30000) * (2^16) + (y + 30000)
        // 或者，我们也可以将坐标编码为 字符串 string。
        Set<Integer> obstacleSet = new HashSet<>((int) (obstacles.length / 0.75) + 1);
        for (int[] o : obstacles) {
            int ox = o[0] + 30000;
            int oy = o[1] + 30000;
            obstacleSet.add((ox << 16) | oy);
        }

        int max = 0;
        for (int cmd : commands) {
            if (cmd == -2) {
                di = (di + 3) % 4;
            } else if (cmd == -1) {
                di = (di + 1) % 4;
            } else {
                for (int k = 0; k < cmd; k++) {
                    x += dx[di];
                    y += dy[di];
                    int code = ((x + 30000) << 16) | (y + 30000);
                    if (obstacleSet.contains(code)) {
                        x -= dx[di];
                        y -= dy[di];
                        break;
                    }
                }
                max = Math.max(max, x * x + y * y);
            }
        }
        return max;
    }
}
