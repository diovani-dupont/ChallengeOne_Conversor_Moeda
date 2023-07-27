package br.com.conversor_moedas.principal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Principal extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Conversor de Moedas");

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/br/com/conversor_moedas/principal.fxml")));

        Scene scene = new Scene(root, 720, 720);

        primaryStage.setScene(scene);

        primaryStage.setWidth(720);
        primaryStage.setHeight(720);

        primaryStage.show();
    }
}
