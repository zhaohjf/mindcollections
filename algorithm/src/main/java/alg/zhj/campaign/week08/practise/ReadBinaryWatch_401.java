package alg.zhj.campaign.week08.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaohongjie on 2020/8/7.
 */
public class ReadBinaryWatch_401 {

    public List<String> readBinaryWatch(int num){
        List<String>times=new ArrayList<>();
        for(int h=0;h<12;h++){
            for(int m=0;m<60;m++){
                if(Integer.bitCount(h)+Integer.bitCount(m)==num)
                    times.add(String.format("%d:%02d",h,m));
            }
        }
        return times;
    }
}
