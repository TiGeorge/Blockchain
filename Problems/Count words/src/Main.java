import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        String s = reader.readLine().trim();
        if (s.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(Arrays.stream(s.split("\\s+")).count());
        }
        reader.close();
    }
}