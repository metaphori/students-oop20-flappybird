package model;

import java.awt.Point;

public class BasicColumn extends ColumnImp{

    public BasicColumn(Point position, boolean type) {
        super(position, type);
      
    }

    @Override
    public double updateHeight() {
      
        return 0;
    }

}
