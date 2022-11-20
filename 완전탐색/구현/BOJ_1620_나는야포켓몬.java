package 완전탐색.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_1620_나는야포켓몬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int pocketmonCount = Integer.parseInt(inputs[0]);
        int questionCount = Integer.parseInt(inputs[1]);

        Map<String, Integer> pocketmonMap = new HashMap<>();
        String[] pocketmons = new String[pocketmonCount + 1];

        for (int i = 1; i <= pocketmonCount; i++) {
            String name = br.readLine();
            pocketmonMap.put(name, i);
            pocketmons[i] = name;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < questionCount; i++) {
            String question = br.readLine();

            if (pocketmonMap.containsKey(question)) {
                sb.append(pocketmonMap.get(question));
            } else {
                sb.append(pocketmons[Integer.parseInt(question)]);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
