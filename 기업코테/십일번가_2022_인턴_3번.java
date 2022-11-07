package 기업코테;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 십일번가_2022_인턴_3번 {

    public String solution(String S) {
        String[] splitedS = S.split("\\\\n");
        List<String> nameList = new ArrayList<>(); // 사진 순서대로 하기 위한 제목

        Map<String, List<Picture>> map = new HashMap<>();
        for (String str : splitedS) {
            String[] split = str.split(", ");
            String name = split[0];
            String city = split[1];
            String time = split[2];

            nameList.add(name);

            Picture picture = new Picture(name, time);
            if (map.containsKey(city)) {
                map.get(city).add(picture);
            } else {
                List<Picture> list = new ArrayList<>();
                list.add(picture);
                map.put(city, list);
            }
        }

        Map<String, String> result = new HashMap<>();
        for (String key : map.keySet()) {
            List<Picture> pictures = map.get(key);
            Collections.sort(pictures);
            int max = (pictures.size() + "").length();

            int count = 1;

            for (Picture now : pictures) {
                String fillCount = String.format("%0" + max + "d", count);
                count++;
                String converted = key + fillCount + "." + now.name.split("\\.")[1];
                result.put(now.name, converted);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String name : nameList) {
            sb.append(result.get(name)).append("\n");
        }
        return sb.toString();
    }

    class Picture implements Comparable<Picture> {
        String name;
        String time;

        public Picture(String name, String time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public int compareTo(Picture o) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date first;
            Date second;
            try {
                first = format.parse(this.time);
                second = format.parse(o.time);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            return first.compareTo(second);
        }
    }

    public static void main(String[] args) {
        십일번가_2022_인턴_3번 three = new 십일번가_2022_인턴_3번();
//        System.out.println(three.splitLine("photo.jpg, 바르샤바, 2013-09-05 14:08:15\njohn.png, 런던, 2015-06-20 15:13:22\nmyFriends.png, 바르샤바").length);
//        List<Picture> temp = new ArrayList<>();
//        temp.add(three.new Picture(".png", "2015-06-20 15:13:22"));
//        temp.add(three.new Picture(".jpg", "2013-09-05 14:08:15"));
//        System.out.println(temp.get(0).name);
//        Collections.sort(temp);
//        System.out.println(temp.get(0).name);
//        String[] b = "photo.jpg, Warsaw, 2013-09-05 14:08:15".split(", ");
//        for (String a : b) {
//            System.out.println(a);
//        }

//        System.out.println(three.solution("photo.jpg, Warsaw, 2013-09-05 14:08:15\\njohn.png, London, 2015-06-20 15:13:22\\nmyFriends.png, Warsaw, 2013-09-05 14:07:13\\nEiffel.jpg, Paris, 2015-07-23 08:03:02\\npisatower.jpg, Paris, 2015-07-22 23:59:59\\nBOB.jpg, London, 2015-08-05 00:02:03\\nnotredame.png, Paris, 2015-09-01 12:00:00\\nme.jpg, Warsaw, 2013-09-06 15:40:22\\na.png, Warsaw, 2016-02-13 13:33:50\\nb.jpg, Warsaw, 2016-01-02 15:12:22\\nc.jpg, Warsaw, 2016-01-02 14:34:30\\nd.jpg, Warsaw, 2016-01-02 15:15:01\\ne.png, Warsaw, 2016-01-02 09:49:09\\nf.png, Warsaw, 2016-01-02 10:55:32\\ng.jpg, Warsaw, 2016-02-29 22:13:11"));
        System.out.println(three.solution("photo.jpg, Warsaw, 2013-09-05 14:08:15\\njohn.png, London, 2015-06-20 15:13:22\\nmyFriends.png, Warsaw, 2013-09-05 14:07:13\\nEiffel.jpg, Paris, 2015-07-23 08:03:02\\npisatower.jpg, Paris, 2015-07-22 23:59:59\\nBOB.jpg, London, 2015-08-05 00:02:03\\nnotredame.png, Paris, 2015-09-01 12:00:00\\nme.jpg, Warsaw, 2013-09-06 15:40:22\\na.png, Warsaw, 2016-02-13 13:33:50\\nb.jpg, Warsaw, 2016-01-02 15:12:22\\nc.jpg, Warsaw, 2016-01-02 14:34:30\\nd.jpg, Warsaw, 2016-01-02 15:15:01\\ne.png, Warsaw, 2016-01-02 09:49:09\\nf.png, Warsaw, 2016-01-02 10:55:32\\ng.jpg, Warsaw, 2016-02-29 22:13:11"));
//        String[] c = "photo.jpg, Warsaw, 2013-09-05 14:08:15\\njohn.png, London, 2015-06-20 15:13:22\\nmyFriends.png, Warsaw, 2013-09-05 14:07:13\\nEiffel.jpg, Paris, 2015-07-23 08:03:02\\npisatower.jpg, Paris, 2015-07-22 23:59:59\\nBOB.jpg, London, 2015-08-05 00:02:03\\nnotredame.png, Paris, 2015-09-01 12:00:00\\nme.jpg, Warsaw, 2013-09-06 15:40:22\\na.png, Warsaw, 2016-02-13 13:33:50\\nb.jpg, Warsaw, 2016-01-02 15:12:22\\nc.jpg, Warsaw, 2016-01-02 14:34:30\\nd.jpg, Warsaw, 2016-01-02 15:15:01\\ne.png, Warsaw, 2016-01-02 09:49:09\\nf.png, Warsaw, 2016-01-02 10:55:32\\ng.jpg, Warsaw, 2016-02-29 22:13:11".split("\\\\n");
//        for (String d : c) {
//            System.out.println(d);
//        }

    }

}
