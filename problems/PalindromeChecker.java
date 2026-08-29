public class PalindromeChecker {
    public static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left++) != text.charAt(right--)) return false;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) return true;
        if (text.charAt(0) != text.charAt(text.length() - 1)) return false;
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] arr = text.toCharArray();
        char[] reversed = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return new String(arr).equals(new String(reversed));
    }

    public static void main(String[] args) {
        String input = "madam";
        String iter = isPalindromeIterative(input) ? "Palindrome" : "Not Palindrome";
        String recur = isPalindromeRecursive(input) ? "Palindrome" : "Not Palindrome";
        String rev = isPalindromeArrayReversal(input) ? "Palindrome" : "Not Palindrome";
        
        System.out.println("Iterative: " + iter + " | Recursive: " + recur + " | Array Reversal: " + rev);
    }
}