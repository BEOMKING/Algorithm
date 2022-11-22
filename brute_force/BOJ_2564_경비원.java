package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 점을 둘레로 바꿔줌
// 전체 둘레에서 두 점사이의 거리를 뺀 값과 두 점 사이의 거리 중 더 짧은 것을 결과값에 더해줌
public class BOJ_2564_경비원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken()); // 가로
        int Y = Integer.parseInt(st.nextToken()); // 세로
        int around = 2 * (X + Y); // 둘레

        int N = Integer.parseInt(br.readLine());
        int store[] = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            if(y == 1){
                store[i] = x;
            }else if(y == 2){
                store[i] = X + Y + (X - x);
            }else if(y == 3){
                store[i] = X + Y + X + (Y - x);
            }else{
                store[i] = X + x;
            }
        }

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int me;
        if(y == 1){
            me = x;
        }else if(y == 2){
            me = X + Y + (X - x);
        }else if(y == 3){
            me = X + Y + X + (Y - x);
        }else{
            me = X + x;
        }

        int answer = 0, distance;
        for (int i = 0; i < N; i++) {
            distance = Math.abs(store[i] - me);
            answer += Math.min(distance, around - distance);
        }
        System.out.print(answer);
    }
}
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st;
//
//    st = new StringTokenizer(br.readLine());
//    int X = Integer.parseInt(st.nextToken());
//    int Y = Integer.parseInt(st.nextToken());
//    int answer = 0;
//    map = new int[Y][X];
//
//    int N = Integer.parseInt(br.readLine());
//    int store[][] = new int[N][2];
//
//        for (int i = 0; i < N; i++) {
//        st = new StringTokenizer(br.readLine());
//        int y = Integer.parseInt(st.nextToken());
//        int x = Integer.parseInt(st.nextToken());
//        store[i] = new int[]{y, x};
//    }
//
//    st = new StringTokenizer(br.readLine());
//    int y = Integer.parseInt(st.nextToken());
//    int x = Integer.parseInt(st.nextToken());
//    int dg[] = new int[]{y, x};
//
//        for (int i = 0; i < N; i++) {
//        if(dg[0] == store[i][0]){
//            answer += Math.abs(dg[1] - store[i][1]);
//            continue;
//        }
//        if(dg[0] == 1){
//            if(store[i][0] == 2){
//                answer += Y + Math.min(dg[1] + store[i][1], X - dg[1] + X - store[i][1]);
//            }
//            else if(store[i][0] == 3){
//                answer += dg[1] + store[i][1];
//            }else{
//                answer += X - dg[1] + store[i][1];
//            }
//        }else if(dg[0] == 2){
//            if(store[i][0] == 1){
//                answer += Y + Math.min(dg[1] + store[i][1], X - dg[1] + X - store[i][1]);
//            }else if(store[i][0] == 3){
//                answer += dg[1] + Y - store[i][1];
//            }else{
//                answer += X - dg[1] + Y - store[i][1];
//            }
//        }else if(dg[0] == 3){
//            if(store[i][0] == 1){
//                answer += dg[1] + store[i][1];
//            }else if(store[i][0] == 2){
//                answer += Y - dg[1] + store[i][1];
//            }else{
//                answer += X + Math.min(dg[1] + store[i][1], Y - dg[1] + Y - store[i][1]);
//            }
//        }else if(dg[0] == 4){
//            if(store[i][0] == 1){
//                answer += dg[1] + X - store[i][1];
//            }else if(store[i][0] == 2){
//                answer += Y - dg[1] + X - store[i][1];
//            }
//            else if(store[i][0] == 3){
//                answer += X + Math.min(dg[1] + store[i][1], Y - dg[1] + Y - store[i][1]);
//            }
//        }
//    }
//        System.out.print(answer);
//}