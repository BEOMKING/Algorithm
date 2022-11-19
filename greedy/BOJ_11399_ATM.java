package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int[] persons = new int[n];
        for (int i = 0; i < n; i++) {
            persons[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(persons);
        int sum = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            sum += persons[i];
            result += sum;
        }

        System.out.println(result);
    }
}
