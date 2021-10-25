package view;

import java.awt.Panel;

import controller.Controller;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * View to display the background
 *
 */
public class PlayView {
    
    private double width;
    private double height;
    Label label;
    Pane pane;

    /**
     * Set the main pane
     */
    public PlayView(Pane p) {
       
        pane = p;
    }

    /**
     * Display the view
     * 
     * @param controller
     *                  the controller
     */
    public void display( Controller controller) {
        
        this.width = controller.getGameWidth();
        height = controller.getGameHeight();
    
        ImageView img = new ImageView();
        img.setImage(new Image(ImageID.PLAYING_BACKGROUND.getPath()));
        img.setFitHeight(height);
        img.setFitWidth(width);
        
        label = new Label();
        label.setLayoutX(400);
        label.setLayoutY(50);
        label.setText("0");
        label.setFont(new Font("Arial", 60));
        label.setTextFill(Color.ANTIQUEWHITE);
        
        
        pane.getChildren().add(img);
        pane.getChildren().add(label);
    }

    /**
     * Update the Score
     * 
     * @param score
     *                  the scpre
     */
    public void updateScore(Integer score) {
    
        pane.getChildren().remove(label);
        label.setText(Integer.toString(score));
        pane.getChildren().add(label);
    }

    /**
     * @return the score
     */
    public Label getScore() {
    
        return this.label;
    }

}
