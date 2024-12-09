package y2024.d9;

public class Disk {

    int[] disk;

    public Disk(String input) {
        // Estimate size of the disk array (sum of all digits)
        int totalLength = 0;
        for (char c : input.toCharArray()) {
            totalLength += Character.getNumericValue(c);
        }

        disk = new int[totalLength];
        int id = 0;
        int pos = 0;

        for (int i = 0; i < input.length(); i++) {
            int length = Character.getNumericValue(input.charAt(i));
            int blockID = (i % 2 == 0) ? id++ : -1; // File ID or free space (-1)

            for (int j = 0; j < length; j++) {
                disk[pos++] = blockID;
            }
        }
    }

    void compactDisk() {
        int numPointer = findNextNum(disk.length - 1);
        int dotCounter = findNextDot(0);

        while (true) {
            if (dotCounter >= numPointer) {
                return;
            }
            swapNumbers(numPointer, dotCounter);
            numPointer = findNextNum(numPointer);
            dotCounter = findNextDot(dotCounter);
        }
    }

    private void swapFile(int startNum, int endNum) {
        int size = startNum - endNum + 1;
        int dotIndex = findEnoughFreeSpace(size, endNum);
        if (dotIndex != -1 && dotIndex < endNum) {
            for (int i = 0; i < size; i++) {
                int numPointer = startNum - i;
                int dotPointer = dotIndex + i;
                swapNumbers(numPointer, dotPointer);
            }
        }
    }

    private int findEnoughFreeSpace(int size, int endNum) {
        int start = findNextDot(0);
        int end = findEndOfDot(start);
        while (true) {
            int freeSize = end - start;
            if (freeSize >= size) {
                return start;
            } else {
                start = findNextDot(end + 1);
                if(start >= endNum){
                    return -1;
                }
                end = findEndOfDot(start);
            }
        }
    }

    private void swapNumbers(int numPointer, int dotCounter) {
        int temp = disk[numPointer];
        disk[numPointer] = disk[dotCounter];
        disk[dotCounter] = temp;
    }

    private int findNextDot(int startIndex) {
        while (true) {
            if (disk[startIndex] == -1) {
                return startIndex;
            } else {
                startIndex++;
            }
        }
    }

    private int findEndOfDot(int startDot) {
        int index = startDot + 1;
        while (true) {
            if (disk[index] != -1) {
                return index;
            } else {
                index++;
            }
        }
    }


    private int findNextNum(int startIndex) {
        while (true) {
            if (startIndex < 0) {
                return -1;
            }
            if (disk[startIndex] != -1) {
                return startIndex;
            } else {
                startIndex--;
            }
        }
    }

    private int findEndOfNum(int startNum) {
        int num = disk[startNum];
        int index = startNum;
        while (true) {
            if(index < 0){
                return -1;
            }
            if (disk[index] != num) {
                return index + 1;
            } else {
                index--;
            }
        }
    }

    long calc1() {
        long checksum = 0;
        for (int position = 0; position < disk.length; position++) {
            int blockID = disk[position];
            if (blockID != -1) { // Skip free space
                checksum += (long) position * blockID;
            }
        }
        return checksum;
    }

    @Override
    public String toString() {
        String output = "";
        for (int i : disk) {
            if (i == -1) {
                output += ".";
            } else {
                output += i;
            }

        }
        return output;
    }

    public void compactDiskFully() {
        int startNum = findNextNum(disk.length - 1);
        int endNum = findEndOfNum(startNum);

        while (true) {
            swapFile(startNum, endNum);

            startNum = findNextNum(endNum - 1);
            endNum = findEndOfNum(startNum);
            if(endNum < 0){
                return;
            }
        }
    }
}