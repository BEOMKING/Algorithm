package sort;

import java.io.*;

public class BOJ_10989_수정렬하기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] n = new int[10001];
        for (int i = 0; i < N; i++) {
            n[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i < n.length; i++) {
            while(n[i] > 0){
                sb.append(i + "\n");
                n[i]--;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
