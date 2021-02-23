package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2116_주사위쌓기 {
    static int dice[][];
    static int result;
    static int top;
    static int answer = 0;

    static void dicemax(int no, int index){
        int temp[] = new int[]{1, 2, 3, 4, 5, 6};
        int max = 0;

        for(int bot = 0; bot < 6; bot++){
            if(dice[no][bot] == index){
                if(bot == 0){
                    top = dice[no][5];
                    temp[index - 1] = 0;
                    temp[top - 1] = 0;
                    for(int t = 0; t < 6; t++){
                        max = Math.max(max, temp[t]);
                    }
                    result += max;
                    return;
                }else if(bot == 5){
                    top = dice[no][0];
                    temp[index - 1] = 0;
                    temp[top - 1] = 0;
                    for(int t = 0; t < 6; t++){
                        max = Math.max(max, temp[t]);
                    }
                    result += max;
                    return;
                }else if(bot > 2){
                    top = dice[no][bot - 2];
                    temp[index - 1] = 0;
                    temp[top - 1] = 0;
                    for(int t = 0; t < 6; t++){
                        max = Math.max(max, temp[t]);
                    }
                    result += max;
                    return;
                }else{
                    top = dice[no][bot + 2];
                    temp[index - 1] = 0;
                    temp[top - 1] = 0;
                    for(int t = 0; t < 6; t++){
                        max = Math.max(max, temp[t]);
                    }
                    result += max;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        dice = new int[N][6];

        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 6; i++){
                dice[n][i] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 1; k <= 6; k++) { // 첫 주사위 윗면 경우의 수
            result = 0;
            dicemax(0, k);
            for (int i = 1; i < N; i++) {
                dicemax(i, top);
            }
            answer = Math.max(answer, result);
        }
        System.out.println(answer);
    }
}
