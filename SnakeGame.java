//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;
import javax.swing.JFrame;

public class SnakeGame {
    JFrame frame = new JFrame("Snake Game");

    SnakeGame() {
        this.frame.setBounds(10, 10, 905, 700);
        GamePannel panel = new GamePannel();
        panel.setBackground(Color.GRAY);
        this.frame.add(panel);
        this.frame.setDefaultCloseOperation(3);
        this.frame.setResizable(false);
        this.frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SnakeGame();
    }
}
