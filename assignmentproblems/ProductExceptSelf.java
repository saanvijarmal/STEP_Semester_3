package assignmentproblems;

public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Forward pass: Accumulate running product of elements to the left
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Backward pass: Multiply running product of elements to the right
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * right;
            right *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] res1 = productExceptSelf(nums1);
        for (int x : res1) System.out.print(x + " ");
        System.out.println();

        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] res2 = productExceptSelf(nums2);
        for (int x : res2) System.out.print(x + " ");
        System.out.println();
    }
}
