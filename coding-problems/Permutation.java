import java.util.stream.IntStream;

public class Permutation {
    public static void main(String[] args) {
        generatePermutations("ABC");
    }

    private static void generatePermutations(String string) {
        printPermutations("", string);
        // printPermutationsJava8("", string);
    }

    private static void printPermutations(String prefix, String input) {
        int n = input.length();

        if (n == 0) {
            System.out.printf(prefix + " ");
        } else {
            for (int i = 0; i < n; i++) {
                printPermutations(prefix + input.charAt(i), input.substring(i + 1, n) + input.substring(0, i));
            }
        }
    }

    private static void printPermutationsJava8(String prefix, String input) {
        int n = input.length();

        if (n == 0) {
            System.out.println(prefix);
        } else {
            IntStream.range(0, n).parallel().forEach(i -> printPermutations(prefix + input.charAt(i),
                    input.substring(i + 1, n) + input.substring(0, i)));
        }
    }
}
