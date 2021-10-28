package model;

import java.awt.Point;
import java.awt.Rectangle;

/**
 * Represent an abstract column 
 */
public  abstract class AbstractColumn implements Column{

    private static final double WEIGHT = 50;
    private static final double GENERIC_HEIGHT = 200;
    private final Boolean laserType;
    private Rectangle column;
    private double height;

    /**
     * Create a new abstract column
     * @param position
     *                  the point position of the new column
     * @param type
     *                  true if is a laserType                 
     */
    public AbstractColumn(final Point position, final Boolean type) {
        this.laserType = type;
        this.height = GENERIC_HEIGHT;
        this.column = new Rectangle();
        this.column.setRect(position.getX(), position.getY(), WEIGHT, this.height);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isLaserType() {
        // TODO Auto-generated method stub
        return this.laserType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updatePosition(final Point position) {
        this.column.setLocation(position);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Point getPosition() {
        return this.column.getLocation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getHeigth() {
        return this.height;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getWidth() {
        return AbstractColumn.WEIGHT;
    }

    /**
     * Set the height of the column
     * 
     *   This is a template method
     */
    @Override
    public void setHeight() {
        this.height = this.updateHeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Rectangle getColumn() {
        return this.column;
    }

    /**
     *Calculate the new height
     *
     * @return the new height 
     */
    protected abstract double updateHeight();
}
