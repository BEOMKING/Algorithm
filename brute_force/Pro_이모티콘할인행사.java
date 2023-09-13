package brute_force;

public class Pro_이모티콘할인행사 {
    // 유저 길이 n <= 100, 할인율 <= 4, 이모티콘 길이 <= 7 이므로
    // 모든 경우를 탐색해도(4^7 * 100 = 1638400) 시간 복잡도에 문제가 없다.
    // 따라서 이모티콘이 가질 수 있는 모든 비율에 따라 이모티콘 플러스 가입수와 판매액을 비교하면 해결할 수 있다.
    public int maxSubscribers = 0;
    public int maxSales = 0;
    public int[] discounts;

    public int[] solution(int[][] users, int[] emoticons) {
        discounts = new int[emoticons.length];
        brute(0, users, emoticons);
        return new int[]{maxSubscribers, maxSales};
    }

    private void brute(int index, int[][] users, int[] emoticons) {
        if (index == emoticons.length) {
            int subscribers = 0;
            int sales = 0;

            for (int[] user : users) {
                int buyPercent = user[0];
                int limit = user[1];
                int buy = 0;

                for (int i = 0; i < emoticons.length; i++) {
                    if (discounts[i] >= buyPercent) {
                        buy += (emoticons[i] - (emoticons[i] * discounts[i] / 100));
                    }
                }

                if (limit <= buy) {
                    subscribers++;
                } else {
                    sales += buy;
                }
            }

            if (maxSubscribers < subscribers || maxSubscribers == subscribers && maxSales < sales) {
                maxSubscribers = subscribers;
                maxSales = sales;
            }

            return;
        }

        for (int sale = 10; sale <= 40; sale += 10) {
            discounts[index] = sale;
            brute(index + 1, users, emoticons);
        }
    }
}
