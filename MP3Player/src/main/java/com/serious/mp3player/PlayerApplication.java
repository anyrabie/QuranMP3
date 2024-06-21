package com.serious.mp3player;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class PlayerApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PlayerApplication.class.getResource("guiMp3Player.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Quran MP3!");
////      Trop long..
//        String imageUrl = "https://cdn.pixabay.com/photo/2018/03/19/06/26/quran-3239152_960_720.png";
//        Image image = new Image(imageUrl);
//        stage.getIcons().add(image);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
