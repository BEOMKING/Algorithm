package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16917_양념반후라이드반 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int seasoning = Integer.parseInt(inputs[0]);
        int fried = Integer.parseInt(inputs[1]);
        int half = Integer.parseInt(inputs[2]);

        int wantS = Integer.parseInt(inputs[3]);
        int wantF = Integer.parseInt(inputs[4]);

        int price = Integer.MAX_VALUE;
        price = Math.min(price, seasoning * wantS + fried * wantF);
        int minCount = Math.min(wantS, wantF);
        int maxCount = Math.max(wantS, wantF);
        if (wantS < wantF) {
           price = Math.min(price, (minCount * 2 * half) + (wantF - wantS) * fried);
        } else if (wantS > wantF) {
            price = Math.min(price, (minCount * 2 * half) + (wantS - wantF) * seasoning);
        }

        price = Math.min(price, (maxCount * 2 * half));

        System.out.print(price);
    }
}
