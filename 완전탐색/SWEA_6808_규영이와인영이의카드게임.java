package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6808_규영이와인영이의카드게임 {
    static final int MAX = 9;
    static int kyu[] = new int[MAX];
    static int in[] = new int[MAX];
    static int kyuwin, kyulose;
    static boolean isselected[] = new boolean[MAX];
    static int numbers[] = new int[MAX];

    static void numberofcases(int count){
        if(count == MAX){
            int kyuscore = 0, inscore = 0;
            for(int i = 0; i < MAX; i++){
                if(numbers[i] < kyu[i]){
                    kyuscore += (numbers[i] + kyu[i]);
                }else{
                    inscore += (numbers[i] + kyu[i]);
                }
            }
            if(kyuscore > inscore){
                kyuwin += 1;
            }else if(kyuscore < inscore){
                kyulose += 1;
            }
            return;
        }
        for(int i = 0; i < MAX; i++){
            if(isselected[i] != true){
                numbers[count] = in[i];
                isselected[i] = true;
                numberofcases(count + 1);
                isselected[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            kyu = new int[MAX];
            in = new int[MAX];

            for(int k = 0; k < MAX; k++) {
                kyu[k] = Integer.parseInt(st.nextToken());
            }

            int index = 0;
            for(int i = 1; i <= 18; i++) {
                int ox = 0;
                for (int j = 0; j < MAX; j++) {
                    if (kyu[j] == i) {
                        ox = 1;
                        break;
                    }
                }
                if (ox != 1) {
                    in[index++] = i;
                }
            }
            kyuwin = 0;
            kyulose = 0;
            numberofcases(0);
            System.out.print("#" + (t + 1) + " " + kyuwin + " " + kyulose);
            System.out.println();
        }
    }
}
