package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import java.time.LocalTime;

public class clockViewController {
    private Main mainApp;
    private double deltaX;
    private double deltaY;

    @FXML
    Line handMinutes = new Line();
    @FXML
    Line handHours = new Line();
    @FXML
    Line handSeconds = new Line();
    @FXML
    Button btClose = new Button();

    @FXML
    private void initialize(){
        //createHoursMarks();
        setHoursHandPosition();
        setMinutesHandPosition();
        setSecondsHandPosition();
        btClose.setVisible(false);


    }

    public void setMainApp(Main mainApp){
        this.mainApp = mainApp;
        mainApp.addItems();
    }

    private void setHoursHandPosition(){
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

    private void setMinutesHandPosition(){
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

    private void setSecondsHandPosition(){
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


    @FXML
    private void getMousePosition(MouseEvent event){
        deltaX = event.getSceneX();
        deltaY = event.getSceneY();
    }

    @FXML
    private void moveStage(MouseEvent event){
        mainApp.setStageNewPosition(event.getScreenX() - deltaX, event.getScreenY() - deltaY);
    }

    @FXML
    private void showCloseButton(){
        btClose.setVisible(true);
    }

    @FXML
    private void hideCloseButton(){
        btClose.setVisible(false);
    }

    @FXML
    private void closeApp(){
        mainApp.closeApp();
    }

}
