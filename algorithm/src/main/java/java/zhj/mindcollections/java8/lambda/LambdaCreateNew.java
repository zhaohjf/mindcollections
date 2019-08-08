package java.zhj.mindcollections.java8.lambda;

import java.util.Random;
import java.util.function.Function;

/**
 * 利用Class::new关键字创建带参数构造函数类的创建
 *
 * Created by zhaohongjie on 2018/10/19.
 */
public class LambdaCreateNew {

    public static void main(String[] args) {
        LambdaCreateNew createNew = new LambdaCreateNew();
        long random = createNew.get().random();
        System.out.println(random);
    }

    private class RandomArray {

        private long[] array;

        RandomArray(long... values) {
            this.array = values;
        }

        public long random() {
            Random random = new Random();
            return array[random.nextInt(array.length)];
        }
    }

    private interface IRangeFactory {
        static RandomArray create(Function<long[], RandomArray> function, long... arrays) {
            return function.apply(arrays);
        }
    }

    private RandomArray get() {
        return IRangeFactory.create(RandomArray::new, 50000, 60000, 70000, 80000);
    }

}

