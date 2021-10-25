package view;

import java.awt.Panel;

import controller.Controller;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class PlayView {
    
    private double width;
    private double height;
    Label label;
    Pane pane;

    public PlayView(Pane p) {
        // TODO Auto-generated constructor stub
        pane = p;
    }

    public void display(ViewImpl viewImp, Controller controller) {
        
        width = controller.getGameWidth();
        height = controller.getGameHeight();
        // TODO Auto-generated method stub
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

    public void updateScore(Integer score) {
        // TODO Auto-generated method stub
        pane.getChildren().remove(label);
        label.setText(Integer.toString(score));
        pane.getChildren().add(label);
    }

    public Label getScore() {
        // TODO Auto-generated method stub
        return this.label;
    }

}
