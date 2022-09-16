package 완전탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_1759_암호만들기 {
    static int L;
    static int C;
    static char password[];
    static char alpha[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        password = new char[L]; // 암호 길이
        st = new StringTokenizer(br.readLine());
        alpha = new char[C]; // 주어진 알파벳

        for (int i = 0; i < C; i++) {
            alpha[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alpha);
        mpassword(0, 0);
        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
    }
    static boolean ismoumm(char ch){ // 모음인지 체크
        char moumm[] = new char[]{'a', 'e', 'i', 'o', 'u'};
        for (char mo: moumm) {
            if(ch == mo) return true;
        }
        return false;
    }
    static void mpassword(int start, int count){
        if(count == L){
            int nummo = 0, numja = 0;
            for (char ch: password) {
                if(ismoumm(ch)){
                    nummo += 1;
                }else{
                    numja += 1;
                }
            }
            if(nummo < 1 || numja < 2) return; // 모음과 자음의 수 체크
            for (char ch: password) {
                sb.append(ch);
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < alpha.length; i++) {
            password[count] = alpha[i];
            mpassword(i + 1, count + 1);
        }
    }
}
