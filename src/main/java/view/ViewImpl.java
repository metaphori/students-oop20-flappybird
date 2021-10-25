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
    
    private Rectangle rec;
    private Controller controller;
    private ViewObstacle viewObstacle;
    private FinishView finish;
    private Pane pane;
    private Stage stage;
    private ViewBird viewBird;
    private ViewMenu viewMenu;
    private PlayView playView;
    private ViewObserver observer;

    public ViewImpl() {    
    }
    /**
     * {@inheritDoc}
     */
    public void initiate() {     
        this.controller = new ControllerImpl(this);
     
        this.pane = new Pane();
        this.viewBird = new ViewBirdImp(pane);
        this.viewMenu = new ViewMenu(this,pane,viewBird,stage);
        this.viewMenu.render();

        this.stage.setMaxHeight(this.controller.getGameHeight());
        this.stage.setMaxWidth(this.controller.getGameWidth());
        this.stage.setScene(new Scene(pane));
        this.stage.show();
        this.stage.setResizable(false);
 
    }
    
    /**
     * {@inheritDoc}
     */
    public void playGame(){
        
        this.observer = new ViewObserverImpl(controller);
        this.viewObstacle = new ViewObstacleImpl(pane);       
        this.playView = new PlayView(pane);
        this.playView.display(controller); 
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
              this.viewObstacle.render(columns);
              this.playView.updateScore(score);
              this.viewBird.render(bird);              
              }); 

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void gameOver(Optional<Integer> topScore) {

        this.finish = new FinishView(pane, controller.getLeaderBoardController(), this);
        Platform.runLater(()->{
            NameView.show(stage,controller.getLeaderBoardController());
           
            this.finish.showFinishView(playView.getScore(),topScore);
          
            }); 
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void checkInput() {
     
        Platform.runLater(()->{
        
            pane.getScene().setOnKeyPressed(e->{
                if (e.getCode() == KeyCode.SPACE) {
                    
                    this.observer.pressSpace();
                }
               
            });
        });
              
    }



















    






   
  
     
    







}
