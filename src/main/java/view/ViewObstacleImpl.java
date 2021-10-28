package view;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import model.Column;

/**
 * View to show the obstacles
 */
public class ViewObstacleImpl implements ViewObstacle{
    
    private List<Rectangle> listRectangles;
    private Pane pane;
    private ImagePattern upImagePattern;
    private ImagePattern downImagePattern;
    private ImagePattern laserImagePattern;

    /**
     * Create the view
     * 
     * @param p
     *          the pane of the game
     */
    public ViewObstacleImpl(Pane pane) {
        this.listRectangles = new ArrayList<>();
        this.pane = pane;
        this.upImagePattern = new ImagePattern(new Image(ImageID.UP_COLUMN.getPath()));
        this.downImagePattern = new ImagePattern(new Image(ImageID.DOWN_COLUMN.getPath()));
        this.laserImagePattern = new ImagePattern(new Image(ImageID.LASER.getPath()));
       
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void render(List<Column> list) {
        // TODO Auto-generated method stub
        checkNew(list);
        this.pane.getChildren().addAll(listRectangles);
    }

    /**
     * {@inheritDoc}
     */
    private void checkNew(List<Column> list) {
        this.pane.getChildren().removeAll(listRectangles);
        this.listRectangles.clear();
        List<Column> l = List.copyOf(list);
        l.forEach(b->{
           this.listRectangles.add(createObstacle(b)) ;
        });
    }

    private Rectangle createObstacle(Column b) {
        Rectangle rectangle = new Rectangle();
        rectangle.setLayoutX(b.getPosition().getX());
        rectangle.setLayoutY(b.getPosition().getY());
        rectangle.setWidth(b.getWidth());
        rectangle.setHeight(b.getHeigth());
        rectangle.setFill(getPaint(b));
        return rectangle;    
    }

    private Paint getPaint(Column b) {
        if (b.isLaserType()) {
           return this.laserImagePattern;
        }else {
            return b.getPosition().getY()==0? this.upImagePattern:this.downImagePattern;
        }
      
    }

}
