package model;

public class BirdImpl implements Bird{

    private final static double POS_X = 350;
    private double posy;
    private final static double RADIUS= 25;
    
    public BirdImpl() {
        
        this.posy = 250;
    }
    
   

    @Override
    public void updatePosition(double posY) {
        // TODO Auto-generated method stub
        this.posy= posY;
    }

    @Override
    public double getCenterX() {
        // TODO Auto-generated method stub
        return POS_X;
    }

    @Override
    public double getCenterY() {
        // TODO Auto-generated method stub
        return posy;
    }

    @Override
    public double getRadius() {
        // TODO Auto-generated method stub
        return RADIUS;
    }

    
}
