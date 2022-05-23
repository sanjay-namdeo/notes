import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SortArrayOfString {
    public static void main(String[] args) {
        String[] sorted = sortArrayOfString(new String[] { "a", "bbb", "cc", "dddd" });
        Arrays.stream(sorted).forEach(c -> System.out.println(c));
    }

    private static String[] sortArrayOfString(String[] strings) {
        return Arrays.stream(strings).sorted(Comparator.comparingInt(String::length)).toArray(String[]::new);
    }
}
