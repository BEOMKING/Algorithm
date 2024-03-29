package brute_force;

import java.util.Scanner;

public class SWEA_1873_상호의배틀필드 {
    static int H;
    static int W;
    static String field[][];
    static String input[];
    static int x;
    static int y;
    static String startD;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            H = sc.nextInt(); // 높이
            W = sc.nextInt(); // 너비
            field = new String[H][W];

            for (int j = 0; j < H; j++) { // 필드 생성
                String str = sc.next();
                field[j] = str.split("");
            }
            int N = sc.nextInt(); // 사용자 커맨드
            String str = sc.next();
            input = str.split(""); // 사용자 커맨드 저장

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (field[i][j].equals("^") || field[i][j].equals("v") || field[i][j].equals("<") || field[i][j].equals(">")) {
                        x = i;
                        y = j;
                        startD = field[i][j];
                    }
                }
            }

            for (int m = 0; m < input.length; m++) {
                if (input[m].equals("U")) {
                    if (x - 1 < 0 || field[x - 1][y].equals("*") || field[x - 1][y].equals("#") || field[x - 1][y].equals("-")) {
                        field[x][y] = "^";
                    } else {
                        field[x][y] = ".";
                        x -= 1;
                        field[x][y] = "^";
                    }
                } else if (input[m].equals("D")) {
                    if (x + 1 >= H || field[x + 1][y].equals("*") || field[x + 1][y].equals("#") || field[x + 1][y].equals("-")) {
                        field[x][y] = "v";
                    } else {
                        field[x][y] = ".";
                        x += 1;
                        field[x][y] = "v";
                    }
                } else if (input[m].equals("L")) {
                    if (y - 1 < 0 || field[x][y - 1].equals("*") || field[x][y - 1].equals("#") || field[x][y - 1].equals("-")) {
                        field[x][y] = "<";
                    } else {
                        field[x][y] = ".";
                        y -= 1;
                        field[x][y] = "<";
                    }
                } else if (input[m].equals("R")) {
                    if (y + 1 >= W || field[x][y + 1].equals("*") || field[x][y + 1].equals("#") || field[x][y + 1].equals("-")) {
                        field[x][y] = ">";
                    } else {
                        field[x][y] = ".";
                        y += 1;
                        field[x][y] = ">";
                    }
                } else if (input[m].equals("S")) {
                    int tx = x;
                    int ty = y;
                    if (field[x][y].equals("^")) {
                        while (tx - 1 >= 0 && ty >= 0 && tx < H && ty < W) {
                            if (field[tx - 1][ty].equals("*")) {
                                field[tx - 1][ty] = ".";
                                break;
                            } else if (field[tx - 1][ty].equals("#")) {
                                break;
                            } else if (field[tx - 1][ty].equals("-")) {
                                tx -= 1;
                            } else if (field[tx - 1][ty].equals(".")) {
                                tx -= 1;
                            }
                        }
                    } else if (field[x][y].equals("v")) {
                        while (tx >= 0 && ty >= 0 && tx + 1 < H && ty < W) {
                            if (field[tx + 1][ty].equals("*")) {
                                field[tx + 1][ty] = ".";
                                break;
                            } else if (field[tx + 1][ty].equals("#")) {
                                break;
                            } else if (field[tx + 1][ty].equals("-")) {
                                tx += 1;
                            } else if (field[tx + 1][ty].equals(".")) {
                                tx += 1;
                            }
                        }
                    } else if (field[x][y].equals("<")) {
                        while (tx >= 0 && ty - 1 >= 0 && tx < H && ty < W) {
                            if (field[tx][ty - 1].equals("*")) {
                                field[tx][ty - 1] = ".";
                                break;
                            } else if (field[tx][ty - 1].equals("#")) {
                                break;
                            } else if (field[tx][ty - 1].equals("-")) {
                                ty -= 1;
                            } else if (field[tx][ty - 1].equals(".")) {
                                ty -= 1;
                            }
                        }
                    } else if (field[x][y].equals(">")) {
                        while (tx >= 0 && ty >= 0 && tx < H && ty + 1 < W) {
                            if (field[tx][ty + 1].equals("*")) {
                                field[tx][ty + 1] = ".";
                                break;
                            } else if (field[tx][ty + 1].equals("#")) {
                                break;
                            } else if (field[tx][ty + 1].equals("-")) {
                                ty += 1;
                            } else if (field[tx][ty + 1].equals(".")) {
                                ty += 1;
                            }
                        }
                    }
                }
            }

            System.out.print("#" + (t + 1) + " ");
            for (int k = 0; k < H; k++) {
                for (int l = 0; l < W; l++) {
                    System.out.print(field[k][l]);
                }
                System.out.println();
            }
        }
    }
}
