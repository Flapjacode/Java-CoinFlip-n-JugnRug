import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class JugnRug extends JFrame {
    private JButton flipButton;
    private JLabel resultLabel;
    private JRadioButton jugButton;
    private JRadioButton rugButton;
    private Random random;

    public JugnRug() {
        super("JugnRug");
        setLayout(new FlowLayout());

        flipButton = new JButton("Place-Bet");
        resultLabel = new JLabel("");
        jugButton = new JRadioButton("Jug", true);
        rugButton = new JRadioButton("Rug", false);
        random = new Random();

        ButtonGroup group = new ButtonGroup();
        group.add(jugButton);
        group.add(rugButton);

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
        JugnRug game = new JugnRug();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(300, 150);
        game.setVisible(true);
    }
}
