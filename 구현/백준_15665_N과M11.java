package 구현;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_15665_N과M11 {
    static int N;
    static int M;
    static int numbers[];
    static boolean isselected[];
    static int array[];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void overlapper(int count) throws IOException {
        if(count == M){
            for(int num : numbers){
                bw.write(num + " ");
            }
            bw.newLine();
            return;
        }
        int num = 0;
        for(int i = 0; i < N; i++){
            if(num != array[i]){
                numbers[count] = array[i];
//                isselected[i] = true;
                overlapper(count + 1);
                num = array[i];
//                isselected[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[M];
        isselected = new boolean[N];
        array = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        overlapper(0);
        bw.flush();
        bw.close();

    }
}
