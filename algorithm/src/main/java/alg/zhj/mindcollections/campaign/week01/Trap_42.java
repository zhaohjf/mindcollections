package alg.zhj.mindcollections.campaign.week01;


import java.util.Stack;

/**
 * Created by zhaohongjie on 2020/6/13.
 */
public class Trap_42 {

    public int trap(int[] height) {

        int ans = 0, current = 0;
        Stack<Integer> stack = new Stack<>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                Integer top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            stack.push(current++);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        Trap_42 obj = new Trap_42();
        System.out.println(obj.trap(a));
    }
}
