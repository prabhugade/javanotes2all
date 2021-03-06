package com.javanotes2all.java.sound;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

//To play sound using Clip, the process need to be alive.
//Hence, we use a Swing application.
public class SoundClipTest extends JFrame {

// Constructor
public SoundClipTest() {
   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   this.setTitle("Test Sound Clip");
   this.setSize(300, 200);
   this.setVisible(true);

   try {
      // Open an audio input stream.
     // URL url = this.getClass().getClassLoader().getResource("/home/prabhu/Music/Chaachina_Chethulatho.wav");
      File soundFile = new File("/home/prabhu/Desktop/java/Chaachina_Chethulatho.wav");
      AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
      // Get a sound clip resource.
      Clip clip = AudioSystem.getClip();
      // Open audio clip and load samples from the audio input stream.
      clip.open(audioIn);
      clip.start();
   } catch (UnsupportedAudioFileException e) {
      e.printStackTrace();
   } catch (IOException e) {
      e.printStackTrace();
   } catch (LineUnavailableException e) {
      e.printStackTrace();
   }
}

public static void main(String[] args) {
   new SoundClipTest();
}
}