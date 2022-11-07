package 기업코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 원티드_2022_쇼미더코드_1번 {
    static int N, min = Integer.MAX_VALUE;
    static int[] price;
    static List[] info;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        price = new int[N];
        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }
        info = new List[N];
        checked = new boolean[N];
        for (int i = 0; i < N; i++) {
            info[i] = new ArrayList<>();
            int p = Integer.parseInt(br.readLine());
            for (int j = 0; j < p; j++) {
                st = new StringTokenizer(br.readLine());
                info[i].add(new Sale(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
        }

        brute(0, 0);
        System.out.println(min);
    }

    public static void brute(int count, int sum) {
        if (count == N) {
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (checked[i]) continue;
            checked[i] = true;
            List<Sale> record = new ArrayList<>();
            List<Sale> list = info[i];
            for (int j = 0; j < list.size(); j++) {
                Sale sale = list.get(j);
                int number = sale.num - 1;
                if (price[number] <= sale.salePrice) {
                    record.add(new Sale(number, price[number] - 1));
                    price[sale.num - 1] = 1;
                } else {
                    record.add(new Sale(number, sale.salePrice));
                    price[sale.num - 1] -= sale.salePrice;
                }
            }
            brute(count + 1, sum + price[i]);
            checked[i] = false;
            for (int j = 0; j < record.size(); j++) {
                Sale sale = record.get(j);
                price[sale.num] += sale.salePrice;
            }
        }
    }

    public static class Sale {
        int num, salePrice;

        public Sale(int num, int salePrice) {
            this.num = num;
            this.salePrice = salePrice;
        }
    }
}

/*
    A번 - 물약 구매 성공
    시간 제한	메모리 제한
    3 초	1024 MB
    문제
    준겸이는 모험가이다. 모험을 떠나기 위해서는 철저한 사전 준비를 갖추어야 한다.

    준겸이는 모험을 떠나기 전 $N$종류의 물약을 모두 구매하려고 한다. 물약 상점에 들른 준겸이는 각 물약이 $1$번부터 $N$번까지 번호가 매겨져 있다는 것을 알아냈다. 그런데, 물약 상점에서는 오늘 특별한 이벤트를 하고 있었다. 특정 물약을 구매하면, 어떤 다른 물약들을 할인해준다는 것이었다.

    원래 $i$번째 물약의 가격은 동전 $c_i$개이다. 만약 $i$번째 물약을 구매하면, $p_i$종류의 다른 물약의 가격이 내려간다.

    할인은 중첩된다. 예를 들어 $1$번 물약을 구매하면 $3$번 물약의 가격이 동전 $1$개만큼 할인되고, $2$번 물약을 구매하면 역시 $3$번 물약의 가격이 동전 $2$개만큼 할인된다고 하자. 그러면 두 물약을 모두 구매하고 나서 $3$번 물약을 구매할 때 동전 $3$개만큼의 할인을 받을 수 있다. 단, 물약의 가격이 내려가더라도 $0$ 이하로 내려가지는 않는다. 예를 들어, 원래 가격이 동전 $5$개인 물약이 동전 $4$개를 넘는 만큼 할인되더라도 가격은 동전 $1$개가 된다.

    준겸이는 신나서 물약을 구매하려다가, 물약을 구매하는 순서가 중요하다는 사실을 깨달았다. 준겸이를 위해 물약을 가장 싸게 샀을 때 그 비용을 알려주자.

    입력
    첫째 줄에 물약의 종류 $N$이 주어진다.

    둘째 줄에 물약의 가격 $c_i$가 공백을 사이에 두고 주어진다($1 \le i \le N$).

    다음 줄부터, 물약 할인 정보가 $N$개 주어진다. $i$번째로 주어지는 물약 할인 정보는 다음과 같다($1 \le i \le N$).

     $p_i$가 주어진다. 다음 $p_i$개의 줄에, 물약 번호 $a_j$와 할인되는 가격 $d_j$가 주어진다. 이는 $i$번 물약을 구매하고 나면 물약 $a_j$가 동전 $d_j$개만큼 할인된다는 뜻이다.

    출력
    첫째 줄에 물약을 가장 싸게 샀을 때 동전이 몇 개 필요한지 출력한다.

    제한
     $2 \le N \le 10$ 
     $1 \le c_i \le 1\,000$ 
     $0 \le p_i \le N-1$ 
    각 $i$에 대해, 모든 $a_j$는 서로 다르고 $a_j \neq i$ 
     $1 \le d_j \le 1\,000$ 
    예제 입력 1
    4
    10 15 20 25
    2
    3 10
    2 20
    0
    1
    4 10
    1
    1 10
    예제 출력 1
    36
    동전 10개를 지불하고 1번 물약을 구매하면, 3번 물약이 동전 10개만큼 할인되어 값이 동전 10개가 된다. 2번 물약은 동전 20개만큼 할인되어야 하지만, 최소 1개는 지불해야 하므로 값이 동전 1개가 된다. 그 후 동전 10개를 지불하고 3번 물약을 구매하면, 4번 물약이 동전 10개만큼 할인되어 값이 동전 15개가 된다. 그 후에 2번 물약과 4번 물약을 동전 1개와 15개를 내고 각각 구매하면 총 36개의 동전을 내고 모든 물약을 구매할 수 있다.
*/
