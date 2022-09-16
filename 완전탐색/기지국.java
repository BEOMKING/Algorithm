package 완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 기지국 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            String Maps[][] = new String[n][n];
            int result = 0;

            for (int i = 0; i < n; i++) {
                String st = br.readLine();
                Maps[i] = st.split(""); // 띄어쓰기 없는 입력 분리
            }

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    if (Maps[i][j].equals("A")) {
                        if (i - 1 >= 0) {
                            Maps[i - 1][j] = "X";
                        }
                        if (i + 1 < n) {
                            Maps[i + 1][j] = "X";
                        }
                        if (j - 1 >= 0) {
                            Maps[i][j - 1] = "X";
                        }
                        if (j + 1 < n) {
                            Maps[i][j + 1] = "X";
                        }
                    } else if (Maps[i][j].equals("B")) {
                        for (int k = 1; k <= 2; k++) {
                            if (i - k >= 0) {
                                Maps[i - k][j] = "X";
                            }
                            if (i + k < n) {
                                Maps[i + k][j] = "X";
                            }
                            if (j - k >= 0) {
                                Maps[i][j - k] = "X";
                            }
                            if (j + k < n) {
                                Maps[i][j + k] = "X";
                            }
                        }
                    } else if (Maps[i][j].equals("C")) {
                        for (int k = 1; k <= 3; k++) {
                            if (i - k >= 0) {
                                Maps[i - k][j] = "X";
                            }
                            if (i + k < n) {
                                Maps[i + k][j] = "X";
                            }
                            if (j - k >= 0) {
                                Maps[i][j - k] = "X";
                            }
                            if (j + k < n) {
                                Maps[i][j + k] = "X";
                            }
                        }
                    }
                }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (Maps[i][j].equals("H")) {
                        result += 1;
                    }
                }
            }

            System.out.println("#" + (t + 1) + " " + result);
        }
    }
}