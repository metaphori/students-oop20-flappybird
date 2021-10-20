package model;

public class BirdImp implements Bird{

    private final static double POS_X = 50;
    private double posy;
    private final static double RADIUS= 25;
    
    public BirdImp() {
        
        this.posy = 250;
    }
    
    @Override
    public void setView(String view) {
        // TODO Auto-generated method stub
        
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
