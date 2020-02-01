package sample;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Music {
    private AudioClip mediaPlayer;
    String s;
   public Music(String name) {
        s="resources//" + name;
        music();
    }
    private void music(){
        Media h=new Media(new File(s).toURI().toString());
        mediaPlayer= new AudioClip(h.getSource());
        mediaPlayer.play();


    }

}
