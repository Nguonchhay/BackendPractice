package screens;

import javax.swing.*;

public class LoginScreen extends JFrame {

    public LoginScreen() {
        super("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setUndecorated(true);
    }

    public void display() {
        setVisible(true);
    }
}
