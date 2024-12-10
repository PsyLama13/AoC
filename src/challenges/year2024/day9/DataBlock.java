package challenges.year2024.day9;

public class DataBlock implements DiskData {

    private int index;
    private final int size;
    private final int id;

    public DataBlock(int index, int size, int id) {
        this.index = index;
        this.size = size;
        this.id = id;
    }

    @Override
    public boolean isFreeSpace() {
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
