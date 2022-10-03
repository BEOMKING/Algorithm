package 완전탐색.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10942_팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] palindromes = new int[n + 1];
        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            palindromes[i] = Integer.parseInt(input[i - 1]);
        }

        int[][] isPalindrome = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            isPalindrome[i][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (palindromes[i] == palindromes[i + 1]) {
                isPalindrome[i][i + 1] = 1;
            }
        }

        for (int i = 2; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                if (palindromes[j] == palindromes[j + i] && isPalindrome[j + 1][j + i - 1] == 1) {
                    isPalindrome[j][j + i] = 1;
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            sb.append(isPalindrome[start][end]).append("\n");
        }

        System.out.println(sb);
    }
}
