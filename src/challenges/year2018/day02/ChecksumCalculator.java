package challenges.year2018.day02;

import java.util.ArrayList;
import java.util.List;

public record ChecksumCalculator(List<Box> boxes) {
    public static ChecksumCalculator fromInputList(List<String> input) {
        List<Box> boxList = new ArrayList<>();
        for (String boxId : input) {
            boxList.add(new Box(boxId));
        }
        return new ChecksumCalculator(boxList);
    }

    public long getCheckSum() {

        long doubles = boxes.stream().filter(Box::hasDoubles).count();
        long triples = boxes.stream().filter(Box::hasTriples).count();

        return doubles * triples;
    }

    public String getProtoName() {
        for (int i = 0; i < boxes.size() - 1; i++) {
            Box boxA = boxes.get(i);
            for (int j = i + 1; j < boxes.size(); j++) {
                Box boxB = boxes.get(j);
                if (Box.hasProtoFabric(boxA, boxB)) {
                    return Box.generateProtoName(boxA, boxB);
                }
            }
        }
        throw new IllegalStateException("no proto boxes found!");
    }
}
