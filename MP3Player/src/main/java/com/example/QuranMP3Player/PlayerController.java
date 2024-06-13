package com.example.QuranMP3Player;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.io.File;

public class PlayerController {

    @FXML
    private Button btnPause;
    @FXML
    private Slider slider;
    @FXML
    private Label lblintialise;
    @FXML
    private ListView<String> listeview;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnStop;
    @FXML
    private MediaView mediaView;
    private MediaPlayer mediaPlayer;

    @FXML
    void doPause(ActionEvent event) {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    @FXML
    void doPlay(ActionEvent event) {
        if (mediaPlayer != null) {
            mediaPlayer.play();
        }
    }

    @FXML
    void doStop(ActionEvent event) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    @FXML
    void initialize() {
        String folderPath = "C:\\Users\\HP\\Documents\\GitHub\\QuranMP3\\MP3Player\\src\\main\\java\\com\\example\\QuranMP3Player\\quranList";  // Remplacez par le chemin de votre dossier
        File folder = new File(folderPath);

        // Juste pour voir si tous passe comme prevu.
        System.out.println("Chemin du dossier: " + folderPath);

        if (folder.exists() && folder.isDirectory()) {
            System.out.println("Le dossier existe et est un répertoire.");

            File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".mp3"));
            if (files != null) {
                for (File file : files) {
                    System.out.println("Fichier trouvé: " + file.getName());
                    listeview.getItems().add(file.getName());
                }
            } else {
                System.out.println("Aucun fichier MP3 trouvé dans le dossier.");
            }
        } else {
            System.out.println("Le dossier n'existe pas ou n'est pas un répertoire.");
        }

        listeview.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                }
                String mediaFile = new File(folder, newValue).toURI().toString();
                Media media = new Media(mediaFile);
                mediaPlayer = new MediaPlayer(media);
                //mediaView = new MediaView(mediaPlayer);

                mediaPlayer.currentTimeProperty().addListener((observableValue, oldValuee, newValuee) ->{
                    slider.setValue(newValuee.toSeconds());
                });

                mediaPlayer.setOnReady(()->{
                    Duration duration = media.getDuration();
                    slider.setValue(duration.toSeconds());
                });

            }
        });


    }
    @FXML
    void sliderGo(MouseEvent event) {
        mediaPlayer.seek(Duration.seconds(slider.getValue()));

    }
}
