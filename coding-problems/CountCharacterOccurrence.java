public class CountCharacterOccurrence {
    public static void main(String[] args) {
        System.out.println(countCharacterOccurrence("Sanjay", 'S'));
        System.out.println(countCharacterOccurrenceJava8("Sanjay", 'S'));
    }

    private static int countCharacterOccurrence(String input, char toCount) {
        int initialLength = input.length();
        input = input.replace(String.valueOf(toCount), "");
        return initialLength - input.length();
    }

    private static long countCharacterOccurrenceJava8(String input, char toCount) {
        return input.chars().filter(c -> c==toCount).count();
    }
}
