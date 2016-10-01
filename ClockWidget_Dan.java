/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dan;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.stage.StageStyle.TRANSPARENT;

/**
 *
 * @author Daniel
 */
public class ClockWidget_Dan extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainForm.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root,300,150);
        
        root.getStylesheets().add("com/dan/styles.css");
        root.getStyleClass().add("root");
        //allows the background of the application to be transparent
        stage.initStyle(TRANSPARENT);
        scene.setFill(null);
        root.setStyle("-fx-background-color: rgba(0, 0, 0, 0)");
        //sets window title
        stage.setTitle("TimeLee");
        stage.setAlwaysOnTop(true);
        stage.setScene(scene);
        stage.show();
        //pass stage to the controller obj
        MainFormController ctrl = loader.getController();
        ctrl.setStage(stage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
