package alg.zhj.subject.other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhaohongjie on 2020/8/15.
 */
public class AnimalShelf {

    Queue<int[]> dogs;
    Queue<int[]> cats;

    public AnimalShelf() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        if (animal[1] == 0) {
            cats.offer(animal);
        } else {
            dogs.offer(animal);
        }
    }

    public int[] dequeueAny() {
        if (dogs.isEmpty() && cats.isEmpty()) return new int[] {-1, -1};
        if (dogs.isEmpty()) {
            return cats.poll();
        } else if (cats.isEmpty()) {
            return dogs.poll();
        } else{
            int[] dog = dogs.peek();
            int[] cat = cats.peek();
            if(dog[0] < cat[0]) return dogs.poll();
            else return cats.poll();
        }
    }

    public int[] dequeueDog() {
        if (dogs.isEmpty()) {
            return new int[] {-1, -1};
        }
        return dogs.poll();
    }

    public int[] dequeueCat() {
        if (cats.isEmpty()) {
            return new int[] {-1, -1};
        }
        return cats.poll();
    }
}
