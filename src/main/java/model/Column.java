package model;

import java.awt.Point;
import java.awt.Rectangle;

public class Column extends Entity{
    
    private Rectangle column;
    
  

    public Column(Point pos, int width, int height) {
        super(pos);
        this.column = new Rectangle();
        this.column.setSize(width, height);
        this.column.setLocation(pos);
        // TODO Auto-generated constructor stub
    }
    
    public void update(Point pos) {
        this.column.setLocation(pos);
        super.update(pos);
    }
    public Column getColumn() {
        return this.getColumn();
    }
    
  

}
