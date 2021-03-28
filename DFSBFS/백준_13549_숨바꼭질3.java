package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_13549_숨바꼭질3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());

        int subin = Integer.parseInt(st.nextToken());
        int dongsang = Integer.parseInt(st.nextToken());
        int visited[] = new int[100001];
        Arrays.fill(visited, 100001);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(subin);
        visited[subin] = 0;
        int answer = 0;

        while(!queue.isEmpty()){
            int now = queue.poll();
            if(now == dongsang){
                answer = visited[now];
            }

            if(now - 1 >= 0 && visited[now - 1] > visited[now] + 1){
                visited[now - 1] = visited[now] + 1;
                queue.offer(now - 1);
            }
            if(now + 1 <= 100000 && visited[now + 1] > visited[now] + 1){
                visited[now + 1] = visited[now] + 1;
                queue.offer(now + 1);
            }
            if(now * 2 <= 100000 && visited[now * 2] > visited[now]){
                visited[now * 2] = visited[now];
                queue.offer(now * 2);
            }
        }
        System.out.println(answer);
    }
}
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());

        int subin = Integer.parseInt(st.nextToken());
        int dongsang = Integer.parseInt(st.nextToken());
        int visited[] = new int[100001];
        Arrays.fill(visited, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(subin);
        visited[subin] = 0;
        int answer = 0;

        while(!queue.isEmpty()){
            int now = queue.poll();
            if(now == dongsang){
                answer = visited[now];
                break;
            }
            if(now * 2 <= 100000 && visited[now * 2] == -1){
                visited[now * 2] = visited[now];
                queue.offer(now * 2);
            }
            if(now - 1 >= 0 && visited[now - 1] == -1){
                visited[now - 1] = visited[now] + 1;
                queue.offer(now - 1);
            }
            if(now + 1 <= 100000 && visited[now + 1] == -1){
                visited[now + 1] = visited[now] + 1;
                queue.offer(now + 1);
            }
        }
        System.out.println(answer);
    }
}
 */
