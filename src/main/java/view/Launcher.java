package view;

import java.awt.Dimension;
import java.awt.Point;

import controller.Controller;
import controller.ControllerImp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.Column;


public final class Launcher extends Application{
    
    private static final int width = 800;
    private static final int height = 600;
  
    public void start(Stage primaryStage) throws Exception {
     

        primaryStage.setTitle("ciao");
        Column col = new Column(new Point(width,500), 30,60);
        Rectangle rec = new Rectangle();
        rec.setLayoutX(width);
        rec.setLayoutY(350);
        rec.setWidth(50);
        rec.setHeight(200);
        rec.setFill(new ImagePattern(new Image("column.png")));
        Thread thread = new Thread(()-> {
            while (true) {
                rec.setLayoutX(rec.getLayoutX()-5);
              //  rec.setHeight(rec.getHeight()-1);
                System.out.println(rec.getLayoutX());
                if (rec.getLayoutX()==0) {
                    rec.setLayoutX(width);
                }
                try {
                Thread.sleep(50);
                } catch (Exception ex){
                ex.printStackTrace();
                }
                }
        });
        thread.start();
        AnchorPane lay = new AnchorPane();
        
        
        ImageView img = new ImageView();
        img.setImage(new Image("background.png"));
        img.setFitHeight(height);
        img.setFitWidth(width);
        
        lay.getChildren().add(img);
        lay.getChildren().add(rec);
   
        lay.setMaxSize(width, height);
       
        

    
        //Controller c = new ControllerImp();    
        
        
        primaryStage.setMaxHeight(height);
        primaryStage.setMaxWidth(width);
        primaryStage.setScene(new Scene(lay));
        
  
        primaryStage.show();
    }
    
    

    /**
     * 
     * @param args unused.
     */
    public static void main(final String[] args) {
        launch();
    }

}
