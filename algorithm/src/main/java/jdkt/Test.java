package jdkt;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class Test {
    public static void main(String[] args) {
        RandomGeneratorFactory<RandomGenerator> L128X1024MixRandom = RandomGeneratorFactory.of("L128X1024MixRandom");
        RandomGenerator randomGenerator = L128X1024MixRandom.create(System.currentTimeMillis());
        for (int i = 0; i < 10; i++) {
            System.out.println(randomGenerator.nextInt(10));
        }
    }
}
