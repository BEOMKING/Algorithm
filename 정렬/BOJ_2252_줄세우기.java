package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_2252_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        List<Integer>[] behindStudentLists = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            behindStudentLists[i] = new ArrayList<>();
        }
        int[] inDegree = new int[N + 1];

        for (int i = 1; i <= M; i++) {
            String[] students = br.readLine().split(" ");
            int small = Integer.parseInt(students[0]);
            int tall = Integer.parseInt(students[1]);

            behindStudentLists[small].add(tall);
            inDegree[tall]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            int small = queue.poll();
            sb.append(small).append(" ");

            for (int tall : behindStudentLists[small]) {
                if (--inDegree[tall] == 0) {
                    queue.add(tall);
                }
            }
        }

        System.out.println(sb);
    }
}
