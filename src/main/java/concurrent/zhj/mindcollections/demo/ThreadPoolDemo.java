package concurrent.zhj.mindcollections.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaohongjie on 2018/10/23.
 */
public class ThreadPoolDemo {

    /**
     * 发送kafka消息
     *
     * @param topic
     * @param msg
     */
    public void sendKafkaMessage(String topic, String msg) {

    }

    public static void main(String[] args) {

        //TODO  创建consumer
        //TODO  订阅Topic

        // 创建大小为1的线程池
        ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();

        // 创建大小为10的线程池
        //ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        /**
         * 线程类
         *
         */
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO 消费消息
                int i = 0;
                SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println("yangwen test  " + i++ + "  " + fmtDate.format(new Date()));
            }
        });

        /**
         *
         * @param thread 要执行的线程类
         * @param 1 线程池启动后，要延迟多久去第一次执行thread
         * @param 3 线程池以3s的频率去执行thread
         * @param TimeUnit.SECONDS 时间单位，代表前面参数1和3的的时间单位
         */
        timer.scheduleAtFixedRate(thread, 1, 3, TimeUnit.SECONDS);


        /**
         * 关闭线程池
         *
         */
        try {

            // 运行30s后，关闭线程池
            Thread.sleep(30000);
            System.out.println("Shutting down Executor...");

            // 关闭线程池
            timer.shutdown();
            // 等待线程池终止
            boolean isDone = false;
            do {
                // 等待时间按具体业务需求
                isDone = timer.awaitTermination(5, TimeUnit.SECONDS);
                System.out.println("awaitTermination...");
            } while (!isDone);

            System.out.println("Finished all threads");

        } catch (InterruptedException e) {

        }

    }

}
