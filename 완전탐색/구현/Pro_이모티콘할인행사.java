package 완전탐색.구현;

class Pro_이모티콘할인행사 {
    int[] discountRate;
    int[] percents = {10, 20, 30, 40};
    int[] answer = new int[2];

    public int[] solution(int[][] users, int[] emoticons) {
        discountRate = new int[emoticons.length];
        brute(0, users, emoticons);

        return answer;
    }

    private void brute(int count, int[][] users, int[] emoticons) {
        if (count == discountRate.length) {
            calculate(users, emoticons);
            return;
        }

        for (int i = 0; i < 4; i++) {
            discountRate[count] = percents[i];
            brute(count + 1, users, emoticons);
        }
    }

    private void calculate(int[][] users, int[] emoticons) {
        int[] discountedEmoticons = new int[emoticons.length];
        for (int i = 0; i < emoticons.length; i++) {
            discountedEmoticons[i] = emoticons[i] * (100 - discountRate[i]) / 100;
        }

        int subscriber = 0;
        int sales = 0;

        for (int[] user : users) {
            int desiredDiscountRate = user[0];
            int limit = user[1];
            int sum = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (discountRate[i] >= desiredDiscountRate) {
                    sum += discountedEmoticons[i];
                }
            }

            if (sum >= limit) {
                subscriber++;
            } else {
                sales += sum;
            }
        }

        if (answer[0] < subscriber) {
            answer[0] = subscriber;
            answer[1] = sales;
        } else if (answer[0] == subscriber && answer[1] < sales) {
            answer[1] = sales;
        }
    }
}
