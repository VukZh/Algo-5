package heapsort;

public class HeapsortApp {

    public static void main(String[] args) {

        int SizeHeap = 10000000;
        RandomArray ra = new RandomArray(SizeHeap, 10000000);
//        ra.display();
        int ra1[] = ra.getArray();

        Heap h1 = new Heap(SizeHeap);

        long timeStartA1 = System.currentTimeMillis();
        h1.BuildHeap(ra1);
        
//        h1.DisplayHeap();
//        h1.DisplayArrFromHeap();
        
        h1.HeapSort();
        
        long timeStopA1 = System.currentTimeMillis() - timeStartA1;
        System.out.println("время выполнения пирамидальной сортировкой " + timeStopA1 + " миллисекунд");
        
//        h1.DisplayHeap();
//        h1.DisplayArrFromHeap();

    }

}
