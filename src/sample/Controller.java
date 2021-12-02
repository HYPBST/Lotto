package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Controller {
    @FXML
    private Button btnSorsol;
    @FXML
    private Label lblSzam;
    @FXML
    private ListView<Integer> listSzamok;
    private int sorsolasok=0;
    @FXML
    public void sorsol() throws InterruptedException {
        Timer timer=new Timer();
        final Integer[] szamlal = {0};
        if(sorsolasok<5){
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    String kijelzett =String.valueOf((int)( Math.random() * 90) + 1);
                    Platform.runLater(() -> lblSzam.setText(kijelzett));
                    szamlal[0]++;
                    if (szamlal[0]==2000){
                        timer.cancel();
                        listSzamok.getItems().add(Integer.parseInt(kijelzett));
                    }
                }
            };
            timer.schedule(timerTask,1,1);
            sorsolasok++;
        }if (sorsolasok==5){
            btnSorsol.setText("Rendez");

            btnSorsol.setOnAction(e->rendez());
        }

    }
    private void rendez(){
        lblSzam.setText("");

    }
}
