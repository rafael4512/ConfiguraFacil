package Negocio;

import GUI.Login;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author Jaime Leite, João Marques, Nuno Rei e Rafael Lourenço
 * @version 12-2018
*/
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
    }

    public static void main(String[] args) {
    	ConfiguraFacil f = new ConfiguraFacil();
        Login a = new Login(f);
        a.execLogin();
    }
    
}
