package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_20364_부동산다툼 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        HashSet<Integer> visited = new HashSet<>();

        for (int i = 0; i < Q; i++) {
            int find = Integer.parseInt(br.readLine());
            int block = 0;
            for (int j = find; j > 1; j /= 2) {
                if (visited.contains(j)) block = j;
            }
            sb.append(block + "\n");
            if(block == 0) visited.add(find);
        }

        System.out.println(sb);
    }

}
