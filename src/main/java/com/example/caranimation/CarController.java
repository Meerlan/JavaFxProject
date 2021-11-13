package com.example.caranimation;

import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class CarController {

    @FXML
    private Label carName;
    @FXML
    private Label carSpeed;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    void initialize() {
        FileOperation fileOperation = new FileOperation();
        Vehicle car = fileOperation.getVehicle();
        fileOperation.writeCar(car);

        if(car==null){
            System.out.println("Car settings error");
        }else{
            ImageView imageView = new ImageView(car.getImage());
            imageView.setFitHeight(150);
            imageView.setFitWidth(200);
            imageView.setLayoutY(230);
            imageView.setPreserveRatio(true);
            imageView.setPickOnBounds(true);

            anchorPane.getChildren().add(imageView);
            carName.setText(car.getName());
            carSpeed.setText(car.getSpeed()+"km/h");

            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(150000f/car.getSpeed()), imageView);
            translateTransition.setToX(anchorPane.getPrefWidth() - 200);
            translateTransition.setAutoReverse(true);
            translateTransition.setCycleCount(Timeline.INDEFINITE);
            translateTransition.play();
        }

    }

}