package challenges.year2018.day01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record FrequencyReader(List<Frequency> frequencies) {

    public static FrequencyReader fromInputList(List<String> input) {
        List<Frequency> frequencyValues = new ArrayList<>();
        for (String s : input) {
            int frequencyValue = Integer.parseInt(s);
            frequencyValues.add(new Frequency(frequencyValue));
        }
        return new FrequencyReader(frequencyValues);
    }

    public int calculateFrequencyChange() {
        int output = 0;

        for (Frequency frequency : frequencies) {
            output += frequency.amount();
        }
        return output;
    }

    public int findFirstDuplicate() {
        int currentFrequencyAmount = 0;
        Set<Integer> foundFrequencies = new HashSet<>();
        foundFrequencies.add(0);

        while (true) {
            for (Frequency frequency : frequencies) {
                currentFrequencyAmount += frequency.amount();
                if (foundFrequencies.contains(currentFrequencyAmount)) {
                    return currentFrequencyAmount;
                }

                foundFrequencies.add(currentFrequencyAmount);
            }
        }
    }
}
