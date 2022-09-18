/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revisaobd;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author usuario
 */
public class Venda extends Application {
   private static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }
   
    @Override
    public void start(Stage primaryStage) {
        Venda.primaryStage = primaryStage;
         initMain();
    }
    
 public void initMain(){
        try{
         String url = "/views/TelaVenda.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
        Parent root = loader.load();
        Scene scene = new Scene(root);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            Venda.primaryStage.setScene(scene);
            Venda.primaryStage.setResizable(false);
            Venda.primaryStage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
 
    public static void main(String[] args) {
      
    }

   
}

