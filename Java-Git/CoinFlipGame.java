import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CoinFlipGame extends JFrame {
    private JButton flipButton;
    private JLabel resultLabel;
    private JRadioButton headsButton;
    private JRadioButton tailsButton;
    private Random random;

    public CoinFlipGame() {
        super("Coin Flip Game");
        setLayout(new FlowLayout());

        flipButton = new JButton("Flip Coin");
        resultLabel = new JLabel("");
        headsButton = new JRadioButton("Heads", true);
        tailsButton = new JRadioButton("Tails", false);
        random = new Random();

        ButtonGroup group = new ButtonGroup();
        group.add(headsButton);
        group.add(tailsButton);

        flipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isHeads = random.nextBoolean();
                String result = isHeads ? "Heads" : "Tails";
                String choice = headsButton.isSelected() ? "Heads" : "Tails";

                resultLabel.setText("Result: " + result);
                if (result.equals(choice)) {
                    JOptionPane.showMessageDialog(null, "You win!");
                } else {
                    JOptionPane.showMessageDialog(null, "You lose!");
                }
            }
        });

        add(headsButton);
        add(tailsButton);
        add(flipButton);
        add(resultLabel);
    }

    public static void main(String[] args) {
        CoinFlipGame game = new CoinFlipGame();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(300, 150);
        game.setVisible(true);
    }
}
