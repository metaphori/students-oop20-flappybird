package view;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import model.Bird;
import model.BirdImp;

public class ViewBird {

    private Pane pane;
    private Circle bird;
    private double h = 200;
  
    
    public ViewBird(Pane p) {
        // TODO Auto-generated constructor stub
        //this.bird= new Circle();
       // this.bird.setFill(new ImagePattern(new Image("bird.png")));
        this.pane = p;
        //this.pane.getChildren().add(bird);
    }

    public void render(Bird b) {
        // TODO Auto-generated method stub

        this.pane.getChildren().remove(bird);
        updatePosition(b);
        this.pane.getChildren().add(bird);
      
    }

    private void updatePosition(Bird b) {
        // TODO Auto-generated method stub
        
        this.bird = new Circle();
        this.bird.setLayoutY(b.getCenterY());
        this.bird.setLayoutX(b.getCenterX());
        this.bird.setRadius(b.getRadius());
        this.bird.setFill(new ImagePattern(new Image("bird.png")));
    }

}
