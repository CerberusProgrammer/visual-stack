package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.LinkedList;
import java.util.Scanner;
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
        Stack<String> open = new Stack<>();
        Stack<String> close = new Stack<>();

        try {
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == '(')
                    open.push(string.substring(i, i + 1));
                else if (string.charAt(i) == ')')
                    close.push(string.substring(i - 1, i));
                if (string.charAt(i) == '(')
                    if (string.charAt(i + 1) == ')') {
                        showActivity.appendText("La expresion matematica es incorrecta." + "\n");
                        return;
                    }
                else if (string.charAt(i) == ')')
                    if (string.charAt(i + 1) == '(') {
                        showActivity.appendText("La expresion matematica es incorrecta." + "\n");
                        return;
                    }
            }
        } catch (StringIndexOutOfBoundsException e) {
            showActivity.appendText("La expresion matematica es incorrecta." + "\n");
            return;
        }

        if (open.size() != close.size() || open.size() == 0) {
            showActivity.appendText("La expresion matematica es incorrecta." + "\n");
            return;
        }
        showActivity.appendText("La expresion matematica es correcta." + "\n");
    }
}
