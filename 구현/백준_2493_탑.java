package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 백준_2493_탑 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 탑의 수
        Stack<int[]> send = new Stack<>(); // 송신탑
        int receptio[] = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        receptio[0] = 0;
        for(int i = 1; i <= N; i++){
            int now = Integer.parseInt(st.nextToken());
            while(!send.isEmpty()){
                if(send.peek()[1] >= now){
                    receptio[i] = send.peek()[0];
                    send.push(new int[]{i, now});
                    break;
                }else{
                    send.pop();
                }
            }
            if(send.isEmpty()){
                receptio[i] = 0;
                send.push(new int[] {i, now});
            }
        }
        for(int k = 1; k < N + 1; k++){
            System.out.print(receptio[k] + " ");
        }
    }
}
