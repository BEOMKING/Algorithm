package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_1755_숫자놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Translate> pq = new PriorityQueue<>();
        for (int i = M; i <= N; i++) {
            int div = i / 10;
            int mod = i % 10;
            String temp1;
            String temp2;
            if(div == 0){
                temp1 = change(mod);
                temp2 = "a";
            }else{
                temp1 = change(div);
                temp2 = change(mod);
            }
            pq.offer(new Translate(temp1, temp2, i));
        }
        for (int i = 1; i <= N - M + 1; i++) {
            int n = pq.poll().num;
            if(i % 10 == 0){
                sb.append(n + "\n");
            }else{
                sb.append(n + " ");
            }
        }
        System.out.print(sb.toString()); // ei ni se on ze
    }// fi fo ei ni on se si th tw ze
    static String change(int input){
        if(input == 0){
            return "ze";
        }else if(input == 1){
            return "on";
        }else if(input == 2){
            return "tw";
        }else if(input == 3){
            return "th";
        }else if(input == 4){
            return "fo";
        }else if(input == 5){
            return "fi";
        }else if(input == 6){
            return "si";
        }else if(input == 7){
            return "se";
        }else if(input == 8){
            return "ei";
        }else if(input == 9){
            return "ni";
        }
        return "NO";
    }
    static class Translate implements Comparable<Translate>{
        String first;
        String second;
        int num;

        public Translate(String first, String second, int num) {
            this.first = first;
            this.second = second;
            this.num = num;
        }
        @Override
        public int compareTo(Translate o) {
            if (first == o.first) { // 첫 문자가 같고
                if(second.charAt(0) == o.second.charAt(0)){ // 두번째 단어의 첫 문자가 같다면
                    return second.charAt(1) - o.second.charAt(1); // 두번째 단어의 두 번째 문자를 비교
                }else {
                    return second.charAt(0) - o.second.charAt(0); // 두번째 단어의 첫 문자 비교
                }
            } else { // 첫 문자가 같지않다면
                if(first.charAt(0) == o.first.charAt(0)){
                    return first.charAt(1) - o.first.charAt(1); // 첫번째 단어의 두 번째 문자를 비교
                }else{
                    return first.charAt(0) - o.first.charAt(0);
                }
            }
        }
    }
}
