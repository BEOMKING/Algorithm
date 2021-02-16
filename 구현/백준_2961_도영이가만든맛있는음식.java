package 구현;

import java.io.*;
import java.util.StringTokenizer;

public class 백준_2961_도영이가만든맛있는음식 {
    static int N;
    static int material[][];
    static boolean isselected[];
    static int result = Integer.MAX_VALUE;

    static void subset(int count){
        if(count == N){
            int sin = 1, ssun = 0;
            int truesum = 0;
            for(int i = 0; i < N; i++){
                if(isselected[i] == true){
                    sin *= material[i][0];
                    ssun += material[i][1];
                    truesum += 1;
                }
            }
            if(truesum == 0) return;
            int distance = Math.abs(sin - ssun);
            result = Math.min(result, distance);
            return;
        }
        isselected[count] = true;
        subset(count + 1);
        isselected[count] = false;
        subset(count + 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        isselected = new boolean[N];
        material = new int[N][2];

        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine());
            material[n][0] = Integer.parseInt(st.nextToken());
            material[n][1] = Integer.parseInt(st.nextToken());
        }
        subset(0);
        System.out.println(result);
    }
}
