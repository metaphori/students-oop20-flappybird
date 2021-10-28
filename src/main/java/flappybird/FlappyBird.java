package flappybird;

import javafx.application.Application;
import view.ViewImpl;

/**
 * The Main class of the Application
 */

public class FlappyBird {

    private FlappyBird() {
    }

    /**
     *Launch the application.
     * 
     * @param args
     *            argument
     */
    public static void main(final String[] args) {     
        Application.launch(ViewImpl.class, args);
    }
}


