package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_5215_햄버거다이어트 {
    static int N;
    static int L;
    static int max;
    static int hamberger[][];
    static boolean isselected[];

    static void subset(int count){
        if(count == N){
            int sumscore = 0, sumcalorie = 0;
            for(int i = 0; i < N; i++){
                if(isselected[i]){
                    sumscore += hamberger[i][0];
                    sumcalorie += hamberger[i][1];
                }
            }
            if(sumcalorie <= L){
                max = Math.max(max, sumscore);
            }
            return;
        }
        isselected[count] = true;
        subset(count + 1);
        isselected[count] = false;
        subset(count + 1);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            hamberger = new int[N][2];
            isselected = new boolean[N];
            max = 0;

            for(int n = 0; n < N; n++){
                st = new StringTokenizer(br.readLine());
                int Score = Integer.parseInt(st.nextToken());
                int Calorie = Integer.parseInt(st.nextToken());

                hamberger[n] = new int[]{Score, Calorie};
            }
            subset(0);
            System.out.print("#" + (t + 1) + " ");
            System.out.println(max);
        }
    }
}
