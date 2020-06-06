import java.util.Scanner;

public class Main {
    private static class TableEntry<T> {
        private final int key;
        private final T value;
        private boolean removed;

        public TableEntry(int key, T value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }

        public void remove() {
             removed = true;   
        }

        public boolean isRemoved() {
             return removed;   
        }
    }

    private static class HashTable<T> {
        private int size;
        private TableEntry[] table;

        public HashTable(int size) {
            this.size = size;
            table = new TableEntry[size];
        }

        public boolean put(int key, T value) {
            // put your code here
            int idx = findKey(key);

            if (idx == -1) {
                rehash();
            }

            idx = findKey(key);

            table[idx] = new TableEntry<>(key, value);
            return true;
        }

        public T get(int key) {
            // put your code here
            int idx = findKey(key);

            if (idx == -1 || table[idx] == null) {
                return null;
            }

            return (T) table[idx].getValue();
        }

        public void remove(int key) {
            // put your code here
            int idx = findKey(key);

            if (idx != -1 && table[idx] != null) {
                table[idx].removed = true;
            }
        }

        private int findKey(int key) {
            // put your code here
            int hash = key % size;

            while (!(table[hash] == null || table[hash].getKey() == key)) {
                hash = (hash + 1) % size;

                if (hash == key % size) {
                    return -1;
                }
            }

            return hash;
        }

        private void rehash() {
            // put your code here
            TableEntry<T>[] oldTable = this.table;
            this.table = new TableEntry[size * 2];
            this.size *= 2;
            for (TableEntry<T> entry : oldTable) {
                put(entry.key, entry.value);
            }
        }

        @Override
        public String toString() {
            StringBuilder tableStringBuilder = new StringBuilder();

            for (int i = 0; i < table.length; i++) {
                if (table[i] == null) {
                    tableStringBuilder.append(i + ": null");
                } else {
                    tableStringBuilder.append(i + ": key=" + table[i].getKey()
                                                + ", value=" + table[i].getValue()
                                                + ", removed=" + table[i].isRemoved());
                }

                if (i < table.length - 1) {
                    tableStringBuilder.append("\n");
                }
            }

            return tableStringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        HashTable<String> table = new HashTable<>(5);
        for (int i = 0; i < n; i++) {
            String[] split = scanner.nextLine().split("\\s+");
            int key = Integer.parseInt(split[0]);
            table.put(key, split[1]);
        }
        for (int i = 0; i < m; i++) {
            table.remove(Integer.parseInt(scanner.nextLine()));
        }
        System.out.println(table);
    }
}