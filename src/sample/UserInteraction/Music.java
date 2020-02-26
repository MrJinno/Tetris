package sample.UserInteraction;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import java.io.File;

public class Music {
    private String resourceSource;

    public Music(String name) {
        resourceSource = "resources//" + name;
        handleMusic();
    }

    private void handleMusic() {
        Media h = new Media(new File(resourceSource).toURI().toString());
        AudioClip mediaPlayer = new AudioClip(h.getSource());
        mediaPlayer.play();
    }
}
