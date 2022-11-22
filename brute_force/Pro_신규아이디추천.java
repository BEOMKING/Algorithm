package brute_force;

public class Pro_신규아이디추천 {
    static StringBuilder answer = new StringBuilder();

    public static String solution(String new_id) {
        answer.append(new_id);
        // 1단계
        one();
        // 2단계
        two();
        // 3단계
        if(answer.length() > 1) three();
        // 4단계
        four();
        // 5단계
        five();
        // 6단계
        six();
        // 7 단계
        seven();

        return answer.toString();
    }
    static void one(){
        int leng = answer.length();
        for (int i = 0; i < leng; i++) {
            if(answer.charAt(i) >= 65 && answer.charAt(i) < 91){
                answer.append((char) (answer.charAt(i) + 32));
            }else answer.append(answer.charAt(i));
        }
        answer.delete(0, leng);
    }
    static void two(){
        int leng = answer.length();
        for (int i = 0; i < leng; i++) {
            char now = answer.charAt(i);
            if((now >= 97 && now <= 122) || now == '-' || now == '_' || now == '.' || (now >= 48 && now <= 57)) {
                answer.append(answer.charAt(i));
            }
        }
        answer.delete(0, leng);
    }
    static void three(){
        int leng = answer.length();
        int count = 0;
        for (int i = 0; i < leng; i++) {
            if (answer.charAt(i) == '.') count++;
            else {
                if (count > 0) {
                    answer.append('.');
                    count = 0;
                }
                answer.append(answer.charAt(i));
            }
        }
        if(count > 0) answer.append('.');
        answer.delete(0, leng);
    }
    static void four(){
        int leng = answer.length();
        if (answer.length() > 0 && answer.charAt(answer.length() - 1) == '.') answer.delete(answer.length() - 1, leng);
        if (answer.length() > 0 && answer.charAt(0) == '.') answer.delete(0, 1);
    }
    static void five(){
        if(answer.length() == 0) answer.append('a');
    }
    static void six(){
        if(answer.length() > 15) answer.delete(15, answer.length());
        four();
    }
    static void seven(){
        while(answer.length() < 3){
            answer.append(answer.charAt(answer.length() - 1));
        }
    }
}

//class Solution {
//    public String solution(String new_id) {
//        String answer = new_id.toLowerCase(); // 1단계
//
//        answer = answer.replaceAll("[^-_.a-z0-9]", ""); // 2단계
//        answer = answer.replaceAll("[.]{2,}", "."); // 3단계
//        answer = answer.replaceAll("^[.]|[.]$", "");    // 4단계
//
//        if (answer.equals("")) {    // 5단계
//            answer += "a";
//        }
//
//        if (answer.length() >= 16) {     // 6단계
//            answer = answer.substring(0, 15);
//            answer = answer.replaceAll("[.]$","");
//        }
//
//        if (answer.length() <= 2) {  // 7단계
//            while (answer.length() < 3) {
//                answer += answer.charAt(answer.length()-1);
//            }
//        }
//
//        return answer;
//    }
//}
