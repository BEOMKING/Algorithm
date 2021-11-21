package 완전탐색;

import java.io.*;
import java.util.*;

public class 백준_15664_N과M10 {
    static int N;
    static int M;
    static int numbers[];
    static int array[];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void reversecombi(int start, int count) throws IOException {
        if(count == M){
            for(int num : numbers){
                bw.write(num + " ");
            }
            bw.newLine();
            return;
        }
        int num = 0;
        for(int i = start; i < N; i++) {
            if (num != array[i]) {
                numbers[count] = array[i];
                reversecombi(i + 1, count + 1);
                num = array[i];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[M];
        st = new StringTokenizer(br.readLine());
        array = new int[N];

        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        reversecombi(0, 0);

        bw.flush();
        bw.close();
    }
}

