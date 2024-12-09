package y2024.d9;

public class FreeSpace implements DiskData {

    private final int size;
    private final int index;
    public FreeSpace(int size, int index) {
        this.size = size;
        this.index = index;
    }

    @Override
    public boolean isFreeSpace() {
        return true;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getId() {
        return -1;
    }

    @Override
    public int getIndex() {
        return index;
    }


}
