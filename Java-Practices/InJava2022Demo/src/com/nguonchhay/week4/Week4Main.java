package com.nguonchhay.week4;

import java.util.*;

public class Week4Main {
    public void demo() {
        // task1();
        // task3();
        // task2More();
        // task4();
        // task5();
        task6();
    }

    public void task1() {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        List<Integer> cloneArr = new ArrayList<Integer>();
        cloneArr.addAll(arr);
        cloneArr.set(1, 10);

        cloneArr.forEach(item -> {
            System.out.println("item = " + item);
        });

        System.out.println("\n--------");
        arr.forEach(item -> {
            System.out.println("item = " + item);
        });
    }

    public void task2More() {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        int sum = arr.stream().mapToInt(item -> item.intValue()).sum();
        System.out.println("Sum = " + sum);
    }

    public void task3() {
        LinkedList<Integer> arr = new LinkedList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        System.out.println("Order: ");
        Iterator<Integer> iterator = arr.iterator();
        while(iterator.hasNext()) {
            System.out.println("Item: " + iterator.next());
        }

        System.out.println("\nReverse Order: ");
        Iterator<Integer> iteratorReverse = arr.descendingIterator();
        while(iteratorReverse.hasNext()) {
            System.out.println("Item: " + iteratorReverse.next());
        }

        System.out.println("\nReverse Order with toArray(): ");
        for(Object i : arr.toArray()) {
            System.out.println("Item: " + i);
        }
    }

    public void task4() {
        Set<Integer> set1 = new HashSet<Integer>();
        set1.addAll(
            Arrays.asList(new Integer[] {1, 2, 3})
        );

        Set<Integer> set2 = new HashSet<Integer>();
        set2.add(1);
        set2.add(4);
        set2.add(5);

        Set<Integer> set = new HashSet<Integer>();
        set.addAll(set1);
        set.addAll(set2);

        set.forEach(item -> {
            System.out.println("Item: " + item);
        });
    }

    public void task5() {
        List<Integer> arr1 = new ArrayList<Integer>();
        arr1.addAll(Arrays.asList(new Integer[]{1, 2, 30}));

        List<Integer> arr2 = new ArrayList<Integer>();
        arr2.addAll(Arrays.asList(new Integer[]{1, 2, 4}));

        if (arr1.stream().mapToInt(item -> item.intValue()).sum() < arr2.stream().mapToInt(item -> item.intValue()).sum()) {
            System.out.println("Arr1 < Arr2");
        } else {
            System.out.println("Arr1 > Arr2");
        }
    }

    public void task6() {
        int[] arr = {1, 2, 3};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(i, arr[i]);
        }
        map.forEach((ind, item) -> {
            System.out.println("Item (" + ind + "): " + item);
        });
    }
}
