package 구현.순열과조합;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_15654_N과M5 {
    static int N;
    static int M;
    static int numbers[];
    static boolean isselected[];
    static int array[];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void reversepermu(int count) throws IOException {
        if(count == M){
            for(int num : numbers){
                bw.write(num + " ");
            }
            bw.newLine();
            return;
        }
        for(int i = 0; i < N; i++){
            if(isselected[i] != true){
                numbers[count] = array[i];
                isselected[i] = true;
                reversepermu(count + 1);
                isselected[i] = false;
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
        isselected = new boolean[N];

        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        reversepermu(0);

        bw.flush();
        bw.close();
    }
}
