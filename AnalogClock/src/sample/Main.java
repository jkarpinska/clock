package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Main extends Application {
    private Stage primaryStage;
    private AnchorPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("clockView.fxml"));
        this.primaryStage.setTitle("Analog Clock");
        this.primaryStage.initStyle(StageStyle.TRANSPARENT);
        this.primaryStage.getIcons().add(new Image("file:clock_icon.png"));
        this.primaryStage.setResizable(false);

        rootLayout = loader.load();
        Scene scene = new Scene(rootLayout);
        scene.setFill(null);


        this.primaryStage.setScene(scene);
        this.primaryStage.show();

        clockViewController controller = loader.getController();
        controller.setMainApp(this);


        Timeline timelineEveryMinute = new Timeline(new KeyFrame(Duration.minutes(1), event -> controller.moveHoursHand()));

        Timeline timelineEverySecond = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            if (controller.getSeconds() == 0) {
                controller.moveMinutesHand();
            }
            controller.moveSecondsHand();
        }));

        timelineEveryMinute.setCycleCount(Animation.INDEFINITE);
        timelineEveryMinute.play();
        timelineEverySecond.setCycleCount(Animation.INDEFINITE);
        timelineEverySecond.play();




    }

    public void addItems(){
        int startX =100;
        int startY = 20;
        int endX = 100;
        int endY = 10;
        int angle = 0;

        for(int i=0; i<60; i++){
            Line line;
            if(i%5==0){
                line = new Line(startX, startY, endX, endY);
            }
            else{
                line = new Line(startX, startY-7, endX, endY);
            }

            rootLayout.getChildren().add(line);
            line.getTransforms().add(new Rotate(angle, 100, 100));
            angle += 6;
        }

    }


    public void setStageNewPosition(double x, double y){
        this.primaryStage.setX(x);
        this.primaryStage.setY(y);
    }

    public void closeApp(){
        this.primaryStage.close();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
