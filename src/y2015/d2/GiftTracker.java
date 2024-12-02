package y2015.d2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GiftTracker {

    String input;
    Set<Coordinate> giftedHomes = new HashSet<>();
    Set<Coordinate> giftedHomesY2 = new HashSet<>();
    public GiftTracker(List<String> input) {
        this.input = input.get(0);
    }

    int calculateNumberOfGiftedHomes(){
        Coordinate currentLocation = new Coordinate(0,0);
        giftedHomes.add(currentLocation);
        for(int i = 0; i < input.length(); i++){
            Character c = input.charAt(i);
            Direction direction = Direction.parseDirection(c);
            Coordinate next = currentLocation.getNeighbour(direction);
            giftedHomes.add(next);
            currentLocation = next;
        }
        return giftedHomes.size();
    }

    int calculateNumberOfGiftedHomesY2(){
        Coordinate location = new Coordinate(0,0);
        Coordinate roboLocation = new Coordinate(0,0);
        giftedHomesY2.add(location);

        for(int i = 0; i < input.length(); i++){

            if(i%2 == 0){ // Santa
                Character c = input.charAt(i);
                Direction direction = Direction.parseDirection(c);
                Coordinate next = location.getNeighbour(direction);
                giftedHomesY2.add(next);
                location = next;
            }else{ // Robo Santa
                Character c = input.charAt(i);
                Direction direction = Direction.parseDirection(c);
                Coordinate next = roboLocation.getNeighbour(direction);
                giftedHomesY2.add(next);
                roboLocation = next;
            }
        }
        return giftedHomesY2.size();
    }
}
