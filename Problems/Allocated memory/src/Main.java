import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double scaling = scanner.nextDouble();
        double downscaling = scanner.nextDouble();
        scanner.nextLine();
        DynamicArray<Integer> list = new DynamicArray<Integer>(2, scaling, downscaling);

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            if ("add".equals(command[0])) {
                for (int j = 0; j < Integer.parseInt(command[1]); j++) {
                    list.add(1);
                }
            } else if ("delete".equals(command[0])) {
                for (int j = 0; j < Integer.parseInt(command[1]); j++) {
                    list.remove(list.size() - 1);
                }
            } else if ("count".equals(command[0])) {
                System.out.println(list.count());
            }
        }
    }
}

class DynamicArray<E> {
    private Object[] arr;
    private int size;

    private final int DEFAULT_CAPACITY = 10;
    private double SCALING_FACTOR = 1.5;
    private double downscaling;

    public DynamicArray() {
        this.arr = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public DynamicArray(int initialCapacity, double scallingFactor, double downscaling) {
        this.arr = new Object[initialCapacity > 0 ? initialCapacity : DEFAULT_CAPACITY];
        this.SCALING_FACTOR = scallingFactor;
        this.size = 0;
        this.downscaling = downscaling;
    }

    private void tryIncrease() {
        if (arr.length == size) {
            arr = Arrays.copyOf(arr, (int) Math.ceil(arr.length * SCALING_FACTOR));
        }
    }

    private void tryDecrease() {
        if (arr.length == size * downscaling) {
            arr = Arrays.copyOf(arr, (int) Math.ceil(arr.length / downscaling));
        }
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
        tryDecrease();
        return oldValue;
    }

    public int size() {
        return size;
    }

    public int count() {
        return arr.length;
    }
}
