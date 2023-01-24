package simulation;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 간단한 시뮬레이션 문제이다.
 * 명령에 따라 스택을 이용해 구현하면 된다.
 * 시간 복잡도는 moves의 길이 * board의 깊이이므로 O(NM) 이다.
 * moves의 길이는 1 이상 1,000 이하이고, board의 깊이는 1 이상 30 이하이므로, 최대 30,000 이다.
 *
 * @solved 2022.11.30
 */
class Pro_크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                int now = board[i][move - 1];
                if (now != 0) {
                    if (!stack.isEmpty() && stack.peek() == now) {
                        stack.poll();
                        answer += 2;
                    } else {
                        stack.push(now);
                    }

                    board[i][move - 1] = 0;

                    break;
                }
            }
        }

        return answer;
    }
}
