import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalInt;

public class CharWithMostAppearance {
    public static void main(String[] args) {
        System.out.println(charWithMostAppearance(""));
    }

    private static Character charWithMostAppearance(String string) {
        Map<Character, Integer> charMap = getCharMap(string);
        OptionalInt maxOccurance = charMap.values().stream().mapToInt(v -> (int) v).max();
        if (maxOccurance.isPresent()) {
            int max = maxOccurance.getAsInt();

            for (Entry<Character, Integer> entry : charMap.entrySet()) {
                if (entry.getValue() == max)
                    return Character.valueOf(entry.getKey());
            }
        }
        return null;
    }

    private static Map<Character, Integer> getCharMap(String input) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char ch : input.toCharArray()) {
            if (charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }
        }
        System.out.println(charMap);
        return charMap;
    }
}
