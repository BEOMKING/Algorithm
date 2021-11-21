package 그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1861_정사각형방 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // TC

        for(int t = 0; t < T; t++){
//            ArrayList<int[]> room = new ArrayList<>();
            int N = Integer.parseInt(br.readLine()); // 크기
            int room[][] = new int[N][N];
            int countroom[] = new int[N * N + 1];

            for(int i = 1; i < N * N + 1; i++){
                countroom[i] = 1;
            }
            for(int i = 0; i < N; i++){
//                int a = sc.nextInt();
//                int b = sc.nextInt();
//                room.add(new int[] {a, b});
//                StringTokenizer st = new StringTokenizer(br.readLine());
                String[] temp = br.readLine().split(" ");
                for(int j = 0; j < N; j++) {
//                    room.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
                    room[i][j] = Integer.parseInt(temp[j]);
                }
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    int dx = i;
                    int dy = j;
                    while(true){
                        if(dx - 1 >= 0 && room[dx- 1][dy] == room[dx][dy] + 1){
                            countroom[room[i][j]] += 1;
                            dx -= 1;
                        }else if(dx + 1 < N && room[dx+ 1][dy] == room[dx][dy] + 1){
                            countroom[room[i][j]] += 1;
                            dx += 1;
                        }else if(dy - 1 >= 0 && room[dx][dy - 1] == room[dx][dy] + 1){
                            countroom[room[i][j]] += 1;
                            dy -= 1;
                        }else if(dy + 1 < N && room[dx][dy + 1] == room[dx][dy] + 1){
                            countroom[room[i][j]] += 1;
                            dy += 1;
                        }else{
                            break;
                        }
                    }
                }
            }

//            int max = countroom[countroom.length-1];
            int max = 1;
            for(int i = 1; i < N * N + 1; i++){
                if(countroom[i] > max){
                    max = countroom[i];
                }

            }
            for(int i = 1; i < N * N + 1; i++){
                if(countroom[i] == max){
                    System.out.println("#" + (t + 1) + " " + i + " " + max);
                    break;
                }

            }

        }

    }
}
