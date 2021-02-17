package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 백준_1931_회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int conference[][] = new int[N][2];
        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine());
            conference[n][0] = Integer.parseInt(st.nextToken());
            conference[n][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(conference, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int diff = o1[1] - o2[1];
                if(diff == 0){
                    return o1[0] - o2[0];
                }
                return diff;
            }
        });
        int compare[] = new int[]{conference[0][1]};
        int result = 1;
        for(int i = 1; i < N; i++){
            if(compare[0] <= conference[i][0]){
                compare[0] = conference[i][1];
                result += 1;
            }
        }
        System.out.println(result);
    }
}
