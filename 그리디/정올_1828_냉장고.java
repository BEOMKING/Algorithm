package 그리디;

import java.util.*;

public class 정올_1828_냉장고 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C[][] = new int[N][2];
        for(int n = 0; n < N; n++){
            int min = sc.nextInt();
            int max = sc.nextInt();
            C[n][0] = min;
            C[n][1] = max;
        }
        Arrays.sort(C, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int diff = o1[0] - o2[0];
                if(diff != 0){
                    return diff;
                }else{
                    return o1[1] - o2[1];
                }
            }
        });
        int result = 1;
        int compare[][] = new int[1][2];
        compare[0][0] = C[0][0];
        compare[0][1] = C[0][1];

        for(int i = 1; i < C.length; i++){
            if(compare[0][1] < C[i][0]){
                result += 1;
                compare[0] = C[i];
            }
            else{
                if(compare[0][1] > C[i][1]){
                    compare[0][1] = C[i][1];
                }
            }
        }
        System.out.println(result);
    }
}
