import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveGivenCharacter {
    public static void main(String[] args) {
        System.out.println(removeGivenCharacter("Sanjay", 'S'));
    }

    private static String removeGivenCharacter(String string, char charToRemove) {
        return string
                .chars() // convert input string to characters
                .filter(c -> c != charToRemove) // filter out the character to be removed
                .mapToObj(c -> String.valueOf((char) c)) // convert character to String
                .collect(Collectors.joining()); // joining all the sub strings
    }
}
