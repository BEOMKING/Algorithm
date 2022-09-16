package 완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1230_암호문3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t = 0; t < 10; t++) {
            ArrayList<Integer> List = new ArrayList<>();
            int N = Integer.parseInt(br.readLine()); // 원본 암호문의 길이
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int n = 0; n < N; n++) { // 원본 암호문 입력
                List.add(Integer.parseInt(st.nextToken()));
            }

            int talk = Integer.parseInt(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for(int i = 0; i < talk; i++){
                String input = st2.nextToken();

                if(input.equals("I")){
                    int start = Integer.parseInt(st2.nextToken());
                    int end = Integer.parseInt(st2.nextToken());
                    for(int k = start; k < start + end; k++){
                        List.add(k, Integer.parseInt(st2.nextToken()));
                    }
                }
                else if(input.equals("D")){
                    int start = Integer.parseInt(st2.nextToken());
                    int end = Integer.parseInt(st2.nextToken());
                    for(int count = 0; count < end; count++){
                        List.remove(start);
                    }
                }else{
                    int count = Integer.parseInt(st2.nextToken());
                    for(int l = 0; l < count; l++){
                        List.add(Integer.parseInt(st2.nextToken()));
                    }
                }
            }

            System.out.print("#" + (t + 1) + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print(List.get(j) + " ");
            }
            System.out.println();
        }
    }
}
