package 구현.순열과조합;

import java.io.*;
import java.util.StringTokenizer;

public class 백준_15649_N과M1 {
    static int N;
    static int M;
    static int numbers[];
    static boolean isselected[];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static void permu(int start, int count) throws IOException{
        if(count == M){
            for(int num : numbers){
                bw.write(num + " ");
            }
            bw.newLine();
            return;
        }

        for(int i = 1; i <= N; i++){
            if(isselected[i] != true) {
                numbers[start] = i;
                isselected[i] = true;
                permu(start + 1, count + 1);
                isselected[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[M];
        isselected = new boolean[N + 1];

        permu(0, 0);
        bw.flush();
        bw.close();
    }
}
