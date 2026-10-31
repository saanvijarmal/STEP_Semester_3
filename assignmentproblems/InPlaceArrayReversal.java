package assignmentproblems;

import java.util.Arrays;
import java.util.Scanner;

public class InPlaceArrayReversal {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextLine()) return;
            String line = sc.nextLine().replaceAll("[\\[\\]\\s]", "");
            if (line.isEmpty()) return;

            String[] tokens = line.split(",");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            int left = 0;
            int right = arr.length - 1;
            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }

            System.out.println(Arrays.toString(arr));
        }
    }
}
