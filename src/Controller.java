import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Timer;
import java.util.TimerTask;

public class Controller
{
    @FXML
    Button startButton;
    @FXML
    Button stopButton;
    @FXML
    Label timeDisplay;

    private boolean isStopped = true;
    private Timer timer;

    @FXML
    public void startWatch()
    {
        if (!isStopped)
        {
            return;
        }

        isStopped = false;
        stopButton.setText("Stop");

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask()
        {
            @Override
            public void run()
            {
                javafx.application.Platform.runLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        char[] time = timeDisplay.getText().toCharArray();
                        int carry = 1;
                        for (int i = time.length - 1; i >= 0; i--)
                        {
                            if ((time[i] == '9' || (i == 4 && time[4] == '5')) && carry == 1)
                            {
                                carry = 1;
                                time[i] = '0';
                            }
                            else if (Character.isDigit(time[i]) && carry == 1)
                            {
                                time[i] = (char) (((int) time[i]) + 1);
                                carry = 0;
                            }
                        }
                        timeDisplay.setText(new String(time));
                    }
                });
            }
        }, 0, 100);
    }

    @FXML
    public void stopWatch()
    {
        if (isStopped)
        {
            timeDisplay.setText("000:00.0");
            stopButton.setText("Stop");
        }
        else
        {
            if (timer != null)
            {
                timer.cancel();
            }
            stopButton.setText("Reset");
            isStopped = true;
        }
    }

}
