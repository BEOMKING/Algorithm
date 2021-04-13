package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4014_활주로건설 {
    static int map[][];
    static int tmap[][];
    static int N, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            int answer = 0;
            map = new int[N][N];
            tmap = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int now = Integer.parseInt(st.nextToken());
                    map[i][j] = now;
                    tmap[j][i] = now;
                }
            }

            for (int i = 0; i < N; i++) {
                if(available(map[i])) answer++;
                if(available(tmap[i])) answer++;
            }
            sb.append("#" + (t + 1) + " " + answer + "\n");
        }
        System.out.print(sb.toString());
    }
    static boolean available(int[] temp){
        int before = temp[0];
        int count = 0;
        for (int i = 0; i < N; i++) {
            if(temp[i] == before){
                count++;
            }else if(temp[i] == before + 1){
                if(count < X) return false;
                before++;
                count = 1;
            }else if(temp[i] == before - 1){
                int cnt = 0;
                for (int j = i; j < N; j++) {
                    if(temp[j] != before - 1) break;
                    if(++cnt == X) break;
                }
                if(cnt < X) return false;
                i += X - 1;
                before--;
                count = 0;
            }else{
                return false;
            }
        }
        return true;
    }
}
