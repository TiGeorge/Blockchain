/**
 * Class to implement
 */
class ReflexiveBaker {

    /**
     * Create bakery of the provided class.
     *
     * @param order class of bakery to create
     * @return bakery object
     */
    public <T extends Bakery> T bake(Class<T> order) {
        // Add implementation here
        try {
            return order.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Well done!");
    }

}

// Don't change classes below
class Paper {
}

class Bakery {
}

class Cake extends Bakery {
}

class Pie extends Bakery {
}

class Tart extends Bakery {
}

class ApplePie extends Pie {
}