package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2343_기타레슨 {
    static int N;
    static int M;
    static int lesson[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lesson = new int[N];
        int max = 0;
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++){
            lesson[n] = Integer.parseInt(st.nextToken());
            max = Math.max(max, lesson[n]);
            sum += lesson[n];
        }

        int start = max;
        int end = sum;
        int result = sum;

        while(start != end){
            int count = 0;
            int remain = 0;
            int mid = (start + end) / 2;

            for(int l = 0; l < N; l++){
                if(remain < lesson[l]){
                    count++;
                    remain = mid;
                }
                remain -= lesson[l];

            }

            if(count <= M){
                result = Math.min(result, mid);
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
}
