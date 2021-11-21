package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_13913_숨바꼭질4 {
    static int visited[];
    static int subin, dongsang, second;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());

        subin = Integer.parseInt(st.nextToken());
        dongsang = Integer.parseInt(st.nextToken());
        if(subin == dongsang){
            System.out.println(0);
            System.out.print(subin);
        }else {
            visited = new int[100001];
            Arrays.fill(visited, -1);
            queue = new LinkedList<>();
            queue.offer(subin);
            visited[subin] = 0;
            second = 0;
            bfs();

            System.out.println(second - 1);
            Stack<Integer> temp = new Stack<>();
            temp.add(dongsang);
            int tmp = dongsang;
            while (true) {
                tmp = visited[tmp];
                if (tmp == subin) {
                    temp.add(tmp);
                    break;
                }
                temp.add(tmp);
            }
            while (!temp.isEmpty()) {
                System.out.print(temp.pop() + " ");
            }
        }
    }
    static void bfs(){
        while(!queue.isEmpty()){
            second += 1;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                if(now == dongsang){
                    return;
                }
                if(now * 2 <= 100000 && visited[now * 2] == -1){
                    visited[now * 2] = now;
                    queue.offer(now * 2);
                }
                if(now - 1 >= 0 && visited[now - 1] == -1){
                    visited[now - 1] = now;
                    queue.offer(now - 1);
                }
                if(now + 1 <= 100000 && visited[now + 1] == -1){
                    visited[now + 1] = now;
                    queue.offer(now + 1);
                }
            }
        }
    }
}
