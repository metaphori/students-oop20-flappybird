package view;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import model.Column;

public class ViewObstacleImp implements ViewObstacle{
    
    private List<Rectangle> object;
    private Pane pane;
    private ImagePattern upImagePattern;
    private ImagePattern downImagePattern;
    private ImagePattern laserImagePattern;

    
    public ViewObstacleImp(Pane p) {
        object = new ArrayList<>();
        pane = p;

        this.upImagePattern = new ImagePattern(new Image(ImageID.UP_COLUMN.getPath()));
        this.downImagePattern = new ImagePattern(new Image(ImageID.DOWN_COLUMN.getPath()));
        this.laserImagePattern = new ImagePattern(new Image(ImageID.LASER.getPath()));
       
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
        rectangle.setFill(getPaint(b));
      
        
        return rectangle;
     
    }

    private Paint getPaint(Column b) {
        // TODO Auto-generated method stub
        if (b.isLaserType()) {
           return this.laserImagePattern;
        }else {
            return b.getPosition().getY()==0? this.upImagePattern:this.downImagePattern;
        }
      
    }

}
