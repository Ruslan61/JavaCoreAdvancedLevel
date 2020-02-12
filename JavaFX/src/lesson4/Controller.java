package lesson4;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {    
    @FXML
    TextArea chatText;
    @FXML
    TextField inputText;

    public void sendMessage() {
        chatText.appendText(inputText.getText()+"\n");
        inputText.clear();
        inputText.requestFocus();
    }
}
