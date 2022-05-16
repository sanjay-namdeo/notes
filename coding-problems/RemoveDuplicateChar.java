public class RemoveDuplicateChar {
    public static void main(String[] args) {
        System.out.println(removeDuplicateChar("Sanjay"));
    }

    private static String removeDuplicateChar(String string) {
        if (string.length() == 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : string.toCharArray()) {
            if (sb.indexOf(String.valueOf(ch)) == -1) {
                sb.append(String.valueOf(ch));
            }
        }
        return sb.toString();
    }
}
