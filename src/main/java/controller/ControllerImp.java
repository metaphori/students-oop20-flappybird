package controller;


import model.Model;
import model.ModelImp;
import view.View;

public class ControllerImp implements Controller{
    
    
    

    private State gameState;
    public Model model;
    public View view;
  
 
    public ControllerImp(Model model) {
        
        this.model = new ModelImp();
        this.gameState = State.PLAYING;
       
    }

    @Override
    public void updateState() {
  
     
        switch (gameState) {
        case GAME_OVER:
          
            break;
        case INITIALIZE:
            this.model.startGame();
            
            break;
        case PLAYING:
            this.model.updateGame();
            break;
        case READY:
            
            break;
            
        default:
            break;
        }
    }

    @Override
    public void setState(State state) {
        // TODO Auto-generated method stub
        
    }
    
    private void render(State gameState) {
        
        this.view.render(gameState);
        
    }
   
    
  
    

 
          
               
             
   
 }




   
  

   