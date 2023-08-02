package simulation;

import java.util.*;
import java.io.*;

public class Softeer_회의실예약
{
    /**
     * 각 방과 방의 예약 시간 배열을 Map에 저장해두고 예약을 확인하며 예약 시간에 해당하는 배열의 값을 1로 변경한다.
     * 방 이름 오름차순은 TreeMap을 이용하면 해결할 수 있다.
     * 오히려 출력에서 줄바꿈을 처리하는데 오랜 시간이 걸렸다.
     */
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        Map<String, int[]> rooms = new TreeMap<>();
        for (int n = 0; n < N; n++) {
            rooms.put(br.readLine(), new int[19]);
        }

        for (int m = 0; m < M; m++) {
            inputs = br.readLine().split(" ");
            String name = inputs[0];
            int start = Integer.parseInt(inputs[1]);
            int end = Integer.parseInt(inputs[2]);

            int[] times = rooms.get(name);
            for (int i = start; i < end; i++) {
                times[i] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (String key : rooms.keySet()) {
            sb.append("Room ").append(key).append(":\n");
            int[] times = rooms.get(key);

            boolean isReserved = true;
            int count = 0;
            int start = 9;
            StringBuilder temp = new StringBuilder();

            for (int i = 9; i < 18; i++) {
                if (times[i] == 1) { // 현재 시간 예약이 되어있는데
                    if (!isReserved) { // 이전에 예약이 안되어있다면 이전 시간까지는 비어있는 시간이므로 저장하고 예약중으로 변경한다.
                        temp.append("\n").append(String.format("%02d", start)).append("-").append(String.format("%02d", i));
                        isReserved = true;
                    }
                } else { // 현재 시간이 예약이 안되어있는데
                    if (isReserved) { // 이전에 예약이 이미 되어있다면 비어있는 시간이 생긴 것이므로 카운트를 증가시키고 비어있는 시간을 시작시간으로 체크한다.
                        count++;
                        start = i;
                        isReserved = false;
                    }
                }
            }

            if (!isReserved) {
                temp.append("\n").append(String.format("%02d", start)).append("-").append(18);
            }
            if (count > 0) {
                sb.append(count).append(" available:");
            } else {
                sb.append("Not available");
            }

            sb.append(temp);
            if (++index != rooms.size()) {
                sb.append("\n").append("-----").append("\n");
            }
        }

        System.out.print(sb);
    }
}