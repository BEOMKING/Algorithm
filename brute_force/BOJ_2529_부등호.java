package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2529_부등호 {
    static List<String> answers = new ArrayList<>();
    static char[] signs;
    static int k;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        signs = new char[k];
        for (int i = 0; i < k; i++) {
            signs[i] = st.nextToken().charAt(0);
        }
        checked = new boolean[10];
        combination(0, "");
        System.out.println(answers.get(answers.size() - 1));
        System.out.println(answers.get(0));
        System.out.println(answers.size());
    }

    static void combination(int count, String sum) {
        if (count == k + 1) {
            answers.add(sum);
            return;
        }

        for (char i = '0'; i <= '9'; i++) {
            if (checked[i - '0']) continue;
            if (count != 0 && !check(sum.charAt(count - 1), i, signs[count - 1])) continue;
            checked[i - '0'] = true;
            combination(count + 1, sum + i);
            checked[i - '0'] = false;
        }
    }

    private static boolean check(char before, char now, char sign) {
        if (sign == '<') {
            return before < now;
        }
        return before > now;
    }

}
