import javax.swing.ImageIcon;

public class Card {
    private Rank rank;
    private Suit suit;
    private ImageIcon image;
    private String stringPath;

    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }
    public void setRank(Rank rank) {
        this.rank = rank;
    }
    public Rank getRank() {
        return rank;
    }
    public Suit getSuit() {
        return suit;
    }
    public void setSuit(Suit suit) {
        this.suit = suit;
    }
    public ImageIcon getImage(){
        if (image == null) {
            loadImage();
        }
        return image;
    }
    public void loadImage(){

        if(rank.isRoyale()){
            stringPath = String.format("Pictures/%s_of_%s.png",rank.getRank().toLowerCase(),suit.toString().toLowerCase()); 
        }
        else{
            stringPath = String.format("Pictures/%d_of_%s.png",rank.getValue(), suit.toString().toLowerCase()); 
        }
        this.image = new ImageIcon(getClass().getResource(stringPath));
    }
}
