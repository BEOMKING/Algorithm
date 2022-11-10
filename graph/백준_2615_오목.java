package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2615_오목 {
    static final int width = 19;
    static int map[][];
    static boolean isselected[][];
    static int dy[] = new int[]{1, 1, 1, 0}; // 남서 남 남동 동
    static int dx[] = new int[]{-1, 0, 1, 1}; // 남서 남 남동 동
    static int answer;
    static int answery;
    static int answerx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[width][width];
        for (int i = 0; i < width; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(check(map)){
            System.out.println(answer);
            System.out.print(answery + " " + answerx);
        }else{
            System.out.print(0);
        }
    }
    static boolean rulecheck(int y, int x, int k, int count, int color, int lefty, int leftx){
        int mny = y - dy[k];
        int mnx = x - dx[k];
        if(mny >= 0 && mny < width && mnx >= 0 && mnx < width && count == 1 && map[mny][mnx] == color) return false;
        int ny = y + dy[k];
        int nx = x + dx[k];

        if(ny < 0 || ny >= width || nx < 0 || nx >= width || map[ny][nx] != color){
            if(count == 5) {
                if(leftx > x){
                    answerx = x + 1;
                    answery = y + 1;
                }else if(leftx == x){
                    if(answery > y){
                        answerx = leftx + 1;
                        answery = y + 1;
                    }else{
                        answerx = leftx + 1;
                        answery = lefty + 1;
                    }
                }else{
                    answerx = leftx + 1;
                    answery = lefty + 1;
                }
                answer = color;
                return true;
            }else{
                return false;
            }
        }
        if(rulecheck(ny, nx, k, count + 1, color, lefty, leftx)) return true;
        return false;
    }

    static boolean check(int map[][]){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if(map[i][j] != 0){
                    for (int k = 0; k < 4; k++) {
                        answery = 0; answerx = 0;
                        if(rulecheck(i, j, k, 1, map[i][j], i, j)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
