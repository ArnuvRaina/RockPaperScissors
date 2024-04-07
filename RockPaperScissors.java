import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissors extends JFrame implements ActionListener {
    private JButton rockButton, paperButton, scissorsButton, nextRoundButton, exitButton;
    private JLabel resultLabel, computerChoiceLabel, scoreLabel, userWinsLabel, computerWinsLabel, tiedRoundsLabel, roundLabel;
    private int totalRounds;
    private int currentRound = 0;
    private int userWins = 0;
    private int computerWins = 0;
    private int tiedRounds = 0;
    private JPanel controlPanel;

    public RockPaperScissors() {
        setTitle("Rock Paper Scissors");
        setSize(730, 600); // Increased height to accommodate the labels
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        getContentPane().setBackground(new Color(50, 50, 50));

        String roundsStr = JOptionPane.showInputDialog(this, "Enter the number of rounds:");
        if (roundsStr == null) {
            System.exit(0);
        }
        totalRounds = Integer.parseInt(roundsStr);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(50, 50, 50));

        roundLabel = new JLabel("", SwingConstants.CENTER);
        roundLabel.setFont(new Font("Pixelade", Font.BOLD, 30));
        roundLabel.setForeground(Color.WHITE);
        roundLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));

        tiedRoundsLabel = new JLabel("Tied Rounds: 0", SwingConstants.CENTER);
        tiedRoundsLabel.setFont(new Font("Pixelade", Font.PLAIN, 18));
        tiedRoundsLabel.setForeground(Color.WHITE);

        userWinsLabel = new JLabel("Your Wins: 0", SwingConstants.LEFT);
        userWinsLabel.setFont(new Font("Pixelade", Font.PLAIN, 18));
        userWinsLabel.setForeground(Color.WHITE);

        computerWinsLabel = new JLabel("Computer Wins: 0", SwingConstants.RIGHT);
        computerWinsLabel.setFont(new Font("Pixelade", Font.PLAIN, 18));
        computerWinsLabel.setForeground(Color.WHITE);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(50, 50, 50));

        JPanel winsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 110, 0));
        winsPanel.setBackground(new Color(50, 50, 50));
        winsPanel.add(userWinsLabel);
        winsPanel.add(tiedRoundsLabel);
        winsPanel.add(computerWinsLabel);

        JPanel labelsPanel = new JPanel(new BorderLayout());
        labelsPanel.setBackground(new Color(50, 50, 50));
        labelsPanel.add(roundLabel, BorderLayout.NORTH);
        topPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        topPanel.add(labelsPanel, BorderLayout.CENTER);
        topPanel.add(winsPanel, BorderLayout.SOUTH);

        mainPanel.add(topPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        buttonPanel.setBackground(new Color(50, 50, 50));

        ImageIcon rockIcon = new ImageIcon("C:\\Users\\KIIT\\IdeaProjects\\IntWeek2\\src\\rock.png");
        ImageIcon paperIcon = new ImageIcon("C:\\Users\\KIIT\\IdeaProjects\\IntWeek2\\src\\paper.png");
        ImageIcon scissorsIcon = new ImageIcon("C:\\Users\\KIIT\\IdeaProjects\\IntWeek2\\src\\scissor.png");

        rockButton = new JButton(rockIcon);
        paperButton = new JButton(paperIcon);
        scissorsButton = new JButton(scissorsIcon);

        rockButton.setPreferredSize(new Dimension(120, 140));
        paperButton.setPreferredSize(new Dimension(120, 140));
        scissorsButton.setPreferredSize(new Dimension(120, 140));

        Font buttonFont = new Font("Pixelade", Font.BOLD, 18);
        rockButton.setFont(buttonFont);
        paperButton.setFont(buttonFont);
        scissorsButton.setFont(buttonFont);

        rockButton.setActionCommand("0");
        paperButton.setActionCommand("1");
        scissorsButton.setActionCommand("2");

        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);

        rockButton.setText("");
        paperButton.setText("");
        scissorsButton.setText("");

        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);


        JLabel label1 = new JLabel("Rock", SwingConstants.CENTER);
        JLabel label2 = new JLabel("Paper", SwingConstants.CENTER);
        JLabel label3 = new JLabel("Scissors", SwingConstants.CENTER);

        label1.setForeground(Color.WHITE);
        label1.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 50));
        label2.setForeground(Color.WHITE);
        label2.setBorder(BorderFactory.createEmptyBorder(10, 45, 10, 20));
        label3.setForeground(Color.WHITE);
        label3.setBorder(BorderFactory.createEmptyBorder(10, 60, 10, 30));
        label1.setFont(new Font("Pixelade", Font.PLAIN, 20));
        label2.setFont(new Font("Pixelade", Font.PLAIN, 20));
        label3.setFont(new Font("Pixelade", Font.PLAIN, 20));


        buttonPanel.add(label1);
        buttonPanel.add(label2);
        buttonPanel.add(label3);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        scoreLabel = new JLabel("", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Pixelade", Font.PLAIN, 20));
        scoreLabel.setForeground(Color.WHITE);
        mainPanel.add(scoreLabel, BorderLayout.SOUTH);

        resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Pixelade", Font.BOLD, 48));
        resultLabel.setForeground(Color.WHITE);

        computerChoiceLabel = new JLabel("", SwingConstants.CENTER);
        computerChoiceLabel.setFont(new Font("Pixelade", Font.PLAIN, 20));
        computerChoiceLabel.setForeground(Color.WHITE);

        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 70, 0));
        resultPanel.add(resultLabel, BorderLayout.NORTH);
        resultPanel.add(computerChoiceLabel, BorderLayout.CENTER);
        resultPanel.setBackground(new Color(50, 50, 50));

        nextRoundButton = new JButton("Next Round");
        exitButton = new JButton("Exit");

        nextRoundButton.addActionListener(this);
        exitButton.addActionListener(this);
        exitButton.setFont(buttonFont);
        nextRoundButton.setFont(buttonFont);

        controlPanel = new JPanel(new FlowLayout());
        controlPanel.add(nextRoundButton);
        controlPanel.add(exitButton);
        controlPanel.setVisible(false);
        controlPanel.setBackground(new Color(50, 50, 50));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        resultPanel.add(controlPanel, BorderLayout.SOUTH);

        mainPanel.add(resultPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setLocationRelativeTo(null);
        setVisible(true);

        updateScoreLabel();
    }

    public void actionPerformed(ActionEvent e) {
        rockButton.setEnabled(false);
        paperButton.setEnabled(false);
        scissorsButton.setEnabled(false);
        nextRoundButton.setVisible(true);
        exitButton.setVisible(true);

        if (e.getSource() == nextRoundButton) {
            resultLabel.setText("");
            computerChoiceLabel.setText("");
            nextRoundButton.setVisible(false);
            exitButton.setVisible(false);
            rockButton.setEnabled(true);
            paperButton.setEnabled(true);
            scissorsButton.setEnabled(true);
            controlPanel.setVisible(false);

            if (currentRound >= totalRounds) {
                nextRoundButton.setText("Play Again");
                currentRound = 0;
                userWins = 0;
                computerWins = 0;
                tiedRounds = 0;
                updateScoreLabel();
                String roundsStr = JOptionPane.showInputDialog(this, "Enter the number of rounds:");
                if (roundsStr == null) {
                    System.exit(0);
                }
                totalRounds = Integer.parseInt(roundsStr);
            }
            return;
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }

        int userChoice = Integer.parseInt(e.getActionCommand());
        int computerChoice = generateComputerChoice();

        String result = determineWinner(userChoice, computerChoice);

        resultLabel.setText(result);
        computerChoiceLabel.setText("Computer chose: " + getChoiceName(computerChoice));
        controlPanel.setVisible(true);

        currentRound++;

        if (currentRound >= totalRounds) {
            rockButton.setEnabled(false);
            paperButton.setEnabled(false);
            scissorsButton.setEnabled(false);
            determineFinalWinner();
        }
    }

    private int generateComputerChoice() {
        Random random = new Random();
        return random.nextInt(3);
    }

    private String determineWinner(int userChoice, int computerChoice) {
        String[] choices = {"Rock", "Paper", "Scissors"};
        String result;

        if (userChoice == computerChoice) {
            result = "It's a tie!";
            tiedRounds++;
        } else if ((userChoice == 0 && computerChoice == 2) ||
                (userChoice == 1 && computerChoice == 0) ||
                (userChoice == 2 && computerChoice == 1)) {
            result = "You win!";
            userWins++;
        } else {
            result = "Computer wins!";
            computerWins++;
        }

        updateScoreLabel();
        return result;
    }

    private String getChoiceName(int choice) {
        String[] choices = {"Rock", "Paper", "Scissors"};
        return choices[choice];
    }

    private void updateScoreLabel() {
        roundLabel.setText("Round " + (currentRound + 1) + " of " + totalRounds);
        userWinsLabel.setText("Your Wins: " + userWins);
        computerWinsLabel.setText("Computer Wins: " + computerWins);
        tiedRoundsLabel.setText("Tied Rounds: " + tiedRounds);
    }

    private void determineFinalWinner() {
        String winner;
        if (userWins > computerWins) {
            winner = "You are the winner!";
        } else if (userWins < computerWins) {
            winner = "Computer is the winner!";
        } else {
            winner = "It's a tie!";
        }
        JOptionPane.showMessageDialog(this, winner);
        nextRoundButton.setText("Play Again");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RockPaperScissors::new);
    }
}
