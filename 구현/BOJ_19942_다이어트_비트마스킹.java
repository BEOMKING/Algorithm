package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_19942_다이어트_비트마스킹 {

    static int min = Integer.MAX_VALUE;
    static Material[] combination;
    static int[] combinationNumber;
    static Material target;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Material[] materials = new Material[N];
        st = new StringTokenizer(br.readLine());
        target = new Material(strToInt(st.nextToken()),
            strToInt(st.nextToken()), strToInt(st.nextToken()),
            strToInt(st.nextToken()), 0);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            materials[i] = new Material(strToInt(st.nextToken()),
                strToInt(st.nextToken()), strToInt(st.nextToken()),
                strToInt(st.nextToken()), strToInt(st.nextToken()));
        }

        combination = new Material[N];
        combinationNumber = new int[N];
        brute(materials, 0, 0);
        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(min);
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }

    }

    private static void brute(Material[] materials, int count, int index) {
        if(calulateSum(count)) {
            queue = new LinkedList<>();
            for (int i = 0; i < count; i++) {
                queue.add(combinationNumber[i]);
            }
            return;
        }

        for (int i = index; i < materials.length; i++) {
            combination[count] = materials[i];
            combinationNumber[count] = i + 1;
            brute(materials, count + 1, i + 1);
        }
    }

    private static boolean calulateSum(int count) {
        int sumProtein = 0, sumFat = 0, sumCarbo = 0, sumViatamin = 0, sumPrice = 0;
        for (int i = 0; i < count; i++) {
            Material now = combination[i];
            sumProtein += now.protein;
            sumFat += now.fat;
            sumCarbo += now.carbo;
            sumViatamin += now.vitamin;
            sumPrice += now.price;
        }

        return check(sumProtein, sumFat, sumCarbo, sumViatamin, sumPrice);
    }

    private static boolean check(int sumProtein, int sumFat, int sumCarbo, int sumViatamin, int sumPrice) {
        if(sumProtein < target.protein) return false;
        if(sumFat < target.fat) return false;
        if(sumCarbo < target.carbo) return false;
        if(sumViatamin < target.vitamin) return false;
        if(min <= sumPrice) return false;
        min = sumPrice;
        return true;
    }

    private static int strToInt(String str) {
        return Integer.parseInt(str);
    }

    static class Material {
        int protein, fat, carbo, vitamin, price;

        public Material(int protein, int fat, int carbo, int vitamin, int price) {
            this.protein = protein;
            this.fat = fat;
            this.carbo = carbo;
            this.vitamin = vitamin;
            this.price = price;
        }
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int min = Integer.MAX_VALUE;
//
//        int N = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine());
//        Material target = new Material(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
//        Material[] materials = new Material[N + 1];
//        for (int i = 1; i <= N; i++) {
//            st = new StringTokenizer(br.readLine());
//            materials[i] = new Material(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
//        }
//
//        HashMap<Integer, List<String>> hashMap = new HashMap<>();
//        for (int i = 1; i < (1 << N); i++) { // 모든 조합의 수
//            int sumProtein = 0, sumFat = 0, sumCarbo = 0, sumViatamin = 0, sumPrice = 0;
//            String str = "";
//            for (int j = 0; j < N; j++) {
//                if((i & 1 << j) == 0) continue;
//                str += (j + 1) + " ";
//                sumProtein += materials[j + 1].protein;
//                sumFat += materials[j + 1].fat;
//                sumCarbo += materials[j + 1].carbo;
//                sumViatamin += materials[j + 1].vitamin;
//                sumPrice += materials[j + 1].price;
//            }
//            if(sumProtein < target.protein) continue;
//            if(sumFat < target.fat) continue;
//            if(sumCarbo < target.carbo) continue;
//            if(sumViatamin < target.vitamin) continue;
//            if(min < sumPrice) continue;
//            if(min == sumPrice) {
//                List<String> base = hashMap.get(min);
//                base.add(str);
//                hashMap.put(min, base);
//            } else {
//                min = sumPrice;
//                List<String> base = new ArrayList<>();
//                base.add(str);
//                hashMap.put(min, base);
//            }
//        }
//
//        if (hashMap.isEmpty()) {
//            System.out.println(-1);
//        } else {
//            for (int key : hashMap.keySet()) {
//                if (min == key) {
//                    System.out.println(key);
//                    List<String> result = hashMap.get(key);
//                    Collections.sort(result);
//                    System.out.print(result.get(0));
//                    break;
//                }
//            }
//        }
//    }

//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringTokenizer st;
//    static int min = Integer.MAX_VALUE;
//    static Material target;
//    static Stack<Integer> stack = new Stack<>();
//    static HashMap<Integer, List<Integer>> hashmap =new HashMap<>();
//
//    public static void main(String[] args) throws IOException {
//        int N = Integer.parseInt(br.readLine());
//        target = setTarget();
//        Material[] materials = setMaterial(N);
//        brute(materials, 0, 0, 0, 0, 0, 1);
//
//        if(hashmap.isEmpty()) {
//            System.out.println(-1);
//        } else {
//            System.out.println(min);
//            for (int num : hashmap.get(min)) {
//                System.out.print(num + " ");
//            }
//        }
//
//    }
//
//    private static void brute(Material[] materials, int sumProtein, int sumFat, int sumCarbo, int sumViatamin, int sumPrice, int index) {
//        if(check(sumProtein, sumFat, sumCarbo, sumViatamin, sumPrice)) {
//            hashmap.put(sumPrice, new ArrayList<>());
//            for (int num : stack) {
//                hashmap.get(sumPrice).add(num);
//            }
//            return;
//        }
//
//        for (int i = index; i < materials.length; i++) {
//            stack.push(i);
//            brute(materials, sumProtein + materials[i].protein, sumFat + materials[i].fat,
//                sumCarbo + materials[i].carbo, sumViatamin + materials[i].vitamin,
//                sumPrice + materials[i].price, i + 1);
//            stack.pop();
//        }
//    }
//
//    private static boolean check(int sumProtein, int sumFat, int sumCarbo, int sumViatamin, int sumPrice) {
//        if(sumProtein < target.protein) return false;
//        if(sumFat < target.fat) return false;
//        if(sumCarbo < target.carbo) return false;
//        if(sumViatamin < target.vitamin) return false;
//        if(min <= sumPrice) return false;
//        min = sumPrice;
//        return true;
//    }
//
//    private static Material[] setMaterial(int N) throws IOException {
//        Material[] materials = new Material[N + 1];
//        for (int i = 1; i <= N; i++) {
//            st = new StringTokenizer(br.readLine());
//            materials[i] = new Material(strToInt(st.nextToken()),
//                strToInt(st.nextToken()), strToInt(st.nextToken()),
//                strToInt(st.nextToken()), strToInt(st.nextToken()));
//        }
//        return materials;
//    }
//
//    private static Material setTarget() throws IOException {
//        st = new StringTokenizer(br.readLine());
//        target = new Material(strToInt(st.nextToken()),
//            strToInt(st.nextToken()), strToInt(st.nextToken()),
//            strToInt(st.nextToken()), 0);
//        return target;
//    }
//
//    private static int strToInt(String str) {
//        return Integer.parseInt(str);
//    }
//
//    static class Material {
//        int protein, fat, carbo, vitamin, price;
//
//        public Material(int protein, int fat, int carbo, int vitamin, int price) {
//            this.protein = protein;
//            this.fat = fat;
//            this.carbo = carbo;
//            this.vitamin = vitamin;
//            this.price = price;
//        }
//    }

}
