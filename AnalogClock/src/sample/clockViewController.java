package sample;

import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;

import java.time.Clock;
import java.time.LocalTime;

public class clockViewController {
    private Main mainApp;

    @FXML
    Line handMinutes = new Line();
    @FXML
    Line handHours = new Line();
    @FXML
    Line handSeconds = new Line();

    @FXML
    private void initialize(){
        //createHoursMarks();
        setHoursHandPosition();
        setMinutesHandPostition();
        setSecondsHandPosition();
    }

    public void setMainApp(Main mainApp){
        this.mainApp = mainApp;
        mainApp.addItems();
    }

    public void setHoursHandPosition(){
        double angle = getHour()*30 + getMinutes()*0.5;
        handHours.getTransforms().add(new Rotate(angle, 100, 100));
    }

    private int getHour(){
        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime);
        return currentTime.getHour();
    }

    public void moveHoursHand(){
        handHours.getTransforms().add(new Rotate(0.5, 100, 100));
    }

    private void setMinutesHandPostition(){
        double angle = getMinutes()*6;
        handMinutes.getTransforms().add(new Rotate(angle, 100, 100));
    }

    private int getMinutes(){
        LocalTime currentTime = LocalTime.now();
        return currentTime.getMinute();
    }

    public void moveMinutesHand(){
        handMinutes.getTransforms().add(new Rotate(6, 100, 100));
    }

    public void setSecondsHandPosition(){
        int angle = getSeconds()*6;
        handSeconds.getTransforms().add(new Rotate(angle, 100, 100));
    }

    public int getSeconds(){
        LocalTime currentTime = LocalTime.now();
        return currentTime.getSecond();
    }

    public void moveSecondsHand(){
        handSeconds.getTransforms().add(new Rotate(6, 100, 100));
    }


    private void createHoursMarks(){

    }

    private void showMenuBar(){

    }

}
