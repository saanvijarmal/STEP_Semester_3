package problems;

public class ExamScoreBandCounter {

    // Finds the first index where score >= target (lower bound)
    private static int findLowerBound(int[] scores, int target) {
        int low = 0;
        int high = scores.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (scores[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // Finds the first index where score > target (upper bound)
    private static int findUpperBound(int[] scores, int target) {
        int low = 0;
        int high = scores.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (scores[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int countInBand(int[] scores, int low, int high) {
        int start = findLowerBound(scores, low);
        int end = findUpperBound(scores, high);
        return end - start;
    }

    public static void main(String[] args) {
        int[] scores1 = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println("Output 1: " + countInBand(scores1, 42, 58)); // Expected: 6

        int[] scores2 = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println("Output 2: " + countInBand(scores2, 90, 100)); // Expected: 0
    }
}
