package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_16506_CPU {
    private static final HashMap<String, String> assembleToMachine = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        coidSetting();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String opcode = st.nextToken();
            opcode = assembleToMachine.get(opcode);
            sb.append(opcode + "0");
            int rD = Integer.parseInt(st.nextToken());
            sb.append(String.format("%03d", Integer.parseInt(Integer.toBinaryString(rD))));
            int rA = Integer.parseInt(st.nextToken());
            sb.append(String.format("%03d", Integer.parseInt(Integer.toBinaryString(rA))));
            int BC = Integer.parseInt(st.nextToken());
            if (opcode.charAt(4) == '0') {
                sb.append(String.format("%03d", Integer.parseInt(Integer.toBinaryString(BC))) + "0");
            } else {
                sb.append(String.format("%04d", Integer.parseInt(Integer.toBinaryString(BC))));
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void coidSetting() {
        assembleToMachine.put("ADD", "00000");
        assembleToMachine.put("ADDC", "00001");
        assembleToMachine.put("SUB", "00010");
        assembleToMachine.put("SUBC", "00011");
        assembleToMachine.put("MOV", "00100");
        assembleToMachine.put("MOVC", "00101");
        assembleToMachine.put("AND", "00110");
        assembleToMachine.put("ANDC", "00111");
        assembleToMachine.put("OR", "01000");
        assembleToMachine.put("ORC", "01001");
        assembleToMachine.put("NOT", "01010");
        assembleToMachine.put("MULT", "01100");
        assembleToMachine.put("MULTC", "01101");
        assembleToMachine.put("LSFTL", "01110");
        assembleToMachine.put("LSFTLC", "01111");
        assembleToMachine.put("LSFTR", "10000");
        assembleToMachine.put("LSFTRC", "10001");
        assembleToMachine.put("ASFTR", "10010");
        assembleToMachine.put("ASFTRC", "10011");
        assembleToMachine.put("RL", "10100");
        assembleToMachine.put("RLC", "10101");
        assembleToMachine.put("RR", "10110");
        assembleToMachine.put("RRC", "10111");
    }


}
