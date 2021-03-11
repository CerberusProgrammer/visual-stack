package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Stack;

public class Controller {

    @FXML
    private TextField inputAdd;

    @FXML
    private TextField inputSearch;

    @FXML
    private TextField inputVerify;

    @FXML
    private TextArea showActivity;

    static Stack<String> stack = new Stack<>();

    @FXML
    void addElement() {
        stack.push(inputAdd.getText());
        showActivity.appendText("Se ha agregado '" + stack.peek() + "'" + "\n");
    }

    @FXML
    void deleteTop() {
        if (stack.isEmpty()) {
            showActivity.appendText("Ya esta vacio la pila." + "\n");
            return;
        }
        showActivity.appendText("Se ha eliminado '" + stack.pop() + "'" + "\n");
    }

    @FXML
    void showTop() {
        if (stack.isEmpty()) {
            showActivity.appendText("La pila esta vacia." + "\n");
            return;
        }
        showActivity.appendText("El tope de la pila es: '" + stack.peek() + "'" + "\n");
    }

    @FXML
    void searchElement() {
        if (stack.isEmpty()) {
            showActivity.appendText("La pila esta vacia." + "\n");
            return;
        }

        if (stack.contains(inputSearch.getText()))
            showActivity.appendText("El elemento existe en la pila." + "\n");
        else
            showActivity.appendText("El elemento no existe en la pila." + "\n");
    }

    @FXML
    void verifyExpression() {
        String string = inputVerify.getText();
        Stack<String> original = new Stack<>();
        Stack<String> reverso = new Stack<>();

        for (int i = 0; i < string.length(); i++)
            original.push(string.substring(i, i + 1));

        for (int i = string.length(); i > 0; i--)
            reverso.push(string.substring(i - 1, i));

        for (int i = 0; i < string.length()/2; i++) {
            int x = (int)reverso.pop().charAt(0) + 2;
            int y = (int)original.pop().charAt(0);

            if (!(x == y || x - 1 == y)) {
                showActivity.appendText("La expresion matematica es incorrecta." + "\n");
                return;
            }
        }
        showActivity.appendText("La expresion matematica es correcta." + "\n");
    }

    void verify() {
        String string = inputVerify.getText();
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(')
                s1.push(string.charAt(i));
            else if (string.charAt(i) == ')')
                s2.push(string.charAt(i));
        }
    }
}
