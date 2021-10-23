package view;

import javax.swing.Renderer;

import controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ViewMenu {

    Pane pane;
    View view;
    ViewBird viewBird;
    Stage stage;
    
    
    public ViewMenu(View viewImp, Pane p, ViewBird viewBirdImp, Stage parentStage) {
        // TODO Auto-generated constructor stub
        this.view = viewImp;
        this.viewBird = viewBirdImp;
        this.stage = parentStage;
        pane= p;
    }

    public void render() {
        
        Button startButton= new Button();
        startButton.setLayoutX(325);
        startButton.setLayoutY(200);
        startButton.setPrefWidth(150);
        startButton.setTextAlignment(TextAlignment.CENTER);
     
        startButton.setText("START");
        startButton.setFont(new Font("Arial", 12));
        startButton.setOnAction(e->{
            pane.getChildren().clear();
            this.view.playGame();
        });
        
        Button scoreButton= new Button();
        scoreButton.setLayoutX(325);
        scoreButton.setLayoutY(250);
        scoreButton.setPrefWidth(150);
        scoreButton.setTextAlignment(TextAlignment.CENTER);
        scoreButton.setText("SCORE");
        scoreButton.setFont(new Font("Arial", 12));
        
        Button exitButton= new Button();
        exitButton.setLayoutX(325);
        exitButton.setLayoutY(300);
        exitButton.setPrefWidth(150);
        exitButton.setTextAlignment(TextAlignment.CENTER);
        exitButton.setText("EXIT");
        exitButton.setFont(new Font("Arial", 12));
        
        Button playerButton= new Button();
        playerButton.setLayoutX(325);
        playerButton.setLayoutY(350);
        playerButton.setPrefWidth(150);
        playerButton.setTextAlignment(TextAlignment.CENTER);
        playerButton.setText("SELECT PLAYER");
        playerButton.setFont(new Font("Arial", 12));
        playerButton.setOnAction(e-> {
            PlayerView.show(viewBird,stage);
        });
        
        ImageView img = new ImageView();
        img.setImage(new Image(ImageID.PLAYING_BACKGROUND.getPath()));
        img.setFitHeight(600);
        img.setFitWidth(800);
        
        ImageView title= new ImageView();
        title.setImage(new Image("title.png"));
        title.setFitHeight(200);
        title.setFitWidth(600);
        title.setLayoutX(100);
        
        
        pane.getChildren().add(img);
        pane.getChildren().add(title);
        pane.getChildren().add(startButton);
        pane.getChildren().add(playerButton);
        pane.getChildren().add(scoreButton);
        pane.getChildren().add(exitButton);
        
        
    }
    
 
                
                
        
    }

  

