import java.util.ArrayList;

public class Player {
    
    private ArrayList<Card> hand;

    public Player(){
        this.hand = new ArrayList<>();
    }
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
    public ArrayList<Card> getHand() {
        ArrayList<Card> copyOfHand = new ArrayList<>(hand);;
        return copyOfHand;
    }
    //ger kort till spelare
    public void addCardToHand(Card card){
        hand.add(card);
    }
}
