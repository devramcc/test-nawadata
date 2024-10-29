import java.util.*;

import static java.lang.System.in;

public class Main {

    private static String procVowel(String input) {

        Set<Character> vowels = Set.of('a', 'i', 'u', 'e', 'o');
        List<Character> resultChar = new ArrayList<>();

        for (char letter : input.toCharArray()) {
            if (resultChar.contains(letter)) {
                int index = resultChar.indexOf(letter);
                resultChar.add(index, letter);
            }
            else if (vowels.contains(letter)) {
                resultChar.add(letter);
            }
        }

        StringBuilder result = new StringBuilder();
        for (Character ch : resultChar) {
            result.append(ch);
        }
        return result.toString();
    }

    private static String procConsonant(String input) {

        Set<Character> vowels = Set.of('a', 'i', 'u', 'e', 'o');
        List<Character> resultChar = new ArrayList<>();

        for (char letter : input.toCharArray()) {
            if (resultChar.contains(letter)) {
                int index = resultChar.indexOf(letter);
                resultChar.add(index, letter);
            }
            else if (!(vowels.contains(letter))) {
                resultChar.add(letter);
            }
        }

        StringBuilder result = new StringBuilder();
        for (Character ch : resultChar) {
            result.append(ch);
        }
        return result.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(in);

        System.out.print("Input one line of words (S) : ");
        String input = scanner.nextLine().toLowerCase().replace(" ", "");

        String resultVowel = procVowel(input);
        String resultConsonant = procConsonant(input);

        System.out.println(resultVowel);
        System.out.println(resultConsonant);
    }
}