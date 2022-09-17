package 완전탐색.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3307_최장거리부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int leng[] = new int[N];
            int subsequence[] = new int[N];
            st = new StringTokenizer(br.readLine());
            int max = 0;

            for (int i = 0; i < N; i++) {
                subsequence[i] = Integer.parseInt(st.nextToken());
                leng[i] = 1;
                for (int j = 0; j < i; j++) {
                    if(subsequence[j] < subsequence[i]){
                        leng[i] = Math.max(leng[i], leng[j] + 1);
                        max = Math.max(leng[i], max);
                    }
                }
            }
            sb.append("#" + (t + 1) + " " + max + "\n");
        }
        System.out.print(sb.toString().trim());
    }
}
