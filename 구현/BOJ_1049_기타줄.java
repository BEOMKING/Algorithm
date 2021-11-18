package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1049_기타줄 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int mPack = Integer.MAX_VALUE;
        int mPiece = Integer.MAX_VALUE;
        int result;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pack = Integer.parseInt(st.nextToken());
            int piece = Integer.parseInt(st.nextToken());

            mPack = Math.min(mPack, pack);
            mPiece = Math.min(mPiece, piece);
        }

        if(N % 6 == 0) {
            result = Math.min((N / 6) * mPack, N * mPiece);
        } else {
            result = Math.min((N / 6) * mPack + (N % 6) * mPiece, Math.min((N / 6 + 1) * mPack, N * mPiece));
        }

        System.out.println(result);
    }

}
