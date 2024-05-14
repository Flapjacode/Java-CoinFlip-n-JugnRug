import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class JugnRug2 extends JFrame {
    private JButton flipButton;
    private JLabel resultLabel;
    private JRadioButton jugButton;
    private JRadioButton rugButton;
    private JRadioButton[] betButtons;
    private Random random;

    public JugnRug2() {
        super("Jug'o'Rug");
        setLayout(new FlowLayout());

        flipButton = new JButton("Place-Bet");
        resultLabel = new JLabel("");
        jugButton = new JRadioButton("Jug", true);
        rugButton = new JRadioButton("Rug", false);
        random = new Random();

        // Create bet buttons
        String[] betAmounts = {"0.025 SOL", "0.05 SOL", "0.1 SOL", "0.25 SOL", "0.5 SOL", "1 SOL"};
        betButtons = new JRadioButton[betAmounts.length];
        ButtonGroup betGroup = new ButtonGroup();
        for (int i = 0; i < betAmounts.length; i++) {
            betButtons[i] = new JRadioButton(betAmounts[i]);
            betGroup.add(betButtons[i]);
            add(betButtons[i]);
        }

        ButtonGroup choiceGroup = new ButtonGroup();
        choiceGroup.add(jugButton);
        choiceGroup.add(rugButton);

        flipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isJug = random.nextBoolean();
                String result = isJug ? "Jug" : "Rug";
                String choice = jugButton.isSelected() ? "Jug" : "Rug";

                resultLabel.setText("Result: " + result);
                if (result.equals(choice)) {
                    JOptionPane.showMessageDialog(null, "You win!");
                } else {
                    JOptionPane.showMessageDialog(null, "You lose!");
                }
            }
        });

        add(jugButton);
        add(rugButton);
        add(flipButton);
        add(resultLabel);
    }

    public static void main(String[] args) {
        JugnRug2 game = new JugnRug2();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(300, 150);
        game.setVisible(true);
    }
}
