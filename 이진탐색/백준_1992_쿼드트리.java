package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1992_쿼드트리 {
    static StringBuilder sb = new StringBuilder();
    static int video[][];

    static boolean check(int starty, int startx, int size){ // 시작 y, 시작 x, 크기
        int first = video[starty][startx]; // 첫빠따
        for(int i = starty; i < size + starty; i++){ // 시작값 ~ 시작값 + 크기
            for(int j = startx; j < size + startx; j++){
                if(first != video[i][j]){ // 통일되지 않았다면
                    return false;
                }
            }
        }
        return true;
    }

    static void quardtree(int starty, int startx, int size){
        if(check(starty, startx, size)){ // 값이 같다면
            sb.append(video[starty][startx]);
            return;
        }else { // 같지않다면 아래 시작
            sb.append('(');
        }
        size /= 2; // 배열 4등분
        quardtree(starty, startx, size); // 1사
        quardtree(starty, startx + size, size); // 2사
        quardtree(starty + size, startx, size); // 3사
        quardtree(starty + size, startx + size, size); // 4사
        sb.append(')'); // 다끝나면 닫기
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        video = new int[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                video[i][j] = Integer.parseInt(str.substring(j, j + 1)); // 띄어쓰기 없는 숫자 배열에 넣기
            }
        }

        quardtree(0, 0, N);
        System.out.println(sb.toString());
    }
}