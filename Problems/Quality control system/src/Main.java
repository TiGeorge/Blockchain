import java.util.List;

class QualityControl {

    public static boolean check(List<?> boxes) {
        // Add implementation here
        if (boxes.isEmpty()) {
            return true;
        }
        for (Object box : boxes) {
            if (!(box instanceof Box<?>)) {
                return false;
            }
            if (((Box<?>) box).get() == null) {
                return false;
            }
            if (!(((Box<?>) box).get() instanceof Bakery)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("Well done!");
    }

}

// Don't change the code below
class Bakery {
}

class Cake extends Bakery {
}

class Pie extends Bakery {
}

class Tart extends Bakery {
}

class Paper {
}

class Box<T> {

    private T item;

    public void put(T item) {
        this.item = item;
    }

    public T get() {
        return this.item;
    }
}