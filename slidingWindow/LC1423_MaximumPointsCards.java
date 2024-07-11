package slidingWindow;

public class LC1423_MaximumPointsCards {
    public static void main(String[] args) {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        System.out.println(maxScore(cardPoints, 3));
    }

    static int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int n = cardPoints.length;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        int maxSum = sum;
        for (int i = 1; i <= k; i++) {
            sum = sum - cardPoints[k - i] + cardPoints[n - i];
            if (sum > maxSum)
                maxSum = sum;
        }
        return maxSum;
    }
}
