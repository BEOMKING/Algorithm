package 구현;

import java.io.*;
import java.util.StringTokenizer;

public class 백준_11723_집합 { // 비트마스킹
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        int masking = 0;

        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("add")){
                int addcommand = Integer.parseInt(st.nextToken());
                if((masking & (1 << addcommand - 1)) == 0) {
                    masking += 1 << addcommand - 1;
                }
            }else if(command.equals("remove")){
                int removecommand = Integer.parseInt(st.nextToken());
                if((masking & (1 << removecommand - 1)) != 0) {
                    masking -= 1 << removecommand - 1;
                }
            }else if(command.equals("check")){
                if((masking & (1 << Integer.parseInt(st.nextToken()) - 1)) != 0){
                    sb.append(1 + "\n");
                }else{
                    sb.append(0 + "\n");
                }
            }else if(command.equals("toggle")){
                int togglecommand = Integer.parseInt(st.nextToken());
                if((masking & (1 << togglecommand - 1)) != 0){
                    masking -= 1 << togglecommand - 1;
                }else{
                    masking += 1 << togglecommand - 1;
                }
            }else if(command.equals("all")){
                masking = 0;
                for(int i = 1; i <= 20; i++){
                    masking += 1 << i - 1;
                }
            }else if(command.equals("empty")){
                masking = 0;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
