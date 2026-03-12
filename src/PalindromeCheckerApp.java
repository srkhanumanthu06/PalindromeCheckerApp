import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // UC1: Application Entry & Welcome Message
        System.out.println("Welcome to Palindrome Checker App");
        System.out.println("Application Version: 1.0");

        // UC2: Hardcoded Palindrome Result
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

        // UC3: Palindrome Check Using String Reverse
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string to check palindrome: ");
        String input = sc.nextLine();

        String rev = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            rev = rev + input.charAt(i);
        }

        if (input.equals(rev)) {
            System.out.println("Palindrome (Using Reverse)");
        } else {
            System.out.println("Not a Palindrome (Using Reverse)");
        }

        // UC4: Character Array Based Palindrome Check
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

        // UC5: Stack-Based Palindrome Checker
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i)); // push characters
        }

        String stackReverse = "";

        while (!stack.isEmpty()) {
            stackReverse = stackReverse + stack.pop(); // pop characters
        }

        if (input.equals(stackReverse)) {
            System.out.println("Palindrome (Using Stack)");
        } else {
            System.out.println("Not a Palindrome (Using Stack)");
        }

        sc.close();
    }
}