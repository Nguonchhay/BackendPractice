package com.nguonchhay.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Week2Main {
    public void demo() throws IOException, ParseException {
        // task1();
        // task5();
        task6();
    }

    public void task1() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter grade: ");
        int grade = scan.nextInt();
        System.out.println("Your grade is " + grade);
    }

    public void task5() throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter name: ");
        String name = reader.readLine();
        System.out.println("Name: " + name);

        System.out.print("Enter birth date (dd.MM.yyyy): ");
        String strBirtDate = reader.readLine();

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);

        Date birthDate = format.parse(strBirtDate);
        Date currentDate = calendar.getTime();

        long diffInMs = Math.abs(calendar.getTimeInMillis() - birthDate.getTime());
        //long diffInMs = Math.abs(currentDate.getTime() - birthDate.getTime());
        long diffDays = TimeUnit.DAYS.convert(diffInMs, TimeUnit.MILLISECONDS);

        System.out.println("Days: " + diffDays);
    }

    public void task6() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int upperBound = 5;
        int num = -1;
        char answer = ' ';
        do {
            num = random.nextInt(upperBound);
            System.out.println("Random class: " + num);
            System.out.print("Press y to continue: ");
            answer = scanner.next().charAt(0);
        } while(answer == 'y');
    }
}
