package challenges.year2024.day22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Monkey {
    List<Long> secretList;
    List<Long> priceList;
    List<Long> diffList;

    public Monkey(String string) {
        long num = Long.parseLong(string);
        secretList = new ArrayList<>(List.of(num));
        for (int i = 0; i < 2000; i++) {
            num = SecretHelper.encode(num);
            secretList.add(num);
        }

        priceList = getPriceList(secretList);
        diffList = getPriceDiffList(priceList);
    }

    public long getCalc1Value() {
        return secretList.get(secretList.size() - 1);
    }

    private List<Long> getPriceList(List<Long> list) {
        List<Long> arrayList = new ArrayList<>();
        for (Long l : list) {
            String string = String.valueOf(l);
            long newA = Long.parseLong(string.split("")[string.length() - 1]);
            arrayList.add(newA);
        }
        return arrayList;
    }

    private List<Long> getPriceDiffList(List<Long> prices) {
        List<Long> diffs = new ArrayList<>();
        for (int i = 0; i < prices.size() - 1; i++) {
            Long diff = prices.get(i + 1) - prices.get(i);
            diffs.add(diff);
        }

        return diffs;
    }

    public List<Long> getDiffRowAt(int index) {
        return diffList.subList(index, index + 4);
    }

    public Long getPriceForDiffList(List<Long> list) {
        int index = Collections.indexOfSubList(diffList, list);
        if (index == -1) {
            return 0L;
        }
        return priceList.get(index + 4);
    }
}
