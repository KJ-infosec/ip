package kj;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private KJ kj;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/user.jpg"));
    private Image kjImage = new Image(this.getClass().getResourceAsStream("/images/chatbot.jpg"));

    /**
     * Initialize KJ application
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        String welcomeMessage = "Welcome back! My circuits are ready to hold your ideas so your mind doesn't have to. "
                + "What's on your brain?";
        dialogContainer.getChildren().add(
                DialogBox.getKjDialog(welcomeMessage, kjImage)
        );
    }

    /** Injects the KJ instance */
    public void setKJ(KJ k) {
        kj = k;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing KJ's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = kj.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getKjDialog(response, kjImage)
        );
        userInput.clear();
    }
}
