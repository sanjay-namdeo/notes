import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FindFirstNonRepeatedCharacter {
    public static void main(String[] args) {
        Map<Character, Integer> charCount = getCharCount("Sanjay");
        for (Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
                break;
            }
        }
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
