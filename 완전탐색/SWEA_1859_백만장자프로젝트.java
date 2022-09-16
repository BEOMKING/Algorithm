package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859_백만장자프로젝트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int map[] = new int[N];

            for (int i = 0; i < N; i++) {
                map[i] = Integer.parseInt(st.nextToken());
            }

            long result = 0;
            int max = 0;
            for (int i = N - 1; i >= 0; i--) {
                if(max < map[i]){
                    max = map[i];
                }else{
                    result += max - map[i];
                }
            }
            System.out.println("#" + (t + 1) + " " + result);

        }
    }
}
