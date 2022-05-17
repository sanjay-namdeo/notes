import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class FindFirstNonRepeatedCharacter {
    public static void main(String[] args) {
        String input = "SanjayS";

        // Traditional way
        Map<Character, Integer> charCount = getCharCount(input);
        for (Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
                break;
            }
        }

        // Java 8 way
        System.out.println(input
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Entry::getKey).findFirst());
    }

    private static Map<Character, Integer> getCharCount(String input) {
        Map<Character, Integer> charCount = new HashMap<>();
        char[] charArry = input.toCharArray();
        for (int i = 0; i < charArry.length; i++) {
            if (charCount.containsKey(charArry[i])) {
                charCount.compute(charArry[i], (k, v) -> (v == null) ? 1 : ++v);
            } else {
                charCount.put(charArry[i], 1);
            }
        }
        return charCount;
    }
}
