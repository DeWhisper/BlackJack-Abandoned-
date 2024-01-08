import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck(){
        this.cards = new ArrayList<>();
        initilizeDeck();
    }
    public ArrayList<Card> getCards() {
        return cards;
    }
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    //Skapar kortlek
    public void initilizeDeck(){
        for(Suit suit : Suit.values()){
            for(Rank rank : Rank.values()){
                Card card = new Card(rank, suit);
                cards.add(card);
            }
        }
        shuffle();  //Blandar den nyskapade sorterade kortleken
    }
    public void shuffle(){
        Collections.shuffle(cards);
    }
    public Card dealCard(){
        if(cards.isEmpty()){    //Om KortLeken är tom,
            initilizeDeck();
        }
        Card giveCard = cards.get(0);
        cards.remove(0);
        return giveCard;
    }
}
