package brute_force;

public class Pro_키패드누르기 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10; int right = 12;

        for (int num : numbers) {
            if(num == 0) num = 11;
            int remain = num % 3;

            if(remain == 0){
                answer += "R";
                right = num;
            }else if(remain == 1){
                answer += "L";
                left = num;
            }else {
                int leftnum = Math.abs(left - num);
                int rightnum = Math.abs(right - num);

                int leftDistance = (leftnum % 3) + (leftnum / 3); // 가로 거리 + 세로 거리
                int rightDistance = (rightnum % 3) + (rightnum / 3);

                if(leftDistance < rightDistance){
                    answer += "L";
                    left = num;
                }else if(leftDistance > rightDistance){
                    answer += "R";
                    right = num;
                }else{
                    if(hand.equals("left")){
                        answer += "L";
                        left = num;
                    }else{
                        answer += "R";
                        right = num;
                    }
                }
            }

        }
        return answer;
    }
}
