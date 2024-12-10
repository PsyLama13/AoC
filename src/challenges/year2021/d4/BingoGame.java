package challenges.year2021.d4;

import java.util.ArrayList;
import java.util.List;

public class BingoGame {

    List<Integer> numbers = new ArrayList<>();
    List<BingoCard> bingoCards = new ArrayList<>();

    public BingoGame(List<String> input){
        numbers = parseNumbers(input.get(0));
        List<String> bingoStrings = new ArrayList<>();
        for(int i = 2; i < input.size(); i++){
            if(input.get(i).isEmpty()){
                BingoCard bingoCard = new BingoCard(bingoStrings);
                bingoCards.add(bingoCard);
                bingoStrings = new ArrayList<>();
            }else{
                bingoStrings.add(input.get(i));
            }
        }
        BingoCard bingoCard = new BingoCard(bingoStrings);
        bingoCards.add(bingoCard);
    }

    private List<Integer> parseNumbers(String string) {
        List<Integer> output = new ArrayList<>();
        List<String> numberStrings = List.of(string.split(","));
        for(String s : numberStrings){
            output.add(Integer.parseInt(s));
        }
        return output;
    }

    public int getFinalScore() {
        for(int val : numbers){
            playBingoRound(val);
            Integer score = determineWinningScore(val);
            if(score != null){
                return score;
            }
        }
        return -1;
    }

    public int getLastBoardScore() {
        List<BingoCard> cards = new ArrayList<>(bingoCards);
        for (int val : numbers){
            playBingoRoundWithCards(cards, val);
        }
        return -1;
    }


    private void playBingoRoundWithCards(List<BingoCard> cards, int value) {
        for(BingoCard card : cards){
            card.markNumber(value);
        }
    }

    private Integer determineWinningScore(int val) {
        List<Integer> scores = new ArrayList<>();
        for(BingoCard bingoCard : bingoCards){
            Integer score = bingoCard.getScore(val);
            if(score != null){
                scores.add(score);
            }
        }
        if(scores.isEmpty()){
            return null;
        }
        return scores.stream().sorted().findFirst().orElseThrow();
    }

    private void playBingoRound(int val) {
        for(BingoCard bingoCard: bingoCards){
            bingoCard.markNumber(val);
        }
    }
}
