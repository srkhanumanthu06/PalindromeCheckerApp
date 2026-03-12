import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    // Node class for Linked List (UC8)
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // Recursive method for UC9
    static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end)
            return true;

        if (str.charAt(start) != str.charAt(end))
            return false;

        return isPalindromeRecursive(str, start + 1, end - 1);
    }

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

        if (word.equals(reversed))
            System.out.println(word + " is a Palindrome");
        else
            System.out.println(word + " is not a Palindrome");

        Scanner sc = new Scanner(System.in);

        // UC3
        System.out.print("Enter a string to check palindrome: ");
        String input = sc.nextLine();

        String rev = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            rev = rev + input.charAt(i);
        }

        if (input.equals(rev))
            System.out.println("Palindrome (Using Reverse)");
        else
            System.out.println("Not a Palindrome (Using Reverse)");

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

        if (isPalindrome)
            System.out.println("Palindrome (Using Character Array)");
        else
            System.out.println("Not a Palindrome (Using Character Array)");

        // UC5
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        String stackReverse = "";
        while (!stack.isEmpty()) {
            stackReverse += stack.pop();
        }

        if (input.equals(stackReverse))
            System.out.println("Palindrome (Using Stack)");
        else
            System.out.println("Not a Palindrome (Using Stack)");

        // UC6
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack2 = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            queue.add(input.charAt(i));
            stack2.push(input.charAt(i));
        }

        boolean isPalindromeQS = true;

        while (!queue.isEmpty()) {
            if (queue.remove() != stack2.pop()) {
                isPalindromeQS = false;
                break;
            }
        }

        if (isPalindromeQS)
            System.out.println("Palindrome (Using Queue + Stack)");
        else
            System.out.println("Not a Palindrome (Using Queue + Stack)");

        // UC7
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        boolean isPalindromeDeque = true;

        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                isPalindromeDeque = false;
                break;
            }
        }

        if (isPalindromeDeque)
            System.out.println("Palindrome (Using Deque)");
        else
            System.out.println("Not a Palindrome (Using Deque)");

        // UC8
        Node head = null;
        Node tail = null;

        for (int i = 0; i < input.length(); i++) {
            Node newNode = new Node(input.charAt(i));

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node current = slow;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        Node firstHalf = head;
        Node secondHalf = prev;

        boolean isPalindromeLL = true;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isPalindromeLL = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        if (isPalindromeLL)
            System.out.println("Palindrome (Using Linked List)");
        else
            System.out.println("Not a Palindrome (Using Linked List)");

        // UC9
        boolean resultRecursive = isPalindromeRecursive(input, 0, input.length() - 1);

        if (resultRecursive)
            System.out.println("Palindrome (Using Recursion)");
        else
            System.out.println("Not a Palindrome (Using Recursion)");

        // UC10: Case-Insensitive & Space-Ignored Palindrome
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        String normalizedRev = "";

        for (int i = normalized.length() - 1; i >= 0; i--) {
            normalizedRev += normalized.charAt(i);
        }

        if (normalized.equals(normalizedRev))
            System.out.println("Palindrome (Ignoring Case & Spaces)");
        else
            System.out.println("Not a Palindrome (Ignoring Case & Spaces)");

        sc.close();
    }
}