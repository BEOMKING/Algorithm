package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_6987_월드컵 {
    static int[] result = new int[18];
    static List<Case> cases = new ArrayList<>();
    static int flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 6; j++) {
                cases.add(new Case(i, j));
            }
        }

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            flag = 0;
            for (int j = 0; j < 18; j++) {
                result[j] = Integer.parseInt(st.nextToken());
            }
            if (!checkCaseNumber()) {
                System.out.print(flag + " ");
                continue;
            }
            brute(0, 0);
            System.out.print(flag + " ");
        }
    }

    private static boolean checkCaseNumber() {
        for (int i = 0; i < 18; i++) {
            if (i % 3 == 2) {
                if (result[i - 2] + result[i - 1] + result[i] != 5) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void brute(int index, int count) {
        if (flag == 1 || !check()) {
            return;
        }
        if (index == 15) {
            flag = 1;
            return;
        }

        Case c = cases.get(index);
        winOrLose(c.first, c.second);
        brute(index + 1, count + 1);
        winOrLoseRestore(c.first, c.second);
        draw(c.first, c.second);
        brute(index + 1, count + 1);
        drawRestore(c.first, c.second);
        winOrLose(c.second, c.first);
        brute(index + 1, count + 1);
        winOrLoseRestore(c.second, c.first);
    }

    private static boolean check() {
        for (int i : result) {
            if (i < 0) return false;
        }
        return true;
    }

    private static void draw(int drawer1, int drawer2) {
        result[drawer1 * 3 + 1]--;
        result[drawer2 * 3 + 1]--;
    }

    private static void drawRestore(int drawer1, int drawer2) {
        result[drawer1 * 3 + 1]++;
        result[drawer2 * 3 + 1]++;
    }

    private static void winOrLose(int winner, int loser) {
        result[winner * 3]--;
        result[loser * 3 + 2]--;
    }

    private static void winOrLoseRestore(int winner, int loser) {
        result[winner * 3]++;
        result[loser * 3 + 2]++;
    }

    public static class Case {
        int first, second;

        public Case(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

}
