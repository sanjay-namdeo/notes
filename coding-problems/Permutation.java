public class Permutation {
    public static void main(String[] args) {
        generatePermutations("ABC");
    }

    private static void generatePermutations(String input) {
        permutePrint("", input);
    }

    private static void permutePrint(String prefix, String str) {
        int n = str.length();

        if (n == 0) {
            System.out.println(prefix + " ");
        } else {
            for (int i = 0; i < n; i++) {
                permutePrint(prefix + str.charAt(i), str.substring(i + 1, n)
                        + str.substring(0, i));
            }
        }
    }
}
