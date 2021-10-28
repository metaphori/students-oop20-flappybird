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
    
    private static final int LABEL_FONT = 60;
    private static final int LABEL_Y = 50;
    private static final int LABEL_X = 400;
    private double width;
    private double height;
    private Label label;
    private Pane pane;

    /**
     * Set the main pane
     */
    public PlayView(Pane p) {
       
        this.pane = p;
    }

    /**
     * Display the view
     * 
     * @param controller
     *                  the controller
     */
    public void display( Controller controller) {
        
        this.width = controller.getGameWidth();
        this.height = controller.getGameHeight();
    
        ImageView img = new ImageView();
        img.setImage(new Image(ImageID.PLAYING_BACKGROUND.getPath()));
        img.setFitHeight(this.height);
        img.setFitWidth(this.width);
        
        this.label = new Label();
        this.label.setLayoutX(LABEL_X);
        this.label.setLayoutY(LABEL_Y);
        this.label.setText("0");
        this.label.setFont(new Font("Arial", LABEL_FONT));
        this. label.setTextFill(Color.ANTIQUEWHITE);
        this.pane.getChildren().add(img);
        this.pane.getChildren().add(label);
    }

    /**
     * Update the Score
     * 
     * @param score
     *                  the scpre
     */
    public void updateScore(Integer score) {
    
        this.pane.getChildren().remove(label);
       this. label.setText(Integer.toString(score));
       this. pane.getChildren().add(label);
    }

    /**
     * @return the score
     */
    public Label getScore() {
        return this.label;
    }

}
