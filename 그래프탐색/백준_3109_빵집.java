package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_3109_빵집 {
    static int R;
    static int C;
    static char map[][]; // char 배열과 string 배열의 속도 차이는 엄청나다.
    static int result = 0;
    static int dx[] = {-1, 0, 1};

    static boolean pipenum(int r, int c) {
        if (c + 1 == C) { // 현재 열이 식당이라면
            map[r][c] = 'x';
            result += 1;
            return true; // true 값 리턴
        }

        for(int i = 0; i < 3; i++) {
            int newx = r + dx[i];
            if (r + newx >= 0 && newx < R && map[newx][c + 1] == '.') {// 다음 경로가 비었다면
                map[r][c] = 'x';
                if(pipenum(newx, c + 1)){// true 값이 리턴 온다면 (현재 경로가 파이프 최적경로란 뜻 다음을 진행할 필요 없이 현재까지 모든 반복문 종료)
                    return true; // true 리턴
                }
            }
        }
        return false; // false 값이 리턴오고 모든 반복문이 안됬다면 현재 경로는 안된다는 것을 의미
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for(int r = 0; r < R; r++) {
//            map[r] = br.readLine().split("");
            map[r] = br.readLine().toCharArray();
        }

        for(int r = 0; r < R; r++){
            pipenum(r,0);
        }
        System.out.print(result);
    }
}
