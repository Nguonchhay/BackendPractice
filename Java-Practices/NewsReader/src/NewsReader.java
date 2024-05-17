import screens.LoginScreen;
import screens.MainScreen;
import services.FileService;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class NewsReader {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception e) {
            System.out.println("Look and Feel not set");
        }
        MainScreen mainScreen = new MainScreen("News Reader");
        mainScreen.display();
//        LoginScreen loginScreen = new LoginScreen();
//        loginScreen.display();

//        fileIO();
    }

    public static void fileIO() {
        String path = System.getProperty("user.dir");
        String filenameAndPath = path + "/src/storedfiles/auth.txt";
//        File yourFile = new File(filenameAndPath);
//        try {
//            yourFile.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        FileService.fileWriter(filenameAndPath, "sok");
        System.out.println("FileReader: " + FileService.fileReader(filenameAndPath));
        System.out.println("FileInputStream: " + FileService.fileInputStream(filenameAndPath));
        System.out.println("BufferReader: " + FileService.bufferedReader(filenameAndPath));
    }
}
