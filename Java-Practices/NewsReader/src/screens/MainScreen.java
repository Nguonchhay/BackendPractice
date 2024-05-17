package screens;

import animations.ThreadScreen;
import layoutmanagers.FlowLayoutScreen;
import layoutmanagers.GroupLayoutScreen;

import javax.swing.*;

public class MainScreen extends JFrame {

    private int mode;
    public static final int MODE_OPEN = 1;
    public static final int MODE_SAVE = 2;

    private JFileChooser jFileChooser;

    public MainScreen(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        pack();
        initMenuBar();
        initContent();
        mode = MODE_OPEN;
    }

    public void display() {
        setVisible(true);
    }

    private void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // Menu
        JMenu menuFile = new JMenu("File");
        JMenu menuManage = new JMenu("Management");
        JMenu menuAbout = new JMenu("About");
        JMenu menuLayouts = new JMenu("Layout Manager");
        menuBar.add(menuFile);
        menuBar.add(menuManage);
        menuBar.add(menuAbout);
        menuBar.add(menuLayouts);

        // Menu Items
        JMenuItem itemSave = new JMenuItem("Save Filter");
        JMenuItem itemQuit = new JMenuItem("Quit");
        itemQuit.addActionListener(e -> {
            super.dispose();
        });
        menuFile.add(itemSave);
        menuFile.add(itemQuit);

        // Menu Items for Category
        JMenuItem itemCategory = new JMenuItem("Categories");
        itemCategory.addActionListener(e -> {
            CategoryScreen screen  = new CategoryScreen();
            screen.display();
            super.dispose();
        });
        menuManage.add(itemCategory);

        // Menu Items for User
        JMenuItem itemRegister = new JMenuItem("Register");
        itemRegister.addActionListener(e -> {
            RegisterScreen screen  = new RegisterScreen();
            screen.display();
            super.dispose();
        });
        menuManage.add(itemRegister);

        // Menu Items for User
        JMenuItem itemUser = new JMenuItem("Users");
        itemUser.addActionListener(e -> {
            UsersScreen screen  = new UsersScreen();
            screen.display();
            super.dispose();
        });
        menuManage.add(itemUser);

        // Menu items for Layout Manager
        JMenuItem itemFlowLayout = new JMenuItem("FlowLayout");
        itemFlowLayout.addActionListener(e -> {
            FlowLayoutScreen screen = new FlowLayoutScreen();
            screen.setVisible(true);
        });
        menuLayouts.add(itemFlowLayout);

        JMenuItem itemGroupLayout = new JMenuItem("GroupLayout");
        itemGroupLayout.addActionListener(e -> {
            GroupLayoutScreen screen = new GroupLayoutScreen();
            screen.setVisible(true);
        });
        menuLayouts.add(itemGroupLayout);

        JMenuItem itemThreadTimer = new JMenuItem("Thread Timer");
        itemThreadTimer.addActionListener(e -> {
            ThreadScreen screen = new ThreadScreen();
            screen.setVisible(true);
        });
        menuLayouts.add(itemThreadTimer);

        super.setJMenuBar(menuBar);
    }

    private void initContent() {
        JPanel pContent = new JPanel();

        JPanel lContent = new JPanel();
        DefaultListModel<String> newsData = new DefaultListModel<>();
        newsData.addElement("AA");
        newsData.addElement("AA");
        newsData.addElement("AA");
        JList listNews = new JList(newsData);
        lContent.add(listNews);

        JButton btnBrowse = new JButton("Choose file");
        btnBrowse.addActionListener(e -> {
            jFileChooser = new JFileChooser();
            if (mode == MODE_OPEN) {
                if (jFileChooser.showOpenDialog(MainScreen.this) == JFileChooser.APPROVE_OPTION) {
                    System.out.println(jFileChooser.getSelectedFile().getAbsolutePath());
                }
            } else if (mode == MODE_SAVE) {
                if (jFileChooser.showSaveDialog(MainScreen.this) == JFileChooser.APPROVE_OPTION) {
                    System.out.println(jFileChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });
        lContent.add(btnBrowse);


        JPanel rContent = new JPanel();
        rContent.setLayout(new BoxLayout(rContent, BoxLayout.Y_AXIS));
        JLabel lblTitle = new JLabel("News Title");

        rContent.add(lblTitle);

        pContent.add(lContent);
        pContent.add(rContent);
        pContent.setLayout(new BoxLayout(pContent, BoxLayout.X_AXIS));

        super.add(pContent);
    }
}
