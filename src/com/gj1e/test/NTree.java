package com.gj1e.test;

import java.util.*;

/**
 * @author FenDa
 */
public class NTree {
    class Department {
        private long id;
        private String name;
        private List<Department> children;
    }

    public List<Long> solution(Department root, String name) {
        List<Long> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Department> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Department tmp = queue.poll();
                if (name.equalsIgnoreCase(tmp.name)) {
                    res.add(tmp.id);
                }
                for (Department ele : tmp.children) {
                    queue.offer(ele);
                }
            }
        }
        return res;
    }
}
