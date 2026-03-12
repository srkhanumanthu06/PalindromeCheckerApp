import java.util.*;

public class PalindromeCheckerApp {

    // UC8 Node class
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // UC9 Recursive method
    static boolean isPalindromeRecursive(String str, int start, int end) {

        if (start >= end)
            return true;

        if (str.charAt(start) != str.charAt(end))
            return false;

        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    // UC11 OOP Service
    static class PalindromeChecker {

        public boolean checkPalindrome(String str) {

            str = str.replaceAll("\\s+", "").toLowerCase();

            int start = 0;
            int end = str.length() - 1;

            while (start < end) {

                if (str.charAt(start) != str.charAt(end))
                    return false;

                start++;
                end--;
            }

            return true;
        }
    }

    // UC12 Strategy Pattern

    interface PalindromeStrategy {
        boolean check(String str);
    }

    static class StackStrategy implements PalindromeStrategy {

        public boolean check(String str) {

            Stack<Character> stack = new Stack<>();

            for (char c : str.toCharArray())
                stack.push(c);

            for (char c : str.toCharArray()) {

                if (c != stack.pop())
                    return false;
            }

            return true;
        }
    }

    static class DequeStrategy implements PalindromeStrategy {

        public boolean check(String str) {

            Deque<Character> deque = new ArrayDeque<>();

            for (char c : str.toCharArray())
                deque.addLast(c);

            while (deque.size() > 1) {

                if (deque.removeFirst() != deque.removeLast())
                    return false;
            }

            return true;
        }
    }

    public static void main(String[] args) {

        // UC1
        System.out.println("Welcome to Palindrome Checker App");
        System.out.println("Application Version: 1.0");

        // UC2
        String word = "madam";
        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--)
            reversed += word.charAt(i);

        if (word.equals(reversed))
            System.out.println(word + " is a Palindrome");
        else
            System.out.println(word + " is not a Palindrome");

        Scanner sc = new Scanner(System.in);

        // UC3
        System.out.print("Enter a string to check palindrome: ");
        String input = sc.nextLine();

        String rev = "";

        for (int i = input.length() - 1; i >= 0; i--)
            rev += input.charAt(i);

        System.out.println(input.equals(rev)
                ? "Palindrome (Using Reverse)"
                : "Not a Palindrome (Using Reverse)");

        // UC4
        char[] arr = input.toCharArray();

        int start = 0;
        int end = arr.length - 1;
        boolean isPal = true;

        while (start < end) {

            if (arr[start] != arr[end]) {
                isPal = false;
                break;
            }

            start++;
            end--;
        }

        System.out.println(isPal
                ? "Palindrome (Using Character Array)"
                : "Not a Palindrome (Using Character Array)");

        // UC5
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray())
            stack.push(c);

        String stackRev = "";

        while (!stack.isEmpty())
            stackRev += stack.pop();

        System.out.println(input.equals(stackRev)
                ? "Palindrome (Using Stack)"
                : "Not a Palindrome (Using Stack)");

        // UC6
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack2 = new Stack<>();

        for (char c : input.toCharArray()) {

            queue.add(c);
            stack2.push(c);
        }

        boolean qs = true;

        while (!queue.isEmpty()) {

            if (queue.remove() != stack2.pop()) {
                qs = false;
                break;
            }
        }

        System.out.println(qs
                ? "Palindrome (Using Queue + Stack)"
                : "Not a Palindrome (Using Queue + Stack)");

        // UC7
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray())
            deque.addLast(c);

        boolean dq = true;

        while (deque.size() > 1) {

            if (deque.removeFirst() != deque.removeLast()) {
                dq = false;
                break;
            }
        }

        System.out.println(dq
                ? "Palindrome (Using Deque)"
                : "Not a Palindrome (Using Deque)");

        // UC8 Linked List
        Node head = null, tail = null;

        for (char c : input.toCharArray()) {

            Node newNode = new Node(c);

            if (head == null)
                head = tail = newNode;
            else {

                tail.next = newNode;
                tail = newNode;
            }
        }

        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null, curr = slow;

        while (curr != null) {

            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node first = head, second = prev;

        boolean ll = true;

        while (second != null) {

            if (first.data != second.data) {
                ll = false;
                break;
            }

            first = first.next;
            second = second.next;
        }

        System.out.println(ll
                ? "Palindrome (Using Linked List)"
                : "Not a Palindrome (Using Linked List)");

        // UC9
        System.out.println(isPalindromeRecursive(input, 0, input.length() - 1)
                ? "Palindrome (Using Recursion)"
                : "Not a Palindrome (Using Recursion)");

        // UC10
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        String normalizedRev = new StringBuilder(normalized).reverse().toString();

        System.out.println(normalized.equals(normalizedRev)
                ? "Palindrome (Ignoring Case & Spaces)"
                : "Not a Palindrome (Ignoring Case & Spaces)");

        // UC11
        PalindromeChecker checker = new PalindromeChecker();

        System.out.println(checker.checkPalindrome(input)
                ? "Palindrome (Using OOP Service)"
                : "Not a Palindrome (Using OOP Service)");

        // UC12 Strategy Pattern

        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeStrategy dequeStrategy = new DequeStrategy();

        System.out.println(stackStrategy.check(input)
                ? "Palindrome (Strategy Pattern - Stack)"
                : "Not a Palindrome (Strategy Pattern - Stack)");

        System.out.println(dequeStrategy.check(input)
                ? "Palindrome (Strategy Pattern - Deque)"
                : "Not a Palindrome (Strategy Pattern - Deque)");

        // UC13: Performance Comparison of Algorithms

        System.out.println("\n--- Performance Comparison ---");

        long startTime, endTime;

// Reverse Method
        startTime = System.nanoTime();

        String revPerf = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            revPerf += input.charAt(i);
        }
        input.equals(revPerf);

        endTime = System.nanoTime();
        System.out.println("Reverse Method Time: " + (endTime - startTime) + " ns");


// Character Array Method
        startTime = System.nanoTime();

        char[] perfArr = input.toCharArray();
        int s = 0, e = perfArr.length - 1;

        while (s < e) {
            if (perfArr[s] != perfArr[e])
                break;
            s++;
            e--;
        }

        endTime = System.nanoTime();
        System.out.println("Character Array Method Time: " + (endTime - startTime) + " ns");


// Stack Method
        startTime = System.nanoTime();

        Stack<Character> perfStack = new Stack<>();

        for (char c : input.toCharArray())
            perfStack.push(c);

        while (!perfStack.isEmpty())
            perfStack.pop();

        endTime = System.nanoTime();
        System.out.println("Stack Method Time: " + (endTime - startTime) + " ns");


// Deque Method
        startTime = System.nanoTime();

        Deque<Character> perfDeque = new ArrayDeque<>();

        for (char c : input.toCharArray())
            perfDeque.addLast(c);

        while (perfDeque.size() > 1) {
            perfDeque.removeFirst();
            perfDeque.removeLast();
        }

        endTime = System.nanoTime();
        System.out.println("Deque Method Time: " + (endTime - startTime) + " ns");

        sc.close();
    }
}