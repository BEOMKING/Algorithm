package datastucture;

import java.util.HashMap;

public class Pro_오픈채팅방 {
    public static String[] solution(String[] record) {
        int length = 0;
        String[] str = new String[3];

        HashMap<String, String> hashMap = new HashMap<>();
        for (String re : record) {
            str = re.split(" ");
            if(!str[0].equals("Change")) length++;
            if(str[0].equals("Leave")) continue;
            hashMap.put(str[1], str[2]);
        }

        String[] answer = new String[length];
        int index = 0;
        for (int i = 0; i < record.length; i++) {
            str = record[i].split(" ");
            if(str[0].equals("Change")) continue;
            if(str[0].equals("Enter")) {
                answer[index++] = hashMap.get(str[1]) + "님이 " + "들어왔습니다.";
            }
            if(str[0].equals("Leave")) {
                answer[index++] = hashMap.get(str[1]) + "님이 " + "나갔습니다.";
            }

        }

        return answer;
    }
}
