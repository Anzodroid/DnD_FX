/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DnDFx;

import DnDFx.util.XMLParser;
import javafx.application.Application;
import static javafx.fxml.FXMLLoader.load;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author Anzo
 */
public class DnDFx extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = load(getClass().getResource("Resources/FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        
        System.exit(0);
    }
    
}
