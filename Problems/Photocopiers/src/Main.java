/**
 * Class to work with
 */
class Multiplicator {

    public static <T extends Copy<T>> Folder<T>[] multiply(Folder<T> folder, int arraySize) {
        // Method to implement
        Folder<T>[] folders = new Folder[arraySize];

        for (int i = 0; i < arraySize; i++) {

            Folder<T> newFolder = new Folder<>();
            newFolder.put(folder.get().copy());
            folders[i] = newFolder;
        }

        return folders;
    }

    public static void main(String[] args) {
        System.out.println("Well done!");
    }

}

// Don't change the code below
interface Copy<T> {
    T copy();
}

class Folder<T> {

    private T item;

    public void put(T item) {
        this.item = item;
    }

    public T get() {
        return this.item;
    }
}