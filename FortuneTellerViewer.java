import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerViewer {

    private static JTextArea fortuneTextArea;
    private static String lastFortune = "";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FortuneTellerFrame frame = new FortuneTellerFrame();


            Font titleFont = new Font("Arial", Font.BOLD, 36);
            Font buttonFont = new Font("Verdana", Font.PLAIN, 16);
            Font fortuneFont = new Font("Courier New", Font.PLAIN, 30);


            JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            ImageIcon fortuneImage = new ImageIcon("fortune_teller.png"); // Replace with your image
            JLabel titleLabel = new JLabel("Fortune Teller", fortuneImage, JLabel.CENTER);
            titleLabel.setFont(titleFont);
            titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
            topPanel.add(titleLabel);
            frame.add(topPanel, BorderLayout.NORTH);


            fortuneTextArea = new JTextArea(); // Initialize here
            fortuneTextArea.setFont(fortuneFont);
            JScrollPane scrollPane = new JScrollPane(fortuneTextArea);
            frame.add(scrollPane, BorderLayout.CENTER);


            JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JButton fortuneButton = new JButton("Read My Fortune!");
            fortuneButton.setFont(buttonFont);
            JButton quitButton = new JButton("Quit");
            quitButton.setFont(buttonFont);

            fortuneButton.addActionListener(e -> displayFortune()); // No need to pass
            quitButton.addActionListener(e -> System.exit(0));

            bottomPanel.add(fortuneButton);
            bottomPanel.add(quitButton);
            frame.add(bottomPanel, BorderLayout.SOUTH);


            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension screenSize = toolkit.getScreenSize();
            frame.setSize(screenSize.width * 3 / 4, screenSize.height * 3 / 4);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true); // Set visible AFTER adding components
        });
    }

    private static void displayFortune() {
        ArrayList<String> fortunes = new ArrayList<>();

        fortunes.add("You will have unexpected good luck.");
        fortunes.add("A journey lies before you.");
        fortunes.add("You will soon receive a pleasant surprise.");
        fortunes.add("The stars are aligned in your favor.");
        fortunes.add("A golden opportunity awaits you.");
        fortunes.add("Your hard work will soon pay off.");
        fortunes.add("Someone admires you from afar.");
        fortunes.add("You will discover hidden talents.");
        fortunes.add("Take a chance, you won't regret it.");
        fortunes.add("Your future is bright.");
        fortunes.add("You will find happiness in unexpected places.");
        fortunes.add("Embrace change, it will lead to good things.");
        fortunes.add("A new friendship will blossom.");
        fortunes.add("You will achieve great things.");

        Random random = new Random();
        String currentFortune;

        do {
            currentFortune = fortunes.get(random.nextInt(fortunes.size()));
        } while (currentFortune.equals(lastFortune));

        lastFortune = currentFortune;
        fortuneTextArea.append(currentFortune + "\n");
    }
}
