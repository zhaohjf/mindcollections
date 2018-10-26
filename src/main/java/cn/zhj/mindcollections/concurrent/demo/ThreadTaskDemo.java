package cn.zhj.mindcollections.concurrent.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaohongjie on 2018/10/25.
 */
public class ThreadTaskDemo implements Runnable {

    String name;

    /**
     * 传入参数
     * @param userName
     */
    public ThreadTaskDemo(String userName) {
        this.name = userName;
    }

    /**
     * ThreadTaskDemo是一个类
     * name 是它的成员变量
     * ThreadTaskDemo中的任意一个方法都可以访问它的成员变量
     *
     */
    @Override
    public void run() {
        // TODO 消费消息
        int i = 0;
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(name + "  " + i++ + "  " + fmtDate.format(new Date()));
    }


    public static void main(String[] args) {

        // 在创建线程的时候就可以把参数传进去
        ThreadTaskDemo demo = new ThreadTaskDemo("yangwen");

        // 创建大小为1的线程池
        ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();

        timer.scheduleAtFixedRate(demo, 1, 3, TimeUnit.SECONDS);

        // 关闭线程池，略。。。。
    }
}
