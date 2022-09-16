package 완전탐색;

public class Pro_자물쇠와열쇠 {
    public boolean solution(int[][] key, int[][] lock) {
        int offset = key.length - 1;

        for (int y = 0; y < offset + lock.length; y++) {
            for (int x = 0; x < offset + lock.length; x++) {
                for (int d = 0; d < 4; d++) {
                    int[][] virtual = new int[58][58];
                    for (int i = 0; i < lock.length; i++) {
                        for (int j = 0; j < lock.length; j++) {
                            virtual[offset + i][offset + j] = lock[i][j];
                        }
                    }
                    brute(virtual, key, d, y, x);
                    if (match(virtual, offset, lock.length)) return true;

                }
            }
        }

        return false;
    }

    private boolean match(int[][] virtual, int offset, int length) {
        for (int i = offset; i < offset + length; i++) {
            for (int j = offset; j < offset + length; j++) {
                if (virtual[i][j] != 1) return false;
            }
        }

        return true;
    }

    private void brute(int[][] virtual, int[][] key, int d, int y, int x) {
        int keyLength = key.length;

        for (int i = 0; i < keyLength; i++) {
            for (int j = 0; j < keyLength; j++) {
                if (d == 0) {
                    virtual[y + i][x + j] += key[i][j];
                } else if (d == 1) {
                    virtual[y + i][x + j] += key[j][keyLength - 1 - i];
                } else if (d == 2) {
                    virtual[y + i][x + j] += key[keyLength - 1 - i][keyLength - 1 - j];
                } else {
                    virtual[y + i][x + j] += key[keyLength - 1 - j][i];
                }
            }
        }

    }
}
