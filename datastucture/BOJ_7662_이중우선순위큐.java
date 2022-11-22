package datastucture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_7662_이중우선순위큐 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> treeMap;

        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            treeMap = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String operation = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if(operation.equals("I")) {
                    operationI(treeMap, n);
                }
                if(operation.equals("D") && !treeMap.isEmpty()) {
                    Entry<Integer, Integer> now = operationD(treeMap, n);
                    if(now.getValue() > 1) {
                        treeMap.put(now.getKey(), now.getValue() - 1);
                    }
                }

            }
            System.out.println(result(treeMap));
        }

    }

    private static void operationI(TreeMap<Integer, Integer> treeMap, int n) {
        if(treeMap.containsKey(n)) {
            treeMap.put(n, treeMap.get(n) + 1);
        } else {
            treeMap.put(n, 1);
        }
    }

    private static Entry<Integer, Integer> operationD(TreeMap<Integer, Integer> treeMap, int n) {
        if(n == 1) return treeMap.pollLastEntry();
        return treeMap.pollFirstEntry();
    }

    private static String result(TreeMap<Integer, Integer> treeMap) {
        if(treeMap.isEmpty()) return "EMPTY";
        return treeMap.lastKey() + " " + treeMap.firstKey();
    }
}
