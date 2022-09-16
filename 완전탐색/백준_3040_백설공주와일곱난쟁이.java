package 완전탐색;

import java.io.*;

public class 백준_3040_백설공주와일곱난쟁이 {
    static final int sevenhobit = 7;
    static final int allhobit = 9;
    static int hobit[];
    static int numbers[];

    static void combi(int start, int count){
        if(count == sevenhobit){
            int sum = 0;
            for(int i = 0; i < sevenhobit; i++){
                sum += numbers[i];
            }
            if(sum == 100){
                for(int i = 0; i < sevenhobit; i++){
                    System.out.println(numbers[i]);
                }
            }
            return;
        }
        for(int i = start; i < allhobit; i++){
            numbers[count] = hobit[i];
            combi(i + 1, count + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        hobit = new int[allhobit];
        numbers = new int[sevenhobit];
        for(int i = 0; i < allhobit; i++){
            hobit[i] = Integer.parseInt(br.readLine());
        }
        combi(0, 0);
    }
}
