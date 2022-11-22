package brute_force;

public class Pro_단체사진찍기 {
    final char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    final int length = friends.length;
    char[] permutations = new char[length];
    boolean[] checked = new boolean[length];
    int answer = 0;

    public int solution(int n, String[] data) {
        permutation(0, data);
        return answer;
    }

    public void permutation(int count, String[] data) {
        if (count == length) {
            answer += condition(data);
            return;
        }

        for (int i = 0; i < length; i++) {
            if (checked[i]) {
                continue;
            }
            checked[i] = true;
            permutations[count] = friends[i];
            permutation(count + 1, data);
            checked[i] = false;
        }
    }

    public int condition(String[] datas) {

        for (String data : datas) {
            char operation = data.charAt(3);
            int want = data.charAt(4) - '0';
            int beforeIndex = find(data.charAt(0));
            int afterIndex = find(data.charAt(2));
            if (!calulate(beforeIndex, afterIndex, operation, want + 1)) {
                return 0;
            }

        }

        return 1;
    }

    private boolean calulate(int beforeIndex, int afterIndex, char operation, int want) {
        if (operation == '=') {
            if (Math.abs(beforeIndex - afterIndex) == want) {
                return true;
            }
        }

        if (operation == '>') {
            if (Math.abs(beforeIndex - afterIndex) > want) {
                return true;
            }
        }

        if (operation == '<') {
            if (Math.abs(beforeIndex - afterIndex) < want) {
                return true;
            }
        }
        return false;
    }

    private int find(char before) {
        for (int i = 0; i < permutations.length; i++) {
            if (before != permutations[i]) {
                continue;
            }
            return i;
        }
        return -1;
    }

}
