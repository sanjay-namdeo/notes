import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveDuplicateChar {
    public static void main(String[] args) {
        System.out.println(removeDuplicateChar("Sanjay"));
        System.out.println(removeDuplicateCharJava8("Sanjay"));
    }

    private static String removeDuplicateChar(String string) {
        if (string.length() == 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : string.toCharArray()) {
            if (sb.indexOf(String.valueOf(ch)) == -1) {
                sb.append(String.valueOf(ch));
            }
        }
        return sb.toString();
    }

    private static String removeDuplicateCharJava8(String string) {
        return Arrays.asList(string.split("")).stream().distinct().collect(Collectors.joining());
    }
}
