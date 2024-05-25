import java.util.Scanner;

public class Knapsack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the number of items
        System.out.println("Enter the number of items:");
        int a = scanner.nextInt();

        int[] we = new int[a]; // Array to hold item weights
        int[] v = new int[a];  // Array to hold item values

        // Ask the user for the weights of the items
        System.out.println("Enter the weights of the items:");
        for (int j = 0; j < a; j++) {
            we[j] = scanner.nextInt();
        }

        // Ask the user for the values of the items
        System.out.println("Enter the values of the items:");
        for (int j = 0; j < a; j++) {
            v[j] = scanner.nextInt();
        }

        // Ask the user for the knapsack's capacity
        System.out.println("Enter the capacity of the knapsack:");
        int ca = scanner.nextInt();

        // Compute the maximum value achievable
        int maxValue = knapsack(we, v, a, ca);
        System.out.println("Maximum value in knapsack: " + maxValue);
    }

    // Function to solve the knapsack problem using dynamic programming
    public static int knapsack(int[] we, int[] v, int a, int ca) {
        int[][] dp = new int[a + 1][ca + 1]; // DP table to store subproblem solutions

        // Populate the DP table
        for (int j = 0; j <= a; j++) {
            for (int w = 0; w <= ca; w++) {
                if (j == 0 || w == 0) { // Base case: no items or zero capacity
                    dp[j][w] = 0;
                } else if (we[j - 1] <= w) { // Current item can be included
                    dp[j][w] = Math.max(v[j - 1] + dp[j - 1][w - we[j - 1]], dp[j - 1][w]);
                } else { // Current item cannot be included
                    dp[j][w] = dp[j - 1][w];
                }
            }
        }

        // Display the DP table
        System.out.println("DP Table:");
        for (int j = 0; j <= a; j++) {
            for (int w = 0; w <= ca; w++) {
                System.out.print(dp[j][w] + " ");
            }
            System.out.println();
        }

        // Return the maximum value that can be carried
        return dp[a][ca];
    }
}
