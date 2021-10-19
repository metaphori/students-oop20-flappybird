package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class ScoreImpl implements Score {
    
    private World world;
    private Integer score;
    private final double flyPosX;
    private List<Column> columnList;
    
    
    public ScoreImpl(World worldImp) {
        
        this.flyPosX = 400;
        this.columnList = new ArrayList<>();
        this.score = 0;
        this.world = worldImp;
        
    }
    
    
   
    

    @Override
    public void update() {
        // TODO Auto-generated method stub
      
        if (!this.world.getColumns().isEmpty()) {
           this.world.getColumns().forEach(a->{
               if (!columnList.contains(a) && a.getPosition().getX()<flyPosX) {
                   columnList.add(a);
                   score++;
                   System.out.println(score);
               }
           });
           
        }

    }


    public Integer getScore() {
        return score;
    }

}
