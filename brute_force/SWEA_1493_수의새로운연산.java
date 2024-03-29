package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1493_수의새로운연산 {
    static int result;
    static int start;
    static int temp[];

    static void findxy(int value){ // (x, 1)의 값은 1부터 x까지의 합과 같다.
        int num = 1;
        int x = 1;
        int y = 1;
        while(value > num){ // (x, 1)의 값보다 크다면
            num += ++x;  // x 좌표 증가
        }                // num보다 작아진다면 그 x 좌표의 대각선에 찾는 (x, y) 값이 존재 (1씩 작아지므로)
        start = x;
        while(value != num){// 찾는 값이 현재 num 값이 아니라면
            x--; // 대각선으로 이동
            y++;
            num--;
        }
        temp[0] += x;
        temp[1] += y;
    }

    static void findanswer(int x, int y){ // # (p + q)
        start = x;
        while(x != 0){ // (x, 1)의 값
            result += x--;
        }
        while(y != 1){ // x + y방향으로 이동한 횟수만큼 증가
            result += start++;
            y--;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()); // &p
            int q = Integer.parseInt(st.nextToken()); // &q
            temp = new int[2];
            result = 0;
            findxy(p);
            findxy(q);
            findanswer(temp[0], temp[1]);
            System.out.println("#" + (t + 1) + " " + result);
        }
    }
}
