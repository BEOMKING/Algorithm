package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2567_색종이2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int result = 0;
        int dohwaji[][] = new int[102][102]; // 범위 밖 조건을 확인할 때 인덱스 오류를 발생시키지 않으려고
        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // x좌표
            int y = Integer.parseInt(st.nextToken()); // y좌표
            for(int i = y; i < y + 10; i++){ // 아래에서부터 y만큼 떨어져있음
                for(int j = x; j < x + 10; j++) { // 왼쪽에서부터 x만큼
                    dohwaji[i][j] = 1;
                }
            }
        }
        //                  북  남 동  서
        int dx[] = new int[]{0, 0, 1, -1};
        int dy[] = new int[]{1, -1, 0, 0};
        for(int i = 1; i < 101; i++){
            for(int j = 1; j < 101; j++) {
                if(dohwaji[i][j] == 1) { // 주위에 빈부분이 있다면 둘레값 추가
                    for (int k = 0; k < 4; k++) {
                        if (dohwaji[i + dy[k]][j + dx[k]] != 1) {
                            result += 1;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
