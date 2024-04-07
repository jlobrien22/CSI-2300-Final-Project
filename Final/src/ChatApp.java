import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatApp extends Application {

    private TextArea chatArea;
    private TextField user1InputField;
    private TextField user2InputField;
    private String user1Name;
    private String user2Name;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        VBox chatContainer = new VBox();
        chatArea = new TextArea();
        chatArea.setEditable(false);
        user1InputField = new TextField();
        user2InputField = new TextField();
        Button user1SendButton = new Button("Send");
        Button user2SendButton = new Button("Send");

        // Prompts user 1 for username
        TextInputDialog user1Dialog = new TextInputDialog();
        user1Dialog.setTitle("Hello User 1!");
        user1Dialog.setHeaderText(null);
        user1Dialog.setContentText("Please enter your username:");
        user1Dialog.showAndWait().ifPresent(name -> {
            user1Name = name.trim();
        });

         // Prompts user 2 for username
        TextInputDialog user2Dialog = new TextInputDialog();
        user2Dialog.setTitle("Hello User 2!");
        user2Dialog.setHeaderText(null);
        user2Dialog.setContentText("Please enter your username:");
        user2Dialog.showAndWait().ifPresent(name -> {
            user2Name = name.trim();
        });

        user1SendButton.setOnAction(e -> sendMessage(user1Name, user1InputField.getText()));
        user2SendButton.setOnAction(e -> sendMessage(user2Name, user2InputField.getText()));

        chatContainer.getChildren().addAll(chatArea, user1InputField, user1SendButton, user2InputField, user2SendButton);
        chatContainer.setSpacing(10);
        chatContainer.setPadding(new Insets(10));

        root.setCenter(chatContainer);

        primaryStage.setTitle("Chat App");
        primaryStage.setScene(new Scene(root, 600, 300));
        primaryStage.show();
    }

    private void sendMessage(String username, String message) {
        if (!message.trim().isEmpty()) {
            appendMessage(username + " (" + getCurrentTime() + "): " + message);
            if (username.equals(user1Name)) {
                user1InputField.clear();
            } else if (username.equals(user2Name)) {
                user2InputField.clear();
            }
        }
    }

    private void appendMessage(String message) {
        Platform.runLater(() -> chatArea.appendText(message + "\n"));
    }

    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }

    public static void main(String[] args) {
        launch(args);
    }
}

