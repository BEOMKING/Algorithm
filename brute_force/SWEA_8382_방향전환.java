package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_8382_방향전환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int starty = Integer.parseInt(st.nextToken());
            int startx = Integer.parseInt(st.nextToken());
            int endy = Integer.parseInt(st.nextToken());
            int endx = Integer.parseInt(st.nextToken());
            int y = Math.abs(endy - starty);
            int x = Math.abs(endx - startx);

            int answer;
            if(y < x){
                int temp = y;
                y = x;
                x = temp;
            }
            if(y - x == 0){
                answer = y + x;
            }else if(Math.abs(y - x) % 2 == 0){
                answer = 2 * y;
            }else{
                answer = 2 * y - 1;
            }
            System.out.println("#" + t + " " + answer);
        }
    }
}
