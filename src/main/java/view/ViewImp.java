package view;

import java.util.ArrayList;
import java.util.List;

import controller.Controller;
import controller.ControllerImp;
import controller.State;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;
import model.Column;

public class ViewImp extends Application implements View {
    
    private static final int width = 800;
    private static final int height = 600;
    private List<Column> columns;
    Rectangle rec;
    Controller controller;
    
    public ViewImp() {
     
     
    }
    
    public void set (Controller c,String[] args) {
        //System.out.println("ciaoo1");
       // this.controller = c;
        //ViewImp.run(args);;
        controller = c;
       
          launch();
    }

  




   
  


    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        primaryStage.setTitle("ciao");
        // Column col = new Column(new Point(width,500), 30,60);
      
        
     
        
        Pane p = new Pane();
         rec = new Rectangle();
        rec.setLayoutX(width-50);
        rec.setLayoutY(350);
        rec.setWidth(50);
        rec.setHeight(200);
        rec.setFill(new ImagePattern(new Image("column.png")));
        ImageView img = new ImageView();
        img.setImage(new Image("background.png"));
        img.setFitHeight(height);
        img.setFitWidth(width);
        
        p.getChildren().add(img);
        p.getChildren().add(rec);
         primaryStage.setMaxHeight(height);
         primaryStage.setMaxWidth(width);
        // primaryStage.setScene(new Scene(new GamePane(c)));
         primaryStage.setScene(new Scene(p));
         
        
        
         
        
         primaryStage.show();
         
       
    }
    
    public static void run(final String[] args) {
        launch();
    }
    
    public  void render() {
        // TODO Auto-generated method stub
     
           /* columns.forEach(a->{
                list.add(new Rectangle());
                Rectangle r = list.get(list.size()-1);
              
                r.setLayoutX(a.getPosition().getX());
                r.setLayoutY(a.getPosition().getY());
                r.setWidth(a.getWidth());
                r.setHeight(a.getHeigth());
                r.setFill(new ImagePattern(new Image("column.png")));
            });*/

            //    System.out.println("ciaou");
          //  rec.setTranslateX(-10);
           System.out.println("ciaoo");
       
    }












    






   
        

       
       
           // lay.getChildren().addAll(list);
            
         
    
      
        
        
        
        //System.out.println("ciaoo");
        
     
    







}
