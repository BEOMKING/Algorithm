package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class 백준_2164_카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> queue = new LinkedList<>();

        for(int n = N; n > 0; n--){
            queue.offer(n); // 리스트 삽입
        }

        while(queue.size() > 1){
            queue.removeLast();
            if(queue.size() == 1){break;}
            int top = queue.removeLast();
            queue.addFirst(top);
        }
        System.out.print(queue.get(0));
    }
}
