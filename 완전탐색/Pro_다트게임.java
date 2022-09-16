package 완전탐색;

public class Pro_다트게임 {
    public int solution(String dartResult) {
        int answer = 0;

        double beforenum = 0;
        double nownum = 0;

        for (int i = 0; i < dartResult.length(); i++) {
            char now = dartResult.charAt(i);

            if(now >= '0' && now <= '9'){
                if(now == '0' && nownum == 1) nownum = 10;
                else {
                    answer += beforenum;
                    beforenum = nownum;
                    nownum = now - '0';
                }
            }

            if(now == 'D') nownum = Math.pow(nownum, 2);
            else if(now == 'T') nownum = Math.pow(nownum, 3);

            if(now == '*'){
                beforenum *= 2;
                nownum *= 2;
            }else if(now == '#'){
                nownum = -(nownum);
            }

        }

        answer += (beforenum + nownum);

        return answer;
    }
}
