package 기업코테;

import java.io.IOException;
import java.util.*;

public class SSG_2022_상반기_2번 {
    public static void main(String[] args) throws IOException {
        String[] logs2 = {"1901 1 100", "1901 2 100", "1901 4 100", "1901 7 100", "1901 8 100", "1902 2 100", "1902 1 100", "1902 7 100", "1902 4 100", "1902 8 100", "1903 8 100", "1903 7 100", "1903 4 100", "1903 2 100", "1903 1 100", "1101 1 95", "1101 2 100", "1101 4 100", "1101 7 100", "1101 9 100", "1102 1 95", "1102 2 100", "1102 4 100", "1102 7 100", "1102 9 100"};
        String[] logs1 = {"0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"};
        String[] logs3 = {"1901 10 50", "1909 10 50"};
        String[] logs4 = {"0001 1 0", "0001 2 0", "0001 3 0", "0001 4 0", "0001 5 0", "0456 1 0", "0456 2 0", "0456 3 0", "0456 4 0", "0456 5 0"};

        String[] sol1 = solution(logs1);
        for (int i = 0; i < sol1.length; i++) {
            System.out.print(sol1[i] + " ");
        }
        System.out.println();
        String[] sol2 = solution(logs2);
        for (int i = 0; i < sol2.length; i++) {
            System.out.print(sol2[i] + " ");
        }
        System.out.println();
        String[] sol3 = solution(logs3);
        for (int i = 0; i < sol3.length; i++) {
            System.out.print(sol3[i] + " ");
        }
        System.out.println();
        String[] sol4 = solution(logs4);
        for (int i = 0; i < sol4.length; i++) {
            System.out.print(sol4[i] + " ");
        }
    }

    public static String[] solution(String[] logs) {
        Map<String, Map<Integer, Integer>> data = new HashMap<>();
        for (String log : logs) {
            String[] splited = log.split(" ");
            String person = splited[0];
            Integer sol = Integer.parseInt(splited[1]);
            Integer score = Integer.parseInt(splited[2]);

            if (data.containsKey(person)) {
                Map<Integer, Integer> solAndScore = data.get(person);
                solAndScore.put(sol, score);
            } else {
                Map<Integer, Integer> solAndScore = new HashMap<>();
                solAndScore.put(sol, score);
                data.put(person, solAndScore);
            }
        }

        Set<String> set = new HashSet<>();
        for (String key1 : data.keySet()) {
            Map<Integer, Integer> yer = data.get(key1);
            int yerSize = yer.size();
            if (yerSize < 5) continue;
            int[] yerSol = new int[101];
            Arrays.fill(yerSol, -1);
            for (Integer sol : yer.keySet()) {
                yerSol[sol] = yer.get(sol);
            }

            for (String key2 : data.keySet()) {
                Map<Integer, Integer> yee = data.get(key2);
                if (key1.equals(key2)) continue;
                int yeeSize = yee.size();
                if (yerSize != yeeSize) continue;
                int[] yeeSol = new int[101];
                Arrays.fill(yeeSol, -1);
                for (Integer sol : yee.keySet()) {
                    yeeSol[sol] = yee.get(sol);
                }

                boolean flag = true;
                for (int i = 0; i < 101; i++) {
                    if (yerSol[i] == -1 && yeeSol[i] == -1) continue;
                    if (yerSol[i] == yeeSol[i]) continue;
                    flag = false;
                    break;
                }

                if (flag) {
                    set.add(key1);
                    set.add(key2);
                }
            }

        }
        String[] answer;
        if (set.size() == 0) {
            answer = new String[1];
            answer[0] = "None";
        } else {
            answer = set.toArray(new String[0]);
            Arrays.sort(answer);
        }
        return answer;
    }
}
/**
 * 온라인으로 시험을 보는 프로그래밍 학원이 있습니다. 모든 시험 문제는 프로그램에 의해 자동으로 채점되며, 부분점수가 부여됩니다. 채점은 답안 제출과 동시에 실시간으로 이루어지며, 채점 로그가 시험 관리자에게 전달됩니다. 관리자는 시험이 모두 끝난 후 채점 로그를 통해 부정행위자로 의심되는 사람들을 찾아내려고 합니다. 이를 위해 다음과 같은 조건을 정했습니다.
 *
 * 1. 두 수험자가 푼 문제 수가 같다. 단, 푼 문제 수가 5 미만인 경우는 제외한다.
 * 2. 두 수험자가 푼 문제의 번호가 모두 같다.
 * 3. 두 수험자가 푼 문제의 점수가 모두 같다.
 * 임의의 두 수험자가 위 3가지 조건에 모두 부합하는 경우, 두 수험자를 부정행위자로 의심합니다.
 *
 * 수험자의 수험번호, 문제 번호, 받은 점수를 나타내는 문자열 배열 logs가 매개변수로 주어집니다. 위 조건에 해당하는 모든 부정행위 의심자의 수험번호를 배열에 담아 사전 순으로 정렬하여 return 하도록 solution 함수를 완성해주세요. 단, 부정행위자로 의심되는 수험자가 없는 경우에는 문자열 "None"을 배열에 담아 return 해주세요.
 *
 * 제한사항
 * logs의 길이는 1 이상 5,000 이하입니다.
 * logs의 원소는 한 수험자가 한 문제를 풀었을 때 받은 점수를 나타냅니다.
 * logs의 원소는 "수험번호 문제번호 점수" 형식의 문자열입니다.
 * 수험번호는 길이가 4인 문자열이며 숫자로만 이루어져 있습니다.
 * 문제번호는 1 이상 100 이하인 자연수입니다.
 * 점수는 0 이상 100 이하인 정수입니다.
 * 문제를 풀지 않은 경우는 logs에 기록되지 않습니다.
 * 한 수험자가 같은 문제에 대해 여러 번 답안을 제출할 수 있습니다. 단, 마지막 제출의 채점 결과가 최종 점수입니다.
 * 0점을 받는 답안 제출도 문제를 푼 것으로 칩니다.
 * 입출력 예
 * logs	result
 * ["0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"]	["0001", "0002"]
 * ["1901 1 100", "1901 2 100", "1901 4 100", "1901 7 100", "1901 8 100", "1902 2 100", "1902 1 100", "1902 7 100", "1902 4 100", "1902 8 100", "1903 8 100", "1903 7 100", "1903 4 100", "1903 2 100", "1903 1 100", "1101 1 95", "1101 2 100", "1101 4 100", "1101 7 100", "1101 9 100", "1102 1 95", "1102 2 100", "1102 4 100", "1102 7 100", "1102 9 100"]	["1101", "1102", "1901", "1902", "1903"]
 * ["1901 10 50", "1909 10 50"]	["None"]
 * ["0001 1 0", "0001 2 0", "0001 3 0", "0001 4 0", "0001 5 0", "0456 1 0", "0456 2 0", "0456 3 0", "0456 4 0", "0456 5 0"]	["0001", "0456"]
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 입력 로그는 다음과 같습니다.
 *
 * 0001 3 95
 * 0001 5 90
 * 0001 5 100
 * 0002 3 95
 * 0001 7 80
 * 0001 8 80
 * 0001 10 90
 * 0002 10 90
 * 0002 7 80
 * 0002 8 80
 * 0002 5 100
 * 0003 99 90
 * 0001번 수험자는 문제 3번을 95점, 5번을 100점(마지막 제출 기준), 7번을 80점, 8번을 80점, 10번을 90점 받았습니다. 0002번 수험자는 0001번 수험자와 완전히 같은 문제를 풀어 같은 점수를 받았으며, 두 수험자가 푼 문제 수는 5개입니다. 따라서 0001번 수험자와 0002번 수험자는 부정행위자로 의심됩니다. 따라서 수험번호 "0001"과 "0002"를 배열에 담아 사전 순으로 정렬한 후 return 합니다.
 *
 * 입출력 예 #2
 * 입력 로그는 다음과 같습니다.
 *
 * 1901 1 100
 * 1901 2 100
 * 1901 4 100
 * 1901 7 100
 * 1901 8 100
 * 1902 2 100
 * 1902 1 100
 * 1902 7 100
 * 1902 4 100
 * 1902 8 100
 * 1903 8 100
 * 1903 7 100
 * 1903 4 100
 * 1903 2 100
 * 1903 1 100
 * 1101 1 95
 * 1101 2 100
 * 1101 4 100
 * 1101 7 100
 * 1101 9 100
 * 1102 1 95
 * 1102 2 100
 * 1102 4 100
 * 1102 7 100
 * 1102 9 100
 * 1901번 수험자, 1902번 수험자, 1903번 수험자는 모두 같은 문제 5개를 풀고, 같은 점수를 받았습니다. 따라서 세 사람은 한 그룹의 부정행위자로 의심됩니다. 1101번 수험자와 1102번 수험자는 같은 문제 5개를 풀고, 모두 같은 점수를 받았습니다. 따라서 두 사람은 또 다른 한 그룹의 부정행위자로 의심됩니다. 따라서 수험번호 "1901", "1902", "1903", "1101", "1102"을 배열에 담아 사전 순으로 정렬한 후 return 합니다.
 *
 * 입출력 예 #3
 * 부정행위자로 의심받는 사람이 없으므로 ["None"]을 return 합니다.
 *
 * 입출력 예 #4
 * 0001번 수험자와 0456번 수험자는 같은 문제 5개를 풀고, 모두 0점으로 같은 점수를 받았습니다. 문제에 주어진 조건에 따라 두 사람은 한 그룹의 부정행위자로 의심됩니다. 따라서 수험번호 "0001", "0456"을 배열에 담아 정렬 후 return 합니다.
 */