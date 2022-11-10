package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
    static int N, section[], person[], around[][], answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 구역 수
        section = new int[N + 1]; // 구역
        person = new int[N + 1]; // 각 구역 인구 수

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            person[i] = Integer.parseInt(st.nextToken());
        }

        around = new int[N + 1][]; // 각 구역의 인접
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            around[i] = new int[num];
            for (int j = 0; j < num; j++) {
                around[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = Integer.MAX_VALUE;
        for (int i = 1; i <= N / 2; i++) {
            combination(0, 1, i);
        }

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        System.out.print(answer);

    }
    static boolean available(ArrayList<Integer> section){
        boolean check[] = new boolean[N + 1];
        int want = section.size();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(section.get(0));
        check[section.get(0)] = true;
        int count = 1;

        while (!queue.isEmpty()){
            int now = queue.poll();

            for (int i = 0; i < around[now].length; i++) {
                if(!check[around[now][i]] && section.contains(around[now][i])){
                    queue.add(around[now][i]);
                    check[around[now][i]] = true;
                    count++;
                }
            }
        }

        if(want == count) return true;
        return false;
    }
    static void combination(int count, int start, int num){
        if(count == num){
            ArrayList<Integer> section1 = new ArrayList<>();
            ArrayList<Integer> section2 = new ArrayList<>();

            for (int i = 1; i <= N; i++) {
                if(section[i] == 1){
                    section1.add(i);
                }else{
                    section2.add(i);
                }
            }
            if(available(section1) && available(section2)){
                int person1 = 0;
                int person2 = 0;
                for (int i = 0; i < section1.size(); i++) {
                    person1 += person[section1.get(i)];
                }
                for (int i = 0; i < section2.size(); i++) {
                    person2 += person[section2.get(i)];
                }
                answer = Math.min(answer, Math.abs(person1 - person2));
            }
            return;
        }
        for (int i = start; i <= N; i++) {
            section[i] = 1;
            combination(count + 1, i + 1, num);
            section[i] = 0;
        }
    }
}
