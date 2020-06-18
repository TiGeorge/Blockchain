import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        DynamicArray<Integer> integerDynamicArray = new DynamicArray<>();
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            if ("add".equals(command[0])) {
                integerDynamicArray.add(Integer.parseInt(command[1]));
            } else if ("remove".equals(command[0])) {
                integerDynamicArray.remove(integerDynamicArray.size() - 1);
            } else if ("size".equals(command[0])) {
                System.out.println(integerDynamicArray.size());
            }
        }
    }
}

class DynamicArray<E> {
    private Object[] arr;
    private int size;

    private final int DEFAULT_CAPACITY = 10;
    private final double SCALING_FACTOR = 1.5;

    public DynamicArray() {
        this.arr = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public DynamicArray(int initialCapacity) {
        this.arr = new Object[initialCapacity > 0 ? initialCapacity : DEFAULT_CAPACITY];
        this.size = 0;
    }

    private void tryIncrease() {
        if (arr.length == size)
            arr = Arrays.copyOf(arr, (int) (arr.length * SCALING_FACTOR));
    }

    public void add(E value) {
        tryIncrease();
        arr[size++] = value;
    }

    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        E oldValue = (E) arr[index];
        int moveCount = size - index - 1;
        if (moveCount > 0)
            System.arraycopy(arr, index + 1, arr, index, moveCount);
        arr[--size] = null;
        return oldValue;
    }

    public int size() {
        return size;
    }
}