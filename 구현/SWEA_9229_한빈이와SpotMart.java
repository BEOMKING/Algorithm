package 구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_9229_한빈이와SpotMart {
    static int max;
    static int numbers[];

    static void combi(int[] bongi, int r, int count, int start, int M) {
        if (count == r) {
            int result = numbers[0] + numbers[1]; // 조합의 합
            if(M < result){ // 제한 무게보다 높다면 리턴
                return;
            }
            else if(max < result){ // 제한 무게보다 낮으면서 현재 무게보다 높다면
                max = result;
                return;
            }
            return;
        }
        for(int i = start; i < bongi.length; i++){
            numbers[count] = bongi[i];
            combi(bongi, r, count + 1, i + 1, M);
        }
    }
    public static void main (String[]args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st1.nextToken()); // 봉지의 개수
            int M = Integer.parseInt(st1.nextToken()); // 무게 합 제한
            int bongi[] = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            max = 0;
            for (int n = 0; n < N; n++) {
                bongi[n] = Integer.parseInt(st.nextToken());
            }
            int r = 2; // 최대 두 봉지
            numbers = new int[2];
            combi(bongi, r, 0, 0, M);
            if(max == 0){max = - 1;}
            sb.append("#" + (tc + 1) + " " + max + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}// 이중 for문으로 일일이 계산해서 비교하면 되는걸 괜히 조합 짜면서 고생했다.
