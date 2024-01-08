public class Dealer {

    private Deck deck;

    public Dealer(){
        this.deck = new Deck();
    }
    public Card dealCardToPlayer(Player player){
        Card card = deck.dealCard();
        player.addCardToHand(card);
        return card;
    }
    public Card dealCardToHouse(House house){
        Card card = deck.dealCard();
        house.addCardToHand(card);
        return card;
    }
}
