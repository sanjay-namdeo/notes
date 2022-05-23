import java.util.Arrays;

public class Anagrams {
    public static void main(String[] args) {
        String s1 = "hel lo";
        String s2 = "o lleh";

        s1 = s1.replace("\\s", "");
        s2 = s2.replace("\\s", "");

        System.out.println(checkAnagrams(s1.toCharArray(), s2.toCharArray()));
    }

    public static boolean checkAnagrams(char[] str1, char[] str2) {
        if(str1.length!=str2.length)
        return false;

        Arrays.sort(str1);
        Arrays.sort(str2);

        for (int i = 0; i < str2.length; i++) {
            if(str1[i]!=str2[i])
            return false;
        }

        return true;
    }
}
