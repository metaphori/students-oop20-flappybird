package view;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import model.Column;

public class ViewObstacleImp implements ViewObstacle{
    
    private List<Rectangle> object;
    private Pane pane;
    
    public ViewObstacleImp(Pane p) {
        object = new ArrayList<>();
        pane = p;
    }

    @Override
    public void render(List<Column> list) {
        // TODO Auto-generated method stub
        checkNew(list);
      
        pane.getChildren().addAll(object);
    }

    private void checkNew(List<Column> list) {
        // TODO Auto-generated method stub
        pane.getChildren().removeAll(object);
        object.clear();
        List<Column> l = List.copyOf(list);
        l.forEach(b->{
           object.add(createObstacle(b)) ;
        });
        
        
    }

    private Rectangle createObstacle(Column b) {
        // TODO Auto-generated method stub
        Rectangle rectangle = new Rectangle();
        rectangle.setLayoutX(b.getPosition().getX());
        rectangle.setLayoutY(b.getPosition().getY());
        rectangle.setWidth(b.getWidth());
        rectangle.setHeight(b.getHeigth());
        if (rectangle.getLayoutY()==0) {
            rectangle.setFill(new ImagePattern(new Image("upColumn.png")));
        } else {
            rectangle.setFill(new ImagePattern(new Image("column.png")));
        }
        
        return rectangle;
     
    }

}
