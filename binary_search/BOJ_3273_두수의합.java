package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273_두수의합 {
    static int sequence[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        sequence = new int[T];
        st = new StringTokenizer(br.readLine());
        for (int t = 0; t < T; t++) {
            sequence[t] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(sequence);
        int count = 0;
        int start = 0;
        int end = T - 1;

        while(start < end){
            int sum = sequence[start] + sequence[end];
            if(sum == x){
                count++;
                start++;
                end--;
            }else if(sum > x){
                end--;
            }else{
                start++;
            }
        }
        System.out.println(count);
    }
}
