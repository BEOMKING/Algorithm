package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1475_방번호 {
    static int list[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new int[9];
        String N = br.readLine();
        for (int i = 0; i < N.length(); i++) {
            if(N.charAt(i) == '9'){
                list[6] += 1;
            }else {
                list[N.charAt(i) - '0'] += 1;
            }
        }
        list[6] = list[6] / 2 + list[6] % 2;
        int max = 0;
        for (int i = 0; i < 9; i++) {
            max = Math.max(list[i], max);
        }
        System.out.println(max);
    }
}
