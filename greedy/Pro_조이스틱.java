package greedy;

public class Pro_조이스틱 {
    public static int solution(String name) {
        int answer = 0;
        int length = 'Z' - 'A';
        int nlength = name.length();
        int minlr = nlength - 1;

        for (int i = 0; i < name.length(); i++) {
            char now = name.charAt(i);
            int min = Math.min(('A' + length + 1) % now, now - 'A');
            answer += min;

            int next = i + 1;
            while (next < nlength && name.charAt(next) == 'A') next++;
            minlr = Math.min(minlr, (i * 2) + nlength - next);
        }

        return answer + minlr;
    }

}
