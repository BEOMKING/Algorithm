package datastucture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_3190_뱀 {
    static int map[][];
    static int dy[] = new int[]{0, 1, 0, -1}; // 동 남 서 북
    static int dx[] = new int[]{1, 0, -1, 0}; // 동 남 서 북

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 맵 크기
        map = new int[N][N];
        int K = Integer.parseInt(br.readLine()); // 사과 개수


        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y - 1][x - 1] = 2; // 맵에 사과 표식
        }

        int L = Integer.parseInt(br.readLine());
        Queue<String[]> direction = new LinkedList<>(); // 이동 방향 정보를 담은 리스트
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            direction.add(new String[]{st.nextToken(), st.nextToken()});
        }

        map[0][0] = 1; // 시작점
        int dindex = 0; // 현재 방향
        int y = 0, x = 0;
        int time = 0; // 경과 시간
        Queue<int[]> queue = new LinkedList<>();

        while(true){
            int ny = y + dy[dindex];
            int nx = x + dx[dindex];
            if(ny < 0 || ny >= N || nx < 0 || nx >= N) break; // 벽에 박으면 사망
            if(map[ny][nx] == 0){ // 다음 칸에 아무것도 없으면
                if(!queue.isEmpty()) {
                    int tail[] = queue.poll(); // 꼬리가 있던 자리를 비움
                    map[tail[0]][tail[1]] = 0;
                    map[y][x] = 1; // 기존에 있던 자리를 몸통이 채움
                    queue.add(new int[]{y, x});
                }else{ // 큐가 비어있다면 기존에 있던 자리만 비움
                    map[y][x] = 0;
                }
                map[ny][nx] = 1; // 이동
                time += 1;
            }else if(map[ny][nx] == 1){ // 다음칸이 자신의 몸이라면
                break;
            }else{ // 사과
                queue.add(new int[]{y, x}); // 몸길이를 증가 시킴
                map[ny][nx] = 1;
                time += 1;
            }
            y = ny; x = nx;

            if(!direction.isEmpty()){
                String dir[] = direction.peek();
                if(time == Integer.parseInt(dir[0])){
                    if(dir[1].equals("D")){
                        if(dindex + 1 == 4){
                            dindex = 0;
                        }else{
                            dindex += 1;
                        }
                    }else{
                        if(dindex - 1 < 0) {
                            dindex = 3;
                        }else{
                            dindex -= 1;
                        }
                    }
                    direction.poll();
                }
            }
        }
        System.out.println(time + 1);
    }
}
