package 완전탐색.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16968_차량번호판1 {
    static char[] forms;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        forms = br.readLine().toCharArray();
        char start = forms[0];
        System.out.println(dfs(start == 'c' ? 26 : 10, 1));
    }

    private static int dfs(int prefix, int count) {
        if (count == forms.length) {
            return prefix;
        }

        if (forms[count - 1] == forms[count]) {
            if (forms[count] == 'd') {
                return dfs(prefix * 9, count + 1);
            } else {
                return dfs(prefix * 25, count + 1);
            }
        } else {
            if (forms[count] == 'd') {
                return dfs(prefix * 10, count + 1);
            } else {
                return dfs(prefix * 26, count + 1);
            }
        }
    }
}
