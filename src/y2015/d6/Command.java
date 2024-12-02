package y2015.d6;

public class Command {

    CommandType commandType;
    Coordinate start;
    Coordinate end;
    public Command(String commandString) {
        String[] parts = commandString.split(" ");

        if(parts[0].equals("toggle")){
            commandType = CommandType.TOGGLE;
            start = parseCoordinate(parts[1]);
            end = parseCoordinate(parts[3]);
        }else{ // either turn on or turn off
            commandType = CommandType.parseCommandType(parts[0] + " "  + parts[1]);
            start = parseCoordinate(parts[2]);
            end = parseCoordinate(parts[4]);
        }
    }

    private Coordinate parseCoordinate(String part) {
        String[] numberStrings = part.split(",");
        return new Coordinate(Integer.parseInt(numberStrings[0]), Integer.parseInt(numberStrings[1]));
    }
}
