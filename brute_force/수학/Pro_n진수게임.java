package brute_force.수학;

class Pro_n진수게임 {
    public String solution(int n, int t, int m, int p) {
        String str = makeString(n, t, m);
        StringBuilder answer = new StringBuilder();

        for (int i = p - 1; i < t * m; i += m) {
            answer.append(str.charAt(i));
        }

        return answer.toString().toUpperCase();
    }

    private String makeString(final int radix, final int t, final int m) {
        StringBuilder sb = new StringBuilder();

        int num = 0;
        while (sb.length() < t * m) {
            sb.append(Integer.toString(num++, radix));
        }

        return sb.toString();
    }
}