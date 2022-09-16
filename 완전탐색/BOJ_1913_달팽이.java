package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1913_달팽이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] map = new int[N + 1][N + 1];
        int y = (N + 1) / 2; int x = (N + 1) / 2; // 중앙 위치
        map[y][x] = 1; // 초기값
        int direction = 0; // 초기 방향
        int move = 1; // 규칙 2번 같은 횟수로 움직이면 이동횟수 1 증가
        int count = 0; // 같은 방향으로 움직인 횟수
        int two = 0;
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        int[] result = {y, x}; // 첫번째 값이 1에서 시작하므로 1의 위치로 초기화 (2부터는 아래 로직에서 처리 가능)

        for (int i = 2; i <= N * N; i++) {
            y += dy[direction];
            x += dx[direction];
            if(M == i) {
                result[0] = y;
                result[1] = x;
            }
            map[y][x] = i;
            if(++count == move){ // 같은 방향으로 현재 움직임 가능 횟수만큼 이동했다면 방향 전환
                direction++;
                direction %= 4;
                count = 0; // 방향 전환 후 움직임 횟수 초기화
                if(++two == 2){ // 방향 전환을 두 번했다면 움직임 가능 횟수 증가
                    move++;
                    two = 0; // 움직임 가능 횟수 사용 횟수 초기화
                }
            }

        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append(result[0] + " " + result[1]);
        System.out.println(sb);
    }

}
