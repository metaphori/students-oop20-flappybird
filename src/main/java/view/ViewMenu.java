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

    /**
     * Add button to the opening stage.
     * 
     */
    
    public void render() {
        
        Button startButton= new Button();
        startButton.setLayoutX(325);
        startButton.setLayoutY(250);
        startButton.setPrefWidth(150);
        startButton.setTextAlignment(TextAlignment.CENTER);
     
        startButton.setText("START");
        startButton.setFont(new Font("Arial", 12));
        startButton.setOnAction(e->{
            pane.getChildren().clear();
            this.view.playGame();
        });
        
        Button exitButton= new Button();
        exitButton.setLayoutX(325);
        exitButton.setLayoutY(350);
        exitButton.setPrefWidth(150);
        exitButton.setTextAlignment(TextAlignment.CENTER);
        exitButton.setText("EXIT");
        exitButton.setFont(new Font("Arial", 12));
        exitButton.setOnAction(e-> {
            stage.close();
        });
        
        Button playerButton= new Button();
        playerButton.setLayoutX(325);
        playerButton.setLayoutY(300);
        playerButton.setPrefWidth(150);
        playerButton.setTextAlignment(TextAlignment.CENTER);
        playerButton.setText("SELECT PLAYER");
        playerButton.setFont(new Font("Arial", 12));
        playerButton.setOnAction(e-> {
            PlayerView.show(viewBird,stage);
        });
        
        ImageView img = new ImageView();
        img.setImage(new Image(ImageID.MENU_BACKGROUND.getPath()));
        img.setFitHeight(600);
        img.setFitWidth(800);
        
        pane.getChildren().add(img);
        pane.getChildren().add(startButton);
        pane.getChildren().add(playerButton);
        pane.getChildren().add(exitButton);
        
        
    }
}

  

