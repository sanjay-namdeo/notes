public class Palindrome {
    public static void main(String[] args) {
        System.out.println(checkPalindrome1("Hello"));
        System.out.println(checkPalindrome2("madam"));
    }

    public static boolean checkPalindrome1(String input) {
        char[] characters = input.toCharArray();
        int n = characters.length;
        for (int i = 0; i < n / 2; i++) {
            if (characters[i] != characters[n - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkPalindrome2(String input) {
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString().equals(input);
    }
}
