package simulation;

import java.io.*;


public class Softeer_전광판
{
    /**
     * 시뮬레이션 문제이다. 모든 전구 숫자들이 서로 변환될 때 사용되는 스위치 횟수를 미리 구해놓고 입력받은 숫자들을 비교하여 최소 스위치 횟수를 구하면 된다.
     * 주의해야할 점은 스위치 횟수를 미리 구해서 배열에 저장하는 것이 좀 헷갈리고, 불빛이 들어오지 않은 것과 전구 숫자 0은 다른 경우라는 것이다.
     * 5자리를 채우지 못한 숫자의 경우 앞부분이 전구가 다 꺼져있는 것이라는 것을 배열의 10번째에 함께 저장해서 해결했다.
     */
    public static void main(String args[]) throws IOException
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    int[][] count = {
            {0, 4, 3, 3, 4, 3, 2, 2, 1, 2, 6},
            {4, 0, 5, 3, 2, 5, 6, 2, 5, 4, 2},
            {3, 5, 0, 2, 5, 4, 3, 5, 2, 3, 5},
            {3, 3, 2, 0, 3, 2, 3, 3, 2, 1, 5},
            {4, 2, 5, 3, 0, 3, 4, 2, 3, 2, 4},
            {3, 5, 4, 2, 3, 0, 1, 3, 2, 1, 5},
            {2, 6, 3, 3, 4, 1, 0, 4, 1, 2, 6},
            {2, 2, 5, 3, 2, 3, 4, 0, 3, 2, 4},
            {1, 5, 2, 2, 3, 2, 1, 3, 0, 1, 7},
            {2, 4, 3, 1, 2, 1, 2, 2, 1, 0, 6},
            {6, 2, 5, 5, 4, 5, 6, 4, 7, 6, 0}
    };


    while (T-->0) {
        String[] inputs = br.readLine().split(" ");
        int A = Integer.parseInt(inputs[0]);
        int B = Integer.parseInt(inputs[1]);
        int[] aDigits = new int[5];
        int[] bDigits = new int[5];

        int temp = 4;
        while (temp >= 0) {
            aDigits[temp] = A % 10;
            bDigits[temp] = B % 10;
            A /= 10;
            B /= 10;
            temp--;
        }

        for (int i = 0; i < 5; i++) {
            if (aDigits[i] == 0) {
                aDigits[i] = 10;
            } else {
                break;
            }
        }

        for (int i = 0; i < 5; i++) {
            if (bDigits[i] == 0) {
                bDigits[i] = 10;
            } else {
                break;
            }
        }


        int result = 0;
        for (int i = 0; i < 5; i++) {
            result += count[aDigits[i]][bDigits[i]];
        }

        System.out.println(result);
    }
}
}