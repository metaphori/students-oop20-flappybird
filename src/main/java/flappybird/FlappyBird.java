package flappybird;

import controller.Controller;
import controller.ControllerImpl;
import javafx.application.Application;
import view.View;
import view.ViewImpl;

/**
 * The Main class of the Application
 */

public class FlappyBird {
    
 
    private FlappyBird() {
        
    }
   

    public static void main(final String[] args) {
        
    
        Application.launch(ViewImpl.class, args);

        
    }

}

 
    
   
    

