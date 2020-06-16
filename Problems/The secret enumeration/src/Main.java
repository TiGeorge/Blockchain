import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.stream(Secret.values())
                .filter(e -> e.name().startsWith("STAR"))
                .count());
    }
}

// At least two constants start with STAR
//enum Secret {
//    STAR, CRASH, START, // ...
//}
