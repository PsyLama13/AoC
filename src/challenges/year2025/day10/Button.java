package challenges.year2025.day10;

import java.util.List;

public record Button(List<Integer> lightSwitches) {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for(Integer i : lightSwitches){
            sb.append(i)
                    .append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(")");
        return sb.toString();
    }
}
