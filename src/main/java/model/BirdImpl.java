package model;

public class BirdImpl implements Bird{

    private final static double POS_X = 350;
    private double posy;
    private final static double RADIUS= 25;
    
    public BirdImpl() {
        this.posy = 250;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updatePosition(double posY) {
        this.posy= posY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getCenterX() {
        return POS_X;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getCenterY() {
        return posy;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getRadius() {
        return RADIUS;
    }

    
}
