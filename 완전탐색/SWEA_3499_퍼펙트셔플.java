package 완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_3499_퍼펙트셔플 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());
//            String card[] = br.readLine().split(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<String> card3 = new LinkedList<>();
            if(N % 2 == 0){ // 짝수라면
                Queue<String> card1 = new LinkedList<>();
                Queue<String> card2 = new LinkedList<>();
                for(int i = 0; i < N / 2; i++){
                    card1.add(st.nextToken());
                }
                for(int i = 0; i < N / 2; i++){
                    card2.add(st.nextToken());
                }
                for(int i = 0; i < N / 2; i++){
                    card3.add(card1.poll());
                    card3.add(card2.poll());
                }
            }else{
                Queue<String> card1 = new LinkedList<>();
                Queue<String> card2 = new LinkedList<>();
                for(int i = 0; i <= N / 2; i++){
                    card1.add(st.nextToken());
                }
                for(int i = 0; i < N / 2; i++){
                    card2.add(st.nextToken());
                }
                for(int i = 0; i < N / 2 + 1; i++){
                    card3.add(card1.poll());
                    if(i == N / 2){
                        break;
                    }
                    card3.add(card2.poll());
                }
            }
            int a = card3.size();
            System.out.print("#" + (t + 1) + " ");
            for(int i = 0; i < a; i++){
                System.out.print(card3.poll() + " ");
            }
            System.out.println();
        }
    }

}
