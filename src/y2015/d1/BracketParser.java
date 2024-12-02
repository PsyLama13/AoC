package y2015.d1;

import java.util.List;

public class BracketParser {

    String instruction;

    public BracketParser(List<String> input) {
        instruction = input.get(0);
    }

    int getFirstBasementOccurence(){
        int firstoccurence = Integer.MAX_VALUE;
        int level = 0;
        for(int i = 0; i < instruction.length(); i++){
            Character c = instruction.charAt(i);
            Direction direction = Direction.parseDirection(c);
            switch (direction){
                case UP -> level++;
                case DOWN -> level--;
            }

            if(level == -1){
                return i+1;
            }
        }
        throw new IllegalStateException();
    }
}
