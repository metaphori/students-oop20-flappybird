package model.generator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import model.BasicColumn;
import model.Column;
import model.LaserColumn;
import model.RandomColumn;

/**
 * Generator class of the columns
 */
public class ObstacleGenerator implements Generator{
     
    private static final double SPACECOLUMN = 200;
    private static final double INTERSPACE = 150;
    private static final double FLOOR = 50;
    private static final double BASEMANT = 250;
    private static final int STEPMOVE = -2;
    private List<Column> obstacles;
    private double startNext;
    private GameStep gameStep;
    private Point upPosition;
    private double countColumn;
    private Point downPosition;
    private double basemantHeight;
    private double gameHeight;
    private boolean legendStep;
    
    /**
     * Create the obstacle generator
     * 
     * @param gameWorldWidth
     *                       world width
     * 
     * @param gameWorldHeight
     *                        world height 
     */
    public ObstacleGenerator(double gameWorldWidth, double gameWorldHeight) {       
        this.basemantHeight = gameWorldHeight-BASEMANT;
        this.gameHeight = gameWorldHeight;
        this.countColumn = 0;
        this.gameStep = GameStep.EASY_DOWN;
        this.legendStep = false;
        this.obstacles = new ArrayList<>();
        this.startNext = gameWorldWidth - SPACECOLUMN;       
        this.upPosition = new Point();
        this.upPosition.setLocation(gameWorldWidth,0);        
        this.downPosition = new Point();
        this.downPosition.setLocation(gameWorldWidth, basemantHeight);       
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Column> getWorldElements() {
        // TODO Auto-generated method stub
        return this.obstacles;
    }

    private void addElement() { 
        switch (gameStep) {
        case EASY_UP:
            OperationGenerate generateUp = () -> new BasicColumn(upPosition,false);
            this.obstacles.add(generateUp.getElement());
            break;
        case EASY_DOWN:     
            OperationGenerate generateDown = () -> new BasicColumn(downPosition,false);
            this.obstacles.add(generateDown.getElement());
            break;
        case NORMAL:
            OperationGenerate generateUpNormal = () -> new BasicColumn(upPosition,false);
            this.obstacles.add(generateUpNormal.getElement());
            OperationGenerate generateDownNormal = () -> new BasicColumn(downPosition,false);
            this.obstacles.add(generateDownNormal.getElement());
            break;
        case DIFFICULT:            
            RandomColumn r = new RandomColumn(upPosition,false,0);
            r.setHeight();
            OperationGenerate generateNormalUp = () -> r;           
            OperationGenerate generateNormalDown = generateDown(generateNormalUp);
            this.obstacles.add(generateNormalUp.getElement());         
            this.obstacles.add(generateNormalDown.getElement());            
            break;
        case LEGEND:
            if(legendStep) {
                OperationGenerate generateLegend = () -> new LaserColumn(upPosition,true);
                this.obstacles.add(generateLegend.getElement());
                legendStep = false;
            } else {
                OperationGenerate generateLegendd = () -> new LaserColumn(downPosition,true);
                
                this.obstacles.add(generateLegendd.getElement());
                legendStep=true;
            }
            break;                
        default:
            break;
        }        
        this.countColumn++;        
    }
       
    private OperationGenerate generateDown(OperationGenerate generateNormalUp) { 
        double y = generateNormalUp.getElement().getHeigth();
        Point p = new Point();
        p.setLocation(downPosition.getX(), y + INTERSPACE);
        double height = gameHeight - FLOOR - INTERSPACE - y;       
        RandomColumn r = new RandomColumn(p, false, height);
        r.setHeight();     
        return () -> r;
    }

    private void removeElement() {
        if(!this.obstacles.isEmpty() && this.obstacles.get(0).getPosition().x < 0 ) {
                this.obstacles.remove(0);       
        } 
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        removeElement();       
        if(this.obstacles.isEmpty() || this.checkDistance()) {
            setStep();
            addElement();     
        } 

        this.obstacles.forEach(a->{
            Point c = new Point();
            c.setLocation(a.getPosition());
            c.translate(STEPMOVE, 0);
            a.updatePosition(c);
        });       
    }
    
    private void setStep() {
        if (countColumn>GameStep.LEGEND.getNumb()) {
            gameStep = GameStep.LEGEND;
        } else if (countColumn>GameStep.DIFFICULT.getNumb()) {
            gameStep = GameStep.DIFFICULT;
        } else if (countColumn>GameStep.NORMAL.getNumb()) {
            gameStep = GameStep.NORMAL;
        }else if (countColumn>GameStep.EASY_UP.getNumb()) {
            gameStep = GameStep.EASY_UP;
        } else if (countColumn>GameStep.EASY_DOWN.getNumb()) {
            gameStep = GameStep.EASY_DOWN;
        }
    }

    private boolean checkDistance() {
               Column col= this.obstacles.get(this.obstacles.size()-1);  
                return col.getPosition().getX() < startNext;       
    }

   

}
