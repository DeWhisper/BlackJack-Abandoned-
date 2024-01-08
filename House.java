import java.util.ArrayList;

public class House {
    private ArrayList<Card> hand;
    private int score;

    public House(){
        this.hand = new ArrayList<>();
    }
    public int getScore() {
        calculateScore();
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void houseAlwaysWins(){

    }
    public void addCardToHand(Card card){
        hand.add(card);
    }
    public boolean isBusted(){
        if(score > 21){
            return true;
        }
        return false;
    }
    public void calculateScore(){
        int score = 0;

        for (Card card : hand) {
            score += card.getRank().getValue();
        }
        this.score = score;
    }
}
