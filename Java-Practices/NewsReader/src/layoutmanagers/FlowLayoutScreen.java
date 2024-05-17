package layoutmanagers;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutScreen extends JFrame {

    public FlowLayoutScreen() {
        super("FlowLayout");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        BoxLayout layout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
        setLayout(layout);
        initUI();
    }

    public void initUI() {
        JPanel pTitle = new JPanel();
        FlowLayout layoutTitle = new FlowLayout();
        layoutTitle.setAlignment(FlowLayout.CENTER);
        pTitle.setLayout(layoutTitle);
        pTitle.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        JLabel lblTitle = new JLabel("Login Form");
        lblTitle.setFont(new Font("Times New Romain", Font.BOLD, 24));
        pTitle.add(lblTitle);

        super.add(pTitle);

        JPanel pEmail = new JPanel(new FlowLayout());
        pEmail.setSize(300, 30);
        JLabel lblEmail = new JLabel("Email ");
        pEmail.add(lblEmail);

        JTextField txtEmail = new JTextField(60);
        pEmail.add(txtEmail);
        super.add(pEmail);

        JPanel pPassword = new JPanel(new FlowLayout());
        pEmail.setSize(300, 30);
        JLabel lblPassword = new JLabel("Password ");
        pEmail.add(lblPassword);

        JPasswordField txtPassword = new JPasswordField(60);
        pPassword.add(txtPassword);
        super.add(pPassword);
    }
}
