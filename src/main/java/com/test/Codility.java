package com.test;

import java.util.*;

public class Codility {
    public static void main(String[] args) {
        Codility obj = new Codility();
        boolean param_1 = obj.insert(1);
        boolean param_2 = obj.remove(2);
        boolean param_3 = obj.insert(2);
        int param_4 = obj.getRandom();
        boolean param_5 = obj.remove(2);
        boolean param_6 = obj.insert(2);
        int param_7 = obj.getRandom();

        System.out.println(param_1 + " " + param_2 + " " + param_3 + " " + param_4 + " " + param_5 + " " + param_6 + " " + param_7);
    }

    List<Integer> randomList;

    public Codility() {
        randomList = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (randomList.contains(Integer.valueOf(val))) {
            return false;
        } else {
            randomList.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (randomList.contains(val)) {
            randomList.remove(Integer.valueOf(val));
            return true;
        }
        return false;
    }

    public int getRandom() {
        Random random = new Random();
        return randomList.get(random.nextInt());
    }
}
