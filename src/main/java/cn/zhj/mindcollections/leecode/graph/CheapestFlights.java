package cn.zhj.mindcollections.leecode.graph;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by zhaohongjie on 2018/10/26.
 */
public class CheapestFlights {

    private Map<Integer, List<int[]>> flightsMap;
    private int minPrice;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        flightsMap = new HashMap<>();
        for (int[] flight : flights) {
            if (!flightsMap.containsKey(flight[0])) {
                flightsMap.put(flight[0], new ArrayList<>());
            }
            flightsMap.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        minPrice = Integer.MAX_VALUE;
        dfs(0, K, src, dst, new HashSet<>());
        return (minPrice == Integer.MAX_VALUE) ? -1 : minPrice;
    }

    private void dfs(int price, int stop, int curr, int dst, Set<Integer> visited) {
        if (stop < -1) return;
        if (curr == dst) {
            minPrice = Math.min(minPrice, price);
            return;
        }
        if (flightsMap.containsKey(curr)) {
            for (int[] to : flightsMap.get(curr)) {
                if (visited.add(to[0])) {
                    dfs(price + to[1], stop - 1, to[0], dst, visited);
                    visited.remove(to[0]);
                }
            }
        }
    }

    public static void main(String[] args) {

        int[][] path = {{0,1,100},{1,2,100},{0,2,500}};

        CheapestFlights cheapestFlights = new CheapestFlights();
        int cheapestPrice = cheapestFlights.findCheapestPrice(3, path, 0, 2, 1);

        Consumer<Integer> consumer = System.out::println;
        consumer.accept(cheapestPrice);


    }
}
