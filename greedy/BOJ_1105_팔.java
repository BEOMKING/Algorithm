package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1105_팔 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int count = 0;
        if (input[0].length() == input[1].length()) {
            for (int i = 0; i < input[1].length(); i++) {
                if (input[0].charAt(i) != input[1].charAt(i)) break;
                if(input[0].charAt(i) == '8') count++;
            }
        }
        System.out.println(count);
    }

}
