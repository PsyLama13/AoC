package y2024.d2;

import java.util.ArrayList;
import java.util.List;

public class ReactorHelper {

    List<Report> reportList = new ArrayList<>();
    public ReactorHelper(List<String> input) {
        for(String s : input){
            Report report = new Report(s);
            reportList.add(report);
        }
    }

    public int calc1() {
        int counter = 0;
        for(Report report : reportList){
            if(report.isSafe()){
                counter++;
            }
        }
        return counter;
    }

    public int calc2() {
        int counter = 0;
        for(Report report : reportList){
            if(report.isSafe2()){
                counter++;
            }
        }
        return counter;
    }
}
