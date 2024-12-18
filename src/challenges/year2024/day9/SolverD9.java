package challenges.year2024.day9;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD9 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2024/d9.txt");
        List<String> debug = Helper.readInput("year2024/d9d.txt");

        main1(debug.get(0)); // 6366665108136
        main2(debug.get(0)); // 6398065450842
    }

    static void main1(String input) {
        Disk disk = new Disk(input);
        disk.compactDisk();
        long checksum = disk.calc1();
        System.out.println("Checksum: " + checksum);
    }

    private static void main2(String s) {
        Disk disk = new Disk(s);
        disk.compactDiskFully();
        long checkSum = disk.calc1();
        System.out.println(checkSum);
    }
}