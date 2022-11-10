package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_12851_숨바꼭질2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());

        int subin = Integer.parseInt(st.nextToken());
        int dongsang = Integer.parseInt(st.nextToken());
        int visited[] = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(subin);
        int min = Integer.MAX_VALUE;
        int count = 0;

        while(!queue.isEmpty()){
            int now = queue.poll();
            if(now == dongsang){
                min = visited[now];
                count += 1;
            }

            if(visited[now] >= min) continue; // 최저 시간 이상이면
            if(now - 1 >= 0 && (visited[now - 1] == 0 || visited[now] + 1 == visited[now - 1])){ // 이미 방문을 했더라도 같은 시간에 도착한다면 가능성이 존재
                visited[now - 1] = visited[now] + 1;
                queue.offer(now - 1);
            }
            if(now + 1 <= 100000 && (visited[now + 1] == 0 || visited[now] + 1 == visited[now + 1])){
                visited[now + 1] = visited[now] + 1;
                queue.offer(now + 1);
            }
            if(now * 2 <= 100000 && (visited[now * 2] == 0 || visited[now] + 1 == visited[now * 2])){
                visited[now * 2] = visited[now] + 1;
                queue.offer(now * 2);
            }
        }
        System.out.println(min);
        System.out.print(count);
    }
}
