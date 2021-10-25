package view;

import java.util.List;
import java.util.Optional;
import controller.Controller;
import controller.ControllerImpl;
import controller.GameState;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;
import model.Bird;
import model.Column;
import view.ImageID;

/**
 * Rappresent the view class entry
 */
public class ViewImpl extends Application implements View {
    
    Rectangle rec;
    Controller controller;
    ViewObstacle viewObstacle;
    FinishView finish;
    Pane p;
    Stage stage;
    
    ViewBird viewBird;
    ViewMenu viewMenu;
    PlayView playView;
    ViewObserver observer;


            
    
    public ViewImpl() {
     
    }
    

 
    /**
     * {@inheritDoc}
     */
    public void initiate() {
      
        controller = new ControllerImpl(this);
     
        p = new Pane();
<<<<<<< HEAD:src/main/java/view/ViewImp.java
        //viewMenu = new ViewMenu(p);
        viewBird = new ViewBirdImpl(p);
=======
        viewBird = new ViewBirdImp(p);
>>>>>>> 2082fb847cfdaa4af2b638ac830dfcc2571f9827:src/main/java/view/ViewImpl.java
        viewMenu = new ViewMenu(this,p,viewBird,stage);
        viewMenu.render();

        stage.setMaxHeight(this.controller.getGameHeight());
        stage.setMaxWidth(this.controller.getGameWidth());
        stage.setScene(new Scene(p));
        stage.show();
        stage.setResizable(false);
 
    }
    
    /**
     * {@inheritDoc}
     */
    public void playGame(){
        
        observer = new ViewObserverImpl(controller);
        viewObstacle = new ViewObstacleImpl(p);       
        playView = new PlayView(p);
        playView.display(this, controller); 
        this.controller.updateState();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        primaryStage.setTitle("ciao");
        this.stage = primaryStage;
        initiate();
    }
    
    public static void run(final String[] args) {
        launch();
    }
    
    /**
     * {@inheritDoc}
     */
    public  void render(List<Column> columns, Integer score, Bird bird) {
   
          Platform.runLater(()->{

              viewObstacle.render(columns);
              playView.updateScore(score);
              viewBird.render(bird);
              
              }); 

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void gameOver(Optional<Integer> topScore) {

        finish = new FinishView(p, controller, this);
        Platform.runLater(()->{
            NameView.show(stage,controller);
           
            finish.showFinishView(playView.getScore(),topScore);
          
            }); 
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void checkInput() {
     
        Platform.runLater(()->{
        
            p.getScene().setOnKeyPressed(e->{
                if (e.getCode() == KeyCode.SPACE) {
                    
                    this.observer.pressSpace();
                }
               
            });
        });
       
        
    }



















    






   
  
     
    







}
