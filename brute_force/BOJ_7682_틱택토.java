package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_7682_틱택토 {
    static String input;
    static char[][] map;
    static int xCount, oCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(!(input = br.readLine()).equals("end")) { // 입력 줄마다
            if(brute(input)) sb.append("valid\n");
            else sb.append("invalid\n");
        }

        System.out.println(sb);
    }
    static boolean brute(String input) {
        map = new char[3][3];
        xCount = 0; oCount = 0;

        for (int i = 0; i < 9; i++) {
            map[i / 3][i % 3] = input.charAt(i);
            if(input.charAt(i) == 'X') xCount++;
            if(input.charAt(i) == 'O') oCount++;
        }

        if(xCount + oCount == 9) { // 격자판이 가득 찼다면
            if(xCount != oCount + 1 || valid('O')) return false; // 개수가 맞지않거나 O가 승리한 경우가 있다면
            return true;
        }

        if(xCount == oCount + 1) { // X가 승리한 경우
            if(valid('O') || !valid('X')) return false; // O가 승리한 경우가 있거나 X가 승리한 경우가 없을 경우
            return true;
        }

        if(xCount == oCount) { // O가 승리한 경우
            if(valid('X') || !valid('O')) return false; // O가 승리한 경우가 있거나 X가 승리한 경우가 없을 경우
            return true;
        }

        return false;
    }

    static boolean valid(char c) {
        for (int i = 0; i < 3; i++) {
            if(map[i][0] == c && map[i][1] == c && map[i][2] == c) return true; // 가로
            if(map[0][i] == c && map[1][i] == c && map[2][i] == c) return true; // 세로
        }
        if(map[0][0] == c && map[1][1] == c && map[2][2] == c) return true; // 대각
        if(map[2][0] == c && map[1][1] == c && map[0][2] == c) return true; // 대각
        return false;
    }

}
