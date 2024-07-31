package main;


import piece.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    public static final int WIDTH = 1100;
    public static final int HEIGHT = 800;
    final int FPS = 60;
    Thread gameThread;
    Board board = new Board();

    public static ArrayList<Piece> pieces = new ArrayList<>();
    public static ArrayList<Piece> simPieces = new ArrayList<>();

    public static final int WHITE = 0;
    public static final int BLACK = 1;
    int currentColor = WHITE;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
    }

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void setPiece() {

        pieces.add(new Pawn(WHITE,0,6));
        pieces.add(new Pawn(WHITE,0,6));
        pieces.add(new Pawn(WHITE,0,6));
        pieces.add(new Pawn(WHITE,0,6));
        pieces.add(new Pawn(WHITE,0,6));
        pieces.add(new Pawn(WHITE,0,6));
        pieces.add(new Pawn(WHITE,0,6));
        pieces.add(new Pawn(WHITE,0,6));
        pieces.add(new Knight(WHITE,1,7));
        pieces.add(new Knight(WHITE,1,7));
        pieces.add(new Rook(WHITE,0,7));
        pieces.add(new Rook(WHITE,0,7));
        pieces.add(new Bishop(WHITE,2,7));
        pieces.add(new Bishop(WHITE,2,7));
        pieces.add(new Queen(WHITE,3,7));
        pieces.add(new King(WHITE,4,7));
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    private void update() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        board.draw(g2d);
    }

}
