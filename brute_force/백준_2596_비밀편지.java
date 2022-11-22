package brute_force;

import java.io.*;

public class 백준_2596_비밀편지 {
    static String Alpha[] = new String[]{"000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String array[] = new String[N];
        String str = br.readLine();
        for(int i = 0; i < N; i++){
            array[i] = str.substring(i * 6, (i + 1) * 6);
        }

        for(int i = 0; i < N; i++){
            for(int a = 0; a < Alpha.length; a++){
                int diff = 0;
                for(int j = 0; j < 6; j++){
                    if(!(Alpha[a].substring(j, j + 1).equals(array[i].substring(j, j + 1)))){
                        diff += 1;
                    }
                    if(diff > 1) break;
                }
                if(diff <= 1) {
                    sb.append((char) (a + 65));
                    break;
                }
            }
            if(sb.length() < i + 1){
                sb.delete(0, i + 1);
                sb.append(i + 1);
                break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
