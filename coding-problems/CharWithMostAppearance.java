import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class CharWithMostAppearance {
    public static void main(String[] args) {
        String input = "Sanjay";
        // By conventional methods
        System.out.println(charWithMostAppearance(input));

        // By java 8
        Optional<Character> mostAppear = input
                .chars() // Convert String to character
                .mapToObj(c -> (char) c) // Convert char to Character
                .collect(Collectors.groupingBy(c -> c, Collectors.counting())) // Map of Character, and it's count
                .entrySet() // Get all entries of the map
                .stream() // stream over map entries
                .max(Entry.comparingByValue()) // get max value from the map
                .map(Entry::getKey); // get the key of the max value entry
        if (mostAppear.isPresent()) {
            System.out.println(mostAppear.get());
        }
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
