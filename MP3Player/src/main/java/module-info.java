module com.serious.mp3player {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.serious.mp3player to javafx.fxml;
    exports com.serious.mp3player;
    exports com.example.QuranMP3Player;
    opens com.example.QuranMP3Player to javafx.fxml;
}