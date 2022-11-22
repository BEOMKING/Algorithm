package brute_force.구현;

import java.util.ArrayList;
import java.util.List;

class Pro_cell만들기 {
    Cell[][] table = new Cell[51][51];

    public String[] solution(String[] commands) {
        for (int i = 1; i < 51; i++) {
            for (int j = 1; j < 51; j++) {
                table[i][j] = new Cell(i, j, "");
            }
        }
        List<String> answer = new ArrayList<>();

        for (String command : commands) {
            String[] cmd = command.split(" ");

            if (cmd[0].equals("UPDATE")) {
                if (cmd.length == 4) {
                    int y = Integer.parseInt(cmd[1]);
                    int x = Integer.parseInt(cmd[2]);
                    table[y][x].update(cmd[3]);
                } else {
                    String findValue = cmd[1];
                    String replaceValue = cmd[2];

                    for (int i = 1; i < 51; i++) {
                        for (int j = 1; j < 51; j++) {
                            if (table[i][j].value.equals(findValue)) {
                                table[i][j].update(replaceValue);
                            }
                        }
                    }
                }
            } else if (cmd[0].equals("MERGE")) {
                Cell cell1 = table[Integer.parseInt(cmd[1])][Integer.parseInt(cmd[2])];
                Cell cell2 = table[Integer.parseInt(cmd[3])][Integer.parseInt(cmd[4])];

                if (cell1.value.isEmpty() && !cell2.value.isEmpty()) {
                    cell2.merge(cell1);
                } else {
                    cell1.merge(cell2);
                }
            } else if (cmd[0].equals("UNMERGE")) {
                Cell cell = table[Integer.parseInt(cmd[1])][Integer.parseInt(cmd[2])];
                cell.unmerge(cell.value);
            } else if (cmd[0].equals("PRINT")) {
                String value = table[Integer.parseInt(cmd[1])][Integer.parseInt(cmd[2])].value;
                answer.add(value.isEmpty() ? "EMPTY" : value);
            }
        }

        return answer.toArray(new String[answer.size()]);
    }

    class Cell {
        int r;
        int c;
        String value;
        Cell next;
        Cell prev;

        public Cell(int r, int c, String value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }

        void setNext(Cell next) {
            if (this.next != null) {
                this.next.setNext(next);
            } else {
                this.next = next;
                next.setPrev(this);
            }

            this.value = next.value;
        }

        void setPrev(Cell prev) {
            if (this.prev != null) {
                this.prev.setPrev(prev);
            } else {
                this.prev = prev;
            }

            this.value = prev.value;
        }

        public void update(String value) {
            this.value = value;

            if (next != null) {
                setNext(new Cell(r, c, value));
            }

            if (prev != null) {
                setPrev(new Cell(r, c, value));
            }
        }

        public void merge(Cell cell) {
            setNext(cell);
        }

        public void unmerge(String value) {
            if (this.next != null) {
                Cell next = this.next;
                this.next = null;
                next.unmerge("");
            }

            this.value = value;

            if (prev != null) {
                Cell prev = this.prev;
                this.prev = null;
                prev.unmerge(value);
            }
        }
    }

    public static void main(String[] args) {
        Pro_cell만들기 solution = new Pro_cell만들기();
        String[] commands = {
                "UPDATE 1 1 A",
                "UPDATE 1 2 B",
                "UPDATE 2 1 C",
                "UPDATE 2 2 D",
                "MERGE 1 1 1 2",
                "MERGE 2 2 2 1",
                "MERGE 2 1 1 1",
                "PRINT 1 1",
                "UNMERGE 2 2",
                "PRINT 1 1"
        };
        String[] answer = solution.solution(commands);
        for (String s : answer) {
            System.out.println(s);
        }
    }
}
