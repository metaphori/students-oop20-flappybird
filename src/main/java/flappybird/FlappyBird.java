package flappybird;

import controller.Controller;
import controller.ControllerImp;


import view.View;
import view.ViewImp;

// fa partire il gioco
//run using gradle-> applicatiomn->run



public class FlappyBird {
    
 
    private FlappyBird() {
        
    }
   

    public static void main(final String[] args) {
        
        
        final Controller ctx = new ControllerImp();
        final View view = new ViewImp();
       // view.set(ctx, args);
        ctx.start(args,view);
      // view.run(args);
     // view.run(args);
        
    }

  
    }

 
    
   
    

