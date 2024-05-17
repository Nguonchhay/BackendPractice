package screens;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RegisterScreen extends JFrame {

    private int chooserMode;
    private final int MODE_OPEN = 1;
    private final int MODE_SAVE = 2;

    private String selectedFilePath = "";

    public RegisterScreen() {
        super("Register");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        getContentPane().setLayout(
            new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)
        );
        initUI();
        chooserMode = MODE_OPEN;
    }

    public void display() {
        setVisible(true);
    }

    private void initUI() {
        // Screen title
        JPanel pTitle = new JPanel();
        pTitle.setLayout(new FlowLayout());
        JLabel lblTitle = new JLabel("Create New User");
        pTitle.add(lblTitle);

        // Form label and field groups
        JPanel pForm = new JPanel();
        pForm.setBorder(new EmptyBorder(10, 10, 10, 10));
        pForm.setLayout(new BoxLayout(pForm, BoxLayout.Y_AXIS));

        // Form labels
        JPanel pFormLabel = new JPanel();
        pFormLabel.setLayout(new BoxLayout(pFormLabel, BoxLayout.Y_AXIS));
        JLabel lblFullName = new JLabel("Full Name");
        JLabel lblUserName = new JLabel("Username");
        JLabel lblPassword = new JLabel("Password");
        JLabel lblGender = new JLabel("Gender");
        JLabel lblProfile = new JLabel("Profile");

        // Form Fields
        JPanel pFormField = new JPanel();
        pFormField.setLayout(new BoxLayout(pFormField, BoxLayout.Y_AXIS));
        JTextField txtFullName = new JTextField(50);
        JTextField txtUsername = new JTextField(50);
        JPasswordField txtPassword = new JPasswordField(50);
        ButtonGroup radGender = new ButtonGroup();
        JRadioButton radMale = new JRadioButton("Male");
        JRadioButton radFemale = new JRadioButton("Female");
        JRadioButton radOther = new JRadioButton("Other");
        radGender.add(radMale);
        radGender.add(radFemale);
        radGender.add(radOther);
        JPanel pGender = new JPanel(new FlowLayout());
        pGender.add(radMale);
        pGender.add(radFemale);
        pGender.add(radOther);
        JLabel imgProfile = new JLabel();
        imgProfile.setSize(150, 150);
        imgProfile.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        JButton btnBrowseProfile = new JButton("Choose file");
        btnBrowseProfile.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", "jpg", "png", "jpeg"));
            if (chooserMode == MODE_OPEN) {
                if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                    String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                    selectedFilePath = filePath;
                    ImageIcon icon = new ImageIcon(new ImageIcon(filePath).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
                    imgProfile.setIcon(icon);
                }
            }
        });
        JPanel pFileChooser = new JPanel();
        pFileChooser.setLayout(new BoxLayout(pFileChooser, BoxLayout.Y_AXIS));
        pFileChooser.add(imgProfile);
        pFileChooser.add(btnBrowseProfile);

        JPanel pFullName = new JPanel();
        pFullName.setLayout(new BoxLayout(pFullName, BoxLayout.LINE_AXIS));
        pFullName.add(lblFullName);
        pFullName.add(txtFullName);
        pForm.add(pFullName);

        JPanel pUserName = new JPanel();
        pUserName.setLayout(new BoxLayout(pUserName, BoxLayout.LINE_AXIS));
        pUserName.add(lblUserName);
        pUserName.add(txtUsername);
        pForm.add(pUserName);

        JPanel pPassword = new JPanel();
        pPassword.setLayout(new BoxLayout(pPassword, BoxLayout.LINE_AXIS));
        pPassword.add(lblPassword);
        pPassword.add(txtPassword);
        pForm.add(pPassword);

        JPanel panelGender = new JPanel();
        panelGender.setLayout(new BoxLayout(panelGender, BoxLayout.LINE_AXIS));
        panelGender.add(lblGender);
        panelGender.add(pGender);
        pForm.add(panelGender);

        JPanel pProfile = new JPanel();
        pProfile.setLayout(new BoxLayout(pProfile, BoxLayout.LINE_AXIS));
        pProfile.add(lblProfile);
        pProfile.add(pFileChooser);
        pForm.add(pProfile);

        JPanel pButton = new JPanel(new FlowLayout());
        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(e -> {
            Path src = Paths.get(selectedFilePath);
            Path dest = Paths.get(System.getProperty("user.dir") + "/src/uploads/file.jpg");
            try {
                Files.copy(src, dest);
//                copy(src.toFile(), dest.toFile());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        pButton.add(btnSave);

        add(pTitle);
        add(pForm);
        add(pButton);
    }

    private static void copy(File src, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);
            // buffer size 1K

            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buf)) > 0) {
                os.write(buf, 0, bytesRead);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}
