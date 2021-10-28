package model;

import java.awt.Point;
import java.util.Random;

/**
 * Represent a laser Column
 */
public class LaserColumn extends AbstractColumn{
    
    private static final int FLOOR_HEIGHT = 550;
    private static final double PROBABILITY = 0.01;
    private static final double MIN_HEIGHT = 50;
    private static final double MAX_HEIGHT = 350;
    private final Random random;
    private boolean upDownSwitch;
    private boolean typeUp;
    
    /**
     * Create a new laser column and setting if it is up or down
     * @param position
     *                  the point position of the new column
     * @param type
     *                  true if is a laserType                 
     */
    public LaserColumn(Point position, boolean type) {

        super(position,type);

        if (position.getY()==0) {
            this.typeUp=true;
        } else {
            this.typeUp=false;
        }

        this.upDownSwitch = false;
        this.random = new Random();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updatePosition(final Point position) {
        Point point = new Point();

        if (this.random.nextDouble() < PROBABILITY) {
            setHeight();    
        }

        if (!this.typeUp) {
            point.setLocation(position.getX(), FLOOR_HEIGHT-getHeigth());
        } else {
            point = position;
        }

        super.updatePosition(point);
    }

    /**
     * @return a small or a big laser column
     */
    @Override
    public double updateHeight() {
       if (this.upDownSwitch) {
            this.upDownSwitch = false;
            return MIN_HEIGHT;
        }

        this.upDownSwitch = true;
        return MAX_HEIGHT;
    }

}
