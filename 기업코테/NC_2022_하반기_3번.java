package 기업코테;

/**
 * 종이 접기
 */
class NC_2022_하반기_3번 {
    int max = 0;

    public int solution(int[] paper, int n) {


        dfs(paper, n);

        return max;
    }

    private void dfs(int[] paper, int remain) {
        for (int i : paper) {
            max = Math.max(max, i);
        }

        if (remain == 0) {
            return;
        }

        for (int i = 0; i < paper.length - 1; i++) {
            for (int j = i; j < paper.length; j++) {
                if (paper[i] == paper[j]) {
                    continue;
                }

            }
        }
    }

    public static void main(String[] args) {
        NC_2022_하반기_3번 solution = new NC_2022_하반기_3번();
        System.out.println(solution.solution(new int[]{7, 3, 5, -2, 9}, 2)); //
        System.out.println(solution.solution(new int[]{10, -10}, 1)); // 10
        System.out.println(solution.solution(new int[]{1, 2, 4, 8, 16}, 3)); // 31
        System.out.println(solution.solution(new int[]{7, 3, -7, 5, -3}, 2));
    }
}
