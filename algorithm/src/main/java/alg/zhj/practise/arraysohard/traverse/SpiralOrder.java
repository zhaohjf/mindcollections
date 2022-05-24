package alg.zhj.practise.arraysohard.traverse;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int top = 0; int bottom = matrix.length;
        int left = 0; int right = matrix[0].length;

        while(true){
            for(int i = left ; i <= right ; ++i) ans.add(matrix[top][i]);
            if(++top > bottom) break;

            for(int i = top ; i <= bottom ; ++i) ans.add(matrix[i][right]);
            if(--right < left) break;

            for(int i = right ; i >= left ; --i) ans.add(matrix[bottom][i]);
            if(--bottom < top) break;

            for(int i = bottom ; i >= top ; --i) ans.add(matrix[i][left]);
            if(++left > right) break;
        }
        return ans;

    }
}
