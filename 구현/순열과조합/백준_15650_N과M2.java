package 구현.순열과조합;

import java.io.*;
import java.util.StringTokenizer;

public class 백준_15650_N과M2 {
    static int N;
    static int M;
    static int numbers[];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void combi(int start, int count) throws IOException{
        if(count == M){
            for(int num : numbers){
                bw.write(num + " ");
            }
            bw.newLine();
            return;
        }

        for(int i = start; i <= N; i++){
            numbers[count] = i;
            combi(i + 1, count + 1);

        }
    }
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[M];

        combi(1, 0);
        bw.flush();
        bw.close();
    }
}
