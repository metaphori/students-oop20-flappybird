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

    private static final int IMAGE_WIDTH = 800;
    private static final int IMAGE_HEIGHT = 600;
    private static final int BUTTON_FONT = 12;
    private static final int START_BUTTON_WIDTH = 150;
    private static final int START_BUTTON_Y = 250;
    private static final int START_BUTTON_X = 325;
    private static final int EXIT_BUTTON_WIDTH = 150;
    private static final int EXIT_BUTTON_Y = 350;
    private static final int EXIT_BUTTON_X = 325;
    private static final int PLAYER_BUTTON_WIDTH = 150;
    private static final int PLAYER_BUTTON_Y = 300;
    private static final int PLAYER_BUTTON_X = 325;
    private Pane pane;
    private View view;
    private ViewBird viewBird;
    private Stage stage;
    
    
    public ViewMenu(View viewImp, Pane p, ViewBird viewBirdImp, Stage parentStage) {
        this.view = viewImp;
        this.viewBird = viewBirdImp;
        this.stage = parentStage;
        this.pane= p;
    }

    /**
     * Add button to the opening stage.
     * 
     */
    
    public void render() {
        Button startButton= new Button();
        startButton.setLayoutX(START_BUTTON_X);
        startButton.setLayoutY(START_BUTTON_Y);
        startButton.setPrefWidth(START_BUTTON_WIDTH);
        startButton.setTextAlignment(TextAlignment.CENTER);
        startButton.setText("START");
        startButton.setFont(new Font("Arial", BUTTON_FONT));
        startButton.setOnAction(e->{
            pane.getChildren().clear();
            this.view.playGame();
        });
        Button exitButton= new Button();
        exitButton.setLayoutX(EXIT_BUTTON_X);
        exitButton.setLayoutY(EXIT_BUTTON_Y);
        exitButton.setPrefWidth(EXIT_BUTTON_WIDTH);
        exitButton.setTextAlignment(TextAlignment.CENTER);
        exitButton.setText("EXIT");
        exitButton.setFont(new Font("Arial", BUTTON_FONT));
        exitButton.setOnAction(e-> {
            stage.close();
        });
        Button playerButton= new Button();
        playerButton.setLayoutX(PLAYER_BUTTON_X);
        playerButton.setLayoutY(PLAYER_BUTTON_Y);
        playerButton.setPrefWidth(PLAYER_BUTTON_WIDTH);
        playerButton.setTextAlignment(TextAlignment.CENTER);
        playerButton.setText("SELECT PLAYER");
        playerButton.setFont(new Font("Arial", BUTTON_FONT));
        playerButton.setOnAction(e-> {
            PlayerView.show(viewBird,stage);
        });
        
        ImageView img = new ImageView();
        img.setImage(new Image(ImageID.MENU_BACKGROUND.getPath()));
        img.setFitHeight(IMAGE_HEIGHT);
        img.setFitWidth(IMAGE_WIDTH);
        this.pane.getChildren().add(img);
        this.pane.getChildren().add(startButton);
        this.pane.getChildren().add(playerButton);
        this.pane.getChildren().add(exitButton);

    }
}

  

