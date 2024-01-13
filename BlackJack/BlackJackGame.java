

public class BlackJackGame {

    public static void main(String[] args) {

        Player player = new Player();
        House house = new House();
        Dealer dealer = new Dealer();
        BlackJackUI blackJackUi = new BlackJackUI(player, house, dealer);
        blackJackUi.initilization();
    }
}
