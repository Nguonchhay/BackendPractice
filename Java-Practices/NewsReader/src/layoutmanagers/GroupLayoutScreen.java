package layoutmanagers;

import javax.swing.*;
import java.awt.*;

public class GroupLayoutScreen extends JFrame {

    public GroupLayoutScreen() {
        super("GroupLayout");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //BoxLayout layout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
        //setLayout(layout);
        initUI();
    }

    public void initUI() {
        JPanel pLoginForm = new JPanel();
        GroupLayout layoutLoginForm = new GroupLayout(pLoginForm);
        layoutLoginForm.setAutoCreateGaps(true);
        layoutLoginForm.setAutoCreateContainerGaps(true);
        pLoginForm.setLayout(layoutLoginForm);
        pLoginForm.setSize(200, 100);

        JTextField txtEmail = new JTextField(40);
        JLabel lblEmail = new JLabel("Email");

        JLabel lblPassword = new JLabel("Password");
        JPasswordField txtPassword = new JPasswordField(40);

        // Configure horizontal layout
        layoutLoginForm.setHorizontalGroup(
            layoutLoginForm.createSequentialGroup()
                    .addGroup(
                            layoutLoginForm.createParallelGroup()
                                    .addComponent(lblEmail)
                                    .addComponent(lblPassword)
                    )
                    .addGroup(
                            layoutLoginForm.createParallelGroup()
                                    .addComponent(txtEmail)
                                    .addComponent(txtPassword)
                    )
        );

        // Configure vertical layout
        layoutLoginForm.setVerticalGroup(
            layoutLoginForm.createSequentialGroup()
                    .addGroup(
                            layoutLoginForm.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblEmail)
                                    .addComponent(txtEmail)
                    )
                    .addGroup(
                            layoutLoginForm.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblPassword)
                                    .addComponent(txtPassword)
                    )
        );

        super.add(pLoginForm, BorderLayout.CENTER);
    }
}
