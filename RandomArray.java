package heapsort;

import static java.lang.Math.random;

public class RandomArray {

    private final int[] arr;
    private final int size;

    RandomArray(int s, int maxnumber) {
        size = s;
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (maxnumber * random());
        }
    }

    void display() {
        System.out.println("Array:");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]);
            System.out.print(" - ");
        }
        System.out.println();
    }

    int[] getArray() {
        return arr;
    }

}
