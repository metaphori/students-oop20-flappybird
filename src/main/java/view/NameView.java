package view;







import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;




public class NameView {
    

    
   
    
   
    public static void show(Stage parentStage, Controller controller) {
        // TODO Auto-generated method stub
        Stage stage = new Stage();
        Pane pane = new Pane();
        Label label = new Label("Insert your name");
        Button button = new Button("Save");
        TextField textField = new TextField();
        label.setStyle("-fx-font-size: 20;");
        label.setLayoutX(75);
        label.setLayoutY(20);
        textField.setLayoutX(75);
        textField.setLayoutY(75);
        button.setLayoutX(120);
        button.setLayoutY(120);
        button.setPrefWidth(60);
        button.setOnAction(e->{
           controller.savePlayer(textField.getText());
        });
        
        
        pane.getChildren().add(label);
        pane.getChildren().add(textField);
        pane.getChildren().add(button);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(parentStage);
        stage.setHeight(200);
        stage.setWidth(300);
        stage.setScene(new Scene(pane));
        stage.requestFocus();
        stage.setResizable(false);
        stage.show();
    }

}
