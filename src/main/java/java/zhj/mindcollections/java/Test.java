package java.zhj.mindcollections.java;

/**
 * Created by zhaohongjie on 2019/3/23.
 */
public class Test {
    public static void main(String[] args) {

        Number num = new Number(1);

        PrintJiShu jishu = new PrintJiShu(num);
        PrintOuShu oushu = new PrintOuShu(num);

        PrintJiShu jishu1 = new PrintJiShu(num);
        PrintOuShu oushu1 = new PrintOuShu(num);

        Thread jishuThread = new Thread(jishu);
        Thread oushuThread = new Thread(oushu);

        Thread jishuThread1 = new Thread(jishu1);
        Thread oushuThread1 = new Thread(oushu1);

        jishuThread.start();
        oushuThread.start();

        jishuThread1.start();
        oushuThread1.start();
    }
}
 class Number {

    public int num;

    public Number(int num) {
        this.num = num;
    }

}
 class PrintJiShu implements Runnable {

    Number number;

    public PrintJiShu(Number number) {
        this.number = number;
    }

    public void run() {

        while (number.num < 1000) {
            synchronized (number){
                // 如果是偶数，等待
                if ((number.num & 1) == 0){
                    try {
                        number.wait();
                    } catch (Exception e) {
                        // print error msg
                    }
                } else {
                    System.out.println(number.num);
                    number.num++;
                    number.notifyAll();
                }
            }
        }

    }

}
 class PrintOuShu implements Runnable {

    Number number;

    public PrintOuShu(Number number) {
        this.number = number;
    }

    public void run() {

        while (number.num < 1000) {
            synchronized(number){
                if ((number.num & 1) == 1){
                    try {
                        number.wait();
                    } catch (Exception e) {
                        // print error msg
                    }
                } else {
                    System.out.println(number.num);
                    number.num++;
                    number.notifyAll();
                }
            }
        }

    }
}

