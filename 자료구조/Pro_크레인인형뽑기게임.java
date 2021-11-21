package 자료구조;

import java.util.Stack;

public class Pro_크레인인형뽑기게임 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int move : moves) {
            for (int i = 0; i < board.length; i++) {
                int now = board[i][move - 1];
                if(now == 0) continue;
                if(stack.isEmpty() || stack.peek() != now) {
                    stack.add(now);
                } else {
                    stack.pop();
                    answer += 2;
                }
                board[i][move - 1] = 0;
                break;
            }
        }

        return answer;
    }

}
