package model;

import java.awt.Point;

public class BasicColumn extends AbstractColumn{

    public BasicColumn(Point position, boolean type) {
        super(position, type);
      
    }

    @Override
    public double updateHeight() {
      
        return 0;
    }

}
