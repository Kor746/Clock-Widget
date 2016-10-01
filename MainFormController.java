/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dan;

import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Daniel
 */
public class MainFormController implements Initializable {
    
    private Stage stage;
    
    @FXML
    private Label timeLabel;
   
    private double deltaX;
    private double deltaY;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        /*This will set the duration for the keyframe and create the event handler to
        set the label text to the current time on intialize*/
        KeyFrame keyframe = new KeyFrame(Duration.millis(1000),new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e)
                {
                    timeLabel.setText(getCurrentTime());
                }
                
            });
        
        Timeline timeline = new Timeline(keyframe);
        //This makes the keyframe run infinitely until stop() is invoked
        timeline.setCycleCount(Animation.INDEFINITE);
        //This starts the keyframe
        timeline.play();
        // This will calculate the curr location relative to the screen position
        timeLabel.setOnMousePressed(me -> {
            this.deltaX = timeLabel.getScene().getWindow().getX() - me.getScreenX(); 
            this.deltaY = timeLabel.getScene().getWindow().getY() - me.getScreenY();
            
        });
        //This will calculate the new position on drag 
        timeLabel.setOnMouseDragged(me -> {
            stage.setX(me.getScreenX() + this.deltaX);
            stage.setY(me.getScreenY() + this.deltaY);
            
        });
        
        timeLabel.setOnMouseEntered(me -> timeLabel.setCursor(Cursor.MOVE));
             
    } 
    //set stage method 
    @FXML
    public void setStage(Stage stage)
    {
        this.stage = stage;
    }
    
    //this method formats local time into a string and returns it
    public String getCurrentTime()
    {
        LocalTime time = LocalTime.now();
        String timeStr = time.format(DateTimeFormatter.ofPattern("hh : mm : ss a"));
        return timeStr;
    }
    //exits the application when the exit item is clicked in the context menu
    @FXML
    private void handleExitAction(ActionEvent event) {
        Platform.exit();
    }
    
    
}
