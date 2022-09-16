package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1974_스도쿠검증 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            int list[][] = new int[9][9];
            int result = 1;

            for(int i = 0; i < 9; i++){ // 퍼즐 초기화
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 9; j++){
                    list[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < 9; i++){
                Boolean isselected[] = new Boolean[10];
                Boolean isselected2[] = new Boolean[10];

                for(int j = 0; j < 9; j++){
                    if(isselected[list[i][j]] == null){ // 같은 행에 같은 값이 있는지 비교
                        isselected[list[i][j]] = true;
                    }else{
                        result = 0;
                        break;
                    }

                    if(isselected2[list[j][i]] == null){ // 같은 열에 같은 값이 있는지 비교
                        isselected2[list[j][i]] = true;
                    }else{
                        result = 0;
                        break;
                    }
                }
            }
            for(int k = 0; k < 9; k += 3){ // 같은 부분에 같은 값이 있는지 비교
                for(int l = 0; l < 9; l += 3){
                    Boolean isselected3[] = new Boolean[10];
                    for(int i = k; i < k + 3; i++){
                        for(int j = l; j < l + 3; j++){
                            if(isselected3[list[i][j]] == null){
                                isselected3[list[i][j]] = true;
                            }else{
                                result = 0;
                                break;
                            }
                        }
                    }
                }
            }

            System.out.print("#" + (t + 1) + " " + result);
            System.out.println();
        }
    }
}
