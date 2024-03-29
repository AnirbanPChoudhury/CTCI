
/*
* Disadvantages of Array:
* 1. Insertion at a particular location is O(n)
* 2. Space Allocation
*   a[i] = base address + (int size * i)
*   Fragmented memory cannot be used for Array allocation
* 3.
* */

import java.util.*;

public class Array {
    public static void main(String[] args) {
        int[] rawArr = new int[6];

        List<Integer> arr = new ArrayList<>();

        for(int i=1; i<=20; ++i) {
            arr.add(i);
        }
        System.out.println(arr);
        arr.add(21);
        System.out.println(arr);

        List<String> arrOfString = new ArrayList<>();
        arr.add(0, 77); //O(n)
        System.out.println(arr);

        arr.set(0, 0); //O(1)
        System.out.println(arr);

    }
}
