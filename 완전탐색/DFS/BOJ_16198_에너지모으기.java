package 완전탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16198_에너지모으기 {
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] energy = new int[N];
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            energy[i] = Integer.parseInt(inputs[i]);
        }

        dfs(energy, 0);
        System.out.println(max);
    }

    private static void dfs(final int[] energy, final int sum) {
        if (energy.length == 2) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 1; i < energy.length - 1; i++) {
            int[] newEnergy = new int[energy.length - 1];
            int index = 0;
            for (int j = 0; j < energy.length; j++) {
                if (j == i) {
                    continue;
                }
                newEnergy[index++] = energy[j];
            }
            dfs(newEnergy, sum + energy[i - 1] * energy[i + 1]);
        }
    }
}
