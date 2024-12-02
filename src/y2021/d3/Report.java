package y2021.d3;

import java.util.ArrayList;
import java.util.List;

public class Report {
    List<String> input;

    public Report(List<String> input) {
        this.input = input;
    }

    public int getPowerConsumption() {
        int gamma = calculateGamma();
        int epsilon = calculateEpsilon();

        return gamma * epsilon;
    }

    public int getOxygenGeneratorRating() {
        String bin = filterForOxygen();
        return convertBinStringToInteger(bin);
    }

    public int getCo2ScurbberRating(){
        String bin = filterForCo2();
        return convertBinStringToInteger(bin);
    }

    private String filterForCo2() {
        List<String> temp = new ArrayList<>(input);
        int count = 0;
        while (temp.size()> 1){
            int one = getOneSizeOfIndexForSet(count, temp);
            int zero = getZeroSizeOfIndexForSet(count, temp);
            String common = one < zero ? "1" : "0";
            List<String> removeList = new ArrayList<>();
            for(String s : temp){
                if(!Character.toString(s.charAt(count)).equals(common)){
                    removeList.add(new String(s));
                }
            }
            for(String s : removeList){
                int index = temp.indexOf(s);
                if(index != -1){
                    temp.remove(index);
                }
            }
            count++;
        }
        return temp.get(0);
    }

    private String filterForOxygen() {
        List<String> temp = new ArrayList<>(input);
        int count = 0;
        while (temp.size()> 1){
            int one = getOneSizeOfIndexForSet(count, temp);
            int zero = getZeroSizeOfIndexForSet(count, temp);
            String common = one >= zero ? "1" : "0";
            List<String> removeList = new ArrayList<>();
            for(String s : temp){
                if(!Character.toString(s.charAt(count)).equals(common)){
                    removeList.add(new String(s));
                }
            }
            for(String s : removeList){
                int index = temp.indexOf(s);
                if(index != -1){
                    temp.remove(index);
                }
            }
            count++;
        }
        return temp.get(0);
    }

    private int calculateEpsilon() {
        String binEpsilon = "";
        for (int i = 0; i < input.get(0).length(); i++) {
            int oneCount = getOneSizeOfIndexForSet(i, input);
            int zeroCount = getZeroSizeOfIndexForSet(i, input);
            if (oneCount < zeroCount) {
                binEpsilon += "1";
            } else {
                binEpsilon += "0";
            }
        }
        return convertBinStringToInteger(binEpsilon);
    }

    private int calculateGamma() {
        String binGamma = "";
        for (int i = 0; i < input.get(0).length(); i++) {
            int oneCount = getOneSizeOfIndexForSet(i, input);
            int zeroCount = getZeroSizeOfIndexForSet(i, input);
            if (oneCount > zeroCount) {
                binGamma += "1";
            } else {
                binGamma += "0";
            }
        }
        return convertBinStringToInteger(binGamma);
    }

    private int convertBinStringToInteger(String binString) {
        int factor = 1;
        int returnValue = 0;
        for (int i = binString.length() - 1; i >= 0; i--) {
            int y = Integer.parseInt(String.valueOf(binString.charAt(i)));
            returnValue += y * factor;
            factor *= 2;
        }
        return returnValue;
    }

    int getOneSizeOfIndexForSet(int index, List<String> input){
        int count = 0;
        for(int i = 0; i < input.size(); i++){
            String s = input.get(i);
            Character c = s.charAt(index);
            if(c.equals('1')){
                count++;
            }
        }
        return count;
    }

    int getZeroSizeOfIndexForSet(int index, List<String> input){
        int ones = getOneSizeOfIndexForSet(index, input);
        return input.size() - ones;
    }

    public int getLifeSupportRating() {
        return getOxygenGeneratorRating() * getCo2ScurbberRating();
    }
}
