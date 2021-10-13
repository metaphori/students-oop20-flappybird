package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class ScoreImpl implements Score {
    
    World world;
    private Integer score;
    private final double flyPosX;
    private List<Column> list;
    
    
    public ScoreImpl(World worldImp) {
        flyPosX = 400;
        list = new ArrayList<>();
        score = 0;
        world = worldImp;
        
    }
    
    
   
    

    @Override
    public void update() {
        // TODO Auto-generated method stub
      
        if (!world.getColumns().isEmpty()) {
           world.getColumns().forEach(a->{
               if (!list.contains(a) && a.getPosition().getX()<flyPosX) {
                   list.add(a);
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
