public class Permutation {
    public static void main(String[] args) {
        generatePermutations("ABC");
    }

    private static void generatePermutations(String string) {
        printPermutations("", string);
    }

    private static void printPermutations(String prefix, String input) {
        int n = input.length();

        if (n == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                printPermutations(prefix + input.charAt(i), input.substring(i + 1, n) + input.substring(0, i));
            }
        }
    }
}
