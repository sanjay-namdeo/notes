public class ReverseLetterAndWord {
    private static final String WHITESPACE = " ";

    public static void main(String[] args) {
        System.out.println(reverseLetterAndWord("Sanjay Namdeo"));
    }

    private static String reverseLetterAndWord(String input) {
        String[] inputWords = input.split(WHITESPACE);
        StringBuilder reversedString = new StringBuilder();
        for (int word = inputWords.length - 1; word >= 0; word--) {
            StringBuilder reversedWord = new StringBuilder();
            char[] chars = inputWords[word].toCharArray();
            for (int currentChar = chars.length - 1; currentChar >= 0; currentChar--) {
                reversedWord.append(chars[currentChar]);
            }
            reversedString.append(reversedWord).append(WHITESPACE);
        }
        return reversedString.toString();
    }
}
