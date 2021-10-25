package model;

import java.awt.Point;

/**
 * Represent a generic column with standard dimension 
 */
public class BasicColumn extends AbstractColumn{

    /**
     * {@inheritDoc}
     */
    public BasicColumn(Point position, boolean type) {
        super(position, type);
      
    }

    /**
     * @return always 0
     */
    @Override
    public double updateHeight() {
      
        return 0;
    }

}
