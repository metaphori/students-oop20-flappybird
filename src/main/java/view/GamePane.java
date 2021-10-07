package view;

import controller.Controller;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class GamePane extends Pane {
    
    private double dim;
    Controller c;

    GamePane(Controller c){
        super();
        dim = 700;
        c=c;
        c.setPane(this);
        
    }
    
    public void startGame() {
        this.getChildren().clear();
        ImageView img = new ImageView();
        img.setImage(new Image("background.png"));
        img.setFitHeight(800);
        img.setFitWidth(600);
        this.getChildren().add(img);
        Rectangle rec = new Rectangle();
        rec.setLayoutX(dim-10);
        rec.setLayoutY(350);
        rec.setWidth(50);
        rec.setHeight(200);
        rec.setFill(new ImagePattern(new Image("column.png")));
        System.out.println(rec.getLayoutX());
        this.getChildren().add(img);
        this.getChildren().add(rec);
        dim=dim-10;
    }

   

}
