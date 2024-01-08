import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BlackJackUI {

    private Player player;
    private House house;
    private Dealer dealer;

    private JFrame frame;
    private JPanel playerPanel, housePanel, buttonPanel;
    private JLabel playerLabel, houseLabel, resultLabel;
    private JButton hitButton, standButton;

    public BlackJackUI(Player player, House house, Dealer dealer){
        this.player = player;
        this.house = house;
        this.dealer = dealer;
    }

    public void initilization(){
        frame = new JFrame("Blackjack Game");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        playerPanel = new JPanel();
        housePanel = new JPanel();
        buttonPanel = new JPanel();
        playerLabel = new JLabel("Player Hand: ");
        houseLabel = new JLabel("Dealer Hand: ");
        resultLabel = new JLabel(":");

        //Button
        hitButton = new JButton("Hit");
        
        hitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            Card card = dealer.dealCardToPlayer(player);
            cardVisualization(player, card);
        }});

        standButton = new JButton("Stand");

        standButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            while(!house.isBusted() && house.getScore() < 16){
                Card card = dealer.dealCardToHouse(house);
                cardVisualization(house, card);
            }
        }});

        //Color
        houseLabel.setForeground(Color.RED);
        playerLabel.setForeground(Color.GREEN);
        resultLabel.setForeground(Color.BLACK);
        hitButton.setBackground(Color.GREEN);
        standButton.setBackground(Color.RED);
        //Background color
        playerPanel.setBackground(new Color(50, 100, 50));
        housePanel.setBackground(new Color(100, 25,25));
        buttonPanel.setBackground(new Color(50,50,50));

        playerPanel.add(playerLabel);
        housePanel.add(houseLabel);
        buttonPanel.add(hitButton);
        buttonPanel.add(standButton);

        frame.add(playerPanel, BorderLayout.CENTER);
        frame.add(housePanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setSize(400, 300);
        frame.setVisible(true);
    }
    public void changeLabel(String text){
        //labelMain.setText(text);
    }
    public void cardVisualization(Player player, Card card){
        Icon icon = card.getImage();
        Image originalImage = ((ImageIcon) icon).getImage();
        Image scaledImage = originalImage.getScaledInstance(75, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel cardLabel = new JLabel(scaledIcon);
        playerPanel.add(cardLabel);
        cardLabel.setPreferredSize(new Dimension(100,100));
        frame.revalidate();
    }
    public void cardVisualization(House house, Card card){
        Icon icon = card.getImage();
        Image originalImage = ((ImageIcon) icon).getImage();
        Image scaledImage = originalImage.getScaledInstance(75, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel cardLabel = new JLabel(scaledIcon);
        housePanel.add(cardLabel);
        cardLabel.setPreferredSize(new Dimension(100,100));
        frame.revalidate();
    }
    public void cardVisualization(Dealer dealer){

    }
}
