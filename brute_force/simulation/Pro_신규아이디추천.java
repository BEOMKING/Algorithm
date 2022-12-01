package brute_force.simulation;

public class Pro_신규아이디추천 {
    public String solution(String new_id) {
        return parsing(new_id);
    }

    private String parsing(String id) {
        id = id.toLowerCase();
        id = id.replaceAll("[^a-z0-9-_.]", "");
        id = id.replaceAll("[.]{2,}", ".");

        if (!id.isEmpty() && id.charAt(0) == '.') {
            id = id.substring(1);
        }

        if (!id.isEmpty() && id.charAt(id.length() - 1) == '.') {
            id = id.substring(0, id.length() - 1);
        }

        if (id.isEmpty()) {
            id += "a";
        }

        if (id.length() > 15) {
            id = id.substring(0, 15);

            if (id.charAt(id.length() - 1) == '.') {
                id = id.substring(0, id.length() - 1);
            }
        }

        if (id.length() <= 2) {
            while (id.length() < 3) {
                id += id.charAt(id.length() - 1);
            }
        }

        return id;
    }

    private String another(String id) {
        String answer = id.toLowerCase(); // 1단계

        answer = answer.replaceAll("[^-_.a-z0-9]", ""); // 2단계
        answer = answer.replaceAll("[.]{2,}", "."); // 3단계
        answer = answer.replaceAll("^[.]|[.]$", "");    // 4단계

        if (answer.equals("")) {    // 5단계
            answer += "a";
        }

        if (answer.length() >= 16) {     // 6단계
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$","");
        }

        if (answer.length() <= 2) {  // 7단계
            while (answer.length() < 3) {
                answer += answer.charAt(answer.length()-1);
            }
        }

        return answer;
    }
}
