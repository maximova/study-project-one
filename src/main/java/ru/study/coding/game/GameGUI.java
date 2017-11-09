package ru.study.coding.game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameGUI implements ActionListener {

    private JLabel infoLabel;
    private JFrame frame;
    private JButton[][] buttons;
    private String playerSymbol;

    GameGUI() {
        playerSymbol = "X";
        frame = new JFrame("Tic-tac-toe");
        frame.getContentPane().setLayout(new GridBagLayout());
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
//        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        infoLabel = new JLabel("Now player's " + playerSymbol + " turn");
        frame.getContentPane().add(infoLabel, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        //add padding to buttons
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        buttons = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gridBagConstraints.gridx = j;
                gridBagConstraints.gridy = i + 1;
                buttons[i][j] = new JButton(" ");
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].setPreferredSize(new Dimension(30, 30));

                buttons[i][j].setBackground(Color.WHITE);
                buttons[i][j].setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.BLACK, 0),
                        BorderFactory.createLineBorder(Color.BLACK, 1)));

                buttons[i][j].setActionCommand("" + i + j);
                buttons[i][j].addActionListener(this);
                frame.add(buttons[i][j], gridBagConstraints);
            }
        }

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String buttonID = actionEvent.getActionCommand();
        int x = Integer.parseInt(buttonID.substring(0, 1));
        int y = Integer.parseInt(buttonID.substring(1, 2));
        buttons[x][y].setText(playerSymbol);
        buttons[x][y].setEnabled(false);
        String winner = checkWin();
        changePlayer();
        if (!winner.equals("NO")) {
            infoLabel.setText("Winner is player " + winner);
            endGame();
        }
    }

    private void endGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    private String checkWin() {
        for (int i = 0; i < 3; i++) {
            //horizontal check
            if (!buttons[i][0].getText().equals(" ") &&
                    buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                    buttons[i][1].getText().equals(buttons[i][2].getText())) {
                return buttons[i][0].getText();
            }
            //vertical check
            if (!buttons[0][i].getText().equals(" ") &&
                    buttons[0][i].getText().equals(buttons[1][i].getText()) &&
                    buttons[1][i].getText().equals(buttons[2][i].getText())) {
                return buttons[0][i].getText();
            }
        }
        if (!buttons[0][0].getText().equals(" ") &&
                buttons[0][0].getText().equals(buttons[1][1].getText()) &&
                buttons[1][1].getText().equals(buttons[2][2].getText())) {
            return buttons[0][0].getText();
        }
        if (!buttons[0][2].getText().equals(" ") &&
                buttons[0][2].getText().equals(buttons[1][1].getText()) &&
                buttons[1][1].getText().equals(buttons[2][0].getText())) {
            return buttons[0][2].getText();
        }
        return "NO";
    }

    private void changePlayer() {
        if (playerSymbol.equals("X")) {
            playerSymbol = "O";
        } else {
            playerSymbol = "X";
        }
        infoLabel.setText("Turn player " + playerSymbol);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameGUI();
            }
        });
    }
}
