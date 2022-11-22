package brute_force;

import java.util.HashSet;

public class Pro_불량사용자 {
    String[] cUsers;
    boolean[] checked;
    HashSet<HashSet<String>> hashSet = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        cUsers = new String[banned_id.length];
        checked = new boolean[user_id.length];
        permutation(user_id, banned_id, 0);
        return hashSet.size();
    }

    private void permutation(String[] user_id, String[] banned_id, int count) {
        if (count == banned_id.length) {
            if (!checkCase(banned_id)) return;
            HashSet<String> hash = new HashSet<>();
            for (String str : cUsers) {
                hash.add(str);
            }
            hashSet.add(hash);
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (checked[i]) continue;
            checked[i] = true;
            cUsers[count] = user_id[i];
            permutation(user_id, banned_id, count + 1);
            checked[i] = false;
        }

    }

    private boolean checkCase(String[] banned_id) {
        for (int i = 0; i < cUsers.length; i++) {
            if (cUsers[i].length() != banned_id[i].length()) return false;

            for (int j = 0; j < cUsers[i].length(); j++) {
                if (banned_id[i].charAt(j) == '*') continue;
                if (cUsers[i].charAt(j) != banned_id[i].charAt(j)) return false;
            }

        }

        return true;
    }

}
