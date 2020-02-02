package sample;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

class Music {
    private AudioClip mediaPlayer;
    private String s;
   Music(String name) {
        s="resources//" + name;
        music();
    }
    private void music(){
        Media h=new Media(new File(s).toURI().toString());
        mediaPlayer= new AudioClip(h.getSource());
        mediaPlayer.play();


    }

}
