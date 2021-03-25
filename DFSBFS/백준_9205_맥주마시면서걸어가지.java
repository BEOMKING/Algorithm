package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_9205_맥주마시면서걸어가지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            Location location[] = new Location[n + 2];
            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                location[i] = new Location(y, x);
            }

            int leng[][] = new int[n + 2][n + 2];
            for (int i = 0; i < n + 2; i++) {
                for (int j = 0; j < n + 2; j++) {
                    if(i == j) continue;
                    int len = Math.abs(location[j].y - location[i].y) + Math.abs(location[j].x - location[i].x);
                    if(len <= 1000){
                        leng[i][j] = Math.abs(location[j].y - location[i].y) + Math.abs(location[j].x - location[i].x);
                        leng[j][i] = Math.abs(location[j].y - location[i].y) + Math.abs(location[j].x - location[i].x);
                    }else{
                        leng[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            for (int i = 0; i < n + 2; i++) {
                for (int j = 0; j < n + 2; j++) {
                    if(i == j) continue;
                    for (int k = 0; k < n + 2; k++) {
                        if(i == k || j == k) continue;
                        leng[j][k] = Math.min(leng[j][k], leng[j][i] + leng[i][k]);
                    }
                }
            }
            if(leng[0][n + 1] != Integer.MAX_VALUE){
                sb.append("happy" + "\n");
            }else{
                sb.append("sad" + "\n");
            }
        }
        System.out.print(sb.toString().trim());
    }
    static class Location{
        int y;
        int x;

        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
