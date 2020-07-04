package blockchain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> ints = Lists.toList(1, 2, 3);
        List<String> words = Lists.toList("hello", "world");
        List<Integer> ints1 = Lists.toList();
        List<Object> objs = Lists.toList(1, "two");
    }

    double sumCount(Collection<? extends Number super Integer> coll, int n) {

    }
}

class Lists {
    public static <T> List<T> toList(T... arr) {
        List<T> list = new ArrayList<T>();
        for (T elt : arr) list.add(elt);
        return list;
    }

    public static void main(String[] args) {
        List<?> list = Lists.<Object>toList(1, "two");
    }
}

