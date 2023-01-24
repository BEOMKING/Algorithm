package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_17219_비밀번호찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int count = Integer.parseInt(inputs[0]);
        int find = Integer.parseInt(inputs[1]);

        Map<String, String> idpw = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String[] idpwInput = br.readLine().split(" ");
            idpw.put(idpwInput[0], idpwInput[1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < find; i++) {
            String id = br.readLine();
            sb.append(idpw.get(id)).append("\n");
        }

        System.out.println(sb);
    }
}
