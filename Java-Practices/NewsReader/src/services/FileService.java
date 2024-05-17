package services;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FileService {

    public static void fileWriter(String filenameAndPath, String content) {
        try {
            FileWriter writer = new FileWriter(filenameAndPath, false);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void bufferedWriter(String filenameAndPath, String content) {
        try {
            FileWriter writer = new FileWriter(filenameAndPath, false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(content);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String fileReader(String filenameAndPath) {
        StringBuilder result = new StringBuilder();
        try {
            FileReader reader = new FileReader(filenameAndPath);
            int character;

            while ((character = reader.read()) != -1) {
                result.append((char) character);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static String fileInputStream(String filenameAndPath) {
        ArrayList<Character> result = new ArrayList<>();
        try {
            FileInputStream inputStream = new FileInputStream(filenameAndPath);
            InputStreamReader reader = new InputStreamReader(inputStream, "UTF-16");
            int character;

            while ((character = reader.read()) != -1) {
                result.add((char) character);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Arrays.toString(result.toArray());
    }

    public static String bufferedReader(String filenameAndPath) {
        String result = "";
        try {
            FileReader reader = new FileReader(filenameAndPath);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result = line + "\n";
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
