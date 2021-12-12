package com.gj1e.test;

import java.util.*;

/**
 * @author FenDa
 */
public class TopK {
    public static List<Integer> solution(List<Integer>[] lists) {
        List<Integer> res = new ArrayList<>();

        Queue<Integer> maxHeap = new PriorityQueue<>(10, (a, b) -> (b - a));
        for (int i = 0; i < lists.length; i++) {
            List<Integer> list = lists[i];
            for (int j = 0; j < list.size(); j++) {
                maxHeap.add(list.get(j));
            }
        }

        for (int i = 0; i < 10; i++) {
            res.add(maxHeap.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>(){{
            add(1);
            add(4);
            add(2);
            add(3);
            add(0);
            add(-9);
        }};
        List<Integer> list2 = new ArrayList<Integer>(){{
            add(9);
            add(10);
            add(4);
            add(20);
            add(40);
            add(80);
            add(1200);
        }};
        List<Integer> list3 = new ArrayList<Integer>(){{
            add(15);
            add(11);
            add(2);
            add(3);
            add(4);
            add(-7);
        }};
        List<Integer> list4 = new ArrayList<Integer>(){{
            add(23);
            add(20);
            add(2);
            add(5);
        }};
        List<Integer> list5 = new ArrayList<Integer>(){{
            add(1);
        }};
        List<Integer>[] lists = new List[]{list1, list2, list3, list4, list5};
        List<Integer> solution = solution(lists);
        solution.forEach(System.out::println);

    }
}
