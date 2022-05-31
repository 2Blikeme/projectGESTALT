package app.gui.components.fields;



import app.database.entity.Music;
import app.gui.components.chunks.CustomButton;
import app.gui.cosmetic.MyFont;
import app.gui.interfaces.CustomField;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;


public class SongView implements CustomField, ActionListener {
    private Box songBox;
    private Music song;
    private CustomButton playButton;
    private final MyFont font;

    private Clip music;
    public static boolean isPlaying = false;

    private AudioInputStream audioInputStream = null;

    FileInputStream fileInputStream;

    public SongView(MyFont font) {
        this.font = font;

        songBox = new Box(BoxLayout.X_AXIS);
        songBox.setBorder(new LineBorder(Color.BLACK, 1));
        songBox.setFont(font.getFont());
        songBox.setPreferredSize(new Dimension(300, 50));


        playButton = new CustomButton(font);
        playButton.setBackground(Color.decode("#444444"));

        playButton.setHolder("Play");
        playButton.getComponent().addAncestorListener((AncestorListener) this);

        songBox.add(playButton.getComponent());


        //Thread playThread = new Thread(runnablePlay);
        //Thread resumeThread = new Thread(runnableResume);

    }


//    Runnable runnablePlay = new Runnable() {
//        @Override
//        public void run() {
//            fileInputStream
//        }
//    }

//    Runnable runnableResume = new Runnable() {
//        @Override
//        public void run() {
//        }
//    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (isPlaying) {

        }
    }


    public void playSong() {
        JButton t = (JButton) playButton.getComponent();
        t.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {



                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }



    public void initSong(Music song) {
        this.song = song;
        JLabel songLabel = new JLabel(song.toString());
        songLabel.setFont(font.getFont());
        songBox.add(songLabel);
    }


    public Music getSong() {
        return song;
    }


    @Override
    public JComponent getComponent() {
        return songBox;
    }


    @Override
    public void setSize(int width, int height) {
        songBox.setPreferredSize(new Dimension(width, height));
    }

}
