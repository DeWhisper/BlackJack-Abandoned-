public enum Rank{
    TWO(2, "Two"),
    THREE(3, "Three"),
    FOUR(4, "Four"),
    FIVE(5, "Five"),
    SIX(6, "Six"),
    SEVEN(7, "Seven"),
    EIGHT(8, "Eight"),
    NINE(9, "Nine"),
    TEN(10, "Ten"),
    JACK(10, "Jack"),
    QUEEN(10, "Queen"),
    KING(10, "King"),
    ACE(11, "Ace");

    private final int value;
    private final String rank;

    Rank(int value, String rank) {
        this.value = value;
        this.rank = rank;
    }
    public boolean isRoyale(){  //Make sure that the 10 is not mixed with royale characters for visualization.
        if(value >= 10){
            if(!rank.equals("Ten")){
                return true;
            }
            return false;
        }
        return false;
    }
    
    public int getValue() {
        return value;
    }
    public String getRank(){
        return rank;
    }
}