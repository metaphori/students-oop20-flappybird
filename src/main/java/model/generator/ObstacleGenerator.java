package model.generator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import model.BasicColumn;
import model.Column;
import model.RandomColumn;

public class ObstacleGenerator implements Generator{
    
    private List<Column> obstacles;
    //private OperationGenerate generate;
    private static final double SPACECOLUMN = 200;
    private double startNext;
    private GameStep gameStep;
    private Point upPosition;
    private double countColumn;
    private Point downPosition;
    private static double basemant = 250;
    private static final double interspace = 150;
    private double basemantHeight;
    private double gameHeight;
    private int count=0;
    
  
    
    
    

    
    public ObstacleGenerator(double gameWorldWidth, double gameWorldHeight) {
        basemantHeight = gameWorldHeight-basemant;
        gameHeight = gameWorldHeight;
        countColumn = 0;
        gameStep = GameStep.DIFFICULT;
        this.obstacles = new ArrayList<>();
     //   this.generate = new OperationGenerateImpl(gameWorldWidth,gameWorldHeight);
        this.startNext = gameWorldWidth - SPACECOLUMN;
        
        this.upPosition = new Point();
        upPosition.setLocation(gameWorldWidth,0);
        
        this.downPosition = new Point();
        downPosition.setLocation(gameWorldWidth, basemantHeight);
    }

    @Override
    public List<Column> getWorldElements() {
        // TODO Auto-generated method stub
        return this.obstacles;
    }


    private void addElement() {
        // TODO Auto-generated method stub
       
        
        
        
       
        switch (gameStep) {
        case EASY_UP:
            OperationGenerate generateUp = () -> new BasicColumn(upPosition);
            this.obstacles.add(generateUp.getElement());
            break;
        case EASY_DOWN:
      
            OperationGenerate generateDown = () -> new BasicColumn(downPosition);
            this.obstacles.add(generateDown.getElement());
            break;
        case NORMAL:
            OperationGenerate generateUpNormal = () -> new BasicColumn(upPosition);
            this.obstacles.add(generateUpNormal.getElement());
            OperationGenerate generateDownNormal = () -> new BasicColumn(downPosition);
            this.obstacles.add(generateDownNormal.getElement());
            break;
        case DIFFICULT:
            
            RandomColumn r = new RandomColumn(upPosition,0);
            r.setHeight();
            OperationGenerate generateNormalUp = () -> r;
            
            
            OperationGenerate generateNormalDown = generateDown(generateNormalUp);
          
            
          
            this.obstacles.add(generateNormalUp.getElement());
          
            this.obstacles.add(generateNormalDown.getElement());
       
            
            break;
            
        default:
            break;
        }
        
        countColumn++;
        
      //  this.obstacles.add(suppler.getElement());
    }
   

    
    private OperationGenerate generateDown(OperationGenerate generateNormalUp) {
        // TODO Auto-generated method stub
        
        double y = generateNormalUp.getElement().getHeigth();
        Point p = new Point();
        p.setLocation(downPosition.getX(), y+interspace);
        double height = gameHeight - 50 - interspace-y;
       
        RandomColumn r = new RandomColumn(p,height);
        r.setHeight();
     
        return ()-> r;
    }

    private void removeElement() {
        // TODO Auto-generated method stub
        if(!this.obstacles.isEmpty() && this.obstacles.get(0).getPosition().x<0) {
          
                this.obstacles.remove(0);
           
        }
     
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        
        removeElement();
        if(this.obstacles.isEmpty() || this.checkDistance()) {
            setStep();
            addElement();     
        } 
      
        
       
        this.obstacles.forEach(a->{
            Point c = new Point();
            c.setLocation(a.getPosition());
            c.translate(-2, 0);
            a.updatePosition(c);
        });
        
   
        
    }
    
    private void setStep() {
        // TODO Auto-generated method stub
     
        if (countColumn<10) {
            gameStep = GameStep.EASY_DOWN;
        } else if (countColumn<20) {
            gameStep = GameStep.EASY_UP;
        } else if (countColumn<30) {
            gameStep = GameStep.NORMAL;
        }else {
            gameStep = GameStep.DIFFICULT;
        }
    }

    private boolean checkDistance() {
        
        
               Column col= this.obstacles.get(this.obstacles.size()-1);
              
             //  System.out.println(col.getPosition().getX());
                return col.getPosition().getX() < startNext;
        
    }

   

}
