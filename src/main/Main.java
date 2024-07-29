package main;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {

        Jframe window =new Jframe("Simple Chess");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}

