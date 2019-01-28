package heapsort;

class HeapElement {

    private int KeyElement;

    public HeapElement(int data) {
        KeyElement = data;
    }

    public int getKey() {
        return KeyElement;
    }

    public void setKey(int key) {
        KeyElement = key;
    }

}

class Heap {

    private HeapElement[] h_array;
    private int sizeArray;
    private int sizeHeap;

    public Heap(int max) {
        sizeArray = max;
        sizeHeap = 0;
        h_array = new HeapElement[sizeArray];
    }

    public boolean insertElement(int key) {
        if (sizeHeap == sizeArray) {
            return false;
        }
        HeapElement newElement = new HeapElement(key);
        h_array[sizeHeap] = newElement;
        GetUp(sizeHeap++);
        return true;
    }

    public void insertElementAt(int key, HeapElement newHeapElement) {
        h_array[key] = newHeapElement;
    }

    public void GetUp(int index) { // перемещение элемента вверх при вставке
        int parent = (index - 1) / 2; // узнаем родителя
        HeapElement bottom = h_array[index]; // сохраняем вставляемый элемент
        while (index > 0 && h_array[parent].getKey() < bottom.getKey()) { /////// находим в цикле 1-й узел где вставляемый элемент не больше родителя и вычисляем его индекс
            h_array[index] = h_array[parent]; // опускаем родителя на один уровень
            index = parent; // искомый узел поднимаем на один уровень
            parent = (parent - 1) / 2; // вычислаем родителя для следующего шага       
        }
        h_array[index] = bottom; // index найден, вставляем элемент
    }

    public HeapElement removeElement() { // удаление верхнего элемента пирамиды
        HeapElement rootElement = h_array[0];
        if (sizeHeap < 1) {
            System.out.println("пирамида пустая");
        };
        h_array[0] = h_array[--sizeHeap];
        Drown(0);
        return rootElement;
    }

    public void Drown(int index) { // перемещение элемента вниз при удалении сверху
        int larger;
        HeapElement top = h_array[index]; // сохраняем корень на месте вставки
        while (index < sizeHeap / 2) { /////// пока внизу есть потомки, определение большего из них в цикле и перестановка если потомок больше вставляемого элемента
            int l_Child = 2 * index + 1;
            int r_Child = l_Child + 1;
            if (r_Child < sizeHeap && h_array[l_Child].getKey() < h_array[r_Child].getKey()) {
                larger = r_Child;
            } else {
                larger = l_Child;
            }
            if (top.getKey() >= h_array[larger].getKey()) {
                break; // выход из цикла если потомок меньше вставляемого элемента    
            }
            h_array[index] = h_array[larger]; // поднимаем потомка, т.к. он больше
            index = larger; // переходим вниз          
        }
        h_array[index] = top; //вставляем элемент в найденный в цикле индекс 

    }

    public void DisplayHeap() {
        int itemsPerRow = 1;
        int itemsPerCol = 0;
        int indexElement = 0;
        System.out.println("Heaparray:");
        while (sizeHeap > 0) {
            System.out.print(h_array[indexElement].getKey());
            if (++indexElement == sizeHeap) {
                break;
            }
            if (++itemsPerCol == itemsPerRow) {
                itemsPerRow *= 2;
                itemsPerCol = 0;
                System.out.println();
            } else {
                if (itemsPerCol % 2 != 0) {
                    System.out.print("-");
                } else {
                    System.out.print("  ");
                }
            }
        }
        System.out.println();
    }

    public void DisplayArrFromHeap() {
        for (int i = 0; i < sizeHeap; i++) {
            System.out.print(h_array[i].getKey() + " - ");
        }
        System.out.println("");

    }

    public void CreateHeap(int[] arr) { // построение пирамиды из числового массива
        if (arr.length > sizeArray) {
            System.out.println("размер массива больше размера пирамиды !!!");
//            break;
        }
        for (int i = 0; i < arr.length; i++) {
            HeapElement newElement = new HeapElement(arr[i]);
            h_array[i] = newElement;
            sizeHeap++;
//            GetUp (sizeHeap++);

        }
    }

    public void BuildHeap(int[] arr) { // сортировка пирамиды 

        CreateHeap(arr);

        for (int j = sizeHeap / 2 - 1; j >= 0; j--) { // построение пирамиды
            Drown(j);
        }
    }

    public int getHeapSize() { // построение пирамиды из числового массива
        return sizeHeap;
    }

    public void HeapSort() { // сортировка - заполняем массив начиная с вершины пирамиды и прогоняем Drown (в removeElement) в цикле, затем из массива формируем новую пирамиду
        int[] arr = new int[sizeHeap];
        int j = 0;
        for (int i = sizeHeap - 1; i >= 0; i--) {
            HeapElement biggestElement = removeElement();
            insertElementAt(i, biggestElement);
            arr[j] = biggestElement.getKey();
            j++;
        }
//        CreateHeap(arr);
    }
          
}
