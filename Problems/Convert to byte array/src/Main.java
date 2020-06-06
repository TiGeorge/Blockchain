import java.util.Arrays;
import java.util.stream.Collectors;

class Converter {
    public static char[] convert(String[] words) throws IOException {
        // implement the method
        return Arrays.stream(words).collect(Collectors.joining()).toCharArray();
    }
}
