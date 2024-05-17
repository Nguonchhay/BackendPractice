package animations;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ThreadScreen extends JFrame {

    private final String initTime = "Time: ";

    private JLabel lblTime;
    private TimeThread timeThread;

    public ThreadScreen() {
        super("Thread Demo");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        initUI();
    }

    private void initUI() {
        lblTime = new JLabel(initTime + getCurrentTime());
        lblTime.setBounds(10, 10, 200, 30);
        super.add(lblTime);

        JButton btnStart = new JButton("Start");
        btnStart.setBounds(10, 80, 80, 30);
        btnStart.addActionListener(e -> {
            timeThread = new TimeThread(this);
            timeThread.start();
        });
        super.add(btnStart);

        JButton btnStop = new JButton("Stop");
        btnStop.setBounds(100, 80, 80, 30);
        btnStop.addActionListener(e -> {
            timeThread.stopTimer();
            timeThread = null;
        });
        super.add(btnStop);
    }

    private String getCurrentTime() {
        String strTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        return strTime;
    }

    class TimeThread extends Thread {

        private final ThreadScreen threadScreen;
        private boolean isStart = false;

        public TimeThread(ThreadScreen threadScreen) {
            this.threadScreen = threadScreen;
        }

        @Override
        public void run() {
            while(isStart) {
                try {
                    threadScreen.lblTime.setText(threadScreen.initTime + threadScreen.getCurrentTime());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void start() {
            isStart = true;
            super.start();
        }

        public void stopTimer() {
            isStart = false;
        }
    }
}
