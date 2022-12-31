//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.Objects;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePannel extends JPanel implements KeyListener, ActionListener {
    ImageIcon snakeTittle = new ImageIcon((URL)Objects.requireNonNull(this.getClass().getResource("Images/snaketitle.jpg")));
    ImageIcon rightMouth = new ImageIcon(this.getClass().getResource("Images/rightmouth.png"));
    ImageIcon snakeimage = new ImageIcon(this.getClass().getResource("Images/snakeimage.png"));
    ImageIcon up = new ImageIcon(this.getClass().getResource("Images/upmouth.png"));
    ImageIcon down = new ImageIcon(this.getClass().getResource("Images/downmouth.png"));
    ImageIcon left = new ImageIcon(this.getClass().getResource("Images/leftmouth.png"));
    ImageIcon enemy = new ImageIcon(this.getClass().getResource("Images/enemy.png"));
    int[] snakeX = new int[750];
    int[] snakeY = new int[750];
    int move = 0;
    int score = 0;
    int time = 0;
    boolean gameOver = false;
    int lengthOfSnake = 3;
    Timer timer;
    boolean isRight = true;
    boolean isUp = false;
    boolean isDown = false;
    boolean isLeft = false;
    int[] xpos = new int[]{25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500, 525, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 825, 850};
    int[] ypos = new int[]{75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500, 525, 575, 600, 625};
    Random random = new Random();
    int foodx = 150;
    int foody = 150;

    GamePannel() {
        this.setFocusable(true);
        this.addKeyListener(this);
        this.timer = new Timer(100, this);
        this.timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.white);
        g.drawRect(24, 10, 851, 55);
        g.drawRect(24, 74, 851, 576);
        this.snakeTittle.paintIcon(this, g, 25, 11);
        g.setColor(Color.black);
        g.fillRect(25, 75, 850, 575);
        if (this.move == 0) {
            this.snakeX[0] = 100;
            this.snakeX[1] = 75;
            this.snakeX[2] = 50;
            this.snakeY[0] = 100;
            this.snakeY[1] = 100;
            this.snakeY[2] = 100;
        }

        if (this.isUp) {
            this.up.paintIcon(this, g, this.snakeX[0], this.snakeY[0]);
        }

        if (this.isDown) {
            this.down.paintIcon(this, g, this.snakeX[0], this.snakeY[0]);
        }

        if (this.isRight) {
            this.rightMouth.paintIcon(this, g, this.snakeX[0], this.snakeY[0]);
        }

        if (this.isLeft) {
            this.left.paintIcon(this, g, this.snakeX[0], this.snakeY[0]);
        }

        this.rightMouth.paintIcon(this, g, this.snakeX[0], this.snakeY[0]);

        for(int i = 1; i < this.lengthOfSnake; ++i) {
            this.snakeimage.paintIcon(this, g, this.snakeX[i], this.snakeY[i]);
        }

        this.enemy.paintIcon(this, g, this.foodx, this.foody);
        if (this.gameOver) {
            g.setColor(Color.white);
            g.setFont(new Font("SansSerif", 1, 30));
            g.drawString("Game Over", 300, 300);
            g.setFont(new Font("Monospaced", 0, 15));
            g.drawString("Press Space Key to restart the Game.", 300, 400);
        }

        g.setColor(Color.white);
        g.setFont(new Font("SansSerif", 1, 15));
        g.drawString("Score : " + this.score, 750, 30);
        g.drawString("Length : " + this.lengthOfSnake, 750, 50);
        g.drawString("Time : " + this.time, 750, 70);
        g.dispose();
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 32 && this.gameOver) {
            this.restart();
        }

        if (e.getKeyCode() == 39 && !this.isLeft) {
            this.isUp = false;
            this.isDown = false;
            this.isLeft = false;
            this.isRight = true;
            ++this.move;
        }

        if (e.getKeyCode() == 37 && !this.isRight) {
            this.isUp = false;
            this.isDown = false;
            this.isLeft = true;
            this.isRight = false;
            ++this.move;
        }

        if (e.getKeyCode() == 40 && !this.isUp) {
            this.isUp = false;
            this.isDown = true;
            this.isLeft = false;
            this.isRight = false;
            ++this.move;
        }

        if (e.getKeyCode() == 38 && !this.isDown) {
            this.isUp = true;
            this.isDown = false;
            this.isLeft = false;
            this.isRight = false;
            ++this.move;
        }

    }

    public void keyReleased(KeyEvent e) {
    }

    public void actionPerformed(ActionEvent e) {
        for(int i = this.lengthOfSnake - 1; i > 0; --i) {
            this.snakeX[i] = this.snakeX[i - 1];
            this.snakeY[i] = this.snakeY[i - 1];
        }

        if (this.isLeft) {
            this.snakeX[0] -= 25;
        }

        if (this.isRight) {
            this.snakeX[0] += 25;
        }

        if (this.isUp) {
            this.snakeY[0] -= 25;
        }

        if (this.isDown) {
            this.snakeY[0] += 25;
        }

        if (this.snakeX[0] > 850) {
            this.snakeX[0] = 25;
        }

        if (this.snakeX[0] < 25) {
            this.snakeX[0] = 850;
        }

        if (this.snakeY[0] > 625) {
            this.snakeY[0] = 75;
        }

        if (this.snakeY[0] < 75) {
            this.snakeY[0] = 625;
        }

        this.collisionWithFood();
        this.collosionWithBody();
        this.repaint();
    }

    private void collosionWithBody() {
        for(int i = this.lengthOfSnake - 1; i > 0; --i) {
            if (this.snakeX[i] == this.snakeX[0] && this.snakeY[i] == this.snakeY[0]) {
                this.timer.stop();
                this.gameOver = true;
            }
        }

    }

    private void restart() {
        this.gameOver = false;
        this.move = 0;
        this.score = 0;
        this.time = 0;
        this.lengthOfSnake = 3;
        this.isLeft = false;
        this.isRight = true;
        this.isDown = false;
        this.isUp = false;
        this.timer.start();
        this.newFood();
        this.repaint();
    }

    private void collisionWithFood() {
        if (this.snakeX[0] == this.foodx && this.snakeY[0] == this.foody) {
            this.newFood();
            ++this.lengthOfSnake;
            ++this.score;
            this.snakeX[this.lengthOfSnake - 1] = this.snakeX[this.lengthOfSnake - 2];
            this.snakeY[this.lengthOfSnake - 1] = this.snakeY[this.lengthOfSnake - 2];
        }

    }

    private void newFood() {
        this.foodx = this.xpos[this.random.nextInt(this.xpos.length - 1)];
        this.foody = this.ypos[this.random.nextInt(this.ypos.length - 1)];

        for(int i = this.lengthOfSnake - 1; i >= 0; --i) {
            if (this.snakeX[i] == this.foodx && this.snakeY[i] == this.foody) {
                this.newFood();
            }
        }

    }
}
