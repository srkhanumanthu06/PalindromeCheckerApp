import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // UC1
        System.out.println("Welcome to Palindrome Checker App");
        System.out.println("Application Version: 1.0");

        // UC2
        String word = "madam";
        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }

        if (word.equals(reversed)) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is not a Palindrome");
        }

        // UC3
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String rev = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            rev = rev + input.charAt(i);
        }

        if (input.equals(rev)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

        // UC4
        char[] chars = input.toCharArray();

        int start = 0;
        int end = chars.length - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if (isPalindrome) {
            System.out.println("Palindrome (Using Character Array)");
        } else {
            System.out.println("Not a Palindrome (Using Character Array)");
        }

        sc.close();
    }
}