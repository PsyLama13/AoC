package challenges.year2024.day9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Disk2 {
    List<DataBlock> dataBlocks = new ArrayList<>();
    List<FreeSpace> freeSpaces = new ArrayList<>();

    public Disk2(String input) {
        int id = 0;
        int index = 0;
        for (int i = 0; i < input.length(); i++) {
            int size = Integer.parseInt(String.valueOf(input.charAt(i)));
            if (i % 2 == 0) {
                //dataBlock
                DataBlock dataBlock = new DataBlock(index, size, id);
                dataBlocks.add(dataBlock);
                id++;
            } else {
                // freeSpace
                FreeSpace freeSpace = new FreeSpace(size, index);
                freeSpaces.add(freeSpace);
            }
            index += size;
        }
    }

    public void compactDisk() {
        for (int i = 0; i < dataBlocks.size(); i++) {
            DataBlock dataBlock = dataBlocks.get(dataBlocks.size() - 1);
            Optional<FreeSpace> freeSpace = findFreeSpace(dataBlock);
            if (freeSpace.isPresent()) {
                removeFromFreeSpace(dataBlock, freeSpace.get());
            }
        }
    }

    private void removeFromFreeSpace(DataBlock dataBlock, FreeSpace freeSpace) {
        freeSpaces.remove(freeSpace);
        if(freeSpace.getSize() != dataBlock.getSize()){
            int newIndex = freeSpace.getIndex() + dataBlock.getSize();
            int newSize = freeSpace.getSize() - dataBlock.getSize();
            FreeSpace newFreeSpace = new FreeSpace(newSize, newIndex);
            freeSpaces.add(newFreeSpace);
            freeSpaces.sort(Comparator.comparingInt(FreeSpace::getIndex));
        }
    }

    private Optional<FreeSpace> findFreeSpace(DataBlock dataBlock) {
        int size = dataBlock.getSize();
        return freeSpaces.stream().filter(i -> i.getSize() >= size).findFirst();
    }

    public long calc() {
        int checkSum = 0;
        for (DataBlock dataBlock : dataBlocks) {
            for (int i = 0; i < dataBlock.getSize(); i++) {
                checkSum += dataBlock.getId() * (dataBlock.getIndex() + i);
            }
        }
        return checkSum;
    }
}
