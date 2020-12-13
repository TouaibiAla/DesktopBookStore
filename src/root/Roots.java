/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root;

/**
 *
 * @author Aymen
 */
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author saif
 */
public class Roots {
    
        
     public static  Stage stage = new Stage();
     public static HashMap<String,Parent> rootMap = new HashMap<String,Parent>();
     
    public static void showStage(String root) {
        
        Scene scene = new Scene(getParent(root));
        Roots.stage.setScene(scene);
        Roots.stage.show();
        
    }

    public static Parent getParent(String page) {
        return rootMap.get(page);
    }
    
     
          
    
}
